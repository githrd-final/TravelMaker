/**
 *
 */

var att = function(file) {
	if (file.files && file.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('img_box').src = e.target.result;
		};
		reader.readAsDataURL(file.files[0]);
	} else {
		document.getElementById('img_box').src = "";
	}
}

/*$('.btnSubmit').on('click',function(){
    window.close();
    var frm = $('.signupContainer')[0];
	var param = $(frm).serialize();
	console.log(frm);
	console.log(param);
	$.post('/member/UserAdd', param, function(data){	
		location.replace("http://localhost:9282/");
	});
})
*/

$('.btnSubmit').on('click',function(){
	var frm = $('.signupContainer')[0];
	var email = sessionStorage.getItem("email");
	console.log("email subi"+email);
	var param = new FormData(frm);
	console.log()
	console.log("subi 가입 param"+param);
	if(frm.nickname.value == ""){
		alert("닉네임을 입력해주세요.");
		frm.nickname.focus();
		return false;
	}
	else {
		$.ajax({
			type: 'POST',
			url: '/member/memberUpdateWithImage',
			contentType: false,
			processData: false,
			data: param,
			dataType: 'html',
			success: function (data) {
				alert("환영합니다.");
				if (data != "") alert(data);
				frm.enctype = '';
				param = $(frm).serialize();
				location.replace('/');
			},
			error: function (data) {
				alert(".");
				alert(data);
			}
		});
	}
})