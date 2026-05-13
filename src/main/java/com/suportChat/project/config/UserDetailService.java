package com.suportChat.project.config;

import com.suportChat.project.exception.admUser.AdmUserNotFoundException;
import com.suportChat.project.model.repository.AdmUserRepository;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final AdmUserRepository admUserRepository;

    public UserDetailService(AdmUserRepository admUserRepository) {
        this.admUserRepository = admUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
        return admUserRepository.findByEmail(email).orElseThrow(AdmUserNotFoundException::new);
    }
}
