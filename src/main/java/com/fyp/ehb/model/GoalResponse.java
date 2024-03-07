package com.fyp.ehb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fyp.ehb.domain.Customer;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoalResponse {

    private String id;
    private String goalTitle;
    private String goalDescription;
    private String startDate;
    private String endDate;
    private String unit;
    private String target;
    private String priority;
    private String reminder;
    private String goalStatus;
    private String isRecurringGoal;
    private Customer customer;
}
