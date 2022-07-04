package com.example.praktika_jwt_token.dto;

import com.example.praktika_jwt_token.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class StudentResponseView {
    List<StudentResponse> responses;
}
