<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>planner/planList</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<c:forEach var = 'planVo' items='${list}'>
		<div class="planItem">
			<div class='planItemDataZone' onclick="openModifyModal(this)">
				<form>
					<span class="planItemOrder">
						<input type="hidden" name="planOrder" value="${planVo.planOrder}"/>${planVo.planOrder}
					</span>
					<span class="planItemName">${planVo.locationName}</span>
					<span class="planItemDate">
						<input type="hidden" name="planDate" value="${planVo.planDate}"/>${planVo.planDate}
					</span>
					<input type="hidden" name="planbucketSerial" value="${planVo.planbucketSerial}"/>
					<input type="hidden" name="purchaseSerial" value="${planVo.purchaseSerial}"/>
				</form>
			</div>
			<div class="planItemMemoZone" >
				<c:if test="${empty planVo.planNote}">
				<span class="planItemIcon" 
					  onclick = "openMemoModal('${planVo.planbucketSerial}')">
				<i class="fa-regular fa-pen-to-square fa-2xl" class="planMemoIcon"></i>
				</span>
				<span>
					<input type="button" value="메모 작성" id="writeMemo${planVo.planbucketSerial}" 
						   onclick="openMemoModal('${planVo.planbucketSerial}')"/>
				</span>
				</c:if>
				<c:if test="${!empty planVo.planNote}">
				<span class="planItemIcon" 
					  onclick = "ShowMemo('${planVo.planbucketSerial}')">
				<i class="fa-regular fa-pen-to-square fa-2xl" class="planMemoIcon"></i>
				</span>
				<span>
					<input type="button" value="메모 보기" class = "btnShowMemo" onclick = "ShowMemo('${planVo.planbucketSerial}')" 
						   id="showMemo${planVo.planbucketSerial}" style="background-color : #0080FF"/>
				</span>
				</c:if>
			</div>
		</div>
	</c:forEach>
</body>
</html>