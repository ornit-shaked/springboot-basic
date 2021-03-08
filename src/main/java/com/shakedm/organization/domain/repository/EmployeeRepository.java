package com.shakedm.organization.domain.repository;

import com.shakedm.organization.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
