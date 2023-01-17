<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<span class='reviewInsertSpanDate'>작성날짜</span>
			<input type='text' class='reviewInsertDate' value='2022-12-25(일)' disabled="disabled">
			<span class='reviewInsertSpanRegion'>지  역</span>
			<input type='text' class='reviewInsertRegion' value='전라도 구례' disabled="disabled"/>
			<div id='starForm'>
				<span>별점</span>
				<p class="star_rating">
				    <a href="#" class="on">⭐</a>
				    <a href="#" class="on">⭐</a>
				    <a href="#" class="on">⭐</a>
				    <a href="#">⭐</a>
				    <a href="#">⭐</a>
				</p>
			</div>
			<span class='reviewInsertSpanSubject'>제  목</span>
			<input type='text' size='90' class='reviewInsertSubject' value='구례여행 후기입니다~'>
			
			<div id='ri_content_plan'>
					<div id='ri_content_plan_day'>1일차</div>
					oo숙소 - oo맛집 - oo관광지<br/>
					<div id='ri_content_plan_day'>2일차</div>
					oo숙소 - oo맛집 - oo관광지
			</div>
			
			<textarea id='summernote' name='editordata'>수정페이지입니다.</textarea>

			<input type='button' class='reviewModifyBtn' value='수정하기'/>
			<!-- <a class='reviewInsertA' href='myTourSelect.jsp'>목록으로</a> -->
		</form>
	</div>
	<script defer src='js/reviewModify.js'></script> 
</body>
</html>