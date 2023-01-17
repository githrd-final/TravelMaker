package com.project1.order;

import com.project1.mybatis.OrderMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
@NoArgsConstructor
public class OrderService {

    @Autowired
    PlatformTransactionManager transactionManager;
    TransactionStatus status;

    @Autowired
    OrderMapper orderMapper;

    public PurchaseDto purchaseTicket(OrderDto orderDto) throws Exception {
        String purchaseSerial = "";
        List<String> ticketSerialListA = new ArrayList<String>();
        List<String> ticketSerialListB = new ArrayList<String>();
        String email = orderDto.getEmail();
        log.info("servicePurchaseTicket");
        log.info(orderDto.getEmail());
        log.info(orderDto.getPeople());
        int people = (Integer.parseInt(orderDto.getPeople()));
        orderDto.setPeopleInt(people);
        log.info("people : " + people);
        String region = orderDto.getRegion();
        String startDate = orderDto.getStartDate();
        String endDate = orderDto.getEndDate();
        String startDateTime = orderDto.getStartDateTime();
        String endDateTime = orderDto.getEndDateTime();
        TicketDto ticketDto = new TicketDto();
        PurchaseDto purchaseDto = new PurchaseDto();
        ticketDto.setRegion(region);
        log.info("region : " + ticketDto.getRegion());
        int price = 0;
        if(region.equals("전국")) {
            price = 30000;
        } else if(region.equals("강원도") || region.equals("충청도")) {
            price = 35000;
        } else if(region.equals("전라도") || region.equals("경상도")) {
            price = 40000;
        }

        int totalPrice = price * people;
        String selectedRegion;
        if(region.equals("전국")){
            selectedRegion = orderMapper.selectRegionA(orderDto);
            orderDto.setSelectedRegion(selectedRegion);
            boolean checkTicketA = false;
            boolean checkTicketB = false;
            while(checkTicketA == false || checkTicketB == false) {
                log.info(selectedRegion);
                orderMapper.checkTicketA(orderDto);
                orderMapper.checkTicketB(orderDto);
                if(orderMapper.checkTicketA(orderDto)>=people){
                    checkTicketA = true;
                }
                if(orderMapper.checkTicketB(orderDto)>=people){
                    checkTicketB = true;
                }
                if(checkTicketA == true && checkTicketB == true) {
                    selectedRegion = orderMapper.selectRegionA(orderDto);
                    orderDto.setSelectedRegion(selectedRegion);
                    log.info("selectedRegion : " + selectedRegion);
                }
            }
            if(checkTicketA && checkTicketB) {
                ticketSerialListA = orderMapper.purchaseTicketA(orderDto);
                ticketSerialListB = orderMapper.purchaseTicketB(orderDto);
            }
        }
        else{
            selectedRegion = orderMapper.selectRegionB(orderDto);
            orderDto.setSelectedRegion(selectedRegion);
            boolean checkTicketA = false;
            boolean checkTicketB = false;
            while(checkTicketA == false || checkTicketB == false) {
                log.info(selectedRegion);
                orderMapper.checkTicketA(orderDto);
                orderMapper.checkTicketB(orderDto);
                if(orderMapper.checkTicketA(orderDto)>=people){
                    checkTicketA = true;
                }
                if(orderMapper.checkTicketB(orderDto)>=people){
                    checkTicketB = true;
                }
                if(checkTicketA == true && checkTicketB == true) {
                    selectedRegion = orderMapper.selectRegionB(orderDto);
                    orderDto.setSelectedRegion(selectedRegion);
                    log.info("selectedRegion : " + selectedRegion);
                }
            }
            if(checkTicketA && checkTicketB) {
                ticketSerialListA = orderMapper.purchaseTicketA(orderDto);
                ticketSerialListB = orderMapper.purchaseTicketB(orderDto);
            }
        }

        purchaseSerial = ticketSerialListA.get(0) + ticketSerialListB.get(0) + email;
        int regionInt = 0;

        if(region.equals("전국")) {
            regionInt = 1;
        } else if(region.equals("강원도")) {
            regionInt = 2;
        } else if(region.equals("경상도")) {
            regionInt = 3;
        } else if(region.equals("전라도")) {
            regionInt = 4;
        } else if(region.equals("충청도")) {
            regionInt = 5;
        }


        purchaseDto.setPurchaseSerial(purchaseSerial);
        purchaseDto.setEmail(email);
        purchaseDto.setPrice(price);
        purchaseDto.setPeople(people);
        purchaseDto.setRegion(region);
        purchaseDto.setStartDate(startDate);
        purchaseDto.setEndDate(endDate);
        purchaseDto.setStartDateTime(startDateTime);
        purchaseDto.setEndDateTime(endDateTime);
        log.info("regionInt : " + regionInt);
        purchaseDto.setRegionInt(regionInt);
        purchaseDto.setCity(selectedRegion);

        orderMapper.insertPurchase(purchaseDto);
        orderMapper.updateTicketStatusA(ticketSerialListA.get(0));
        orderMapper.updateTicketStatusB(ticketSerialListB.get(0));

        return purchaseDto;
    }
}