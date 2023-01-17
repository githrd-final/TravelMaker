/**
 * 
 */
 
 /* 별점 */
$( ".star_rating a" ).on('click',function(){
     $(this).parent().children("a").removeClass("on");
     $(this).addClass("on").prevAll("a").addClass("on");
     return false;
});

/* 수정하기 버튼 클릭 시 reviewView 연결 */
 $('.reviewModifyBtn').on('click',function(){
	var frm = $('.frm_summernote')[0];
	frm.reviewStar.value=$(".on").length;
    var param = $(frm).serialize();
    console.log(param);
    $.post("/review/reviewModify", param, function(data){
		$('#content').html(data);
    })
 }) 
 
 /* 후기수정 페이지 써머노트 연결 */
var fonts = [ '맑은 고딕', '돋움', '궁서', '굴림', '굴림체', '궁서체', '나눔 고딕', '바탕',
		'바탕체', '새굴림', 'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M', 'HY목각파임B',
		'HY신명조', 'HY얕은샘물M', 'HY엽서L', 'HY엽서M', 'HY중고딕', 'HY헤드라인M',
		'휴먼매직체', '휴먼모음T', '휴먼아미체', '휴먼둥근헤드라인', '휴먼편지체', '휴먼옛체' ];	//삽입할 글씨체
fonts.sort();	//폰트 정렬(가나다순)

var loadInterval=[];
var intervalCnt=0;
console.log("reviewInsert 실행OK");

$(document).ready(function() {
	$('#summernote').summernote({
		width : 800,
		height : 300, // set editor height
		minHeight : null, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true, // set focus to editable area after initializing summernote
		lang: "ko-KR",
		fontNames : fonts,
		placeholder: '글 내용을 입력해주세요.',
		
		callbacks : {
				onMediaDelete : function(target) {
					deleteFile(target[0].src);
				},
		
				onImageUpload : function(files, editor, welEditable) {
		
					loadInterval.length = files.length;
					$('#summer').addClass('spinner');//spinner
					
					for (var i = files.length - 1; i >= 0; i--) {
						sendFile(i, files[i], this);
					}
				}
			}	
	});
	
	function sendFile(intervalPos, file, el) {
	var form_data = new FormData();
	form_data.append('file', file);
	$.ajax({
		data : form_data,
		type : "POST",
		url : '/MyTour/MyTourReviewInsert',
		enctype : 'multipart/form-data',
		cache : false,
		contentType : false,
		processData : false,
		success : function(img_name) {
			
			loadInterval[intervalPos] = setInterval(loadCheck.bind(null, intervalPos, img_name), 1500);
			
			
			
			/*
			setTimeout(function(){
				console.log("loading....2")
				$('#summernote').summernote('editor.insertImage', img_name);
			}, 43000)
			*/
							
			
					
			}
		});
	}
	
			function loadCheck(intervalPos, img) {	//spinner(로딩 체크)
			try{
				var t = new Image();
				t.src = img;
				t.onload = function(){
					clearInterval(loadInterval[intervalPos]);
					$('#summernote').summernote('editor.insertImage', img);
					$('#summer').removeClass('spinner'); //spinner 제거
				}
			}catch(err){
				console.log(err);
			}finally{
				
			}

		}

		function deleteFile(target) {
			console.table("target:" + target)
			$.ajax({
				data : {
					target : target
				},
				type : "POST",
				url : '', // replace with your url
				cache : false,
				success : function(resp) {
					console.log(resp);
				}
			});
		}

})