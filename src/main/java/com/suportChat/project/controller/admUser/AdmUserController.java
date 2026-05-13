package com.suportChat.project.controller.admUser;


import com.suportChat.project.service.admUser.AdmUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name="/auth")
public class AdmUserController {

    private final AdmUserService admUserService;

    public AdmUserController(AdmUserService admUserService) {
        this.admUserService = admUserService;
    }
}
