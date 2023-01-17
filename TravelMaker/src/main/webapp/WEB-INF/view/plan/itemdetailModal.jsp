<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>viewdetail</title>
</head>
<body>
        <c:set var="item" value="${result}"/>
        <div class="modal-window">
            <div class="item-detail-modal">
                <div class="item-name">${item.title}</div>
                <div class="item-image" style="background-image: url('${item.firstImage}')"></div>
                <div class="item-address">${item.addr1}</div>
                <div class="item-tel">${item.tel}</div>
                <div class="item-homepage">${item.homepage}</div>
                <div class="item-overview">${item.overView}</div>
            </div>
            <div class="item-detailBtnGroup-modal">
                <input type="button" class= "itemModaltoMyPlan" value="내 일정 보기" />
                <input type="button" value="일정에 추가" /> <!-- c:if 문으로 일정 추가 여부 확인 -->
            </div>
        </div>
</main>
</body>
</html>