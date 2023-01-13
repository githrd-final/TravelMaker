package com.project1.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    public String selectRegion(String region);

    public Integer checkTicket(List<String> dateList);

    public String purchaseTicket(String email, int people, String selectedRegion, String startDate, String endDate, String startDateTime, String endDateTime);

}