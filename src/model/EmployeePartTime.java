package model;

public class EmployeePartTime extends Employee
{
    private double workHour;


    public EmployeePartTime(Long id, String code, String name, int age, String phone, String email, double workHour) {
        super(id, code,name, age, phone, email);
        this.workHour = workHour;
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    @Override
    public double realSalary() {
        return getWorkHour() * 100000;
    }
}
