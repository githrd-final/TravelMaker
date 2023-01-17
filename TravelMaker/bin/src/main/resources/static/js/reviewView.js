/**
 * 
 */
 /**하트 눌를때 */
 $('#rv_heart_icon').on('click',function(){
	var clk_yn = $('#rv_heart_icon').css('background-image');
	console.log(clk_yn);
	if(clk_yn=='url("http://localhost:9282/images/heart-icon.png")'){
		$('#rv_heart_icon').css('background-image','url("../images/heart-icon-clicked.png")');
	}else{
		$('#rv_heart_icon').css('background-image','url("../images/heart-icon.png")');
	}
})

/* 수정하기 버튼 클릭 시 */
$('#rv_content_crud_modify').on('click',function(){
	$('#content').load('/review/reviewModify');
})