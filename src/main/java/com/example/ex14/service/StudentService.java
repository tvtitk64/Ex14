package com.example.ex14.service;

import com.example.ex14.entity.ResponseObject;
import com.example.ex14.entity.Student;

import java.util.List;

public interface StudentService {
    ResponseObject addStudent(Student student);

    List<Student> getQualifiedCandidates(int numCandidatesToRecruit);

//    List<Student> getAllStudentsSorted();

    ResponseObject deleteStudent(long id);
}
