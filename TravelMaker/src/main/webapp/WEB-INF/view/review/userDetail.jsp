<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='../css/userDetail.css'/>
<script src='../js/userDetail.js'></script>
</head>
<body>
	<div id='ud_main'>
		<h1>UI 처리 필요 합니다.</h1>
		<form id='ud_form'>
			<input type='hidden' name = 'reviewSerial' value='${rVo.reviewSerial}'/>
			<input type='hidden' id ='thumbsUp' name='thumbsUp' value='${rVo.thumbsUp}'>
			<input type='hidden' name='purchaseSerial' value='${rVo.purchaseSerial }'/>
			<input type='hidden' id='chkUserLike' name='chkUserLike' value='${pVo.chkUserLike }'/>
			<input type='hidden' name='nowPage' value='${pVo.nowPage }'/>
			<input type='hidden' name='order' value='${pVo.order }'/>
			<input type='hidden' name='findStr' value='${pVo.findStr }'/>
			<input type='hidden' name='period' value='${pVo.period }'/>
			<input type='hidden' name='region' value='${pVo.region }'/>
			<input type='hidden' name='city' value='${pVo.city }'/>
			<input type='hidden' id ='nickName' name='nickName' value='${rVo.nickName }'/>
		</form>
		<span>닉네임  </span><br><img src='images/${uVo.sysUserPhoto }' style ='width : 20px; height : 20px;'/><span>${uVo.nickName }</span><br>
		<span>이메일  </span><div>${uVo.email }</div><br>
		<span>한줄 소개 : </span><div>${uVo.userComment }</div>
		<div id='ud_to_reviewView'>게시글로 가기</div>
	</div>
</body>
</html>