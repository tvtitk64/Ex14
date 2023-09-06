package com.example.ex14.entity;

public class GoodStudent extends Student{
    private double gpa;
    private String bestRewardName;

    public GoodStudent(double gpa, String bestRewardName) {
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public GoodStudent(String id, Integer type, String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName) {
        super(id, type, fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
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

    @Override
    public void showMyInfo() {
        super.showMyInfo();
        System.out.println("GPA: " + gpa);
        System.out.println("Best Reward Name: " + bestRewardName);
    }
}
