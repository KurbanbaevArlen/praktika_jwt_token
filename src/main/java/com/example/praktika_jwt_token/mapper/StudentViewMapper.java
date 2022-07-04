package com.example.praktika_jwt_token.mapper;

import com.example.praktika_jwt_token.dto.StudentResponse;
import com.example.praktika_jwt_token.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {
    public StudentResponse viewStudent(Student student){
        if(student == null){
            return null;
        }
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setStudyFormat(student.getStudyFormat());

        return response;
    }
    public List<StudentResponse> view(List<Student> students){
        List<StudentResponse> responses = new ArrayList<>();
        for( Student student: students){
            responses.add(viewStudent(student));
        }
        return responses;
    }
}
