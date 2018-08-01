package com.company;
import java.util.Scanner;

// KATA DETAILS
//Pay period = per calendar month
//Gross income = annual salary / 12 months
//Income tax = based on the tax table provided below
//Net income = gross income - income tax
//Super = gross income x super rate
//All calculation results should be rounded to the whole dollar. If >= 50 cents round up to the next dollar increment, otherwise round down.

//When supplied employee details: first name, last name, annual salary (positive integer) and super rate (0% - 50% inclusive), payment start date, generate pay slip information with name, pay period, gross income, income tax, net income and super.


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    System.out.println("Welcome to the payslip generator! \nPlease input your first name:");
	    String firstName = scanner.nextLine();
	    System.out.println("Please input your surname:");
	    String lastName = scanner.nextLine();
        System.out.println("Please enter your annual salary:");
        int salary = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter your super rate:");
        double superRate = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter your payment start date:");
        String startDate = scanner.nextLine();
        System.out.println("Please enter your payment end date:");
        String endDate = scanner.nextLine();

        int grossIncome = Math.round(salary/12);
        double superPercent = superRate / 100;
        System.out.println("\nYour payslip has been generated: \n");
        int taxValue = (int)Math.round(calculateMonthlyTax(salary));

        System.out.println("Name: " + firstName + " " + lastName + "\n" +
                "Pay Period: " + startDate + " - " + endDate + "\n" +
                "Gross income: " + grossIncome + "\n" +
                "Income tax: " + taxValue + "\n" +
                "Net income: " + (grossIncome - taxValue) + "\n" +
                "Super: " +  (int)(superPercent * grossIncome) + "\n\n" +
                "Thank you for using MYOB!");

    }

    private static Double calculateMonthlyTax(Integer salary) {
        double tax;
        if(salary > 18201 && salary < 37000){
            tax = ((salary - 18200)*0.19) / 12;
        } else if(salary > 37001 && salary < 87000){
            tax = (3572 + (salary - 37000)*0.325) / 12;
        } else if(salary > 87001 && salary < 180000){
            tax = (19822 + (salary - 87000)*0.37) / 12;
        } else if(salary > 180001){
            tax = (54232 + (salary - 180000)*0.45) / 12;
        } else tax = 0.0;
        return tax;
    }
}
