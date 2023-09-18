package com.example.Student.Service;

import com.example.Student.Payloads.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto creatStudent(StudentDto Student);
    StudentDto updateUser(StudentDto studentDto,Long studentId);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudents();
    void deleteStudent(Long studentId);
}
