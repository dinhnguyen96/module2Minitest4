package views;

import controller.EmployeeManager;
import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static EmployeeManager employeeManager = new EmployeeManager();

    public static void dataInput()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số lượng nhân viên : ");
        int n = input.nextInt();
        for (int i = 0; i < n;)
        {
            Employee employee;
            boolean exitsChecked;
            System.out.println("Nhập thông tin nhân viên thứ "+i+" : ");
            System.out.println("Loại nhân viên");
            System.out.println("1.Nhân viên toàn thời gian");
            System.out.println("2.Nhân viên bán thời gian");
            String type = input.next();
            switch (type)
            {
                case "1":
                    employee = new EmployeeFullTime();
                    employee.employeeInfoInput();
                    exitsChecked = employeeManager.employeeExitsCheck(employee.getId(), employee.getCode());
                    if (!exitsChecked)
                    {
                        employeeManager.addEmployee(employee);
                        i++;
                    }
                    break;
                case "2":
                    employee = new EmployeePartTime();
                    employee.employeeInfoInput();
                    exitsChecked = employeeManager.employeeExitsCheck(employee.getId(), employee.getCode());
                    if (!exitsChecked)
                    {
                        employeeManager.addEmployee(employee);
                        i++;
                    }
                    break;
            }
        }
    }

    public static void employeeListDisplay()
    {
        System.out.println("Danh sách nhân viên trong công ty: ");
        String result = employeeManager.employeeListDisplay();
        System.out.println(result);
    }

    public static void employeeFullTimeListSalarylessAverageDisplay()
    {
        String result = employeeManager.employeeFullTimeListSalarylessAverage();
        if (result.equals(""))
        {
            System.out.println("Không có nhân viên toàn gian nào có lương ít hơn lương trung bình ");
        }
        else
        {
            System.out.println("Danh sách nhân viên toàn thời gian có lương ít hơn lương trung bình : ");
            System.out.println(result);
        }

    }
    public static void employeePartTimeSalarySum()
    {
        double employeePartTimeSalarySum = employeeManager.employeePartTimeSalarySum();
        System.out.println("Tổng số tiền mà công ty trả cho nhân viên bán thời gian : " + employeePartTimeSalarySum);
    }

    public static void employeeFullTimeSortBySalary()
    {
        System.out.println("Danh sách nhân viên toàn thời gian trong công ty theo lương : ");
        List<Employee> employeeList = employeeManager.employeeFullTimeSortBySalary();
        for (Employee employee : employeeList)
        {
            if (employee instanceof EmployeeFullTime)
            {
                System.out.println(employee.getCode() + " "+ employee.getName()+" "+employee.getAge());
            }
        }
    }

    public static void testProgram()
    {
        dataInput();
        employeeListDisplay();
        employeeFullTimeListSalarylessAverageDisplay();
        System.out.println();
        employeePartTimeSalarySum();
        System.out.println();
        employeeFullTimeSortBySalary();
    }

    public static void main(String[] args)
    {
        testProgram();
    }
}
