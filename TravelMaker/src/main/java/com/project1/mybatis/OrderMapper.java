package com.project1.mybatis;

import com.project1.order.OrderDto;
import com.project1.order.PurchaseDto;
import com.project1.review.ReviewVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    public String selectRegionA(OrderDto orderDto);
    public String selectRegionB(OrderDto orderDto);

    public List<ReviewVo> selectReviewAll();
    public List<ReviewVo> selectReview(OrderDto orderDto);

    public Integer checkTicketA(OrderDto orderDto);
    public Integer checkTicketB(OrderDto orderDto);

    public List<String> purchaseTicketA(OrderDto orderDto);
    public List<String> purchaseTicketB(OrderDto orderDto);

    public int getRegion(String selectedRegion);

    public void insertPurchase(PurchaseDto purchaseDto);

    public void updateTicketStatusA(String ticketSerialListA);
    public void updateTicketStatusB(String ticketSerialListB);

    public void makePurchasedTicket(@Param("purchasedTicketSerial") String purchasedTicketSerial,  @Param("purchaseSerial") String purchaseSerial, @Param("ticketSerialA") String ticketSerialA, @Param("ticketSerialB") String ticketSerialB);
    //베스트후기
    public List<ReviewVo> purchaseCheckReview(int region);
    public List<ReviewVo> purchaseCheckReviewAll();
}