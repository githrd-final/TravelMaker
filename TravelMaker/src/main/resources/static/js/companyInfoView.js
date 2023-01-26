/**
 * 
 */

$(".ci_review_go").on('click', function(){
	$('#content').load('/review/reviewSelect');
})
$(".ci_ticket_go").on('click', function(){
	location.replace('/');
})
 
 var obs1 = new IntersectionObserver((e)=>{
	e.forEach((divBox)=>{
		if(divBox.isIntersecting){
			divBox.target.style.opacity = 1;
		}else{
			divBox.target.style.opacity = 0;
		}
	})
})
var div = document.querySelectorAll('div')

for(i=0; i<50; i++){
	obs1.observe(div[i]);
}


