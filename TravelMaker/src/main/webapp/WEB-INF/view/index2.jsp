<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TravelMaker</title>
<link rel="stylesheet" media="screen and (min-width :450px)" href="css/index.css"/> 
<link rel="TravelMaker Icon" href="../img/TroubleMakerFavicon.png">
<link rel="stylesheet" media="screen and (max-width :450px)" href="css/mobileIndex.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Raleway" />
<script defer src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<!-- include summernote css/js -->
<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script> -->
<link href="css/summernote/summernote-lite.css" rel="stylesheet"> 
<script defer src="./js/summernote/summernote-lite.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	38fcbbc356cdd719e19ce18e5b27584d"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script defer src='./js/index2.js'></script>
<meta name ="google-signin-scope" content="profile email">
<meta name ="google-signin-client_id" content="1073520954501-tqj85u21s3lftdforl8ikb220sbg1qn1.apps.googleusercontent.com">
</head>
<body>
<header id='IndexHeader'>
<h2><a href="/index" class='TravelMaker'>Travel Maker</a></h2>
<div id='menu'>
	<ul class='indexUl'>
		<li><a href="#" class='indexMyPage'>마이페이지</a>
		<%
			//로그인된 아이디가 있는지 읽어와보기
			String email = (String)session.getAttribute("email");
			String result = (String)request.getAttribute("result");
		%>
			<ul id='block' class='indexUl'>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyTourB'>내여행</a></li>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyInfoB'>기본정보</a></li>
				
			</ul>
		</li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnReviewBoard'>후기게시판</a></li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnCompanyInfo'>회사소개</a></li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnFAQ'>FAQ</a></li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnLogin'>로그인</a>
		
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
				<input type='button' id='btnSearchB' class = 'indexMenuA' value='Search'/>
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
														 
<!--
https://farm5.staticflickr.com/4005/4267674623_a786e4a440_o.jpg
https://farm9.staticflickr.com/8334/8103080370_254bcd9f90_o.jpg
https://farm6.staticflickr.com/5296/5444152459_2bffa50e90_o.jpg
https://farm1.staticflickr.com/211/535585258_84df3cd5f1_o.jpg
-->														
</body>
</html>