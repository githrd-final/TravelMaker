/**
 * 
 */
(myTicket = function(){
	
	 /* 후기작성 페이지 연결*/
	 myTicket.insert = function(purchaseSerial){
		 frm = $('.myTourTicketFrm')[0];
	     frm.purchaseSerial.value = purchaseSerial;
		 console.log(frm);
		 param = $(frm).serialize();
		 $.post("/myTour/myTourInsert", param, function(data){
		        $('#content').html(data);
		 })
	 }
	 
	 /*내가 작성한 후기 클릭 시 연결*/
	 myTicket.reviewView = function(purchaseSerial, reviewSerial){
		 frm = $('.myTourTicketFrm')[0];
	     frm.purchaseSerial.value = purchaseSerial;
	     frm.reviewSerial.value= reviewSerial;
		 console.log(frm);
		 param = $(frm).serialize();
		 console.log(reviewSerial);
		 $.post("/review/reviewView", param, function(data){
		        $('#content').html(data);
		 })
	 }
	 
	/* 일정짜기 페이지 연결 */
	var width_size = window.outerWidth;
	if(width_size<=450){
	 	myTicket.view = function(purchaseSerial){
		    frm = $('.myTourTicketFrm')[0];
		    frm.purchaseSerial.value = purchaseSerial;
		    
		    param = $(frm).serialize();
		    
		    console.log(param);
		    $.post("/mplan/mPlanner", param, function(data){
		        $('#content').html(data);
		    })
		}
	}else{
	 	myTicket.view = function(purchaseSerial){
		    frm = $('.myTourTicketFrm')[0];
		    frm.purchaseSerial.value = purchaseSerial;
		    param = $(frm).serialize();
		    $.post("/planner/planner", param, function(data){
		    	$('#content').html(data);
			})
		}
	 }
})()
 