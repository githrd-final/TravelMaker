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
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
        int people = (Integer.parseInt(orderDto.getPeople()));
        orderDto.setPeopleInt(people);
        int region = orderDto.getRegion();
        String startDate = orderDto.getStartDate();
        String endDate = orderDto.getEndDate();
        String startDateTime = orderDto.getStartDateTime();
        String endDateTime = orderDto.getEndDateTime();
        TicketDto ticketDto = new TicketDto();
        PurchaseDto purchaseDto = new PurchaseDto();
        ticketDto.setRegion(region);
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
                selectedRegion = orderMapper.selectRegionA(orderDto);
                orderMapper.checkTicketA(orderDto);
                orderMapper.checkTicketB(orderDto);
                if(orderMapper.checkTicketA(orderDto)>=people){
                    checkTicketA = true;
                }
                if(orderMapper.checkTicketB(orderDto)>=people){
                    checkTicketB = true;
                }
                if(checkTicketA == true && checkTicketB == true) {
                    orderDto.setSelectedRegion(selectedRegion);
                }
            }
            if(checkTicketA && checkTicketB) {
                ticketSerialListA = orderMapper.purchaseTicketA(orderDto);
                log.info("ticketSerialListA : " + ticketSerialListA);
                ticketSerialListB = orderMapper.purchaseTicketB(orderDto);
                log.info("ticketSerialListB : " + ticketSerialListB);
            }
        }
        else{
            selectedRegion = orderMapper.selectRegionB(orderDto);
            orderDto.setSelectedRegion(selectedRegion);
            boolean checkTicketA = false;
            boolean checkTicketB = false;
            while(checkTicketA == false || checkTicketB == false) {
                selectedRegion = orderMapper.selectRegionB(orderDto);
                log.info("selectedRegion : " + selectedRegion);
                orderMapper.checkTicketA(orderDto);
                orderMapper.checkTicketB(orderDto);
                if(orderMapper.checkTicketA(orderDto)>=people){
                    checkTicketA = true;
                }
                if(orderMapper.checkTicketB(orderDto)>=people){
                    checkTicketB = true;
                }
                if(checkTicketA == true && checkTicketB == true) {
                    orderDto.setSelectedRegion(selectedRegion);
                    log.info("selectedRegion : " + orderDto.getSelectedRegion());
                }
            }
            if(checkTicketA && checkTicketB) {
                ticketSerialListA = orderMapper.purchaseTicketA(orderDto);
                log.info("ticketSerialListA : " + ticketSerialListA);
                ticketSerialListB = orderMapper.purchaseTicketB(orderDto);
                log.info("ticketSerialListB : " + ticketSerialListB);
            }
        }

        purchaseSerial = ticketSerialListA.get(0) + ticketSerialListB.get(0) + email;
        List<String> purchasedTicketSerialList = new ArrayList<String>();
        for(int i = 0; i < ticketSerialListA.size(); i++){
            purchasedTicketSerialList.add(ticketSerialListA.get(i) + ticketSerialListB.get(i));
        }
        String purchasedTicketSerial = ticketSerialListA.get(0) + ticketSerialListB.get(0);

        String ticketSerialA = ticketSerialListA.get(0);
        String ticketSerialB = ticketSerialListB.get(0);

        region = orderMapper.getRegion(selectedRegion);

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

        purchaseDto.setPurchasedTicketSerial(purchasedTicketSerial);
        purchaseDto.setTicketSerialA(ticketSerialA);
        purchaseDto.setTicketSerialB(ticketSerialB);

        orderMapper.insertPurchase(purchaseDto);
        for(int i = 0; i < purchasedTicketSerialList.size(); i++){
        orderMapper.updateTicketStatusA(ticketSerialListA.get(i));
        orderMapper.updateTicketStatusB(ticketSerialListB.get(i));
        purchasedTicketSerial = purchasedTicketSerialList.get(i);
        ticketSerialA = ticketSerialListA.get(i);
        ticketSerialB = ticketSerialListB.get(i);
        orderMapper.makePurchasedTicket(purchasedTicketSerial, purchaseSerial, ticketSerialA, ticketSerialB);
        }

        return purchaseDto;
    }

    public List<ReviewVo> purchaseCheckReview(int region){
    	List<ReviewVo> list = null;
    	System.out.println("order서비스 지역:"+region);
    	if(region==7) {
    		list = orderMapper.purchaseCheckReviewAll();
    		System.out.println("order서비스 전국 list:"+list.toString());
    	}else {
    		list = orderMapper.purchaseCheckReview(region);
    		System.out.println("order서비스 지역 list:"+list.toString());
    	}
    	return list;
    }
}