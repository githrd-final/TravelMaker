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
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	38fcbbc356cdd719e19ce18e5b27584d"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
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
				<%if(email==null){%>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyTourB'>내여행</a></li>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyInfoB'>기본정보</a></li>
				<%}else{ %>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyTour'>내여행</a></li>
				<li class='indexMenuLi'><a href='#' class='indexMenuA btnMyInfo'>기본정보</a></li>
				<%} %>
			</ul>
		</li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnReviewBoard'>후기게시판</a></li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnCompanyInfo'>회사소개</a></li>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnFAQ'>FAQ</a></li>
		<%if(email==null){%>
		<li class='indexMenuLi'><a href="#" class='indexMenuA btnLogin'>로그인</a>
		<%}else{ %>
		<li class='indexMenuLi'><a href="/" class='indexMenuA btnLogout'>로그아웃</a>
		<%} %>
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
				<%if(email==null){%>
					<input type='button' id='btnSearchB' class = 'indexMenuA' value='Search'/>
				<%}else{ %>
					<input type='button' id='btnSearch' class = 'indexMenuA' value='Search'/>
				<%} %>
			</div>
	</section>
	
	<section class="packages">
	<h3 class="title">Tour Packages</h3>		
	<p>We offer a variety of sightseeing and immersion packages. Whether you want to experience the rich culture, immerse yourself in it's natural beauty, or have a relaxing visit, we've got the perfect vacation for you</p>
	<hr>
	<ul class="indexUl grid">
		<li>
			<i class="fa fa-compass fa-4x"></i>
			<h4>Guided Tours</h4>
			<p class='sectionP'>Looking for the complete experience? Take a tour with one of our experts. Visit the beautiful old temples and churches and the numerous beaches. Sample the local dishes and visit various health or spa retreats to pamper yourself on your vacation. </p>
		</li>
		<li>
			<i class="fa fa-camera-retro fa-4x"></i>
			<h4>Photo Tours</h4>
			<p class='sectionP'>Want to experience nature's beauty without all the trekking, walking and waiting? Take a photo tour on one of our luxury buses.</p>
		</li>
		<li>
			<i class="fa fa-motorcycle fa-4x"></i>
			<h4>Bike Tours</h4>
			<p class='sectionP'>A fun  way to experience the local atmosphere while seeing as much of Goa as you can. We'll provide the bikes and lunch too!</p>
		</li>
		<li>
			<i class="fa fa-binoculars fa-4x"></i>
			<h4>Safari Tours</h4>
			<p class='sectionP'>Looking to see some wildlife? We offer fantastic safari trips! Spend a day out cruising along the back waters of the Zuari River in a giant canoe, returning to camp in the evening to retell your adventures next to the campfire!</p>
		</li>
	</ul>
	</section>	
	
	<section class="contact">
		<h3>Learn More</h3>
		<p class='sectionP'>Want to know about upcoming specials, and value deals? Just sign up for our mailing list. We'll keep you informed on new tour packages and offerings. No  spam, we promise!</p>
		<hr>	
		<form>
			<input type="email" />
			<button class="btn">subscribe now </button>
		</form>	
	</section>	
</div>

<input type="text" id="result" value="${result}" display="none"/>

<div id='indexFooterContainer'>
	<footer id='indexFooter'>
		<p class='indexFooterP'>Visit Goa and have a good time doing it, when you use one or more of our tours...</p>
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