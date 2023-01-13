<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewModify.jsp</title>
<link rel='stylesheet' media='screen and (min-width : 450px)' href='../css/reviewModify.css'>
<link rel='stylesheet' media='screen and (max-width : 450px)' href='../css/mobileReviewModify.css'>
</head>
<body>
	<div id='summer'>
		<form name='frm_summernote' class='frm_summernote'>
			<div id='ri_title'>
				<h2 id='ri_InsertH'>후기 수정</h2>
				<div id='ri_InsertDiv'>후기 수정 페이지입니다.</div>
			</div>
			<input type='hidden' name='reviewSerial' value='${rVo.reviewSerial }'/>
			<input type='text' name='purchaseSerial' value='${rVo.purchaseSerial }'/>
			<span class='reviewInsertSpanDate'>작성날짜</span>
			<input type='text' class='reviewInsertDate' name='postingDate' value='${rVo.postingDate }' readonly="readonly">
			<span class='reviewInsertSpanRegion'>지  역</span>
			<input type='text' class='reviewInsertRegion' name='region' value='${rVo.region }' readonly="readonly"/>
			<input type='text' class='reviewInsertRegion' name='city' value='${rVo.city }' readonly="readonly"/>
			<div id='starForm'>
				<span>별점</span>
				<p class="star_rating">
				    <c:forEach var='i' begin='1' end='${rVo.reviewStar }'>
				    	<a href="#" class='on'>⭐</a>
				    </c:forEach>
				    <c:forEach var='j' begin='1' end='${5-rVo.reviewStar }'>
				    	<a href="#">⭐</a>
				    </c:forEach>
				    <input type='text' name='reviewStar' class='reviewStar' value='${rVo.reviewStar }'/>
				</p>
			</div>
			<span class='reviewInsertSpanSubject'>제  목</span>
			<input type='text' size='90' class='reviewInsertSubject' name='reviewTitle' value='${rVo.reviewTitle }'>
			
			<div id='ri_content_plan'>
				<c:set var="chk" value=""/><div id='blank_div'>
				<c:forEach var='i' items="${rpList }">
					<c:if test="${i.planDate ne chk}">
						</div><div id='ri_content_plan_div_${i.planDate }'><div id='ri_content_plan_day'>${i.planDate }</div>
						<c:set var="chk" value="${i.planDate }"/>
						<span class='spanclass'>
					</c:if>
						<span>-</span></span><span id='ri_content_plan_locationName'>${i.locationName}</span>
				</c:forEach>
			</div>
			
			<textarea id='summernote' name='text'>${rVo.text }</textarea>

		</form>
		<input type='button' class='reviewModifyBtn' value='수정하기'/>
	</div>
	<script defer src='js/reviewModify.js'></script> 
</body>
</html>