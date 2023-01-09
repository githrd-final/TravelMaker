<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>myinfo</title>
    <link rel='stylesheet' href='css/signUp.css'/>
</head>
<body>
<main class='signUpMain'>
    <h1 class='signUpH'>회원정보</h1>
    <div class="signupContainer">
        <div class="input-container ic1">
            <input id="nickname" class="input" type="text" placeholder="닉네임" onfocus="this.placeholder=''" onblur="this.placeholder='닉네임'"/>
        </div>
        <div class="input-container ic2">
            <input id="intro" class="input" type="text" placeholder="한 줄 소개" onfocus="this.placeholder=''" onblur="this.placeholder='한 줄 소개'"/>
        </div>
        <div class='profileImage'>
            <div class='img-box'></div>
            <input type='button' class='btnProfileSelect' value='파일 선택'>
            <br/>
            <input type='button' class='btnSubmit' value='수정'>
        </div>
    </div>
</main>
</body>
</html>