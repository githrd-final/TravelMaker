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
			<input type="button" class="bucketFilter" value="숙소" onclick="bucketFilterBtnClicked(this)">
			<input type="button" class="bucketFilter" value="관광지" onclick="bucketFilterBtnClicked(this)">
			<input type="button" class="bucketFilter" value="식당" onclick="bucketFilterBtnClicked(this)">
		</div>
	</div>
	
	<c:forEach var='vo' items="${list}" varStatus='status'>
		<div class='Bucketitem' onclick="ListClicked(this)">
<!--  			<form name='frm_bucketList_test' class='frm_bucketList_test'> -->
				<img src="${vo.locationPhoto }" class="bucketImg">
				<div class="bucketInfo">
					<div class="bucketTitle">${vo.locationName}<input id='bucketTitleInput' value="${vo.locationName}" name="locationName"/> </div>
					<div class="bucketgubun">${vo.contenttypeId} </div>		
				</div>
				<div></div>
				<div class="bucketbtn">
					<div></div>
					<div>
						<input type="image" src="img/plus.png" class="bucketToPlan" value="${vo.locationName}"/>
						<input type="image" src="img/minus.png" class="bucketThrow"/>
					</div>
					<div>	
						<input type="hidden" value="${vo.planbucketSerial}" name="planbucketSerial">
					</div>
				</div>
<!-- 			</form> -->
		</div>
	</c:forEach>
	<script>
	
	$('.bucketToPlan').on('click', function(){
		$('#BucketModal').css('display', 'block');
		$('#modalLocationName').text(this.value);
		console.log(this.form);
	})
	
	</script>
</body>
</html>