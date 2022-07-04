package com.example.praktika_jwt_token.controller;

import com.example.praktika_jwt_token.dto.StudentRequest;
import com.example.praktika_jwt_token.dto.StudentResponse;
import com.example.praktika_jwt_token.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentController {
    private final StudentService service;

    @PostMapping
    @Operation(summary = "can create student", description = "we can create student")
    public StudentResponse create(@RequestBody StudentRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "can update student", description = "we can update student by id")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/find/{id}")
    @Operation(summary = "can find student", description = "we can find student by ID")
    public StudentResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    @Operation(summary = "can delete student", description = "we can delete student by ID")
    public StudentResponse delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return service.getAllStudents();
    }


}
