/**
 * 
 */
 
 $('#ud_to_reviewView').on('click',function(){
		var frm = $('#ud_form')[0];
		param = $(frm).serialize();
		$.post("/review/reviewView", param, function(data){
			$('#content').html(data);
		})
})
 