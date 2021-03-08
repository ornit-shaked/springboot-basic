package com.shakedm.organization.service.converter;

import com.shakedm.organization.domain.entity.Report;
import com.shakedm.organization.web.dtos.ReportDto;
import lombok.experimental.UtilityClass;

/**
 * Convert Entity to Dto
 */
@UtilityClass
public class ReportConverter {

    public ReportDto convert(Report entity) {
        return ReportDto.builder()
                .reportText(entity.getReportText())
                .reportDate(entity.getReportDate())
                .build();
    }

    public Report convert(ReportDto dto) {
        return Report.builder()
                .reportText(dto.getReportText())
                .reportDate(dto.getReportDate())
                .build();
    }
}
