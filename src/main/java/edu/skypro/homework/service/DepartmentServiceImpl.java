package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;
import edu.skypro.homework.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee findMaxSalaryFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMinSalaryFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> printAllFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Collection<Employee> printAllSortedByDepartment() {
        return employeeServiceImpl.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .toList();
    }
}
