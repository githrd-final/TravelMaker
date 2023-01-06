<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='./css/purchaseCheck.css'/>
<script defer src='./js/purchaseCheck.js'></script>
 <!-- jQuery -->
  <script defer type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
 <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<title>상세보기</title>
</head>
<body>
<li><button type='submit' id='btnTicket'>구매내역</button></li>
<div class = 'one'>
<div id = 'two'></div>

<!-- if문으로 체크 비활성화 항목에 onclick="return(false)"-->
<div id = 'three'>
	<div>
		<label>지역 : </label>
		<span>전라도</span>
	</div>
	<div>
		<label>인원수 : </label>
		<span>2명</span>
	</div>
	<div>
		<label>가는날</label>	
		 <label>
		    <input type="radio" name="Day" value="오전"/>
		    <span>오전</span>
		    <input type="radio" name="NIGHT" value="오후" checked/>
		    <span>오후</span>
	  	</label>
	  	<br/>
	  	<label>오는날</label>	
		 <label>
		    <input type="radio" name="Day" value="오전" checked/>
		    <span>오전</span>
		    <input type="radio" name="NIGHT" value="오후"/>
		    <span>오후</span>
	  	</label>
	</div>
	<div>
		<label>총 금액 : </label>
		<span>60,000원</span>
	</div>
	
	<div id='btnZone'>
		<button type='submit' id='btnBuy' onclick="requestPay()" >결제하기</button>
	</div>
	
</div>



<div id = 'four'>후기</div>



</div>
</body>
</html>