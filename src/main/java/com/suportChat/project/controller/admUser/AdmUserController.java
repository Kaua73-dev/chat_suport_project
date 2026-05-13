package com.suportChat.project.controller.admUser;


import com.suportChat.project.dto.request.AdmUserLoginRequest;
import com.suportChat.project.dto.request.AdmUserRegisterRequest;
import com.suportChat.project.dto.response.AdmUserRegisterResponse;
import com.suportChat.project.dto.response.AdmUserTokenResponse;
import com.suportChat.project.service.admUser.AdmUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="/auth")
public class AdmUserController {

    private final AdmUserService admUserService;

    public AdmUserController(AdmUserService admUserService) {
        this.admUserService = admUserService;
    }

    @PostMapping("/register")
    public AdmUserTokenResponse login(@RequestBody AdmUserLoginRequest request){
        return admUserService.login(request);
    }

    @PostMapping("/login")
    public AdmUserRegisterResponse register(@RequestBody AdmUserRegisterRequest request){
        return admUserService.register(request);
    }






}
