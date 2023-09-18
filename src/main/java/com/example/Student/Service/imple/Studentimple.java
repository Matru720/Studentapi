package com.example.Student.Service.imple;

import com.example.Student.Entity.Student;
import com.example.Student.Exceptions.ResourceNotFoundException;
import com.example.Student.Payloads.StudentDto;
import com.example.Student.Reposetories.StudentRepo;
import com.example.Student.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class Studentimple implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto creatStudent(StudentDto studentDto) {
        Student student = this.dtoToStudent(studentDto);
        Student savedStudent = this.studentRepo.save(student);
        return this.studentToDto(savedStudent);
    }

    @Override
    public StudentDto updateUser(StudentDto studentDto , Long studentId) {
        Student student = this.studentRepo.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student","Id",studentId));
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setAdhar_no(Integer.parseInt(studentDto.getAdhar_no()));

        Student updateStudent = this.studentRepo.save(student);
        StudentDto studentDto1 = this.studentToDto(updateStudent);
        return studentDto1;
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = this.studentRepo.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",studentId));
        return this.studentToDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = this.studentRepo.findAll();
        List<StudentDto> studentDtos = students.stream().map(student -> this.studentToDto(student)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = this.studentRepo.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Student","Id",studentId));

        this.studentRepo.delete(student);
    }

    public Student dtoToStudent(StudentDto studentDto){
        Student student = this.modelMapper.map(studentDto,Student.class);
        return student;
    }

    public StudentDto studentToDto(Student student){
        StudentDto studentDto = this.modelMapper.map(student,StudentDto.class);
        return studentDto;
    }
}
