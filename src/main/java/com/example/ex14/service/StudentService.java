package com.example.ex14.service;

import com.example.ex14.entity.GoodStudent;
import com.example.ex14.entity.NormalStudent;
import com.example.ex14.entity.Student;
import com.example.ex14.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    // Thêm sinh viên vào cơ sở dữ liệu
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    // Lấy danh sách sinh viên từ cơ sở dữ liệu
    public List<Student> getQualifiedCandidates(int numCandidatesToRecruit) {
        List<Student> qualifiedCandidates = new ArrayList<>();

        List<GoodStudent> goodStudents = new ArrayList<>();
        List<NormalStudent> normalStudents = new ArrayList<>();

        // Tách danh sách sinh viên khá giỏi và sinh viên trung bình
        for (Student student : studentRepository.getAllStudents()) {
            if (student instanceof GoodStudent) {
                goodStudents.add((GoodStudent) student);
            } else if (student instanceof NormalStudent) {
                normalStudents.add((NormalStudent) student);
            }
        }

        // Sắp xếp danh sách sinh viên khá giỏi theo GPA giảm dần
        Collections.sort(goodStudents, Comparator.comparingDouble(GoodStudent::getGpa).reversed());

        // Chọn ứng viên khá giỏi
        int numGoodStudentsToRecruit = Math.min(numCandidatesToRecruit, goodStudents.size());
        qualifiedCandidates.addAll(goodStudents.subList(0, numGoodStudentsToRecruit));

        // Nếu vẫn cần tuyển sinh viên, chọn ứng viên trung bình
        if (qualifiedCandidates.size() < numCandidatesToRecruit) {
            // Sắp xếp danh sách sinh viên trung bình theo điểm thi đầu vào và điểm TOEIC giảm dần
            Collections.sort(normalStudents, Comparator.comparingDouble(NormalStudent::getEntryTestScore).reversed()
                    .thenComparing(NormalStudent::getEnglishScore).reversed());

            int numNormalStudentsToRecruit = numCandidatesToRecruit - qualifiedCandidates.size();
            qualifiedCandidates.addAll(normalStudents.subList(0, numNormalStudentsToRecruit));
        }

        return qualifiedCandidates;
    }

    public List<Student> getAllStudentsSorted() {
        List<Student> allStudents = studentRepository.getAllStudents();
        Collections.sort(allStudents);
        return allStudents;
    }
}
