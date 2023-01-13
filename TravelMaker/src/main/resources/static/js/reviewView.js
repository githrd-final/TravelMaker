/**
 * 
 */
 (reviewView = function(){
	 /** 좋아요 확인  */
	 var heart_yn = $('#chkUserLike').val();
	 if(heart_yn=="true"){
		var heart_ynR = 1;
	}else{
		heart_ynR = 0;
	}
	console.log(heart_ynR);
	console.log(Boolean(heart_ynR));
	 if(heart_ynR){
		$('#rv_heart_icon').css('background-image','url("../images/heart-icon-clicked.png")');
		console.log("하트 빨갛게 물들여~");
	}else{
		$('#rv_heart_icon').css('background-image','url("../images/heart-icon.png")');
	}
	 /**하트 눌를때 */
	 $('#rv_heart_icon').on('click',function(){
		var clk_yn = $('#rv_heart_icon').css('background-image');
		console.log(clk_yn);
		frm = $('#rv_form')[0];
		param= $(frm).serialize();
		if(!heart_ynR){
			$.post("/review/reviewThumbsUp", param, function(data){
				$('#content').html(data);
			})
			setTimeout(function(){
				$('#rv_heart_icon').css('background-image','url("../images/heart-icon-clicked.png")');
			},300)
		}else{
			$.post("/review/reviewThumbsUp", param, function(data){
				$('#content').html(data);
			})
			setTimeout(function(){
				$('#rv_heart_icon').css('background-image','url("../images/heart-icon.png")');
			},300)
		}
	})
	
	/* 수정하기 버튼 클릭 시 */
	$('#rv_content_crud_modify').on('click',function(){
		$('#content').load('/review/reviewModify');
	})
})()