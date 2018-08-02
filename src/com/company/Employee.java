package com.company;
import java.util.Scanner;

// Employee has first name, last name, annual salary, super rate, payment start date, payment end date,
// gross income, income tax, net income and super.


class Employee {
    private String firstName, lastName, startDate, endDate;
    private Integer annualSalary, grossIncome, taxValue;
    private Double superRate;

    void getEmployeeInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the payslip generator! \nPlease input your first name:");
        this.firstName = scanner.nextLine();
        System.out.println("Please input your surname:");
        lastName = scanner.nextLine();
        System.out.println("Please enter your annual salary:");
        this.annualSalary = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter your super rate:");
        this.superRate = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter your payment start date:");
        this.startDate = scanner.nextLine();
        System.out.println("Please enter your payment end date:");
        this.endDate = scanner.nextLine();
    }

    private void setGrossIncome(){
        grossIncome = (int)Math.round(annualSalary/12.0);
    }

    private void calculateTaxValue(){
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

    void calculatePaycheck(){
        calculateTaxValue();
        setGrossIncome();
    }

    void printPaycheck(){
        System.out.println("\nYour payslip has been generated: \n");
        System.out.println("Name: " + firstName + " " + lastName + "\n" +
                "Pay Period: " + startDate + " - " + endDate + "\n" +
                "Gross Income: " + grossIncome + "\n" +
                "Income Tax: " + taxValue + "\n" +
                "Net Income: " + (grossIncome - taxValue) + "\n" +
                "Super: " +  (int)((superRate / 100) * grossIncome) + "\n\n" +
                "Thank you for using MYOB!");
    }
}
