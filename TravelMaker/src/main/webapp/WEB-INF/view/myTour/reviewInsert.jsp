<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<title>reviewInsert.jsp</title>
<link rel='stylesheet' media='screen and (min-width : 450px)' href='../css/reviewInsert.css'>
<link rel='stylesheet' media='screen and (max-width : 450px)' href='../css/mobileReviewInsert.css'>
<%
	LocalDate now = LocalDate.now();
%>
<body>
	<div id='summer'> 
		<form name='frm_summernote' class='frm_summernote'>
			<div id='ri_title'>
				<h2 id='ri_InsertH'>후기 작성</h2>
				<div id='ri_InsertDiv'>"${nickName }"님의 여행을 공유해주세요.</div>
			</div>
			<input type='hidden' name='nickName' value='${nickName }'/>
			<input type='hidden' name='purchaseSerial' value='${vo.purchaseSerial }'/>
			<input type='hidden' name='period' value='${datePlan }'/>
			<span class='reviewInsertSpanDate'>작성날짜</span>
			<input type='text' class='reviewInsertDate' name='postingDate' value='<%=now %>' readonly="readonly"/>
			<span class='reviewInsertSpanRegion'>지 역</span>
			<input type='hidden' class='reviewInsertRegion' name='region' value='${vo.region}' readonly="readonly"/>
			<input type='text' class='reviewInsertRegion' name='city' value='${vo.city}' readonly="readonly"/>
			<div id='starForm'>
				<span>평가하기</span>
				<p class="star_rating">
				    <a href="#" >⭐</a>
				    <a href="#" >⭐</a>
				    <a href="#" >⭐</a>
				    <a href="#" >⭐</a>
				    <a href="#" >⭐</a>
				    <input type='hidden' name='reviewStar' class='reviewStar' value='0'/>
				</p>
			</div>
			<span class='reviewInsertSpanSubject'>제  목</span>
			<input type='text' size='90' class='reviewInsertSubject' name='reviewTitle' >
				<div id='ri_content_plan'>
				<c:set var="chk" value=""/><div id='blank_div'>
				<c:forEach var='i' items="${list }">
					<c:if test="${i.planDate ne chk}">
						</div><div id='ri_content_plan_div_${i.planDate }'><div id='ri_content_plan_day'>${i.planDate }</div>
						<c:set var="chk" value="${i.planDate }"/>
						<span class='spanclass'>
					</c:if>
						<span>-</span></span><span id='ri_content_plan_locationName'>${i.locationName}</span>
				</c:forEach>
				</div>
			<textarea id='summernote' name='text'></textarea>

			<!-- <a class='reviewInsertA' href='myTourSelect.jsp'>목록으로</a> -->
		</form>
			<input type='button' class='reviewInsertBtn' value='게시하기'>
	</div>

	<script defer src='js/reviewInsert.js'></script>
</body>
</html>