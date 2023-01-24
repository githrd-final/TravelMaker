<%@ page import="com.project1.order.PurchaseDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script defer src='./js/recommendListMain.js'></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

<!-- CSS only -->
<link rel='stylesheet' media="screen and (min-width :450px)" href='./css/recommendListMain.css'/>
<link rel="stylesheet" media="screen and (max-width :450px)" href="css/mobileRecommendListMain.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>추천 리스트</title>
</head>
<body>

<%
	PurchaseDto purchaseDto = (PurchaseDto)request.getAttribute("purchaseDto");
%>

<form action = 'purchasedTicket' method = 'post' id="frm" hidden>
	<input type="text" name="purchaseSerial" id="purchaseSerial" value="${purchaseDto.purchaseSerial}" style="display:none"/>
	<input type="text" name="email" id="email" value="${purchaseDto.email}" style="display:none">
	<input type="text" name="price" id="price" value="${purchaseDto.price}" style="display:none">
	<input type="text" name="people" id="people" value="${purchaseDto.people}" style="display:none">
	<input type="text" name="region" id="region" value="${purchaseDto.region}" style="display:none">
	<input type="text" name="startDate" value="${purchaseDto.startDate}" style="display:none">
	<input type="text" name="endDate" value="${purchaseDto.endDate}" style="display:none">
	<input type="text" name="startDateTime" value="${purchaseDto.startDateTime}" style="display:none">
	<input type="text" name="endDateTime" value="${purchaseDto.endDateTime}" style="display:none">
	<input type="text" name="city" value="${purchaseDto.city}" style="display:none">
</form>

<div id='listBack'>
	<h3 class='title'>추천 리스트 - ${purchaseDto.city}</h3>
	<div class="btn-group" >
	  <button type="button" class="btnAccommodation">숙소</button>
	  <button type="button" class="btnTouristAttractions">관광지</button>
	  <button type="button" class="btnRestaurants">맛집</button>
	</div>
	
	<div>
	  <input type='text' class='searchTxt' placeholder="검색어를 입력해 주세요"/>
	 
	  <button class="search-btn" type="submit" >
		  <i class="fas fa-search"></i>
	  </button>
	 </div>
	 
	 <br/>
	 
<br/>

<div class="recommandList">

	<p>추천 리스트</p>

</div>
	 
	 
</div> <!-- end of listBack -->


<!-- 퀵메뉴 시작 + TOP버튼 -->
<div id="Quick" class="" >
    <table class="quickMenuBar" style="">
        <tr>
            <td colspan="2" id='btnMyTravel'>MY TRAVEL</td>
        </tr>
        <tr>
            <td colspan="2" id='btnTop' onclick="window.scrollTo(0,0);">맨 위로</td>
        </tr>
    </table>
</div>
<!-- 퀵메뉴 끝 -->   
	
</body>
</html>