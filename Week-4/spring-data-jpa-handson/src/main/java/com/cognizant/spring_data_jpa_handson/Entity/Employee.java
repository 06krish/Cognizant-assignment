package com.cognizant.spring_data_jpa_handson.Entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // used Integer instead of int because int cant hold null value (initially it will hold null value)
    private Integer id;
    private String name;
    private String deprt;
    private double salary;
    public Employee(){} // just to tell jpa that this employee class exist
    public Employee(String name , String deprt, double salary){
        this.name = name;
        this.deprt = deprt;
        this.salary = salary;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return deprt;
    }
    public void setDepartment(String department) {
        this.deprt = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + deprt + '\'' +
                ", salary=" + salary +
                '}';
    }

}
