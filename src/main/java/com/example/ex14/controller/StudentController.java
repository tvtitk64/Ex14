package com.example.ex14.controller;

import com.example.ex14.entity.ResponseObject;
import com.example.ex14.entity.Student;
import com.example.ex14.service.StudentService;
import com.example.ex14.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseObject addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
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
    public ResponseObject deleteStudentById(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }


}
