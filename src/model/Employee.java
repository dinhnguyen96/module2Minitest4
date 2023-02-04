package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Employee
{
    private Long id;
    private String code;

    private String name;
    private int age;
    private String phone;
    private String email;

    protected Employee()
    {
        this.id = 0L;
        this.code = "";
        this.name = "";
        this.age = 0;
        this.email = "";
        this.phone = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void employeeInfoInput()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Id = ");
        this.id = Long.parseLong(input.next());
        System.out.print("Code = ");
        this.code = input.next();
        input = new Scanner(System.in);
        System.out.print("Name = ");
        this.name = input.nextLine();
        input = new Scanner(System.in);
        System.out.print("Age = ");
        this.age = Integer.parseInt(input.next());
        System.out.print("Phone = ");
        this.phone = input.next();
        input = new Scanner(System.in);
        System.out.print("Email = ");
        this.email = input.next();
    }

    public abstract double getRealSalary();
}
