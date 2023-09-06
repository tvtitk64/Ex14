package com.example.ex14.utils;

import com.example.ex14.exception.InvalidDOBException;
import com.example.ex14.exception.InvalidFullNameException;
import com.example.ex14.exception.InvalidPhoneNumberException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    public static void checkFullName(String fullName) throws InvalidFullNameException {
        if (fullName.length() > 50 || fullName.length() < 10) {
            throw new InvalidFullNameException("Invalid full name!");
        }
    }

    public static void checkDOB(String doB) throws InvalidDOBException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        String doBString = dateFormat.format(doB);

        if (!doBString.equals(dateFormat.format(parseDate(doBString)))) {
            throw new InvalidDOBException("Invalid date of birth!");
        }
    }

    public static void checkPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        String[] validPrefixes = {"090", "098", "091", "031", "035", "038"};

        boolean isValidPrefix = false;
        for (String prefix : validPrefixes) {
            if (phoneNumber.startsWith(prefix)) {
                isValidPrefix = true;
                break;
            }
        }

        if (phoneNumber.length() != 10 || !isValidPrefix) {
            throw new InvalidPhoneNumberException("Invalid phone number!");
        }
    }

    public static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
