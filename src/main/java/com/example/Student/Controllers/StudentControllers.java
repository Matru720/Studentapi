package com.example.Student.Controllers;


import com.example.Student.Payloads.ApiResponse;
import com.example.Student.Payloads.StudentDto;
import com.example.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long studentId)
    {
        StudentDto updatedStudent = this.studentService.updateUser(studentDto,studentId);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("studentId") Long studentId)
    {
        this.studentService.deleteStudent(studentId);
        return new ResponseEntity<>(new ApiResponse("Student deleted Successfully", true),HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteAllStudents() {
         this.studentService.deleteAllStudents();
        return new ResponseEntity<>(new ApiResponse("All students deleted Successfully", true), HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudent(){
        return ResponseEntity.ok(this.studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getSingleStudent(@PathVariable Long studentId){
        return ResponseEntity.ok(this.studentService.getStudentById(studentId));
    }


}
