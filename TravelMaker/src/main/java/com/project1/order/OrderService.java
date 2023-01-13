package com.project1.order;

import com.project1.mybatis.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public String purchaseTicket(OrderDto orderDto) throws Exception {
        List<String> purchaseSerialList = new ArrayList<String>();
        String email = orderDto.getEmail();
        int people = (Integer.parseInt(orderDto.getPeople());
        String region = orderDto.getRegion();
        String startDate = orderDto.getStartDate();
        String endDate = orderDto.getEndDate();
        String startDateTime = orderDto.getStartDateTime();
        String endDateTime = orderDto.getEndDateTime();
        TicketDto ticketDto = new TicketDto();
        ticketDto.setRegion(region);
        int price;
        if(region.equals("전국")) {
            price = 30000;
        } else if(region.equals("강원") || region.equals("충청")) {
            price = 35000;
        } else if(region.equals("전라") || region.equals("경상")) {
            price = 40000;
        }
        int totalPrice = price * people;
        List<String> checkList = new ArrayList<>();
        checkList.add(region);
        checkList.add(startDate);
        checkList.add(endDate);
        checkList.add(startDateTime);
        checkList.add(endDateTime);
        String selectedRegion = orderMapper.selectRegion(region);
        boolean checkTicket = false;
        while(checkTicket = false){
            orderMapper.checkTicket(checkList);
            if(orderMapper.checkTicket(checkList)>=people){
                checkTicket = true;
            }
        }
        if(checkTicket){
            purchaseSerial = orderMapper.purchaseTicket(email, people, selectedRegion, startDate, endDate, startDateTime, endDateTime);
        }
        return purchaseSerial;
    }
}