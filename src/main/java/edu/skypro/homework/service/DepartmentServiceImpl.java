package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee findMaxSalaryInDepartment(int department) {
        List<Employee> employeeList = List.copyOf(employeeServiceImpl.getEmployees().values());
        return employeeList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    @Override
    public Employee findMinSalaryInDepartment(Map<String, Employee> employeeMap, int department) {
        return null;
    }

    @Override
    public Collections printAllFromDepartment(Map<String, Employee> employeeMap, int department) {
        return null;
    }

    @Override
    public Collections sortedPrintAll(Map<String, Employee> employeeMap) {
        return null;
    }
}
