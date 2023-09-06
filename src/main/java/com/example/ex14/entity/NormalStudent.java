package com.example.ex14.entity;

public class NormalStudent extends Student{
    private double englishScore;
    private double entryTestScore;

    public NormalStudent(double englishScore, double entryTestScore) {
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public NormalStudent(String id, Integer type, String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, String gradeLevel, double englishScore, double entryTestScore) {
        super(id, type, fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void showMyInfo() {
        super.showMyInfo();
        System.out.println("English Score: " + englishScore);
        System.out.println("Entry Test Score: " + entryTestScore);
    }
}
