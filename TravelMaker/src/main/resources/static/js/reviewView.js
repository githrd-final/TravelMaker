/**
 * 
 */
(gb = function(){
	
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
			var frm = $('.rv_form')[0];
		    var param = $(frm).serialize();
		    console.log(param);
		    $.post("/review/reviewModifyView", param, function(data){
				$('#content').html(data);
	    })
	})
	
	/* 리뷰 삭제 */
	$('#rv_content_crud_delete').on('click',function(){
		/*if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}else{
			var frm = $('.rv_form')[0];
			var param = $(frm).serialize();
			$.post("/review/reviewDelete", param, function(data){
				$('#content').html(data); 
			});
		}*/
	});
})