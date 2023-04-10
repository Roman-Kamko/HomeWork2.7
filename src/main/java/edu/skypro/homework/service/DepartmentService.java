package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;

import java.util.Collections;
import java.util.Map;

public interface DepartmentService {
    Employee findMaxSalaryInDepartment(int department);

    Employee findMinSalaryInDepartment(Map<String, Employee> employeeMap, int department);

    Collections printAllFromDepartment(Map<String, Employee> employeeMap, int department);

    Collections sortedPrintAll(Map<String, Employee> employeeMap);
}
