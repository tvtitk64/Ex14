package com.example.ex14.repository;

import com.example.ex14.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    void addStudent(Student student);

}
