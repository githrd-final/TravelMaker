<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfo/myInfo.jsp</title>
<link rel="stylesheet" href="css/myInfo.css"/>
<script defer src='./js/myInfo.js'></script>
</head>
<body> 
	<main class='signUpMain'>
		<h1 class='signUpH'>My Information</h1>
        <div class="input-container ic1">
          <input id="nickname" class="input" type="text" placeholder=" " />
          <div class="cut"></div>
          <label for="nickname" class="placeholder">닉네임</label>
          <input type='button' class='btnCheck' value='중복 체크'/>
        </div>
        <div class="input-container ic2">
          <input id="intro" class="input" type="text" placeholder=" " />
          <div class="cut"></div>
          <label for="intro" class="placeholder">한 줄 소개</label>
        </div>
		<div class='profileImage'>
			<div class='img-box'></div>
			<input type='button' class='btnProfileSelect' value='파일 선택'>
			<br/>
			<input type='button' class='btnMyInfoModify' value='수정'>
		</div>
	</main>
</body>
</html>