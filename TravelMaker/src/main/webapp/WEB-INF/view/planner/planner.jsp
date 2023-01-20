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
		<div><input type="hidden" id="purchaseSerial" value="${purchase }"/></div>
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
						<select id="planInsertDate">
							<option	value="1일자">1일차</option>
							<option value="2일자">2일차</option>
							<option value="3일자">3일차</option>
						</select>
					</span>
				</div>
				<div class="modalFooter">
					<input type="button" value="입력" id="btnPlanInsert"/>
				</div>
			</div>	
			<div class="plannerModal" id="plannerModifyModal" style="display:none">
				<div class="modalHeader">
					<span class="modalTitle">일정수정</span>
					<span class="modalXicon"><i class="fa-solid fa-xmark fa-2xl" ></i></span>
				</div>
				<div class="modalBody" id="plannerModifyModalBody">
				<form id = "planModifyFrm">
					<span>순번</span></br>
					<span>
						<input type="text" size="10" name="planOrder"/></span><br/>
					<span>날짜</span></br>
					<span>
						<select id="modifyPlanDate" name="planDate">
							<option value="1일자">1일차</option>
							<option value="2일자">2일차</option>
							<option value="3일자">3일차</option>
						</select>
					</span>
					<input type="hidden" name="prePlanOrder"/>
					<input type="hidden" name="prePlanDate"/>
					<input type="hidden" name="planbucketSerial"/>
					<input type="hidden" name="purchaseSerial" value="1201100A106001121A11happilyah@naver.com"/>
				</form>
				</div>
				<div class="modalFooter">
					<input type="button" value="수정" id="btnPlanModify"/>
					<input type="button" value="삭제" id="btnPlanDelete"/>
				</div>
			</div>	
			<div class="plannerModal" id="plannerMemoModal" style="display:none">
				<div class="modalHeader">
					<span class="modalTitle">메모작성</span>
					<span class="modalXicon"><i class="fa-solid fa-xmark fa-2xl" ></i></span>
				</div>
				<div class="modalBody" id="plannerMemoModalBody">
					<form id="planMemoFrm">
						<span>
							<textarea placeholder="메모를 작성해주세요." name="planNote" id="memoText"></textarea>
						</span>
						<input type="hidden" name ="planbucketSerial"/>
					</form>
				</div>
				<div class="modalFooter">
					<input type="button" value="입력" id="btnUpdateMemo"/>
					<input type="hidden" value="초기화" id="btnResetMemo"/>
				</div>
			</div>	
			<div id="MapZone">
			
			</div>
			<div id="planBucketListZone">
				<div id="planBucketListMenu">
					<div class="planBucketMenuItemAll" id="BucketMenuActive">전체</div>
					<div class="planBucketMenuItem">
						<input type="hidden" value="32"/>숙박
					</div>
					<div class="planBucketMenuItem">
						<input type="hidden" value="12"/>관광지
					</div>
					<div class="planBucketMenuItem">
						<input type="hidden" value="39"/>맛집
					</div>
				</div>
				<div id="planBucketList">
				
				</div>
			</div>
		</div>
		<div id="planListZone">
			<div id="planListMenu">
				<div class="planListMenuItemAll" id="PlanMenuActive">전체</div>
				<c:forEach var="i" begin="1" end="3">
				<div class="planListMenuItem" onclick="planMenuClick(this)">
					<form class="planListByDateForm">
						<input type="hidden" name="planDate" value="${i}일자"/>DAY${i}
					</form>	
				</div>
				</c:forEach>
			</div>
			<div id="planList">
			</div>
		</div>
		<a href="#" id="goReview">여행목록</a>
	</div>
	<script>
		
		var planInsertFrm = null;   // customView일정입력폼
		var planListItemFrm = null; // 일정리스트아이템폼
		var planMemoFrm = null;     // 메모모달폼
		var btnWriteMemo = null;    // 선택된 아이템의 메모작성버튼
		var btnShowMemo = null;     // 선택된 아이템의 메모보기버튼
		
		var currentModal = null; // 현재 보여지고 있는 모달
		var plannerDateModal = document.querySelector('#plannerDateModal');
		var plannerModifyModal = document.querySelector('#plannerModifyModal');
		var plannerMemoModal = document.querySelector('#plannerMemoModal');
		var modalWrap = document.querySelector('#modal-wrap');
		
		function openDateModal(Frm){
			planInsertFrm = Frm;
			modalWrap.style.display = 'block';
			plannerDateModal.style.display = 'block';
			currentModal = plannerDateModal;
		}
		
		function openModifyModal(node){
			planListItemFrm = node.children[0];
			
			var planModifyFrm = document.querySelector('#planModifyFrm');
			var planOrder = planListItemFrm.planOrder.value;
			var planDate = planListItemFrm.planDate.value;
			var planbucketSerial = planListItemFrm.planbucketSerial.value;
			planModifyFrm.planOrder.value = planOrder;
			planModifyFrm.prePlanOrder.value = planOrder;
			planModifyFrm.prePlanDate.value = planDate;
			planModifyFrm.planDate.value = planDate;
			planModifyFrm.planbucketSerial.value = planbucketSerial;
			$('#modifyPlanDate').val(planDate).attr("selected","selected");
			
			modalWrap.style.display = 'block';
			plannerModifyModal.style.display = 'block';
			currentModal = plannerModifyModal;
			
		}
		
		function openMemoModal(planbucketSerial){
 			$('#memoText').val("");
			
			btnWriteMemo = document.getElementById('writeMemo'+ planbucketSerial);
			btnShowMemo = document.getElementById('showMemo'+ planbucketSerial);
			
			planMemoFrm = document.querySelector('#planMemoFrm');
			planMemoFrm.planbucketSerial.value = planbucketSerial;
			
			modalWrap.style.display = 'block';
			plannerMemoModal.style.display = 'block';
			currentModal = plannerMemoModal;
		}
		
		function closeModal(){
			modalWrap.style.display = 'none';
			currentModal.style.display = 'none';
		}
		
		$('.modalXicon').on('click',function(){
			closeModal();
		})
		
		$('#modal-wrap').on('click',function(){
			closeModal();
		})
	</script>
</body>
</html>