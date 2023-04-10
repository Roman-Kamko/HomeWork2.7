package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, double salary, int department);

    Employee remove(String firstName, String lastName, double salary, int department);

    Employee find(String firstName, String lastName, double salary, int department);

    Collection<Employee> printAll();
}
