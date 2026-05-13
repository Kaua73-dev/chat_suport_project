package com.suportChat.project.exception.admUser;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdmUserNotFoundException extends RuntimeException {
    public AdmUserNotFoundException() {
        super("User not found");
    }
}
