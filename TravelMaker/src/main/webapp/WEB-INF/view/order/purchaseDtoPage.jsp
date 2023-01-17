<%@ page import="com.project1.order.PurchaseDto" %><%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 2023/01/16
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>purchaseDtoPage</title>
</head>
<body>
<%
    PurchaseDto purchaseDto = (PurchaseDto)request.getAttribute("purchaseDto");
%>
<form action = 'purchasedTicket' method = 'post' id="frm" >
    <input type="text" name="purchaseSerial" id="purchaseSerial" value="${purchaseDto.purchaseSerial}">
    <input type="text" name="email" id="email" value="${purchaseDto.email}">
    <input type="text" name="price" id="price" value="${purchaseDto.price}" style="display:none">
    <input type="text" name="people" id="people" value="${purchaseDto.people}" style="display:none">
    <input type="text" name="region" id="region" value="${purchaseDto.region}" style="display:none">
    <input type="text" name="startDate" value="${purchaseDto.startDate}" style="display:none">
    <input type="text" name="endDate" value="${purchaseDto.endDate}" style="display:none">
    <input type="text" name="startDateTime" value="${purchaseDto.startDateTime}" style="display:none">
    <input type="text" name="endDateTime" value="${purchaseDto.endDateTime}" style="display:none">
    <input type="text" name="city" value="${purchaseDto.city}" style="display:none">
</form>
</body>
</html>
