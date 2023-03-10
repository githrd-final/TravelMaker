<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>myinfo</title>
    <link rel='stylesheet' href='css/myInfoView.css'/>
    <script src='/js/myInfoView.js' defer></script>
</head>
<body>
<main class='signUpMain'>
    <h1 class='signUpH'>회원정보</h1>
    <form class="signupContainer" id="frm" method="post" enctype="multipart/form-data">
        <input type="text" name="email" value="${email}" style="display: none">
        <div class="input-container ic1" name="ic1">
            <input name="nickname" class="input" type="text" placeholder="닉네임" onfocus="this.placeholder=''" onblur="this.placeholder='닉네임'" value ="${uVo.nickName }"/>
        </div>
        <div class="input-container ic2" name="ic2">
            <input name="intro" class="input" type="text" placeholder="한 줄 소개" onfocus="this.placeholder=''" onblur="this.placeholder='한 줄 소개'" value="${uVo.userComment }"/>
        </div>
        <div class='profileImage'>
            <img id='miv_img_box' src='/upload/${uVo.sysUserPhoto}'>
            <input type='file' class='btnProfileSelect' name="attFile" value='파일 선택' onchange="att(this)" accept="image/*" style="display : none;">
            <br/>
            <input type='button' class='btnSubmit' value='수정'>
        </div>
    </form>
</main>
</body>
</html>