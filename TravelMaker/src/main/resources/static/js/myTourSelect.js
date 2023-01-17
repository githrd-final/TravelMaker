/**
 * 
 */
(myTour = function(){
	
	myTour.myTourTicket = function(purchaseSerial, reviewSerial){
		 frm = $('.myTourSelectFrm')[0];
	     frm.purchaseSerial.value = purchaseSerial;
	     frm.reviewSerial.value = reviewSerial;
		 console.log(frm);
		 param = $(frm).serialize();
		 $.post("/myTour/myTourTicket", param, function(data){
		        $('#content').html(data);
		 })
	}
	 
	 /* 페이징처리 */
	 myTour.move = function(nowPage){
	    frm = $('.myTourSelectFrm')[0];
	    frm.nowPage.value = nowPage;
	    param = $(frm).serialize();
	    $.post("/myTour/myTourSelect", param, function(data){
	        $('#content').html(data);
	    })
	}
	
	 /* 후기작성 페이지 연결 */
	 myTour.insert = function(purchaseSerial){
		 frm = $('.myTourSelectFrm')[0];
	     frm.purchaseSerial.value = purchaseSerial;
		 console.log(frm);
		 param = $(frm).serialize();
		 $.post("/myTour/myTourInsert", param, function(data){
		        $('#content').html(data);
		 })
	 }
	 
	 /* 내가 작성한 후기 클릭 시 연결*/
	 myTour.reviewView = function(purchaseSerial, reviewSerial){
		 frm = $('.myTourSelectFrm')[0];
	     frm.purchaseSerial.value = purchaseSerial;
	     frm.reviewSerial.value= reviewSerial;
		 console.log(frm);
		 param = $(frm).serialize();
		 console.log(reviewSerial);
		 $.post("/review/reviewView", param, function(data){
		        $('#content').html(data);
		 })
	 }
	
})()
 