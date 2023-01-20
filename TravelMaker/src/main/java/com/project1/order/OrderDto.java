package com.project1.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private String startDate;
    private String endDate;
    private String people;
    private String startDateTime;
    private String endDateTime;
    private String email;
    private int region;
    private String selectedRegion;
    private int peopleInt;
}