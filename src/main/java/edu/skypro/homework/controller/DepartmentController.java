package edu.skypro.homework.controller;

import edu.skypro.homework.domain.Employee;
import edu.skypro.homework.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalaryInDepartment(@RequestParam int departmentId) {
        return departmentService.findMaxSalaryInDepartment(departmentId);
    }
}
