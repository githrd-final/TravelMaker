/**
 *
 */
/**후기게시판 연결  */

 $('.btnReviewBoard').on('click', function(){
	 $('#content').load('/review/reviewSelect')

 })
/**FAQ 연결 */
$('.btnFAQ').on('click',function(){
	$('#content').load('/faq/faqView')
})

/**회사소개 연결  */

$('.btnCompanyInfo').on('click',function(){
	$('#content').load('/companyInfo/companyInfoView');
})
/* 마이페이지-기본정보 연결 */
$('.btnMyInfo').on('click',function(){
	var email = "<%=session.getAttribute('email')%>";

	if(email == null){
		alert("로그인이 필요한 서비스입니다.");
		$('#content').load('/member/login');
	}
	else{
		$('#content').load('/myInfo/myInfo');
	}
})
/* 마이페이지-내여행 연결 */
$('.btnMyTour').on('click',function(){
	var email = "<%=session.getAttribute('email')%>";

	if(email == null){
		alert("로그인이 필요한 서비스입니다.");
		$('#content').load('/member/login');
	}
	else {
		$('#content').load('/myTour/myTourSelect');
	}
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

$('#btnSearch').on('click',function(){
	var email = "<%=session.getAttribute('email')%>";

	if(email == null){
		alert("로그인이 필요한 서비스입니다.");
		$('#content').load('/member/login');
	}
	else{
		$('#content').load('/order/regionSelect');
	}
})

$('.btnLogin').on('click',function(){
	$('#content').load('/member/login');
})