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

<div class = 'one'>
<div id = 'two'></div>

<!-- if문으로 체크 비활성화 항목에 onclick="return(false)"-->
<div id = 'three'>
	<div>
		<label>선택지역 : </label>
		<span>전라도</span>
	</div>
	<div>
		<label>인원수 : </label>
		<span>2명</span>
	</div>
	<div>
		<label>가는날</label>	
		 <label>
		    <input type="radio" name="startTime" value="오전"/>
		    <span>오전</span>
		    <input type="radio" name="startTime" value="오후" checked/>
		    <span>오후</span>
	  	</label>
	  	<br/>
	  	<label>오는날</label>	
		 <label>
		    <input type="radio" name="endTime" value="오전" checked/>
		    <span>오전</span>
		    <input type="radio" name="endTime" value="오후"/>
		    <span>오후</span>
	  	</label>
	</div>
	<div>
		<label>총 금액 : </label>
		<span>60,000원</span>
	</div>
	
	<div id='btnZone'>
		<button type='submit' id='btnBuy' onclick="requestPay()" >결제하기</button>
		<li><button type='submit' id='btnTicket'>구매내역</button></li>
	</div>
	
</div>

<!-- 후기 -->
<div id = 'four'>
	<div class=reviewList>
		<p class='preReviewTitleP'>이 지역을 다녀온 사람들</p>
		<div class = 'preReview'>
			<span class='preReviewUser'>NAME</span>
			<span class='preReviewTitle'>TITLE</span>
			<br/>
			<span class='preReviewUserName'>채찌</span>
			<span class='preReviewDoc'>두번째 구매(●'◡'●)</span>
		</div>
	
		<div class = 'preReview'>
			<span class='preReviewUserName'>지1</span>
			<span class='preReviewDoc'>누가 노잼지역이라고 했지 여길</span>
		</div>
	
		<div class = 'preReview'>
			<span class='preReviewUserName'>OVOIN</span>
			<span class='preReviewDoc'>내돈내산 솔직후기</span>
		</div>
	
		<div class = 'preReview'>
			<span class='preReviewUserName'>전..아현인데요</span>
			<span class='preReviewDoc'>이게 되네요? </span>
		</div>
		
		<div class = 'preReview'>
			<span class='preReviewUserName'>야생의진우몬</span>
			<span class='preReviewDoc'>흰 천과 트레블메이커만 있다면 어디든 갈 수 있어</span>
		</div>

	</div>
</div>

</div> <!-- end of one -->

<div class='blank'></div>
</body>
</html>