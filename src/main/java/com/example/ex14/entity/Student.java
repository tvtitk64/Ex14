package com.example.ex14.entity;

import com.example.ex14.constant.Regex;
import com.example.ex14.exception.InvalidDOBException;
import com.example.ex14.exception.InvalidFullNameException;
import com.example.ex14.exception.InvalidPhoneNumberException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer type;
    protected String fullName;
    @Column(name = "dOB")
    protected LocalDate dateOfBirth;
    protected String sex;
    protected String phoneNumber;
    protected String universityName;
    protected String gradeLevel;

    public void setBirthday(LocalDate birthday) throws InvalidDOBException {
        try {
            // Kiểm tra tính hợp lệ của ngày tháng bằng cách parse
            birthday.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            throw new InvalidDOBException("Invalid date of birth format");
        }
        this.dateOfBirth = birthday;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {

        Pattern pattern = Pattern.compile(Regex.PHONE_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (!matcher.matches()) {
            throw new InvalidPhoneNumberException("Invalid phone number format");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setFullName(String fullName) throws InvalidFullNameException {

        if (!fullName.matches(Regex.NAME_REGEX)) {
            throw new InvalidFullNameException("Invalid full name");
        }
        this.fullName = fullName;
    }


}
