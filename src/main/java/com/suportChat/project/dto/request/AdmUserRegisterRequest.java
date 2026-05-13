package com.suportChat.project.dto.request;

import com.suportChat.project.model.roles.AdmUserEnum;

public record AdmUserRegisterRequest(String name, String email, String password, AdmUserEnum admUserEnum) {
}
