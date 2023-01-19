/**
 * 
 */
 (reviewView = function(){
	 /** 좋아요 확인  */
	 var heart_yn = $('#chkUserLike').val();
	 if(heart_yn=='true'){
		var heart_ynR = 1;
	}else{
		heart_ynR = 0;
	}
	console.log("하트 yn =", heart_ynR);
	console.log(Boolean(heart_ynR));
	 if(heart_ynR){
		$('#rv_heart_icon').css('background-image','url("../images/heart-icon-clicked.png")');
		console.log("하트 빨갛게 물들여~");
	}else{
		$('#rv_heart_icon').css('background-image','url("../images/heart-icon.png")');
	}
	 /**하트 눌를때 */
	 $('#rv_heart_icon').on('click',function(){
		
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
			var frm = $('.rv_form')[0];
		    var param = $(frm).serialize();
		    console.log(param);
		    $.post("/review/reviewModifyView", param, function(data){
				$('#content').html(data);
	    })
	})
	
	/* 리뷰 삭제 */
	$('#rv_content_crud_delete').on('click',function(){
		if(confirm("정말 삭제하시겠습니까?")==true){
			var frm = $('.rv_form')[0];
			var param = $(frm).serialize();
			$.post("/review/reviewDelete", param, function(data){
				$("#content").load("/myTour/myTourSelect", data); 
			});
		}else{
			return;
		}
	});
	
	/**목록으로 가기  */
	$('#rv_to_list').on('click',function(){
		var frm = $('#rv_form');
		var param = $(frm).serialize();
		$.post("review/reviewSelect", param, function(data){
			$('#content').html(data);
		})
	})
	
	/**프로필 사진 누르기 (한줄 자기 소개 보러 가기) */
	$('#rv_content_user_photo').on('click',function(){
		var frm = $('#rv_form');
		var param = $(frm).serialize();
		$.post("review/userDetail", param, function(data){
			$('#content').html(data);
		})
	})
	$('#rv_content_user_name').on('click',function(){
		var frm = $('#rv_form');
		var param = $(frm).serialize();
		$.post("review/userDetail", param, function(data){
			$('#content').html(data);
		})
	})
	
	/**url 링크 복사 */
	$('#rv_copy_icon').on('click', function(){
		var url = window.document.location.href;
		var textarea = document.createElement("textarea");
		document.body.appendChild(textarea);
		textarea.value = url;
		textarea.select();
		document.execCommand("copy");
		document.body.removeChild(textarea);
		alert("후기 주소가 복사되었습니다.")
	})
	
})();
