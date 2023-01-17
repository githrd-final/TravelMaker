/**
 * 
 */
 /**게시글 제목 클릭 시 게시글 상세보기 페이지로 이동  */
 $('.rs_content_2').on('click', function(){
	$('#content').load('/review/reviewView');
})