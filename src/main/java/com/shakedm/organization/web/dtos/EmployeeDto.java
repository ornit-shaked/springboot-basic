package com.shakedm.organization.web.dtos;

import com.shakedm.organization.domain.entity.Employee;
import com.shakedm.organization.domain.entity.Report;
import com.shakedm.organization.domain.entity.Task;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeDto {

    private Long id;
    private EmployeeType type;
    private String firstName;
    private String lastName;
    private String position;
    private Employee directManager;
    private List<Task> tasks;
    private List<Report> reports;
}
