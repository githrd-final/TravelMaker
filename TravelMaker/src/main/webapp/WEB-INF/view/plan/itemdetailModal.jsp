<%@ page import="com.project1.order.PurchaseDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>viewdetail</title>
    <script defer src='./js/itemdetailModal.js'></script>
</head>
<body>
<%
    PurchaseDto purchaseDto = (PurchaseDto)request.getAttribute("purchaseDto");
%>
<form action = 'purchasedTicket' method = 'post' id="frm" hidden>
    <input type="text" name="purchaseSerial" id="purchaseSerial" value="${purchaseDto.purchaseSerial}" style="display:none">
    <input type="text" name="email" id="email" value="${purchaseDto.email}" style="display:none">
    <input type="text" name="price" id="price" value="${purchaseDto.price}" style="display:none">
    <input type="text" name="people" id="people" value="${purchaseDto.people}" style="display:none">
    <input type="text" name="region" id="region" value="${purchaseDto.region}" style="display:none">
    <input type="text" name="startDate" value="${purchaseDto.startDate}" style="display:none">
    <input type="text" name="endDate" value="${purchaseDto.endDate}" style="display:none">
    <input type="text" name="startDateTime" value="${purchaseDto.startDateTime}" style="display:none">
    <input type="text" name="endDateTime" value="${purchaseDto.endDateTime}" style="display:none">
    <input type="text" name="city" value="${purchaseDto.city}" style="display:none">
</form>

        <c:set var="item" value="${result}"/>
        <div class="modal-window">
            <form class="item-detail-modal" onclick="insertIntoBucket(this)">
                <input type="text" class="item-contentId" name=abc value="${item.contentID}" style="display: none"></input>
                <div class="item-name">${item.title}</div>
                <div class="item-image" style="background-image: url('${item.firstImage}')"></div>
                <div class="item-address">${item.addr1}</div>
                <div class="item-tel">${item.tel}</div>
                <div class="item-homepage">${item.homepage}</div>
                <div class="item-overview">${item.overView}</div>
                <input type="button" class= "itemModaltoMyPlan" value="내 일정 보기" />
                <input type="button" id= "insertPlanBucket" value="일정에 추가" />
            </form>
            <div class="item-detailBtnGroup-modal">
            </div>
        </div>
</main>
</body>
</html>