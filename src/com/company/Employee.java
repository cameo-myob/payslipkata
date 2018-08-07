package src.com.company;
import java.util.Scanner;

// Employee inputs first name, last name, annual salary, super rate, payment start date, payment end date,
// Generate gross income, income tax, net income and super.


public class Employee{
    private String firstName, lastName, startDate, endDate;
    private double superRate;
    private int annualSalary;


    public Employee(String firstName, String lastName, String startDate, String endDate, int annualSalary, double superRate)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
    }

    private int calcGrossIncome(int annualSalary)
    {
        return Math.round(annualSalary / 12);
    }

    private int calcIncomeTax(int annualSalary)
    {
        double taxValue;
        if(annualSalary <= 18200)
        {
            taxValue = 0;
        } else if (annualSalary > 18200 && annualSalary <= 37000 )
        {
            taxValue = (annualSalary - 18000) * 0.19;
        } else if(annualSalary > 37000 && annualSalary <= 87000)
        {
            taxValue = 3572 + ((annualSalary - 37000) * 0.325);
        } else if(annualSalary > 87000 && annualSalary <= 180000)
        {
            taxValue = 19822 + ((annualSalary - 87000) * 0.37);
        } else
            taxValue = 54232 + ((annualSalary - 180000) * 0.45);

        taxValue = Math.round(taxValue/12);
        return (int)taxValue;
    }

    private int calcSuperValue(int annualSalary)
    {
        int superValue = calcGrossIncome(annualSalary);
        double superPercentage = superRate / 100;
        superValue = (int)Math.round(superValue * superPercentage);
        return superValue;
    }

    public void generatePayslip()
    {
        String payslip = "\nYour payslip has been generated:";
        payslip += "\nName: " + this.firstName + " " + this.lastName;
        payslip += "\nPay Period: " + this.startDate + " - " + this.endDate;
        payslip += "\nGross Income: " + calcGrossIncome(annualSalary);
        payslip += "\nIncome Tax: " + calcIncomeTax(annualSalary);
        payslip += "\nNet Income: " + (calcGrossIncome(annualSalary) - calcIncomeTax(annualSalary));
        payslip += "\nSuper: " + calcSuperValue(annualSalary);
        payslip += "\n\nThank you for using MYOB!";

        System.out.println(payslip);
    }

    public static Employee getEmployeeDetails()
    {
        String firstName, lastName, startDate, endDate;
        int annualSalary;
        double superRate;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the payslip generator! \n\nPlease input your first name: ");
        firstName = input.nextLine();
        System.out.println("Please input your last name: ");
        lastName = input.nextLine();
        System.out.println("Please input your annual salary: ");
        annualSalary = Integer.parseInt(input.nextLine());
        System.out.println("Please input your super rate: ");
        superRate = Double.parseDouble(input.nextLine());
        System.out.println("Please enter your payment start date: ");
        startDate = input.nextLine();
        System.out.println("Please enter your payment end date:");
        endDate = input.nextLine();

        return new Employee(firstName, lastName, startDate, endDate, annualSalary, superRate);
    }


}
