package views;

import controller.EmployeeManager;
import model.Employee;
import model.EmployeeFullTime;

import java.util.List;

public class Main {

    public static EmployeeManager employeeManager = new EmployeeManager();

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
