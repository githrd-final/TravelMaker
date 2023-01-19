<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/mplanner.css"/>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script defer src='js/mplan.js'></script>
</head>
<body>
<c:set var="totalTravelDay" value="${totalTravelDay}" />
<div id="map"></div>

	<div id="mplanner">
		<div class="mListContainer">
			<div id="button_container">
				<input type="hidden" name="purchaseSerial" id="purchaseSerial" value="${purchaseSerial }"/>
				<input type="hidden" name="totalTravelDay" id="totalTravelDay" value="${totalTravelDay }"/>
				<input type='button' id="mPlanBucketList" class="clickbtn" value="Bucket" onclick="BucketBtnClicked()"/>
				<input type='button' id="mPlanList" class="nonclickbtn" value="Plan"/>
			</div>
			<div class='mList'>
			</div>
		</div>
	</div>
	<div id='BucketModal'>
		<div id="modalBack"></div>
		<form name='frm_bucketToPlanInsert' class='frm_bucketToPlanInsert'>
			<div id='content1'>
				<div class="modalheader">
					<span class="locationTitle">일정추가</span>
					<input type='button' id='btnClose' value='X'/>			
				</div>
				<div class="locationName" id="modalLocationName">섬진강</div>
				<select name="planDate">
					<c:forEach var="i" begin="1" end="${totalTravelDay+1}">
				    	<option value="${i }일자">${i }일자</option>
				    </c:forEach>
				</select><br/>
				<input type='button' value='추가' id='btnBucketModalAdd'/>
			</div>
			<input type="hidden" name="planbucketSerial" id="modalInputplanbucketSerial" value="">
			<input type="hidden" name="mapX" id="modalInputmapX" value="">
			<input type="hidden" name="mapY" id="modalInputmapY" value="">			
			<input type="hidden" name="purchaseSerial" id="modalInputpurchaseSerial" value="">
			<input type="hidden" name="locationName" id="modalInputLocationName" value=""/>
			<input type="hidden" name="contenttypeId" id="modalInputContenttypeId" value=""/>
		</form>
	</div>
	
	<div id='modal2'>
		<div id="modalBack2"></div>
		<form name='frm_PlanUpdate' class='frm_PlanUpdate'>
			<div id='content2'>
				<div class="modalheader">
					<span class="locationTitle">일정수정</span>
					<input type='button' id='btnClose2' value='X'/>
				</div>
				<input class="locationName" id="UpdateModallocationItem" name="locationName"/><br/>
				<span class="UpdateSubTitle">순번</span>
				<input type="text" value="1" class="UpdatePlanOrder" name="planOrder"><br/>
				<select name="planDate" class="UpdatePlanDate">
				    <c:forEach var="i" begin="1" end="${totalTravelDay+1}">
				    	<option value="${i }일자">${i }일자</option>
				    </c:forEach>
				</select><br/>
				<input type='button' value='수정' id='btnPlanModalAdd'/>
				<input type='button' value='삭제' id='btnPlanModalSubtract'/>
			</div>
			<input type="hidden" name="planbucketSerial" id="UpdatePlanbucketSerial" value="">
			<input type="hidden" name="purchaseSerial" id="UpdatePurchaseSerial" value="">
			<input type="hidden" name="prePlanDate" id="UpdatePrePlanDate" value="">
			<input type="hidden" name="prePlanOrder" id="UpdatePrePlanOrder" value="">
		</form>
	</div>

	<div id='modal3'>
		<form name='frm_PlanMemoUpdate' class='frm_PlanMemoUpdate'>
		<div id="modalBack3"></div>
		<div id='content3'>
			<div class="modalheader">
				<span class="locationTitle">메모</span>
				<input type='button' id='btnClose3' value='X'/>
			</div>
			<textarea class="MemoArea" name="planNote"></textarea><br/>
			<input type='button' value='수정' id='btnCheck3'onclick="memoInsert(this)"/>
		</div>
		<input type="hidden" name="planbucketSerial" id="MemoUpdatePlanbucketSerial" value="">
		</form>
	</div>
	
	<a href="#" id="goReview"><span>여행</span><span>목록</span></a>
</body>
</html>