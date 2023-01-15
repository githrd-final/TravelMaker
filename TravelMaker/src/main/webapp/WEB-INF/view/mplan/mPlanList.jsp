<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="css/mplanner.css">
</head>
<body>
	<div id="FiltersContainer">
		<div id="planFilters">
			<input type="button" class="planFilter" id="TotalplanListFilter" value="전체">
			<c:forEach var="i" begin="1" end="${totalTravelDay+1}">
				    	<input type="button" class="planFilter" value="${i }일자" onclick="planFilterBtnClicked(this)">
			</c:forEach>
			
		</div>
	</div>
	<c:forEach var='vo' items="${list}" varStatus='status'>
	<c:if test="${vo.planOrder eq 1}">
		<div class="planDays">
			<div class="planDay" id="${vo.planDate }">${vo.planDate }</div> 
		</div>	
	</c:if>
		<div class='Planitem' onclick='modalView2(this);' >
			<div class="planSerial">${vo.planOrder }</div>
				<div class="planInfo">
					<div class="planTitle">${vo.locationName }</div>
					<div class="plangubun">${vo.contenttypeId}</div> 
				</div>
				<div class="planMemoWrapper">
					<div class="PlanMemo">
						<c:if test="${empty vo.planNote }">
							<input type="image" value="${vo.planNote}" name="planNote" src="img/edit.png" class="PlanMemoItem" onclick='modalView3(this); memoUpdate(${vo.planbucketSerial})'>
						</c:if>
						<c:if test="${!empty vo.planNote }">
							<input type="image" value="${vo.planNote}" name="planNote" src="img/memo.png" class="PlanMemoItem" onclick='modalView3(this); memoUpdate(${vo.planbucketSerial})'>
						</c:if>
					</div>
					<input type="hidden" value="${vo.planbucketSerial }" name="planbucketSerial" id="planListPlanbucketSerial">
					<input type="hidden" value="${vo.locationName }" name="locationName" id="planListLocationName">
					<input type="hidden" value="${vo.planDate }" name="planDate" id="planListPlanDate">
					<input type="hidden" value="${vo.planOrder }" name="planOrder" id="planListPlanOrder">
					<input type="hidden" value="${vo.purchaseSerial }" name="purchaseSerial" id="planListPurchaseSerial">
					
										
					
				</div>
		</div>
	</c:forEach>
	<script>

	$('#TotalplanListFilter').on('click', function(){
		$.post("/mplan/mPlanList", purchaseSerial, function(data){
            $('.mList').html(data);
 		}) 
	})
	$('.Planitem').on('click'), function(){
		console.log(this);	
	}
	
//	var modalSubmit = function(planOrder, planDate, locationName, planbucketSerial){
//		console.log(locationName);
// 		$('#UpdateModallocationItem').text(locationName);
//  		$('#modalInputContenttypeId').attr('value',jsoninsertplan["contenttypeId"]);
// 		$('#modalInputpurchaseSerial').attr('value',jsoninsertplan["purchaseSerial"]);
//  		$('#modalInputLocationName').attr('value',jsoninsertplan["locationName"]);
//  		$('#modalInputplanbucketSerial').attr('value',jsoninsertplan["planbucketSerial"]);
//  		$('#modalInputmapX').attr('value',jsoninsertplan["mapX"]);
//  		$('#modalInputmapY').attr('value',jsoninsertplan["mapY"]);
//	}
	
	
	</script>	
</body>
</html>