package com.example.ex14.dto;

public class GoodStudentDTO extends StudentDTO {
    public double gpa;
    public String bestRewardName;

    public GoodStudentDTO(String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, int gradeLevel, double gpa, String bestRewardName) {
        super(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }
}
