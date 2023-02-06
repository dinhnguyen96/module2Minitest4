package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeFullTime extends Employee
{
    private double salary;
    private double bonusMoney;
    private double violationMoney;


    public EmployeeFullTime()
    {
        super();
        this.salary = 0;
        this.bonusMoney = 0;
        this.violationMoney = 0;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonusMoney() {
        return bonusMoney;
    }
    public void setBonusMoney(double bonusMoney) {
        this.bonusMoney = bonusMoney;
    }
    public double getViolationMoney() {
        return violationMoney;
    }
    public void setViolationMoney(double violationMoney) {
        this.violationMoney = violationMoney;
    }
    @Override
    public void employeeInfoInput()
    {
        boolean result = false;
        do
        {
            try
            {
                super.employeeInfoInput();
                Scanner input = new Scanner(System.in);
                System.out.print("Salary = ");
                this.salary = Double.parseDouble(input.nextLine());
                System.out.print("Bonus Money = ");
                this.bonusMoney = Double.parseDouble(input.nextLine());
                System.out.print("Violation Money = ");
                this.violationMoney = Double.parseDouble(input.nextLine());
                System.out.println();
                result = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Nhập dữ liệu không hợp lệ !");
            }
        }
        while (!result);
    }

    @Override
    public double getRealSalary()
    {
        return getSalary() + (getBonusMoney()-getViolationMoney());
    }
}
