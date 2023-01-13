<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<form id='rs_header'>
				<div id='rs_header_inner'>
					<div id='rs_filter_period'>
						<select name='period' id='rs_filter_period_combo'>
							<option value=''>기간별</option>
							<option value='1박 2일' >1박 2일</option>
							<option value='2박 3일' >2박 3일</option>
							<option value='3박 4일' >3박 4일</option>
						</select>
						<input id ="tempPeriod" value="${pVo.period }" style="display: none;">
					</div>
					<div id='rs_filter_region'>
						<select name='region' id='rs_filter_region_combo'>
							<option value="">티켓별</option>
							<option value="">전국</option>
							<option value='강원도' >강원도</option>
							<option value='경상도'>경상도</option>
							<option value='전라도' >전라도</option>
							<option value='충청도' >충청도</option>
						</select>
						<input list ='region' id='tempRegion' value='${pVo.region }' style='display:none;'>
					</div>
					<div id='city'>
						<select name='city' id='rs_filter_location_combo'>
							<option value=''>지역별</option>
							
						</select>
						<input id='tempCity' value='${pVo.city }' style='display:none;'>
					</div>
					<div id='rs_search'>
						<div id='rs_search_icon'></div>
						<input id='rs_search_text' name='findStr' value='${pVo.findStr }' placeholder='제목 or 아이디 + Enter' type='text'/>
					</div>
				</div>
				<input type='text' name='nowPage' id='rs_pageVo' value='${pVo.nowPage }' style='display : none;'/>
				<input type='text' name='order' id='rs_order' value='${pVo.order }' style='display : none;' />
				<input type='hidden' name='reviewSerial' value='0'/>
			</form>
			
			<div id='rs_contents'>
				<div id='rs_contents_header'>
					<div id='rs_contents_header_blank'></div>
					<div id='rs_refresh'></div>
					<div id='rs_contents_filter'>
						<div id= 'rs_contents_filter_list'>
							<div id='rs_contents_filter_recent'>과거순</div>
							<div id='rs_contents_filter_view'>조회 많은 순</div>
							<div id='rs_contents_filter_heart'>추천 많은 순</div>
						</div>
					</div>
					<div id='rs_contents_header_blank'></div>
				</div>
				<c:forEach var='vo' items='${list }'>
					<div class='rs_content' onclick='review.view(${vo.reviewSerial })'>
						<div class='rs_content_blank'></div>
						<div class='rs_content_1'>
							<div class='rs_content_user'>
								<img id="rs_content_user_photo" src = '/images/${vo.sysPhoto }'/>
								<div id='rs_content_user_name'>${vo.nickName }</div>
							</div>
							<div class='rs_content_date'>${vo.postingDate }</div>
						</div>
						<div class='rs_content_2'>
							<div class='rs_content_title'>${vo.reviewTitle }</div>
						</div>
						<div class='rs_content_3'>
							<div class='rs_content_3_1'>
								<div class='rs_content_location'><div>${vo.city }</div></div>
							</div>
							<div class='rs_content_3_2'>
								<div class='rs_content_view'>
									<div class='rs_content_view_icon'></div>
									<div class='rs_content_view_num'>${vo.view }</div>
								</div>
								<div class='rs_content_heart'>
									<div class='rs_content_heart_icon'></div>
									<div class='rs_content_heart_num'>${vo.thumbsUp }</div>
								</div>
							</div>
						</div>
						<div class='rs_content_blank'></div>
					</div>	
				</c:forEach>
			</div>
			<div id='rs_blank_30px'></div>
			<div id='rs_page_btn'>
				<c:if test="${pVo.startPage>1 }">
					<input type='button' id='rs_page_begin' value='처음' onclick='review.move(1)'>
					<input type='button' id='rs_page_before' value='이전' onclick='review.move(${pVo.startPage-1})'>
				</c:if>
				<c:forEach var='i' begin='${pVo.startPage }' end='${pVo.endPage }'>
					<input type='button' id='rs_page_${i }' value='${i }' onclick='review.move(${i })'>
					
				</c:forEach>
				<c:if test="${pVo.totPage>pVo.endPage }">
					<input type='button' id='rs_page_after' value='다음' onclick='review.move(${pVo.endPage+1 })'>
					<input type='button' id='rs_page_end' value='끝' onclick='review.move(${pVo.totPage})'>
				</c:if>
			</div>
		</div>
		<div id='rs_blank_65px'></div>
	</body>
</html>