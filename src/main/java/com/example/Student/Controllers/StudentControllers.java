package com.example.Student.Controllers;


import com.example.Student.Payloads.StudentDto;
import com.example.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentControllers {
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto createStudentDto = this.studentService.creatStudent(studentDto);
        return new ResponseEntity<>(createStudentDto, HttpStatus.CREATED);
    }

}
