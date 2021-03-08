package com.shakedm.organization.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Embeddable
public class Task {

    @NotBlank
    private String taskTest;

    private Date assignDate;

    private Date dueDate;
}
