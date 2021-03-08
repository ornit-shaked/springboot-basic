package com.shakedm.organization.service;


import com.shakedm.organization.domain.entity.Employee;
import com.shakedm.organization.domain.entity.Report;
import com.shakedm.organization.domain.entity.Task;
import com.shakedm.organization.domain.repository.EmployeeRepository;
import com.shakedm.organization.service.converter.EmployeeConverter;
import com.shakedm.organization.service.converter.ReportConverter;
import com.shakedm.organization.service.converter.TaskConverter;
import com.shakedm.organization.web.dtos.EmployeeDto;
import com.shakedm.organization.web.dtos.EmployeeType;
import com.shakedm.organization.web.dtos.ReportDto;
import com.shakedm.organization.web.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAll() {
        return EmployeeConverter.convert(employeeRepository.findAll());
    }

    public EmployeeDto get(Long id) {
        return EmployeeConverter.convert(employeeRepository.getOne(id));
    }

    public EmployeeDto addReport(Long id, ReportDto reportDto) {
        Employee employeeEntity = employeeRepository.getOne(id);
        if (employeeEntity != null && employeeEntity.getType() == EmployeeType.MANAGER.name()) {
            Report reportEntity = ReportConverter.convert(reportDto);
            employeeEntity.addReport(reportEntity);
        } else {
            throw new RuntimeException("Cannot add report, employee id not found or employee is not manager");
        }
        return EmployeeConverter.convert(employeeEntity);
    }

    public EmployeeDto addTask(Long id, TaskDto taskDto) {
        Employee employeeEntity = employeeRepository.getOne(id);
        if (employeeEntity != null ) {
            Task taskEntity = TaskConverter.convert(taskDto);
            employeeEntity.addTask(taskEntity);
        } else {
            throw new RuntimeException("employee id not found");
        }
        return EmployeeConverter.convert(employeeEntity);
    }
}
