<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUp</title>
<link rel='stylesheet' href='css/signUp.css'/>
<script src='../../../js/signUp.js' defer></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<main class='signUpMain'>
		<h1 class='signUpH'>회원정보</h1>
        <form class="signupContainer" id="frm" method="post" enctype="multipart/form-data">
            <div class="input-container ic1">
              <input id="nickname" name="nickname" class="input" type="text" placeholder="닉네임" onfocus="this.placeholder=''" onblur="this.placeholder='닉네임'"/>
            </div>
            <div class="input-container ic2">
              <input id="intro" name="intro" class="input" name="userComment" type="text" placeholder="한 줄 소개" onfocus="this.placeholder=''" onblur="this.placeholder='한 줄 소개'"/>
            </div>
            <div class='profileImage'>
                <img id='img_box' src='/images/cat.gif'>
                <input type='file' class='btnProfileSelect' name="attFile" value='파일 선택' onchange="att(this)" accept="image/*" style="display : none;">
                <br/>
                <input type='button' class='btnSubmit' value='가입 완료'>
            </div>
        </form>
	</main>
</body>
</html>
