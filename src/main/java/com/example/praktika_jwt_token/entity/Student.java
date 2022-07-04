package com.example.praktika_jwt_token.entity;

import com.example.praktika_jwt_token.StudyFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.Group;

import javax.persistence.*;

import static javax.persistence.CascadeType.MERGE;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;

}
