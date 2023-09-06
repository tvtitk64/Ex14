package com.example.ex14.service;

import com.example.ex14.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> getQualifiedCandidates(int numCandidatesToRecruit);

    List<Student> getAllStudentsSorted();

    void deleteStudent(String id);
}
