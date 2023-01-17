<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>planner/planner</title>
	<link rel="stylesheet" href="css/planner.css"/>
	<script src="https://kit.fontawesome.com/59e9622ad2.js" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script defer src="/js/planner.js"></script>
</head>
<body>
	<div id='planner_title'>
		<div>여행일정</div>
		<div>여러분만의 일정을 계획해보세요.</div>
	</div>
	<div id="plannerZone">
		<div id="MapBucketZone">
			<div id="modal-wrap" style="display:none;">
			</div>
			<div class="plannerModal" id="plannerDateModal" style="display:none">
				<div class="modalHeader">
					<span class="modalTitle">일정추가</span>
					<span class="modalXicon"><i class="fa-solid fa-xmark fa-2xl" ></i></span>
				</div>
				<div class="modalBody" id="plannerDateModalBody">
					<span>일정을 추가할 날을 입력하세요.</span></br>
					<span>
						<select>
							<option>1일차</option>
							<option>2일차</option>
							<option>3일차</option>
						</select>
					</span>
				</div>
				<div class="modalFooter">
					<input type="button" value="입력"/>
				</div>
			</div>	
			<div class="plannerModal" id="plannerModifyModal" style="display:none">
				<div class="modalHeader">
					<span class="modalTitle">일정수정</span>
					<span class="modalXicon"><i class="fa-solid fa-xmark fa-2xl" ></i></span>
				</div>
				<div class="modalBody" id="plannerModifyModalBody">
					<span>순번</span></br>
					<span><input type="text" size="10"/></span><br/>
					<span>날짜</span></br>
					<span>
						<select>
								<option>1일차</option>
								<option>2일차</option>
								<option>3일차</option>
						</select>
					</span>
				</div>
				<div class="modalFooter">
					<input type="button" value="수정"/>
					<input type="button" value="삭제"/>
				</div>
			</div>	
			<div class="plannerModal" id="plannerMemoModal" style="display:none">
				<div class="modalHeader">
					<span class="modalTitle">메모작성</span>
					<span class="modalXicon"><i class="fa-solid fa-xmark fa-2xl" ></i></span>
				</div>
				<div class="modalBody" id="plannerMemoModalBody">
					<span>
						<textarea placeholder="메모를 작성해주세요."></textarea>
					</span>
				</div>
				<div class="modalFooter">
					<input type="button" value="입력"/>
				</div>
			</div>	
			<div id="MapZone">
			
			</div>
			<div id="planBucketListZone">
				<div id="planBucketListMenu">
					<div class="planBucketMenuItem" id="BucketMenuActive">전체</div>
					<div class="planBucketMenuItem">숙박</div>
					<div class="planBucketMenuItem">관광지</div>
					<div class="planBucketMenuItem">맛집</div>
				</div>
				<div id="planBucketList">
				
				</div>
			</div>
		</div>
		<div id="planListZone">
			<div id="planListMenu">
				<div class="planListMenuItem" id="PlanMenuActive">전체</div>
				<div class="planListMenuItem">DAY1</div>
				<div class="planListMenuItem">DAY2</div>
				<div class="planListMenuItem">DAY3</div>
			</div>
			<div id="planList">
			</div>
		</div>
		<a href="#" id="goReview">여행목록</a>
	</div>
	<script>
		var currentModal = null;
		var plannerDateModal = document.querySelector('#plannerDateModal');
		var plannerModifyModal = document.querySelector('#plannerModifyModal');
		var plannerMemoModal = document.querySelector('#plannerMemoModal');
		var modalWrap = document.querySelector('#modal-wrap');
		
		function openDateModal(){
			modalWrap.style.display = 'block';
			plannerDateModal.style.display = 'block';
			currentModal = plannerDateModal;
			
		}
		
		function openModifyModal(){
			modalWrap.style.display = 'block';
			plannerModifyModal.style.display = 'block';
			currentModal = plannerModifyModal;
			
		}
		
		function openMemoModal(){
			modalWrap.style.display = 'block';
			plannerMemoModal.style.display = 'block';
			currentModal = plannerMemoModal;
		}
		
		$('.modalXicon').on('click',function(){
			modalWrap.style.display = 'none';
			currentModal.style.display = 'none';
			
		})
		
		$('#modal-wrap').on('click',function(){
			modalWrap.style.display = 'none';
			currentModal.style.display = 'none';
		})
	</script>
</body>
</html>