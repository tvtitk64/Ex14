package com.example.ex14.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Good")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodStudent extends Student{
    private double gpa;
    private String bestRewardName;


}
