package com.shakedm.organization.web.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReportDto {

    private Long id;
    private String reportText;
    private Date reportDate;
}
