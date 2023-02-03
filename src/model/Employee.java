package model;

public abstract class Employee
{
    private Long id;
    private String code;

    private String name;
    private int age;
    private String phone;
    private String email;

    protected Employee(Long id, String code, String name, int age, String phone, String email)
    {
        this.id = id;
        this.code = code;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
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

    public abstract double realSalary();
}
