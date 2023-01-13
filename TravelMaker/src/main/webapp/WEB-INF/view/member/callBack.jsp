<%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 2023/01/11
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>

<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script>
    var naverLogin = new naver.LoginWithNaverId({
        clientId: "tmEd6oZsv0Z7hQ6aN3hg", // 본인걸로 수정, 띄어쓰기 금지.
        callbackUrl: "http://localhost:9282", // 아무거나 설정
        isPopup: false,
        callbackHandle: true
    });
    naverLogin.init();

    window.addEventListener('load', function () {
        naverLogin.getLoginStatus(function (status) {

            if (status) {
                console.log(naverLogin.user);
                var email = naverLogin.user.getEmail();
                var id = naverLogin.user.getId();
                var name = naverLogin.user.getName();
                console.log(email);

                $.ajax({
                    type: 'post',
                    url: '/member/naverCheck',
                    data: {'n_email':email, 'n_id':id, 'n_name':name},
                    dataType: 'text',
                    success: function(result) {
                        if(result=='registered') {
                            location.replace("http://localhost:9282");
                        } else if(result=='notRegistered') {
                            location.replace("http://localhost:9282/{result}");
                            /*alert("redirect:/member/signUp");
                            $("#content").load("/member/signUp");*/
                        }
                        else {
                            alert("오류가 발생했습니다. 다시 시도해주세요.")
                        }
                    },
                    error: function(result) {
                        console.log('오류 발생')
                    }
                })

            } else {
                console.log("callback 처리에 실패하였습니다.");
            }
        });
    });
</script>
</body>
</html>
