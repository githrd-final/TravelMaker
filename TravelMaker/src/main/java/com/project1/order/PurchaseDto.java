package com.project1.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDto {

    private String purchaseSerial;
    private String email;
    private int price;
    private int people;
    private int region;
    private String startDate;
    private String endDate;
    private String startDateTime;
    private String endDateTime;
    private String city;
}
