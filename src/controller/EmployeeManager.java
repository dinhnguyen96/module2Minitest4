package controller;

import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeManager {

    private List<Employee> employeeList;

    private Set<Long> employeeIdSet;

    private Set<String> employeeCodeSet;


    public EmployeeManager()
    {
        employeeList = new ArrayList<>();
        employeeIdSet = new HashSet<>();
        employeeCodeSet = new HashSet<>();
    }

    public boolean employeeExitsCheck(Long id, String code)
    {
       if (employeeIdSet.contains(id) || employeeCodeSet.contains(code))
       {
           return true;
       }
       return false;
    }

    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
        employeeCodeSet.add(employee.getCode());
        employeeIdSet.add(employee.getId());
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
           salarySum += employee.getRealSalary();
        }

        return salarySum / employeeList.size();
    }
    public String employeeFullTimeListSalarylessAverage()
    {
        String result = "";
        double salaryAverage = salaryAverage();
        for (Employee employee : employeeList)
        {
            if (employee instanceof EmployeeFullTime && employee.getRealSalary() < salaryAverage)
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
                employeePartimeSalary += employee.getRealSalary();
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
                if (employee1.getRealSalary() > employee2.getRealSalary())
                {
                    return 1;
                }
                else if (employee1.getRealSalary() < employee2.getRealSalary())
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
