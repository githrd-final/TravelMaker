<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- content에 자신의 OAuth2.0 클라이언트ID를 넣습니다. -->
<meta name ="google-signin-client_id" content="AIzaSyDBAyvfoBj784JjkNBP8K_jKpSyfzwC2JE">
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<meta charset="UTF-8">
<link rel='stylesheet' href='css/login.css'/>
<script defer src='/js/login.js'></script>
<title>Login</title>
</head>
<body>
<div class='login-main'>
	<img src="/images/logo-narrow.png" alt="로고" class='logo'>
	
	<div class='logindiv'>
		<a id="naverIdLogin_loginButton" href="javascript:void(0)">
			<img src="/images/btnG_full.png" alt="네이버로그인" class='naverlogin'>
		</a>
	</div>
	
	<div class='logindiv'>
		<a href="javascript:void(0)">
			<img src="/images/kakao_login_medium_narrow.png" alt="카카오로그인" class='kakaologin'>
		</a>
	</div>
	<!-- 
	<ul class='login-ul'>
	   <li>
	      아래와 같이 아이디를 꼭 써준다.
	      <a id="naverIdLogin_loginButton" href="javascript:void(0)">
	          <img src="/image/btnG_full.png" alt="네이버로그인" class='naverlogin'>
	      </a>
	   </li>
	   <li onclick="naverLogout(); return false;">
	      <a href="javascript:void(0)">
	          <span>네이버 로그아웃</span>
	      </a>
	   </li>
	</ul>
	
	<ul class='login-ul'>
	   <li onclick="kakaoLogin();">
	      <a href="javascript:void(0)">
	          <img src="/image/kakao_login_medium_narrow.png" alt="카카오로그인" class='kakaologin'>
	      </a>
	   </li>
	   <li onclick="kakaoLogout();">
	      <a href="javascript:void(0)">
	          <span>카카오 로그아웃</span>
	      </a>
	   </li>
	</ul>
	-->
</div>

</body>
</html>