package controller;

import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {

    private List<Employee> employeeList;

    public EmployeeManager()
    {
        employeeList = new ArrayList<>();
        employeeList.add(new EmployeePartTime(1L,"12DH110544","Trần Văn Tùng",
                      23,"0941904792", "tranvantung2005@gmnail.com", 10));
        employeeList.add(new EmployeePartTime(2L,"12DH110522","Nguyễn Quang Huy",
                20,"0945417915", "quanghuy1005@gmnail.com", 8));
        employeeList.add(new EmployeePartTime(3L,"12DH110521","Phan Công Thông",
                21,"0947888256", "congthong0506@gmnail.com", 30));
        employeeList.add(new EmployeeFullTime(4L,"12DH110585","Nguyễn Đình Nguyên",
                27,"0952444922", "nguyendinhnguyen2510@gmail.com",
                       3000000,15000000,500000));
        employeeList.add(new EmployeeFullTime(5L,"12DH110530","Nguyễn Ngọc Anh",
                25,"0942853114", "nguyenngocanh0505@gmail.com",
                3000000,1000000,500000));
        employeeList.add(new EmployeeFullTime(6L,"12DH110585","Nguyễn Thị Nhung",
                26,"0941504282", "nguyenthinhung2510@gmail.com",
                7000000,1000000,250000));
    }

    public String employeeListDisplay()
    {
        String result = "";
        for (Employee employee : employeeList)
        {
            result += employee.getCode() + " "+ employee.getName()+" "+employee.getAge() + "\n";
        }
        return result;
    }
    public double salaryAverage()
    {
        double salarySum = 0;

        for (Employee employee : employeeList)
        {
           salarySum += employee.realSalary();
        }

        return salarySum / employeeList.size();
    }
    public String employeeFullTimeListSalarylessAverage()
    {
        String result = "";
        double salaryAverage = salaryAverage();
        for (Employee employee : employeeList)
        {
            if (employee instanceof EmployeeFullTime && employee.realSalary() < salaryAverage)
            {
                result += employee.getCode() + " "+ employee.getName()+" "+employee.getAge()+"\n";
            }
        }
        return result;
    }
    public double employeePartTimeSalarySum()
    {
        double employeePartimeSalary = 0;
        for (Employee employee : employeeList)
        {
            if (employee instanceof EmployeePartTime)
            {
                employeePartimeSalary += employee.realSalary();
            }
        }
        return employeePartimeSalary;
    }
    public List<Employee> employeeFullTimeSortBySalary()
    {
        employeeList.sort((employee1, employee2) ->
        {
            if (employee1 instanceof EmployeeFullTime && employee2 instanceof EmployeeFullTime)
            {
                if (employee1.realSalary() > employee2.realSalary())
                {
                    return 1;
                }
                else if (employee1.realSalary() < employee2.realSalary())
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
            return -100;
        });
        return employeeList;
    }













}
