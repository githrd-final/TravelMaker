<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="css/mplanner.css">
</head>
<body>
	<div id="FiltersContainer">
		<div id="planFilters">
			<c:forEach var="i" begin="1" end="${totalTravelDay+1}">
				    	<a class="planFilter">Day${i }</a>
			</c:forEach>
		</div>
	</div>
	<div class="planDays">
		<div class="planDay" id="day1">Day1</div> 
	</div>	
		<% for(int i=0;i<10;i++){ %>
		<div class='Planitem' onclick='modalView2(this); ListClicked(this);'>
				<div class="planSerial"><%=i+1 %></div>
				<div class="planInfo">
					<div class="planTitle">섬진강</div>
					<div class="plangubun">관광지</div> 
				</div>
				<div class="planMemoWrapper">
					<div class="PlanMemo">
						<input type="image" src="img/edit.png" class="PlanMemoItem" onclick='modalView3(this)'>
					</div>
				</div>
		</div>
		<%} %>
	<div class="planDays">
		<div class="planDay" id="day2">Day2</div> 
	</div>	
		<% for(int i=0;i<10;i++){ %>
		<form>
		<div class='Planitem' onclick='modalView2(this); ListClicked(this);'>
				<div class="planSerial"><%=i+1 %></div>
				<div class="planInfo">
					<div class="planTitle">섬진강</div>
					<div class="plangubun">관광지</div> 
				</div>
				<div class="planMemoWrapper">
					<div class="PlanMemo">
						<input type="image" src="img/edit.png" class="PlanMemoItem" onclick='modalView3(this)'>
						
					</div>
				</div>
		</div>
		</form>
		<%} %>
</body>
</html>