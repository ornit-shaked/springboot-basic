package com.shakedm.organization.service.converter;

import com.shakedm.organization.domain.entity.Task;
import com.shakedm.organization.web.dtos.TaskDto;
import lombok.experimental.UtilityClass;

/**
 * Convert Entity to Dto
 */
@UtilityClass
public class TaskConverter {

    public TaskDto convert(Task entity) {
        return TaskDto.builder()
                .assignDate(entity.getAssignDate())
                .taskTest(entity.getTaskTest())
                .dueDate(entity.getDueDate())
                .build();
    }

    public Task convert(TaskDto dto) {
        return Task.builder()
                .assignDate(dto.getAssignDate())
                .taskTest(dto.getTaskTest())
                .dueDate(dto.getDueDate())
                .build();
    }
}
