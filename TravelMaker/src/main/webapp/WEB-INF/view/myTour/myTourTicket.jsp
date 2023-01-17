<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' media='screen and (min-width : 450px)' href='../css/myTourTicket.css'>
<link rel='stylesheet' media='screen and (max-width : 450px)' href='../css/mobileMyTourTicket.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"  />
<script defer src='./js/myTourTicket.js'></script>
<title>TICKET 구매내역</title>
</head>
<body>
<main id='myTourSelectMain'>
	<div class="myTourSelectContainer">
		<form class='myTourTicketFrm' method='post'>
	      	<input type='hidden' name='purchaseSerial' class='purchaseSerial' value='${purchaseSerial }'/>
	      	<input type='hidden' name='reviewSerial' class='reviewSerial' value='${reviewSerial }'/>
	     </form>
		<h1 class="upcomming">왕복티켓 구매 내역</h1>
		<c:forEach var='vo' items='${list }'>
			<div class="myTourSelectItem">
				<div class="item-right">
					<img class="logo" src='./images/LOGO5.png'/>
					<span class="up-border"></span>
					<span class="down-border"></span>
				</div> <!-- end item-right -->
				
				<div class="item-left">
					<div class='TicketClick'>
						<p class="event">예매번호 : ${vo.ticketSerial}</p>
						<h2 class="title">${vo.ticketEndPoint}행</h2>
						
						<div class="sce">
							<div class="icon">
								<i class="fa fa-table"></i>
							</div>
							<p>${vo.ticketDate} ${vo.ticketStartTime}</p>
						</div>
						<div class="fix"></div>
						<div class="loc">
							<div class="icon">
								<i class="fa fa-map-marker"></i>
							</div>
							<p>좌석번호 : ${vo.ticketSeat }</p>
						</div>
						<div class="fix"></div>
					</div>
				</div> <!-- end item-left -->
			</div> <!-- end item -->
	</c:forEach>
		<div id='divBtnPlan'>
			<input type='button' class='btnMyTourTicketPlan' value='내 일정' onclick="myTicket.view('${purchaseSerial}')">
			<c:choose>
				<c:when test="${reviewSerial>0}">
					<input type='button' class='btnMyReview' value='내 후기' onclick="myTicket.reviewView('${purchaseSerial}', '${reviewSerial }')"/>
				</c:when>
				<c:otherwise>
					<input type='button' class="btnReview1" value='후기 작성' onclick="myTicket.insert('${purchaseSerial}')"/>
				</c:otherwise>			
			</c:choose>
		</div>
	
</div> 
</main>
</body>
</html>