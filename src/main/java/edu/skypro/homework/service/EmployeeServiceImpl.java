package edu.skypro.homework.service;

import edu.skypro.homework.domain.Employee;
import edu.skypro.homework.exceptions.EmployeeAlreadyAddedException;
import edu.skypro.homework.exceptions.EmployeeNotFoundException;
import edu.skypro.homework.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private final ValidatorService validatorService;

    public EmployeeServiceImpl(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private String getKey(Employee employee) {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public Employee add(String firstName, String lastName, BigDecimal salary, int department) {

        validatorService.checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.containsKey(getKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(getKey(employee), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, BigDecimal salary, int department) {

        validatorService.checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.containsKey(getKey(employee))) {
            return employees.remove(getKey(employee));
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, BigDecimal salary, int department) {

        validatorService.checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.containsKey(getKey(employee))) {
            return employees.get(getKey(employee));
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> printAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
