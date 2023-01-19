/**
 *
 */
/**후기게시판 연결  */
$( document ).ready(function() {
	console.log(sessionStorage.getItem('email'));
	if(sessionStorage.getItem('email')){
		location.replace('/');
	}
});
 $('.btnReviewBoard').on('click', function(){
	 $('#content').load('/review/reviewSelect')
 })
/**FAQ 연결 */
$('.btnFAQ').on('click',function(){
	$('#content').load('/member/FAQ')
})

/**회사소개 연결  */

$('.btnCompanyInfo').on('click',function(){
	$('#content').load('/companyInfo/companyInfoView');
})
/* 마이페이지-기본정보 연결 */
$('.btnMyInfo').on('click',function(){
		$('#content').load('/myInfo/myInfo');
})
$('.btnMyInfoB').on('click',function(){
	alert("로그인이 필요한 서비스입니다.");
	$('#content').load('/member/login');
})
/* 마이페이지-내여행 연결 */
$('.btnMyTour').on('click',function(){
		$('#content').load('/myTour/myTourSelect');
})
$('.btnMyTourB').on('click',function(){
	alert("로그인이 필요한 서비스입니다.");
	$('#content').load('/member/login');
})

 function navigo (){
	 const hero = document.querySelector('#hero');   //hero부분 획득
	 const fixStart = hero.clientHeight;      //hero 높이
	 document.addEventListener('scroll', onScroll, { passive: true });   //스크롤 이벤트



	 function onScroll () {
		 const scrollposition = pageYOffset;	//스크롤 위치
		 const header = document.querySelector('header'); 	//네비게이션
		 if (fixStart<=scrollposition){	//만약 hero높이<=스크롤 위치라면
			 header.style.position='fixed';
			 header.style.backgroundColor='#E49082';
			 header.style.opacity=0.55;
		 }else {
			 if(document.getElementById("hero")){
				 header.style.position='absolute';
				 header.style.backgroundColor='rgb(255 255 255 / 0%)';
				 header.style.opacity=0;
			 }else{
				 header.style.position='fixed';
				 header.style.backgroundColor='#E49082';
				 header.style.opacity=0.55;
			 }
		 }
	 }
 }
navigo()

function div(){
	const header = document.querySelector('header');
	const empty = document.querySelector('#empty');
	$('.indexMenuA').on('click',function(){
		if($(window).width()>450){
			empty.style.height='65px';
		}else{
			empty.style.height='89.24px';
		}
		header.style.backgroundColor='#E49082';
		header.style.opacity=0.55;
	});
}
div();

$('#btnSearch').on('click', function(){

	var people = $('#peopleSu').val();

	var startDateTime = $('input[name="time1"]:checked').val(); // 체크된 값(checked value)
	var endDateTime = $('input[name="time2"]:checked').val();
	var startTimeCheck = $('input[name="time1"]').is(':checked'); // 체크 여부(checked)
	var endTimeCheck = $('input[name="time2"]').is(':checked');

	var startDate = $('#date1').val();
	var endDate = $('#date2').val();
	var now = new Date();
	var year = now.getFullYear();
	var month = ('0' + (now.getMonth() + 1)).slice(-2);
	var day = ('0' + now.getDate()).slice(-2);
	var nowDate = year + '-' + month + '-' + day;
	var startArrDate = startDate.split('-');
	var endArrDate = endDate.split('-');
	var startDateD = new Date(startArrDate[0], startArrDate[1], startArrDate[2]);
	var endDateD = new Date(endArrDate[0], endArrDate[1], endArrDate[2]);
	var btMs = endDateD.getTime() - startDateD.getTime();
	var btDay = btMs / (1000 * 60 * 60 * 24);

	if(startTimeCheck == false || endTimeCheck == false){
		alert('시간을 선택해주세요');
		return false;
	}
	if(people == ''){
		alert('인원을 선택해주세요');
		return false;
	}
	if(people < 1 || people > 5){
		alert('인원은 1명부터 5명까지 가능합니다!');
		return false;
	}
	if(startDate == '' || endDate == ''){
		alert('날짜를 선택해주세요');
		return false;
	}
	if(startDate < nowDate || endDate < nowDate){
		alert('오늘 이전 날짜는 선택할 수 없습니다!');
		return false;
	}
	if(startDate > endDate){
		alert('종료일이 시작일보다 빠릅니다!');
		return false;
	}
	if(btDay == 1 || btDay == 2) {
		$.ajax({
			type: 'get',
			url: '/order/regionSelect',
			data: {'startDate':startDate, 'endDate':endDate, 'people':people, 'startDateTime': startDateTime, 'endDateTime':endDateTime},
			dataType: 'text',
			success: function(result) {
				$('#content').load('/order/regionSelectB?startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime);
			},
			error: function(result) {
				console.log('오류 발생')
			}
		})
	} else {
		alert('여행은 1박 2일 혹은 2박 3일만 가능합니다!');
	}
})

$('#btnSearchB').on('click', function(){
	alert("로그인이 필요한 서비스입니다.");
	$('#content').load('/member/login');
})

$('.btnLogin').on('click',function(){
	$('#content').load('/member/login');
})

var result = $('#result').val();

if(result == 'unRegistered'){
	$('#content').load('/member/signUp');
}