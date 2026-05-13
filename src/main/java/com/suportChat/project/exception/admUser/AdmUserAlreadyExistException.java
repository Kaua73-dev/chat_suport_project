package com.suportChat.project.exception.admUser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AdmUserAlreadyExistException extends RuntimeException {
    public AdmUserAlreadyExistException() {
        super("adm user already exist");
    }
}
