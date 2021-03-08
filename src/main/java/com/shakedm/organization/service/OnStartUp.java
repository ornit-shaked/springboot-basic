package com.shakedm.organization.service;

import com.shakedm.organization.domain.entity.Employee;
import com.shakedm.organization.domain.repository.EmployeeRepository;
import com.shakedm.organization.web.dtos.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;

@Service
public class OnStartUp implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Employee senior = employeeRepository.save(Employee.builder()
                .firstName("EMPLOYEE1_firstname")
                .lastName("EMPLOYEE1_lastname")
                .type(EmployeeType.EMPLOYEE.name())
                .position("senior").build());

        Employee junior = employeeRepository.save(Employee.builder()
                .firstName("EMPLOYEE2_firstname")
                .lastName("EMPLOYEE2_lastname")
                .type(EmployeeType.EMPLOYEE.name())
                .position("junior").build());

        Employee manager = employeeRepository.save(Employee.builder()
                .firstName("GL_firstname")
                .lastName("GL_lastname")
                .type(EmployeeType.MANAGER.name())
                .position("GL")
                .employees(Arrays.asList(senior, junior)).build());

        Employee rootManager = employeeRepository.save(Employee.builder()
                .firstName("PM_firstname")
                .lastName("PM_lastname")
                .type(EmployeeType.MANAGER.name())
                .position("PM")
                .employees(Collections.singletonList(manager)).build());

        manager.setDirectManager(rootManager);
        senior.setDirectManager(manager);
        junior.setDirectManager(manager);
    }
}
