package com.project1.order;

import com.project1.mybatis.OrderMapper;
import com.project1.review.ReviewVo;
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

    public List<ReviewVo> selectReview(OrderDto orderDto) throws Exception {
        log.info("selectReview");
        List<ReviewVo> reviewVoList = new ArrayList<>();
        int region = orderDto.getRegion();
        if(region == 7){
            reviewVoList = orderMapper.selectReviewAll();
        }
        else {
            reviewVoList = orderMapper.selectReview(orderDto);
        }
        return reviewVoList;
    }

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
        int region = orderDto.getRegion();
        String startDate = orderDto.getStartDate();
        String endDate = orderDto.getEndDate();
        String startDateTime = orderDto.getStartDateTime();
        String endDateTime = orderDto.getEndDateTime();
        TicketDto ticketDto = new TicketDto();
        PurchaseDto purchaseDto = new PurchaseDto();
        ticketDto.setRegion(region);
        log.info("region : " + ticketDto.getRegion());
        int price = 0;
        if(region == 7) {
            price = 30000;
        } else if(region == 1 || region == 5) {
            price = 35000;
        } else if(region == 3 || region == 4) {
            price = 40000;
        }

        int totalPrice = price * people;
        String selectedRegion;
        if(region == 7){
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

        String purchasedTicketSerial = ticketSerialListA.get(0) + ticketSerialListB.get(0);
        purchaseSerial = ticketSerialListA.get(0) + ticketSerialListB.get(0) + email;
        String ticketSerialA = ticketSerialListA.get(0);
        String ticketSerialB = ticketSerialListB.get(0);

        purchaseDto.setPurchaseSerial(purchaseSerial);
        purchaseDto.setEmail(email);
        purchaseDto.setPrice(price);
        purchaseDto.setPeople(people);
        purchaseDto.setRegion(region);
        purchaseDto.setStartDate(startDate);
        purchaseDto.setEndDate(endDate);
        purchaseDto.setStartDateTime(startDateTime);
        purchaseDto.setEndDateTime(endDateTime);
        purchaseDto.setCity(selectedRegion);

        orderMapper.insertPurchase(purchaseDto);
        orderMapper.updateTicketStatusA(ticketSerialListA.get(0));
        orderMapper.updateTicketStatusB(ticketSerialListB.get(0));
        orderMapper.makePurchasedTicket(purchasedTicketSerial, purchaseSerial, ticketSerialA, ticketSerialB);

        return purchaseDto;
    }
    
    public List<ReviewVo> purchaseCheckReview(String region){
    	List<ReviewVo> list = null;
    	System.out.println("order서비스 지역:"+region);
    	if(region.equals("7")) {
    		list = orderMapper.purchaseCheckReviewAll();
    		System.out.println("order서비스 전국 list:"+list.toString());
    	}else {
    		list = orderMapper.purchaseCheckReview(region);
    		System.out.println("order서비스 지역 list:"+list.toString());
    	}
    	return list;
    }
}