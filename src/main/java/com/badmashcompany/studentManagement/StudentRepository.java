package com.badmashcompany.studentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentMap = new HashMap<>(); //database

    public StudentRepository() {
        studentMap = new HashMap<>();
    }

    void addStudent(Student student){
        studentMap.put(student.getAdmnNo(),student);
    }

    Student getStudent(int admNo){
        return studentMap.getOrDefault(admNo,null);
    }

    Student getStud(String name){
        for (Map.Entry<Integer,Student> map: studentMap.entrySet()){
            Student student = map.getValue();
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    void deleteStudent(int admNo){
        if (studentMap.containsKey(admNo)){
            studentMap.remove(admNo);
        }
    }

    boolean updateStudent(String updatedBranch, int admNo){
        if (studentMap.containsKey(admNo)){
            Student student = studentMap.get(admNo);
            student.setBranch(updatedBranch);
            studentMap.put(admNo,student);
            return true;
        }
        return false;
    }
}
