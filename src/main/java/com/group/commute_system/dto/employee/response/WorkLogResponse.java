package com.group.commute_system.dto.employee.response;

import lombok.Getter;

import java.util.List;

@Getter
public class WorkLogResponse {
    private List<WorkLogDetail> details;
    private long sum;

    public WorkLogResponse(List<WorkLogDetail> details, long sum) {
        this.details = details;
        this.sum = sum;
    }
}
