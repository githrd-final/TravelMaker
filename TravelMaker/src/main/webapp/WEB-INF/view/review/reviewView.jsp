<%@ page language="java" contentType="text/html; charvet=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" media="screen and (min-width :450px)" href="../css/reviewView.css"/>
		<link rel="stylesheet" media="screen and (max-width :450px)" href="../css/reviewViewMobile.css"/>
		<script src='../js/reviewView.js'></script>
		<title>Insert title here</title>
	</head>
<body>
	<div id='rv_main'>
		<div id='rv_blank_65px'></div>
		<form id='rv_form' class='rv_form'>
			<input type='text' name = 'reviewSerial' value='${rVo.reviewSerial}'/>
			<input type='text' name='thumbsUp' id='thumbsUp' value='${rVo.thumbsUp}'>
			<input type='text' name='purchaseSerial' value='${rVo.purchaseSerial }'/>
			<input type='text' name='chkUserLike' id='chkUserLike' value='${pVo.chkUserLike }'/>
		</form>
		<div id='rv_title'>
				<div>후기 게시판</div>
				<div id='rv_title_location'>${ rVo.city}</div>
		</div>
		<div id='rv_blank_65px'></div>
		<div id='rv_content'>
			<div id='rv_content_detail'>
				<div id='rv_content_detail_1'>
					<div id='rv_content_user_photo'></div>
					<div id='rv_content_user_name'>${rVo.nickName }</div>
					<div id='rv_content_date'>${rVo.postingDate }</div>				
				</div>
				<div id='rv_content_detail_2'>
					<div id='rv_view_icon'></div>
					<div id='rv_view_num'>${rVo.view }</div>
					<div id='rv_heart_icon'></div>
					<div id='rv_heart_num'>${rVo.thumbsUp }</div>
					<div id='rv_copy_icon'></div>
					<div id='rv_content_crud'>
						<div id= 'rv_content_crud_list'>
								<div id='rv_content_crud_modify'>수정하기</div>
								<div id='rv_content_crud_delete'>삭제하기</div>
						</div>
					</div>
				</div>
				<div id='rv_content_detail_2_blank'></div>
			</div>	
			<div id='rv_blank_30px'></div>
			<div id='rv_content_title'>${rVo.reviewTitle }</div>
			<div id='rv_blank_30px'></div>
			<div id='rv_content_body'>
				<div id='rv_content_plan'>
					<div id='rv_content_plan_grp'>
						<div id='rv_content_plan_day'>1일차</div>
						<div id='rv_content_plan_detail'>oo숙소 - oo맛집 - oo관광지</div>
					</div>
					<div id='rv_content_plan_grp'>
						<div id='rv_content_plan_day'>2일차</div>
						<div id='rv_content_plan_detail'>oo숙소 - oo맛집 - oo관광지</div>
					</div>
				</div>
				<div id='rv_blank_30px'></div>
				<div id='rv_content_article'>
					${rVo.text }
				</div>
			</div>
			
			<div id='rv_blank_25px'></div>
			<div id='rv_blank_30px'></div>
		</div>
	</div>
</body>
</html>