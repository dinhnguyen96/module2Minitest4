package model;

public class EmployeeFullTime extends Employee
{
    private double salary;
    private double bonusMoney;
    private double violationMoney;


    public EmployeeFullTime(Long id, String code, String name,int age, String phone, String email, double salary, double bonusMoney, double violationMoney)
    {
        super(id, code, name, age, phone, email);
        this.salary = salary;
        this.bonusMoney = bonusMoney;
        this.violationMoney = violationMoney;
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
    public double realSalary()
    {
        return getSalary() + (getBonusMoney()-getViolationMoney());
    }
}
