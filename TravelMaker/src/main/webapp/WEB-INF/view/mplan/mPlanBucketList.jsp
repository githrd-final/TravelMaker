<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="FiltersContainer">
		<div id="bucketFilters">
			<input type="button" id="TotalbucketListFilter" class="bucketFilter" value="전체" onclick="BucketBtnClicked(${vo.purchaseSerial })">
			<input type="button" class="bucketFilter" value="숙소" onclick="bucketFilterBtnClicked(this)">
			<input type="button" class="bucketFilter" value="관광지" onclick="bucketFilterBtnClicked(this)">
			<input type="button" class="bucketFilter" value="식당" onclick="bucketFilterBtnClicked(this)">
		</div>
	</div>
	
	<c:forEach var='vo' items="${list}" varStatus='status'>
		<div class='Bucketitem' onclick="ListClicked(${vo.mapX},${vo.mapY})">
				<img src="${vo.locationPhoto }" class="bucketImg">
				<div class="bucketInfo">
					<div class="bucketTitle">${vo.locationName}<input id='bucketTitleInput' value="${vo.locationName}" name="locationName"/> </div>
					<div class="bucketgubun">${vo.contenttypeId} </div>		
				</div>
				<div></div>
				<div class="bucketbtn">
					<div></div>
					<div>
						<input type="image" src="img/plus.png" class="bucketToPlan" value='{"locationName":"${vo.locationName}", "planbucketSerial":"${vo.planbucketSerial}","purchaseSerial":"${vo.purchaseSerial }", "mapX":"${vo.mapX }", "mapY":"${vo.mapY }"}'/>
						<input type="image" src="img/minus.png" class="bucketThrow" style='cursor:hand;'value='{"planbucketSerial":"${vo.planbucketSerial}","purchaseSerial":"${vo.purchaseSerial }"}'/>
					</div>
					<div>	
						<input type="hidden" value="${vo.planbucketSerial}" name="planbucketSerial" id="bucketListPlanbucketSerial">
					</div>
				</div>
		</div>
	</c:forEach>
	<script>
	
	$('.bucketToPlan').on('click', function(){
 		$('#BucketModal').css('display', 'block');
		var jsoninsertplan =  JSON.parse(this.value);
		console.log(jsoninsertplan);
 		$('#modalLocationName').text(jsoninsertplan["locationName"]);
 		
		$('#modalInputpurchaseSerial').attr('value',jsoninsertplan["purchaseSerial"]);
 		$('#modalInputLocationName').attr('value',jsoninsertplan["locationName"]);
 		$('#modalInputplanbucketSerial').attr('value',jsoninsertplan["planbucketSerial"]);
 		$('#modalInputmapX').attr('value',jsoninsertplan["mapX"]);
 		$('#modalInputmapY').attr('value',jsoninsertplan["mapY"]);
	})
	
	
	$('.bucketThrow').on('click', function(){
		window.alert("삭제하시겠습니까?");
		var jsoninsertplan =  JSON.parse(this.value);
		console.log(jsoninsertplan);
		$.post('/mplan/mPlanBucketDelete', jsoninsertplan, function(){
	   		$('.mList').load('/mplan/mPlanBucketList', purchaseSerial);	 
		});
	})
	
	$('#TotalbucketListFilter').on('click', function(){
		$.post("/mplan/mPlanBucketList", purchaseSerial, function(data){
            $('.mList').html(data);
 		}) 
	})
	</script>
</body>
</html>