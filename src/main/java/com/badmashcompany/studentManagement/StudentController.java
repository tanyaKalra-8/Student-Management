package com.badmashcompany.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    ResponseEntity<String> addStudent(@RequestBody() Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("Student added", HttpStatus.CREATED);
    }

    @GetMapping("/get_info")
    ResponseEntity<Student> getStudent(@RequestParam("id") int admnNo){
        Student student = null;
        student = studentService.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/get_in")
    ResponseEntity<Student> getStud(@RequestParam("name") String name){
        Student student = null;
        student = studentService.getStud(name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteStudent(@PathVariable("id") int admnNo){
        studentService.deleteStudent(admnNo);
        return new ResponseEntity<>("Student added", HttpStatus.OK);
    }

    @PutMapping("/update/{updateBranch}/{id}")
    ResponseEntity<String> uptadeStudent(@PathVariable("updatedBranch") String updatedBranch, @PathVariable("id") int admnNo){
        boolean flag = studentService.updateStudent(updatedBranch,admnNo);
        if (flag){
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Student updation failed", HttpStatus.BAD_REQUEST);
    }

}
