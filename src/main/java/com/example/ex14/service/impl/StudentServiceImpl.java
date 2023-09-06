package com.example.ex14.service.impl;

import com.example.ex14.entity.GoodStudent;
import com.example.ex14.entity.NormalStudent;
import com.example.ex14.entity.ResponseObject;
import com.example.ex14.entity.Student;
import com.example.ex14.repository.StudentRepository;
import com.example.ex14.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    // Thêm sinh viên vào cơ sở dữ liệu
    @Override
    public ResponseObject addStudent(Student student) {
        ResponseObject responseObject = new ResponseObject();
//        studentRepository.addStudent(student);
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            responseObject.setMessage("failed");
        }
        return responseObject;
    }

    // Lấy danh sách sinh viên từ cơ sở dữ liệu
    @Override
    public List<Student> getQualifiedCandidates(int numCandidatesToRecruit) {
        List<Student> qualifiedCandidates = new ArrayList<>();

        List<GoodStudent> goodStudents = new ArrayList<>();
        List<NormalStudent> normalStudents = new ArrayList<>();

        // Tách danh sách sinh viên khá giỏi và sinh viên trung bình
        for (Student student : studentRepository.findAll()) {
            if (student instanceof GoodStudent) {
                goodStudents.add((GoodStudent) student);
            } else if (student instanceof NormalStudent) {
                normalStudents.add((NormalStudent) student);
            }
        }

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

//    @Override
//    public List<Student> getAllStudentsSorted() {
//        List<Student> allStudents = studentRepository.findAll();
//        Collections.sort(allStudents);
//        return allStudents;
//    }

    @Override
    public ResponseObject deleteStudent(long id) {
        ResponseObject responseObject = new ResponseObject();
//        studentRepository.addStudent(student);
        try {
            studentRepository.deleteById((int) id);
        } catch (Exception e) {
            responseObject.setMessage("failed");
        }
        return responseObject;
    }
}
