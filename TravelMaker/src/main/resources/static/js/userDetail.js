/**
 * 
 */

$('#ud_to_reviewView').on('click', function() {
	var frm = $('#ud_form')[0];
	param = $(frm).serialize();
	$.post("/review/reviewView", param, function(data) {
		$('#content').html(data);
	})
})

review.view = function(reviewSerial) {
	console.log("hihi", reviewSerial);
	frm = $('#ud_form')[0];
	frm.reviewSerial.value = reviewSerial;
	console.log('리뷰시리얼: ', reviewSerial);
	param = $(frm).serialize();
	$.post("/review/reviewView", param, function(data) {
		$('#content').html(data);
	})
}

$('#ud_to_reviewUserTotal').on("click", function() {
	frm = $('#ud_form')[0];
	frm.findStr.value = frm.nickName.value;
	console.log("파인드에스티알에 값 닉네임 넣기 ", frm.findStr.value);
	param = $(frm).serialize();
	$.post("/review/reviewSelect", param, function(data) {
		$('#content').html(data);
	})
})