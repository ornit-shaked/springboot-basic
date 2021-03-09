package com.shakedm.organization.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String type;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String position;

    @ToString.Exclude
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee directManager;

    @ElementCollection
    private List<Task> tasks;

    @ElementCollection
    private List<Report> reports;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "directManager")
    private List<Employee> employees;

    public void addTask(Task task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }

    public void addReport(Report report) {
        if (reports == null) {
            reports = new ArrayList<>();
        }
        reports.add(report);
    }

    @JsonIgnore
    public List<Employee> getEmployees() {
        return employees;
    }
}
