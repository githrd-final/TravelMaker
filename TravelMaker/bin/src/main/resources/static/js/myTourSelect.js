/**
 * 
 */

/* 일정짜기 페이지 연결 */
var width_size = window.outerWidth;
if(width_size<=450){
 	$('.TicketClick').on('click',function(){
       $('#content').load('/mplan/mPlanner');
       
   	})
       }else{
 	$('.TicketClick').on('click',function(){
       $('#content').load('/planner/planner');  
 })}

  
 /* 후기작성 페이지 연결 */
 $('.btnReview1').on('click',function(){
	 $('#content').load('/myTour/reviewInsert');
 })
 