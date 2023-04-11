package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;
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
        List<Employee> emplList = List.copyOf(employeeServiceImpl.getEmployees().values());
        return emplList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee findMinSalaryFromDepartment(int department) {
        List<Employee> emplList = List.copyOf(employeeServiceImpl.getEmployees().values());
        return emplList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Collection<Employee> printAllFromDepartment(int department) {
        List<Employee> emplList = List.copyOf(employeeServiceImpl.getEmployees().values());
        return emplList.stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Collection<Employee> printAllSortedByDepartment() {
        List<Employee> emplList = List.copyOf(employeeServiceImpl.getEmployees().values());
        return emplList.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .toList();
    }
}
