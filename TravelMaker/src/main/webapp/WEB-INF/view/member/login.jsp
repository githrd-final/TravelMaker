<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- content에 자신의 OAuth2.0 클라이언트ID를 넣습니다. -->
	<meta charset="UTF-8">
	<link rel='stylesheet' href='css/login.css'/>
	<script defer src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<title>Login</title>
</head>
<body>
<div class='login-main'>
	<img src="/images/logo-narrow.png" alt="로고" class='logo'>

	<div class="loginMent">Travel Maker와 여행을 떠날<br/>준비가 되셨나요?</div>

	<div class='logindiv'>
		<a id="naverIdLogin_loginButton" href="javascript:void(0)">
			<img src="/images/naverLogin2.png" alt="네이버로그인" class='naverlogin'/>
		</a>
	</div>

	<div class='logindiv'>
		<a href="javascript:void(0)">
			<img src="/images/kakaoLogin.png" alt="카카오로그인" class='kakaologin'/>
		</a>
	</div>
</div>

<script>
	var naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "tmEd6oZsv0Z7hQ6aN3hg", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
				callbackUrl: "http://localhost:9282/member/callCallBack", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
				isPopup: false,
				callbackHandle: true
			}
	);


	naverLogin.init();


	var testPopUp;
	function openPopUp() {
		testPopUp= window.open("https://nid.naver.com/nidlogin.logout", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,width=1,height=1");
	}
	function closePopUp(){
		testPopUp.close();
	}

	function naverLogout() {
		openPopUp();
		setTimeout(function() {
			closePopUp();
		}, 1000);
	}


	/*카카오 로그인------------------------------------------------------*/
	Kakao.init('5c88dfa9fea7790820d1c6aaf418285a'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단

	var kakaologin = document.querySelector('.kakaologin');
	kakaologin.onclick = function() {
		kakaoLogin();
		var email = sessionStorage.getItem("email");
		console.log(email);
	};

	//카카오로그인
	function kakaoLogin() {
		Kakao.Auth.login({
			scope: "account_email",
			success: function (response) {
				Kakao.API.request({
					url: '/v2/user/me',
					success: function (res) {
						var email = res.kakao_account.email;
						console.log(email);


						$.ajax({
							type: 'POST',
							url: '/member/kakaoCheck',
							data: {'kakao_email':email},
							dataType: 'text',
							success: function(result) {
								if(result=='registered') {
									sessionStorage.setItem("email", email);
									location.replace("http://192.168.219.116:9282/");
								}
								else if(result=='notRegistered') {
									sessionStorage.setItem("email", email);
									location.replace("http://192.168.219.116:9282/{result}");
								}
								else {
									alert("오류가 발생했습니다. 다시 시도해주세요.");
								}
							},
							error: function(result) {
								console.log('오류 발생');
							}
						})
					},

				})
			}
		})
	}
</script>
</body>
</html>