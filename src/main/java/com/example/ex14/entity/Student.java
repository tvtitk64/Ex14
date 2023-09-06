package com.example.ex14.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Student implements Comparable<Student>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer type;
    protected String fullName;
    @Column(name = "dOB")
    protected String dateOfBirth;
    protected String sex;
    protected String phoneNumber;
    protected String universityName;
    protected String gradeLevel;

    public Student() {}

    public Student(String id, Integer type, String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, String gradeLevel) {
        this.id = id;
        this.type = type;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void showMyInfo() {
        System.out.println("Id: " + id);
        System.out.println("Full name: " + fullName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Sex: " + sex);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("University: " + universityName);
        System.out.println("Grade level: " + gradeLevel);
    }

    @Override
    public int compareTo(Student student) {
        int fullNameComparison = this.fullName.compareTo(student.fullName);
        if (fullNameComparison != 0) {
            // Sắp xếp giảm dần theo fullName
            return -fullNameComparison;
        } else {
            // Sắp xếp tăng dần theo phoneNumber
            return this.phoneNumber.compareTo(student.phoneNumber);
        }
    }
}
