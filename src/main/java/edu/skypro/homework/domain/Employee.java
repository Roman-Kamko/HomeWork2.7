package edu.skypro.homework.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private double salary; // todo переделать на BigDecimal
    private int department;

    public Employee(String firstName, String lastName, double salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {return department;}

    @Override
    public String toString() {
        return String.format(
                "ФИО - %s; Оклад - %.2f; Отдел - %d",
                firstName + " " + lastName,
                salary,
                department
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
