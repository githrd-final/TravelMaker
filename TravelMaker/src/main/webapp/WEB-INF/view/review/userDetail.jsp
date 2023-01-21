<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='../css/userDetail.css' />
<script src='../js/userDetail.js'></script>
</head>
<body>
	<div id='ud_main'>
		<form id='ud_form'>
			<input type='hidden' name='reviewSerial' value='${rVo.reviewSerial}' />
			<input type='hidden' id='thumbsUp' name='thumbsUp' value='${rVo.thumbsUp}' /> 
			<input type='hidden' name='purchaseSerial' value='${rVo.purchaseSerial }' />
			<input type='hidden' id='chkUserLike' name='chkUserLike' value='${pVo.chkUserLike }' /> 
			<input type='hidden' name='nowPage' value='${pVo.nowPage }' /> 
			<input type='hidden' name='order' value='${pVo.order }' /> 
			<input type='hidden' name='findStr' value='${pVo.findStr }' /> 
			<input type='hidden' name='period' value='${pVo.period }' /> 
			<input type='hidden' name='region' value='${pVo.region }' /> 
			<input type='hidden' name='city' value='${pVo.city }' /> 
			<input type='hidden' id='nickName' name='nickName' value='${rVo.nickName }' />
		</form>
		<div id="ud_user_info">
			<div id='ud_user_info_1'>
				<img id='ud_user_info_photo' src='/upload/${uVo.sysUserPhoto }' />
				<div id='ud_user_info_nickName'>${uVo.nickName }</div>
			</div>
			<div id='ud_user_info_2'>
				<div id="astro1">"</div>
				<div id='ud_user_info2_userComment'>${uVo.userComment }</div>
				<div id="astro2">"</div>
			</div>
		</div>
		<div id='ud_user_review_header'>
			<div id='ud_user_review_title'>${uVo.nickName}님의 여행 후기</div>
			<div id='ud_to_reviewView'>게시글로 가기</div>
		</div>
		<c:forEach var='vo' items='${list }'>
			<div class='ud_content' onclick='review.view(${vo.reviewSerial })'>
				<div class='ud_content_blank'></div>
				<div class='ud_content_1'>
					<div class='ud_content_user'>
						<img id="ud_content_user_photo" src='/upload/${vo.sysUserPhoto }' />
						<div id='ud_content_user_name'>${vo.nickName }</div>
					</div>
					<div class='ud_content_date'>${vo.postingDate }</div>
				</div>
				<div class='ud_content_2'>
					<div class='ud_content_title'>${vo.reviewTitle }</div>
				</div>
				<div class='ud_content_3'>
					<div class='ud_content_3_1'>
						<div class='ud_content_location'>
							<div>${vo.city }</div>
						</div>
					</div>
					<div class='ud_content_3_2'>
						<div class='ud_content_view'>
							<div class='ud_content_view_icon'></div>
							<div class='ud_content_view_num'>${vo.view }</div>
						</div>
						<div class='ud_content_heart'>
							<div class='ud_content_heart_icon'></div>
							<div class='ud_content_heart_num'>${vo.thumbsUp }</div>
						</div>
					</div>
				</div>
				<div class='ud_content_blank'></div>
			</div>
		</c:forEach>
		<div id='ud_to_reviewUserTotal'>${uVo.nickName}님의 게시글 전체 보러 가기</div>
		<div id='ud_blank_15vh'></div>
	</div>
</body>
</html>