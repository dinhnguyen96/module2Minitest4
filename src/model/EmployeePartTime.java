package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeePartTime extends Employee
{
    private double workHour;

    public EmployeePartTime()
    {
        super();
        this.workHour = 0;
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    @Override
    public void employeeInfoInput()
    {
        try
        {
            super.employeeInfoInput();
            Scanner input = new Scanner(System.in);
            System.out.print("Work Hour = ");
            this.workHour = Double.parseDouble(input.next());
            System.out.println();
        }
        catch (InputMismatchException | NumberFormatException e)
        {
            System.out.println("Nhập dữ liệu không hợp lệ !");
        }
    }

    @Override
    public double getRealSalary() {
        return getWorkHour() * 100000;
    }
}
