<%@ page import="com.project1.order.OrderDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='./css/purchaseCheck.css'/>
<script defer src='./js/purchaseCheck.js'></script>
 <!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
 <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<title>상세보기</title>
</head>
<body>
<%
	OrderDto orderDto = (OrderDto)request.getAttribute("orderDto");
%>

<div class = 'one'>
<div id = 'two' style = "background-image: url('/images/${orderDto.region}.jpeg')"></div>
<form action = 'purchaseCheck' method = 'post' id="frm" hidden>
	<input type="text" name="email" id="email" value="${orderDto.email}" style="display:none"/>
	<input type="text" name="region" id="region" value="${orderDto.region}" style="display:none"/>
	<input type="text" name="people" id="people" value="${orderDto.people}" style="display:none"/>
	<input type="text" name="startDate" value="${orderDto.startDate}" style="display:none"/>
	<input type="text" name="endDate" value="${orderDto.endDate}" style="display:none"/>
	<input type="text" name="startDateTime" value="${orderDto.startDateTime}" style="display:none"/>
	<input type="text" name="endDateTime" value="${orderDto.endDateTime}" style="display:none"/>
</form>
	<!-- if문으로 체크 비활성화 항목에 onclick="return(false)"-->
<div id = 'three'>
	<div>
		<label>선택지역 : </label>
		<span name="region" value="${orderDto.region}">${orderDto.region}</span>
	</div>
	<div>
		<label>인원수 : </label>
		<span name="people" value="${orderDto.people}">${orderDto.people} 명</span>
	</div>
	<div>
		<label>가는날</label>	
		 <label>
		    <input type="radio" name="startTime" value="오전" ${(orderDto.startDateTime eq 'am')? 'checked' : ''}/>
		    <span>오전</span>
		    <input type="radio" name="startTime" value="오후" ${(orderDto.startDateTime eq 'pm')? 'checked' : ''}/>
		    <span>오후</span>
	  	</label>
	  	<br/>
	  	<label>오는날</label>	
		 <label>
		    <input type="radio" name="endTime" value="오전" ${(orderDto.endDateTime eq 'am')? 'checked' : ''}/>
		    <span>오전</span>
		    <input type="radio" name="endTime" value="오후" ${(orderDto.endDateTime eq 'pm')? 'checked' : ''}/>
		    <span>오후</span>
	  	</label>
	</div>
	<div>
		<label>총 금액 : </label>
		<span>${orderDto.people}*30000 원</span>
	</div>
	
	<div id='btnZone'>
		<button type='submit' id='btnBuy' onclick="requestPay()" >결제하기</button>
	</div>
	
</div>
<div class='moveTopBtn'>Top</div>
<!-- 후기 -->
<div id = 'four'>
	<div class=reviewList>
		<p class='preReviewTitleP'>이 지역을 다녀온 사람들</p>
		<c:forEach var='vo' items='${list }'>
			<div class = 'preReview'>
				<span class='preReviewStar'>
					<p class="star_rating">
					    <c:forEach var='i' begin='1' end='${vo.reviewStar }'>
					    	<a href="#" class='on'>⭐</a>
					    </c:forEach>
					    <c:forEach var='j' begin='1' end='${5-vo.reviewStar }'>
					    	<a href="#">⭐</a>
					    </c:forEach>
					    <input type='text' name='reviewStar' class='reviewStar' value='${fn:substring(vo.reviewStar,0,1)}' readonly="readonly"/>
					</p>
				</span>
				<span class='preReviewUserName'>${vo.nickName }</span>
				<span class='preReviewDate'>${vo.postingDate }</span>
				<span class='preReviewDoc'>${vo.reviewTitle }</span>
			</div>
		</c:forEach>
	</div>
</div>
<div id='five'>
	<c:choose>
		<c:when test="${orderDto.region eq 1}">
			<img src="../images/강원도리스트1.png">
			<img src="../images/강원도리스트2.png">
		</c:when>
		<c:when test="${orderDto.region eq 3}">
			<img src="../images/경상도리스트1.png">
			<img src="../images/경상도리스트2.png">
		</c:when>
		<c:when test="${orderDto.region eq 4}">
			<img src="../images/전라도리스트1.png">
			<img src="../images/전라도리스트2.png">
		</c:when>
		<c:when test="${orderDto.region eq 5}">
			<img src="../images/충청도리스트1.png">
			<img src="../images/충청도리스트2.png">
		</c:when>
		<c:when test="${orderDto.region eq 6}">
			<img src="../images/경기도리스트.png">
			<img src="../images/강원도리스트1.png">
			<img src="../images/강원도리스트2.png">
			<img src="../images/경상도리스트1.png">
			<img src="../images/경상도리스트2.png">
			<img src="../images/전라도리스트1.png">
			<img src="../images/전라도리스트2.png">
			<img src="../images/충청도리스트1.png">
			<img src="../images/충청도리스트2.png">
		</c:when>
	</c:choose>
</div>

</div> <!-- end of one -->

<div class='blank'></div>
</body>
</html>