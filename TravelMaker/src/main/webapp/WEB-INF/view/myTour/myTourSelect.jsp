<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myTourSelect.jsp</title>
<link rel='stylesheet' media='screen and (min-width : 450px)' href='../css/myTourSelect.css'>
<link rel='stylesheet' media='screen and (max-width : 450px)' href='../css/mobileMyTourSelect.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"  />
<script defer src='../js/myTourSelect.js'></script>
</head>
<body>
<main id='myTourSelectMain'>
	<div class="myTourSelectContainer">
		 <form class='myTourSelectFrm' method='post'>
	      	<input type='hidden' name='nowPage' value='${pVo.nowPage }'/>
	      	<input type='hidden' name='purchaseSerial' class='purchaseSerial' value='${vo.purchaseSerial }'/>
	      	<input type='hidden' name='reviewSerial' class='reviewSerial' value='0'/>
	     </form>
		<h1 class="upcomming">내 여행</h1>
		<c:forEach var='vo' items='${list }'>
			<div class="myTourSelectItem">
				<div class="item-right">
					<img class="logo" src='./images/LOGO5.png'/>
					<span class="up-border"></span>
					<span class="down-border"></span>
				</div> <!-- end item-right -->
				
				<div class="item-left">
					<div class='TicketClick' onclick="myTour.myTourTicket('${vo.purchaseSerial}', '${vo.reviewSerial }')">
						<p class="event">예매번호 : ${fn:substring(vo.purchaseSerial,0,22) } (${vo.people}명)</p>
						<h2 class="title">${vo.city }행</h2>
						
						<div class="sce">
							<div class="icon">
								<i class="fa fa-table"></i>
							</div>
							<p>${vo.startDate }~${vo.endDate }</p>
						</div>
						<div class="fix"></div>
						<div class="loc">
							<div class="icon">
								<i class="fa fa-map-marker"></i>
							</div>
							<p>${vo.region }</p>

						</div>
						<div class="fix"></div>
					</div>
					<c:choose>
						<c:when test="${vo.myReview ne false}">
								<input type='button' class='btnMyReview' value='내 후기' 
									onclick="myTour.reviewView('${vo.purchaseSerial}', '${vo.reviewSerial }')"/>
						</c:when>
						<c:otherwise>
								<jsp:useBean id="now" class="java.util.Date"/>
								<fmt:parseDate value="${vo.endDate }" pattern="yyyy-MM-dd" var="Date"/>
								<fmt:formatDate value="${now }" pattern="yyyyMMdd" var="nowDate"/>
								<fmt:formatDate value="${Date }" pattern="yyyyMMdd" var="endDate"/>
								<input type='button' class="btnReview1" value='후기 작성' onclick="myTour.insert('${vo.purchaseSerial}')" 
												<c:if test="${nowDate<endDate }">style="display:none;"</c:if>/>
						</c:otherwise>
					</c:choose>
				</div> <!-- end item-left -->
			</div> <!-- end item -->
		</c:forEach>
  
  <!-- 페이징처리 -->
	<div id='ri_page_btn'>
		<c:if test="${pVo.startPage>1 }">
			<div id='ri_page_begin' onclick='myTour.move(1)'>처음</div>
			<div id='ri_page_before' onclick='myTour.move(${pVo.startPage-1})'>이전</div>
		</c:if>
		<c:forEach var='i' begin='${pVo.startPage }' end='${pVo.endPage }'>
			<div id='ri_page_1' onclick='myTour.move(${i})'>${i }</div>
		</c:forEach>
		<c:if test="${pVo.totPage>pVo.endPage }">
			<div id='ri_page_after' onclick='myTour.move(${pVo.endPage+1})'>다음</div>
			<div id='ri_page_end' onclick='myTour.move(${pVo.totPage})'>끝</div>
		</c:if>
	</div>
</div> 
</main>
</body>
</html>