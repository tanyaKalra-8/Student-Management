package com.badmashcompany.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    Student getStudent(int admNo){
        return studentRepository.getStudent(admNo);
    }

    Student getStud(String name){
        return studentRepository.getStud(name);
    }

    void deleteStudent(int admNo){
        studentRepository.deleteStudent(admNo);
    }

    boolean updateStudent(String updatedBranch, int admNo){
        return studentRepository.updateStudent(updatedBranch,admNo);
    }
}
