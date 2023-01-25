/**
 * 
 */
/*체크박스 요소 한개만 선택되게 */
/*window.onload=function(){
	document.querySelector('.btnAccommodation').click();
}*/

var purchaseSerial = $("#purchaseSerial").val();
var load = $("#load");

function checkOnlyOne(element) {
  
  const checkboxes 
      = document.getElementsByName("cb");
  
  checkboxes.forEach((cb) => {
    cb.checked = false;
  })
  
  element.checked = true;
}
/*탑 버튼--------------------------------------- */
$(document).ready(function(){
  var currentPosition = parseInt($(".btnTop").css("top"));
  $(window).scroll(function() {
    var position = $(window).scrollTop(); 
    $(".btnTop").stop().animate({"top":position+currentPosition+"px"},1000);
  });
});



/*숙소, 관광지, 맛집 별로 리스트 뜨게 */
/*숙소 추천 리스트 */
var frm = $("#frm");
var purchaseDto = frm.serialize();
   $('.btnAccommodation').on('click', function(){
       $('.recommandList').load("/plan/loading");
       $.post('plan/itemList/32', purchaseDto, function(data) {
           $('.recommandList').html(data);
       });
   })
        
/*관광지 추천 리스트 */
   $('.btnTouristAttractions').on('click', function(){
       $('.recommandList').load("/plan/loading");
       $.post('plan/itemList/12', purchaseDto, function(data) {
           $('.recommandList').html(data);
       });
    })
        
/*맛집 추천 리스트 */
   $('.btnRestaurants').on('click', function(){
       $('.recommandList').load("/plan/loading");
       $.post('plan/itemList/39', purchaseDto, function(data) {
           $('.recommandList').html(data);
       });
   })
//퀵메뉴 추가 이벤트 시작
$(window).scroll(function(){  //스크롤이 움직일때마다 이벤트 발생
      var position = $(window).scrollTop()+200; // 현재 스크롤바의 위치값을 반환
      $('#Quick').stop().animate({top:position+"px"}, 400); //해당 오브젝트 위치값 재설정
   });

var width_size = window.outerWidth;
if(width_size<=450){
    $('#btnMyTravel').on('click',function(){
        var p = "purchaseSerial="+purchaseSerial;
        $.post('/plan/itemModalToMPlan/', p, function(data){
            $('#content').html(data);
        });
    })
}else{
    $('#btnMyTravel').on('click',function(){
        var p = "purchaseSerial="+purchaseSerial;
        $.post('/planner/planner/', p, function(data){
            $('#content').html(data);
    })})}
    
//검색------------------------------------
$('.search-btn').on('click', function() {
purchaseDto += "&searchTxt="+$(".searchTxt").val();
console.log(purchaseDto);
    $('.recommandList').load("/plan/loading");
	$.post('plan/itemList/searchList', purchaseDto, function(data) {
		$('.recommandList').html(data);
	});
})

//로드 완료 시 숙소 클릭되게---------------------
$(document).ready(function(){
   $('.btnAccommodation').click();
  });