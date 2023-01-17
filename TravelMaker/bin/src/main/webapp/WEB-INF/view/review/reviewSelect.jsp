<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>후기 게시판</title>
		<link rel='stylesheet' media='screen and (min-width : 450px)' href='../css/reviewSelect.css'>
		<link rel='stylesheet' media='screen and (max-width : 450px)' href='../css/reviewSelectMobile.css'>
		<script defer src='../js/reviewSelect.js'></script>
	</head>
	<body>
		<div id='rs_main'>
			<div id='rs_blank_65px'></div>
			<div id='rs_title'>
				<div>후기 게시판</div>
				<div>여러분의 여행을 공유해주세요.</div>
			</div>
			<div id='rs_blank_30px'></div>
			<div id='rs_header'>
				<div id='rs_header_inner'>
					<div id='rs_filter_period'>기간별</div>
					<div id='rs_filter_region'>도별</div>
					<div id='rs_filter_location'>지역별</div>
					<div id='rs_search'>
						<div id='rs_search_icon'></div>
						<input id='rs_search_text' placeholder='제목 or 아이디 + Enter' type='text'/>
					</div>
				</div>
			</div>
			
			<div id='rs_contents'>
				<div id='rs_contents_header'>
					<div id='rs_contents_header_blank'></div>
					<div id='rs_refresh'></div>
					<div id='rs_contents_filter'>
						<div id= 'rs_contents_filter_list'>
							<div id='rs_contents_filter_recent'>최근순</div>
							<div id='rs_contents_filter_view'>조회순</div>
							<div id='rs_contents_filter_heart'>추천순</div>
						</div>
					</div>
					<div id='rs_contents_header_blank'></div>
				</div>
			<%for(int i=0; i<10 ; i++){ %>	
				<div class='rs_content'>
					<div class='rs_content_blank'></div>
					<div class='rs_content_1'>
						<div class='rs_content_user'>
							<div id='rs_content_user_photo'></div>
							<div id='rs_content_user_name'>채찌채찌채찌</div>
						</div>
						<div class='rs_content_date'>2022-12-25 (일)</div>
					</div>
					<div class='rs_content_2'>
						<div class='rs_content_title'>구례 여행 다녀왔어요.</div>
					</div>
					<div class='rs_content_3'>
						<div class='rs_content_3_1'>
							<div class='rs_content_location'><div>구례</div></div>
						</div>
						<div class='rs_content_3_2'>
							<div class='rs_content_view'>
								<div class='rs_content_view_icon'></div>
								<div class='rs_content_view_num'>2023</div>
							</div>
							<div class='rs_content_heart'>
								<div class='rs_content_heart_icon'></div>
								<div class='rs_content_heart_num'>23</div>
							</div>
						</div>
					</div>
					<div class='rs_content_blank'></div>
				</div>	
			<%} %>			
			</div>
			<div id='rs_blank_30px'></div>
			<div id='rs_page_btn'>
				<div id='rs_page_begin'>처음</div>
				<div id='rs_page_before'>이전</div>
				<div id='rs_page_1'>1</div>
				<div id='rs_page_2'>2</div>
				<div id='rs_page_3'>3</div>
				<div id='rs_page_4'>4</div>
				<div id='rs_page_5'>5</div>
				<div id='rs_page_after'>다음</div>
				<div id='rs_page_end'>끝</div>
			</div>
		</div>
		<div id='rs_blank_65px'></div>
	</body>
</html>