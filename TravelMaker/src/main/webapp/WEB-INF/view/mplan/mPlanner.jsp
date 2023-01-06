<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div id="map"></div>

	<div id="mplanner">
		<div class="mListContainer">
			<div id="button_container">
				<input type='button' id="mPlanBucketList" class="clickbtn" value="Bucket" onclick="BucketBtnClicked()"/>
				<input type='button' id="mPlanList" class="nonclickbtn" value="Plan" onclick="PlanClicked()"/>
			</div>
			<div class='mList'>
			</div>
		</div>
	</div>
	<div id='modal'>
		<div id="modalBack"></div>
		<div id='content1'>
			<input type='button' id='btnClose' value='X'/>
			<span class="locationTitle">섬진강</span><br/>
			<select>
			    <option value="1" selected>1일자</option>
			    <option value="2">2일자</option>
			</select><br/>
			<input type='button' value='추가' id='btnCheck'/>
		</div>
	</div>
	
	<div id='modal2'>
		<div id="modalBack2"></div>
		<div id='content2'>
			<input type='button' id='btnClose2' value='X'/>
			<span class="locationTitle">섬진강</span><br/>
			<span class="UpdateSubTitle">순번</span>
			<input type="text" value="1" class="UpdatePlanSerial"><br/>
			<select>
			    <option value="1" selected>1일자</option>
			    <option value="2">2일자</option>
			</select><br/>
			<input type='button' value='수정' id='btnCheck2'/>
		</div>
	</div>

	<div id='modal3'>
		<div id="modalBack3"></div>
		<div id='content3'>
			<input type='button' id='btnClose3' value='X'/>
			<span class="UpdateSubTitle">메모</span><br/>
			<textarea class="MemoArea"></textarea><br/>
			<input type='button' value='수정' id='btnCheck3'onclick="memoInsert(this)"/>
		</div>
	</div>
	
	<a href="#" id="goReview">여행목록</a>
</body>
</html>