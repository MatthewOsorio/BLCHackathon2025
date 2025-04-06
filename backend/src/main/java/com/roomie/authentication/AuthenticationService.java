package com.roomie.authentication;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roomie.student.Student;
import com.roomie.student.StudentService;

@Service
public class AuthenticationService {

    private StudentService studentService;

    public AuthenticationService(StudentService studentService){
        this.studentService = studentService;
    }   

    public List<String> login(LoginRequest request) {
        if(studentService.checkCredentials(request)){
            Student student = studentService.findStudentByEmail(request.getEmail());

            return List.of(
                "Login successful",
                "Student ID: " + student.getId(),
                "Name: " + student.getName(),
                "Email: " + student.getEmail()
            );
        }
        return List.of("Unsuccessful login");
    }
}
