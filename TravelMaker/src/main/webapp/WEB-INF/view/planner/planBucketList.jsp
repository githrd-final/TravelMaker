<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>planner/planBucketList</title>
<link rel="stylesheet" href="css/planner.css"/>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
	<c:forEach var="bucketVo" items="${list}">
		<div class="planBucketItem" onclick="customView('${bucketVo.mapX}','${bucketVo.mapY}')">
			<span class="planBucketItemTitle">${bucketVo.locationName}</span>
			<span class="planBucketItemType">${bucketVo.contenttypeId}</span><br/>
			<span class="planBucketItemAddr">${bucketVo.addr}</span>
			<span class="planBucketItemIcon"><i class="fa-solid fa-xmark fa-2xl" id="planBucketXicon"></i></span>
		</div>
	</c:forEach>
</body>

</html>