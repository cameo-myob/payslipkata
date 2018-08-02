package com.company;

// Employee has first name, last name, annual salary, super rate, payment start date, payment end date,
// gross income, income tax, net income and super.

public class Employee {
    String firstName, lastName, startDate, endDate;
    Integer annualSalary, grossIncome, taxValue;
    Double superRate;



    void setGrossIncome(){
        grossIncome = Math.round(annualSalary/12);
    }

    void calculateTaxValue(){
        double tax;
        if(annualSalary > 18201 && annualSalary < 37000){
            tax = ((annualSalary - 18200)*0.19) / 12;
        } else if(annualSalary > 37001 && annualSalary < 87000){
            tax = (3572 + (annualSalary - 37000)*0.325) / 12;
        } else if(annualSalary > 87001 && annualSalary < 180000){
            tax = (19822 + (annualSalary - 87000)*0.37) / 12;
        } else if(annualSalary > 180001){
            tax = (54232 + (annualSalary - 180000)*0.45) / 12;
        } else tax = 0.0;
        taxValue = (int)Math.round(tax);
    }

    void printPaycheckDetails(){
        System.out.println("\nYour payslip has been generated: \n");
        System.out.println("Name: " + firstName + " " + lastName + "\n" +
                "Pay Period: " + startDate + " - " + endDate + "\n" +
                "Gross income: " + grossIncome + "\n" +
                "Income tax: " + taxValue + "\n" +
                "Net income: " + (grossIncome - taxValue) + "\n" +
                "Super: " +  (int)((superRate / 100) * grossIncome) + "\n\n" +
                "Thank you for using MYOB!");
    }
}
