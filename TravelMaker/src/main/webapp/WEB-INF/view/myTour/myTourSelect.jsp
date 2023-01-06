<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myTourSelect.jsp</title>
<link rel='stylesheet' media='screen and (min-width : 450px)' href='../css/myTourSelect.css'>
<link rel='stylesheet' media='screen and (max-width : 450px)' href='../css/mobileMyTourSelect.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"  />
<script defer src='../js/myTourSelect.js'></script>
</head>
<body>
<main id='myTourSelectMain'>
	<div class="myTourSelectContainer">
		<h1 class="upcomming">내 여행</h1>
		<%for(int i=0; i<10; i++){ %>
			<div class="myTourSelectItem">
				<div class="item-right">
					<img class="logo" src='./images/LOGO.png'/>
					<span class="up-border"></span>
					<span class="down-border"></span>
				</div> <!-- end item-right -->
				
				<div class="item-left">
					<div class='TicketClick'>
						<p class="event">예매번호 : 12345678 (2명)</p>
						<h2 class="title">구례행</h2>
						
						<div class="sce">
							<div class="icon">
								<i class="fa fa-table"></i>
							</div>
							<p>2023-01-01~2023-01-03</p>
						</div>
						<div class="fix"></div>
						<div class="loc">
							<div class="icon">
								<i class="fa fa-map-marker"></i>
							</div>
							<p>전라도</p>
						</div>
						<div class="fix"></div>
					</div>
					<input type='button' class="btnReview1" value='후기작성'/>
				</div> <!-- end item-left -->
			</div> <!-- end item -->
		<%} %>
  <!-- 페이징처리 -->
	<div id='ri_page_btn'>
		<div id='ri_page_begin'>처음</div>
		<div id='ri_page_before'>이전</div>
		<div id='ri_page_1'>1</div>
		<div id='ri_page_2'>2</div>
		<div id='ri_page_3'>3</div>
		<div id='ri_page_4'>4</div>
		<div id='ri_page_5'>5</div>
		<div id='ri_page_after'>다음</div>
		<div id='ri_page_end'>끝</div>
	</div>
</div> 
</main>
</body>
</html>