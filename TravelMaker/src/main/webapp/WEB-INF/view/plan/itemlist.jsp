<%@ page import="com.project1.order.PurchaseDto" %><%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 2023/01/05
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script defer src='./js/itemlist.js'></script>
    <link rel='stylesheet' href='./css/itemlist.css'/>
    <title>itemlist</title>
</head>
<body>

<%
    PurchaseDto purchaseDto = (PurchaseDto)request.getAttribute("purchaseDto");
%>
<form action = 'purchasedTicket' method = 'post' id="frm" hidden>
    <input type="text" name="purchaseSerial" id="purchaseSerial" value="${purchaseDto.purchaseSerial}" style="display:none>
	<input type="text" name="email" id="email" value="${purchaseDto.email}" style="display:none>
    <input type="text" name="price" id="price" value="${purchaseDto.price}" style="display:none">
    <input type="text" name="people" id="people" value="${purchaseDto.people}" style="display:none">
    <input type="text" name="region" id="region" value="${purchaseDto.region}" style="display:none">
    <input type="text" name="startDate" value="${purchaseDto.startDate}" style="display:none">
    <input type="text" name="endDate" value="${purchaseDto.endDate}" style="display:none">
    <input type="text" name="startDateTime" value="${purchaseDto.startDateTime}" style="display:none">
    <input type="text" name="endDateTime" value="${purchaseDto.endDateTime}" style="display:none">
    <input type="text" name="city" value="${purchaseDto.city}" style="display:none">
</form>
<div class='check'>
    <input type="checkbox" id="cb1" name='cb' onclick='checkOnlyOne(this)'>
    <label for="cb1" >거리순(역 기준)</label>

    <input type="checkbox" id="cb2" name='cb' onclick='checkOnlyOne(this)'>
    <label for="cb2" >추천순</label>
</div>

<main class="show list">
    <c:forEach var='item' items='${result}' varStatus="status">
        <form class="item" id="item" onclick="openModal(this)">
            <div class="item-name">${item.title}</div>
            <input type="text" class="item-contentId" name=abc value="${item.contentID}" style="display: none"></input>
            <div class="item-image" style="background-image: url('${item.firstImage}')"></div>
            <div class="item-address">${item.addr1}</div>
            <div class="item-tel">${item.tel}</div>
            <div class="item-homepage">${item.homepage}</div>
        </form>
    </c:forEach>
    <div id="modal" class="modal-overlay">
    </div>
    </main>
</body>
<!--
<script>
    const modal = document.getElementById("modal");

    modal.addEventListener("click", e => {
        const evTarget = e.target
        if(evTarget.classList.contains("modal-overlay")) {
            modalOff()
        }
    })
    window.addEventListener("keyup", e => {
        if(isModalOn() && e.key === "Escape") {
            modalOff()
        }
    })

    function modalOff() {
        modal.style.display = "none"
    }

    function isModalOn() {
        return modal.style.display === "flex"
    }
</script>
-->
</html>