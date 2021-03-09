package com.shakedm.organization.service.converter;

import com.shakedm.organization.domain.entity.Employee;
import com.shakedm.organization.web.dtos.EmployeeDto;
import com.shakedm.organization.web.dtos.EmployeeType;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert Entity to Dto
 */
@UtilityClass
public class EmployeeConverter {
	
	public EmployeeDto convert(Employee entity) {
		return EmployeeDto.builder()
				.id(entity.getId())
				.type(EmployeeType.valueOf(entity.getType()))
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.position(entity.getPosition())
				.directManagerId(entity.getDirectManager() != null ? entity.getDirectManager().getId() : null)
				.reports(entity.getReports())
				.tasks(entity.getTasks())
				.build();
	}
	
	public List<EmployeeDto> convert(List<Employee> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return new ArrayList<>();
		}
		return entities.stream()
				.map(entity -> convert(entity))
				.collect(Collectors.toList());
	}
}
