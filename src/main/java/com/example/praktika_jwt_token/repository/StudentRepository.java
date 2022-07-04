package com.example.praktika_jwt_token.repository;

import com.example.praktika_jwt_token.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
