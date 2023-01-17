<%--
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
    <title>itemlist</title>
</head>
<body>

<main class="show list">
    <c:forEach var='item' items='${result}'>
        <div class="item">
            <div class="item-name">${item.title}</div>
            <div class="item-image" style="background-image: url('${item.firstImage}')"></div>
            <div class="item-address">${item.addr1}</div>
            <div class="item-tel">${item.tel}</div>
            <div class="item-homepage">${item.homepage}</div>
        </div>
    </c:forEach>
    </main>
</body>
</html>
