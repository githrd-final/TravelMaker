<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<c:forEach var='vo' items="${list}" varStatus='status'>
		<div class='item'>
			[${vo.nal }] <b>[${vo.id }]</b> <span>${vo.doc }</span>
		</div>
	</c:forEach> --%>
	<div id="FiltersContainer">
		<div id="bucketFilters">
			<a class="bucketFilter">숙소</a>
			<a class="bucketFilter">관광지</a>
			<a class="bucketFilter">식당</a>
		</div>
	</div>
		<% for(int i=0;i<20;i++){ %>
		<div class='Bucketitem' onclick="ListClicked(this)">
				<img src="img/testimage.jpg" class="bucketImg">
				<div class="bucketInfo">
					<div class="bucketTitle">섬진강</div>
					<div class="bucketgubun">관광지</div> 
				</div>
				<div></div>
				<div class="bucketbtn">
					<div></div>
					<div>
						<input type="image" src="img/plus.png" class="bucketToPlan" onclick='modalView(this)'>
						<input type="image" src="img/minus.png" class="bucketThrow">
					</div>
					<div></div>
				</div>
		</div>
		<%} %>

	
</body>
</html>