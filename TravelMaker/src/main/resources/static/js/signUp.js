/**
 *
 */

$('.btnProfileSelect').on('click',function(){
    $('#content').load('/member/login');
})

$('.btnSubmit').on('click',function(){
    window.close();
    var frm = $('.signupContainer')[0];
	var param = $(frm).serialize();
	console.log(frm);
	console.log(param);
	$.post('/member/UserAdd', param, function(data){	
		location.replace("http://localhost:9282/");
	});
})	
