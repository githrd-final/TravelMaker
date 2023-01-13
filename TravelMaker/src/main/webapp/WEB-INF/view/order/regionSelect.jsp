<%@ page import="com.project1.order.OrderDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>regionSelect</title>
	<link rel='stylesheet' href='css/regionSelect.css'/>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="js/regionSelect.js"></script>
</head>
<body>
<%
	OrderDto orderDto = (OrderDto)request.getAttribute("orderDto");
%>
	<main class='regionSelectMain'>
		<div class='regionSelectH'>가고 싶은 지역이 있으신가요?</div>
		<div class='regionSelectAll'><p class='koreap'>전 국</p></div>
		<div class='regionSelectGang'><p>강원도</p></div>
		<div class='regionSelectGyeong'><p>경상도</p></div>
		<div class='regionSelectJeolla'><p>전라도</p></div>
		<div class='regionSelectChung'><p>충청도</p></div>
	</main>

	<input type="text" id="people" display="hidden" value="${orderDto.people}">${orderDto.people}</input>
	<input type="text" class="startDate" display="hidden" value="${orderDto.startDate}">${orderDto.startDate}</input>
	<input type="text" class="endDate" display="hidden" value="${orderDto.endDate}">${orderDto.endDate}</input>
	<input type="text" class="startDateTime" display="hidden" value="${orderDto.startDateTime}">${orderDto.startDateTime}</input>
	<input type="text" class="endDateTime" display="hidden" value="${orderDto.endDateTime}">${orderDto.endDateTime}</input>
</body>

</html>