package com.project1.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDto {

    String region;
    String ticketSerial;
    String ticketStartPoint;
    String ticketEndPoint;
    String ticketDate;
    String ticketStartTime;
    String ticketEndTime;
    String ticketSeat;
    int ticketStatus;
}