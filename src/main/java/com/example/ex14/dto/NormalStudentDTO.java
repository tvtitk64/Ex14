package com.example.ex14.dto;

public class NormalStudentDTO extends StudentDTO{

    public double entryTestScore;
    public double englishScore;

    public NormalStudentDTO(String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, int gradeLevel, double entryTestScore, double englishScore) {
        super(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
        this.entryTestScore = entryTestScore;
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }
}
