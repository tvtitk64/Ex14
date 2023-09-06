package com.example.ex14.controller;

import com.example.ex14.entity.Student;
import com.example.ex14.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Student added successfully");
    }

    @GetMapping("/qualified-candidates")
    public ResponseEntity<List<Student>> getQualifiedCandidates(
            @RequestParam("numCandidatesToRecruit") int numCandidatesToRecruit) {
        List<Student> qualifiedCandidates = studentService.getQualifiedCandidates(numCandidatesToRecruit);
        return ResponseEntity.ok(qualifiedCandidates);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudentsSorted() {
        List<Student> allStudents = studentService.getAllStudentsSorted();
        return ResponseEntity.ok(allStudents);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }


}
