package com.example.praktika_jwt_token.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class RegisterRequest {
    private String login;
    private String password;
}
