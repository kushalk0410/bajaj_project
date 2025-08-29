package com.example.sqlsolver.service;

import org.springframework.stereotype.Service;

// Decides which SQL query to send
@Service
public class SqlChooser {

    public String pickSql(boolean isOdd) {
        if (isOdd) {
            // TODO: replace with real SQL for Question 1
            return "SELECT /* Your SQL for Q1 */ 1;";
        } else {
            // TODO: replace with real SQL for Question 2
            return "SELECT /* Your SQL for Q2 */ 2;";
        }
    }

    // Figure out if regNo last two digits are odd or even
    public boolean isOdd(String regNo) {
        String digits = regNo.replaceAll("\\D+", "");
        int lastTwo = Integer.parseInt(digits.substring(digits.length() - 2));
        return lastTwo % 2 != 0;
    }
}
