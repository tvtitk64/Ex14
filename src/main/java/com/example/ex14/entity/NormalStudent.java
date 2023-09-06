package com.example.ex14.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Normal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalStudent extends Student{
    private double englishScore;
    private double entryTestScore;


}
