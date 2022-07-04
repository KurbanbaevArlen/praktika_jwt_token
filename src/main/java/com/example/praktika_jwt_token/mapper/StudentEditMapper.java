package com.example.praktika_jwt_token.mapper;

import com.example.praktika_jwt_token.dto.StudentRequest;
import com.example.praktika_jwt_token.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentEditMapper {
    public Student create(StudentRequest request){
        if (request == null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudyFormat());
        // student.setGroups(new Group());

        return student;
    }

    public void update(Student student, StudentRequest request){
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());


    }
}
