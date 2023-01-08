<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='./css/purchasedTicket.css'/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"  />
<script defer src='./js/purchasedTicket.js'></script>
<title>TICKET 구매내역</title>
</head>
<body>
<main id='myTourSelectMain'>
<div class="myTourSelectContainer">
   <h3 class="upcomming">티켓 구매 내역</h3>
  <div class="item">
    <div class="item-right">
      <img src='./images/LOGO.png'/>
      <span class="up-border"></span>
      <span class="down-border"></span>
    </div> <!-- end item-right -->
    
    <div class="item-left">
       <p class="event">예매번호 : zn-7415204(2명)</p>
      <h2 class="title">도착지 : 남원역</h2>
      
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
    </div> <!-- end item-right -->
  </div> <!-- end item -->
  
  <div class="item">
    <div class="item-right">
      <img src='./images/LOGO.png'/>
      <span class="up-border"></span>
      <span class="down-border"></span>
    </div> <!-- end item-right -->
    
    <div class="item-left">
      <p class="event">예매번호 : zn-7415204(2명)</p>
      <h2 class="title">도착지 : 용산행</h2>
      
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
    </div> <!-- end item-right -->
  </div> <!-- end item -->
	
		<button type="button" id='btnPlan'>여행 일정 만들러 가기</button>
	<div id='blank'></div>
</div> 
</main>
</body>
</html>