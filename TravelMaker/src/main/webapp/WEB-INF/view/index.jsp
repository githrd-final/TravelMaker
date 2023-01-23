<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" media="screen and (min-width :450px)" href="css/index.css"/>
<link rel="stylesheet" media="screen and (max-width :450px)" href="css/mobileIndex.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Raleway" />
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<!-- include summernote css/js -->
<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script> -->
<link href="css/summernote/summernote-lite.css" rel="stylesheet"> 
<script src="../js/summernote/summernote-lite.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	38fcbbc356cdd719e19ce18e5b27584d"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script defer src='../js/index.js'></script>
<meta name ="google-signin-scope" content="profile email">
<meta name ="google-signin-client_id" content="1073520954501-tqj85u21s3lftdforl8ikb220sbg1qn1.apps.googleusercontent.com">
</head>
<body>
<header id='IndexHeader'>
<h2><a href="/" class='TravelMaker'>Travel Maker</a></h2>
<div id='menu'>
	<ul class='indexUl'>
		<li><a href="#" class='indexMyPage'>마이페이지</a>
		<%
			//로그인된 아이디가 있는지 읽어와보기
			String email = (String)session.getAttribute("email");
			String result = (String)request.getAttribute("result");
		%>
			<ul id='block' class='indexUl'>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyTour'>내여행</a></li>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyInfo'>기본정보</a></li>
				
			</ul>
		</li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnReviewBoard'>후기게시판</a></li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnCompanyInfo'>회사소개</a></li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnFAQ'>FAQ</a></li>
		<li class='indexMenuLi'><a href="/index" class='indexMenuA btnLogout'>로그아웃</a>
	</ul>
</div>
</header>
<div id='empty'></div>
<div id='content'>
	<section id="hero">
		<div class="bkg-img" style="background-image:url('https://farm4.staticflickr.com/3372/3299941029_0074286419_o.jpg');"></div>
			<div id='hero-content'>
				<span id='start'>서울 출발</span>
				<span id='startDate'>가는 날</span>
				<input type='date' id='date1' placeholder="날짜 선택"
					   required aria-required="true" class="dateSelector"/>
				<span id='amPm1'>
					<input type='radio' value='am' name='time1'/>오전
					<input type='radio' value='pm' name='time1'/>오후
				</span>
				<span id='endDate'>오는 날</span>
				<input type='date' id='date2' placeholder="날짜 선택"
					   required aria-required="true" class="dateSelector"/>
				<span id='amPm2'>
					<input type='radio' value='am' name='time2'/>오전
					<input type='radio' value='pm' name='time2'/>오후
				</span>
				<span id='people'>인원</span>
				<input type='text' size='5' id='peopleSu'/>
				</span>
					<input type='button' id='btnSearch' class = 'indexMenuA' value='Search'/>
				
			</div>
	</section>
	
	<section class="packages">
		<img src="images/travelmaker이용방법.png"/>
	</section>	
	
	<section class="contact">
		<hr>	
		<form>
			<button class="btn">지금 티켓예매하러 가기</button>
		</form>	
	</section>	
</div>

<div id='indexFooterContainer'>
	<footer id='indexFooter'>
		<p class='indexFooterP'>Visit Travel Maker and have a good time doing it, when you use one or more of our tours...</p>
	</footer>
</div>
														
</body>
</html>