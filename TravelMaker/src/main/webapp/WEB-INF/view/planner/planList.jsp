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
	<c:forEach var = 'vo' items='${list}'>
		<div class="planItem">
			<div class='planItemDataZone' onclick="openModifyModal(this)">
				<form>
					<span class="planItemOrder">
						<input type="hidden" name="planOrder" value="${vo.planOrder}"/>${vo.planOrder}
					</span>
					<span class="planItemName">${vo.locationName}</span>
					<span class="planItemDate">
						<input type="hidden" name="planDate" value="${vo.planDate}"/>${vo.planDate}
					</span>
					<input type="hidden" name="planbucketSerial" value="${vo.planbucketSerial}"/>
					<input type="hidden" name="purchaseSerial" value="1234"/>
				</form>
			</div>
			<div class="planItemMemoZone" onclick="openMemoModal()">
				<span class="planItemIcon"><i class="fa-regular fa-pen-to-square fa-2xl" class="planMemoIcon"></i></span>
				<span><input type="button" value="메모 작성" class="btnInsertMemo"/></span>
			</div>
		</div>
	</c:forEach>
</body>
</html>