package com.shakedm.organization.web.controller;

import com.shakedm.organization.service.EmployeeService;
import com.shakedm.organization.web.dtos.EmployeeDto;
import com.shakedm.organization.web.dtos.ReportDto;
import com.shakedm.organization.web.dtos.TaskDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Employee Controller")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ApiOperation("Get All employees")
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get employee by id")
    public EmployeeDto get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    @PostMapping("/add-report/{id}")
    @ApiOperation("Add report")
    public EmployeeDto addReport(@PathVariable Long id,
                                 @RequestBody ReportDto reportDto) {
        return employeeService.addReport(id, reportDto);
    }

    @PostMapping("/assign-task/{id}")
    @ApiOperation("Assign task")
    public EmployeeDto addTask(@PathVariable Long id,
                               @RequestBody TaskDto taskDto) {
        return employeeService.addTask(id, taskDto);
    }
}
