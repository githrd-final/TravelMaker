<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' media='screen and (min-width : 450px)' href='../css/purchasedTicket.css'>
<link rel='stylesheet' media='screen and (max-width : 450px)' href='../css/mobilePurchasedTicket.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"  />
<script defer src='./js/purchasedTicket.js'></script>
<title>TICKET 구매내역</title>
</head>
<body>
<main id='myTourSelectMain'>
	<div class="myTourSelectContainer">
		<h1 class="upcomming">티켓 구매 내역</h1>

			<div class="myTourSelectItem">
				<div class="item-right">
					<img class="logo" src='./images/LOGO5.png'/>
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
							<p>2023-01-01</p>
						</div>
						<div class="fix"></div>
						<div class="loc">
							<div class="icon">
								<i class="fa fa-map-marker"></i>
							</div>
							<p>열차 탑승 시간 - 15:00</p>
						</div>
						<div class="fix"></div>
					</div>
				</div> <!-- end item-left -->
			</div> <!-- end item -->

			<div class="myTourSelectItem">
				<div class="item-right">
					<img class="logo" src='./images/LOGO5.png'/>
					<span class="up-border"></span>
					<span class="down-border"></span>
				</div> <!-- end item-right -->
				
				<div class="item-left">
					<div class='TicketClick'>
						<p class="event">예매번호 : 12345678 (2명)</p>
						<h2 class="title">용산행</h2>
						
						<div class="sce">
							<div class="icon">
								<i class="fa fa-table"></i>
							</div>
							<p>2023-01-03</p>
						</div>
						<div class="fix"></div>
						<div class="loc">
							<div class="icon">
								<i class="fa fa-map-marker"></i>
							</div>
							<p>열차 탑승 시간 - 10:00</p>
						</div>
						<div class="fix"></div>
					</div>
				</div> <!-- end item-left -->
			</div> <!-- end item -->
			
	<div id='divBtnPlan'>
		<button type="button" id='btnPlan'>여행 일정 만들러 가기</button>
	</div>
	
</div> 
</main>
</body>
</html>