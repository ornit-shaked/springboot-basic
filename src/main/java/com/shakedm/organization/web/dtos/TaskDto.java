package com.shakedm.organization.web.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TaskDto {

    private Long id;
    private String taskTest;
    private Date assignDate;
    private Date dueDate;
}
