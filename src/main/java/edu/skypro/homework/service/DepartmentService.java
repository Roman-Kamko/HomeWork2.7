package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;

import java.util.Collection;

public interface DepartmentService {
    Employee findMaxSalaryFromDepartment(int department);

    Employee findMinSalaryFromDepartment(int department);

    Collection<Employee> printAllFromDepartment(int department);

    Collection<Employee> printAllSortedByDepartment();
}
