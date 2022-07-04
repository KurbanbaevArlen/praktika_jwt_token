package com.example.praktika_jwt_token.dto;

import com.example.praktika_jwt_token.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;
}
