package com.company;

import java.io.*;

// PAYSLIP KATA DETAILS
// Pay period = per calendar month
// Gross income = annual salary / 12 months
// Income tax = based on the tax table provided below
// Net income = gross income - income tax
// Super = gross income x super rate
// All calculation results should be rounded to the whole dollar. If >= 50 cents round up to the next dollar increment, otherwise round down.

// When supplied employee details: first name, last name, annual salary (positive integer) and super rate (0% - 50% inclusive), payment start date, generate pay slip information with name, pay period, gross income, income tax, net income and super.


public class Main {

    public static void main(String[] args) {

        Employee user = new Employee();

        user.getEmployeeInfo();
        user.calculatePaycheck();
        user.printPaycheck();

    }


}
