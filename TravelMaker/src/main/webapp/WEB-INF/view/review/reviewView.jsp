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
			<input type='text' id ='thumbsUp' name='thumbsUp' value='${rVo.thumbsUp}'>
			<input type='text' name='purchaseSerial' value='${rVo.purchaseSerial }'/>
			<input type='text' id='chkUserLike' name='chkUserLike' value='${pVo.chkUserLike }'/>
			<input type='text' name='nowPage' value='${pVo.nowPage }'/>
			<input type='text' name='order' value='${pVo.order }'/>
			<input type='text' name='findStr' value='${pVo.findStr }'/>
			<input type='text' name='period' value='${pVo.period }'/>
			<input type='text' name='region' value='${pVo.region }'/>
			<input type='text' name='city' value='${pVo.city }'/>
			<input type='text' id ='nickName' name='nickName' value='${rVo.nickName }'/>
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
					<div id='rv_to_list'>목록으로</div>
					<c:set var="userEmail" value="${userEmail }"/>
					<c:set var="uVo.email" value="${uVo.email}"/>
					<c:if test='${userEmail eq uVo.email }'>
					<div id='rv_content_crud'>
						<div id= 'rv_content_crud_list'>
								<div id='rv_content_crud_modify'>수정하기</div>
								<div id='rv_content_crud_delete'>삭제하기</div>
						</div>
					</div>
					</c:if>
				</div>
				<div id='rv_content_detail_2_blank'></div>
			</div>	
			<div id='rv_blank_30px'></div>
			<div id='rv_content_title'>${rVo.reviewTitle }</div>
			<div id='rv_blank_30px'></div>
			<div id='rv_content_body'>
				<div id='rv_content_plan'>
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