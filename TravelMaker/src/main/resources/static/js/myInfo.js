/**
 * 
 */

 $('.btnMyInfoModify').on('click',function(){
	 $('#content').load('/myInfo/myInfoModify');
 })

$('.btnSubmit').on('click',function(){
    var frm = $('#frm')[0];
    var param = new FormData(frm);
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
                alert("수정되었습니다.");
                if (data != "") alert(data);
                frm.enctype = '';
                param = $(frm).serialize();
                location.replace('/');
            },
            error: function (data) {
                alert("수정에 실패하였습니다.");
                alert(data);
            }
        });
    }
})