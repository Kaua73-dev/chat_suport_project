package com.suportChat.project.service.admUser;

import com.suportChat.project.config.TokenConfig;
import com.suportChat.project.dto.request.AdmUserLoginRequest;
import com.suportChat.project.dto.request.AdmUserRegisterRequest;
import com.suportChat.project.dto.response.AdmUserRegisterResponse;
import com.suportChat.project.dto.response.AdmUserTokenResponse;
import com.suportChat.project.exception.admUser.AdmUserAlreadyExistException;
import com.suportChat.project.exception.admUser.AdmUserNotFoundException;
import com.suportChat.project.model.entity.AdmUser;
import com.suportChat.project.model.repository.AdmUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdmUserService {

    private final AdmUserRepository admUserRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;
    private final PasswordEncoder passwordEncoder;

    public AdmUserService(AdmUserRepository admUserRepository, AuthenticationManager authenticationManager, TokenConfig tokenConfig, PasswordEncoder passwordEncoder) {
        this.admUserRepository = admUserRepository;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
        this.passwordEncoder = passwordEncoder;
    }

    private AdmUserRegisterResponse toResponse(AdmUserRegisterRequest request){
        return new AdmUserRegisterResponse(
                request.email(),
                request.name()
        );
    }


    public AdmUserTokenResponse login(AdmUserLoginRequest request){
        if(admUserRepository.findByEmail(request.email()).isEmpty()){
            throw new AdmUserNotFoundException();
        }

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);


        AdmUser admUser = (AdmUser) authentication.getPrincipal();
        String token = tokenConfig.generateToken(admUser);
        return new AdmUserTokenResponse(token);


    }


    public AdmUserRegisterResponse register(AdmUserRegisterRequest request){
        if(admUserRepository.findByEmail(request.email()).isPresent()){
            throw new AdmUserAlreadyExistException();
        }

        AdmUser admUser = new AdmUser();
        admUser.setName(request.name());
        admUser.setEmail(request.email());
        admUser.setPassword(passwordEncoder.encode(request.password()));

        return toResponse(request);
    }







}
