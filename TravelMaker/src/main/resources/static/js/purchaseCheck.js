/**
 * 
 */

var frm = $("#frm");
var email = document.getElementById("email").value;
var region = document.getElementById("region").value;
var regionString = "";
if(region == "1") {
    regionString = "강원도";
}else if(region == "3") {
    regionString = "경상도";
}else if(region == "4") {
    regionString = "전라도";
}else if(region == "5") {
    regionString = "충청도";
}else if(region == "7") {
    regionString = "전국";
}
var people = document.getElementById("people").value;
var price = 0;
var totalPrice = 0;
if(region == "7") {
    price = 30000;
}else if(region == "3" || region == "4") {
    price = 40000;
}else if(region == "5" || region == "1") {
    price = 35000;
}

totalPrice = people* price;
const rand = Math.floor(Math.random() * 2000);
function requestPay() {
var IMP = window.IMP; // 생략 가능
IMP.init("imp84346376"); // 예: imp00000000
    // IMP.request_pay(param, callback) 결제창 호출
    
    const rand = Math.floor(Math.random() * 1000);
    IMP.request_pay({ // param
        pg: "html5_inicis",
        pay_method: "card",
        merchant_uid: "ORD20230125123-" + rand,
        name: "랜덤 기차 여행 - " + regionString,
        amount: totalPrice, // if
        buyer_email: email,
        buyer_name: "양수비",
        buyer_tel: "010-4242-4242",
        buyer_addr: "서울특별시 강남구 신사동",
        buyer_postcode: "01181"
    }, function (rsp) { // callback
        if (rsp.success) {
            var orderDto = frm.serialize();
            console.log(orderDto);
            $.ajax({
                type : "POST",
                url : "/order/purchasedTicketA",
                data : orderDto,
                success : function(data) {
                    alert("성공");
                    $("#content").load("/order/purchasedTicketB");
                },
                    error: function(data) {
                        alert("실패");
                    }
            });
            /*$('#content').load('/order/purchasedTicket);*/
        } else {
            alert("오류가 발생했습니다. 다시 시도해주세요.");
        }
    });
  }
  /* top버튼 */
$('.moveTopBtn').on('click',function(){
	window.scrollTo({top:0, behavior:"smooth"});
})
/*티켓 구매내역 미리띄울게 */
/*$('#btnTicket').on('click', function(){
            $('#content').load('/order/purchasedTicket');
})*/
/*$('#btnTicket').on('click', function(){
    $('#content').load('/order/purchasedTicket');
})*/
