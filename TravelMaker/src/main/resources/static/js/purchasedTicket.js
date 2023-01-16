/**
 * 
 */
/*티켓 구매내역 미리띄울게 */
var frm = $("#frm");
   $('#btnPlan').on('click', function(){
       var purchaseDto = frm.serialize();
       $.ajax({
              type : "POST",
                url : "/order/purchasedTicket",
                data : purchaseDto,
                dataType : "application/json",
                success : function(data) {
                    alert("성공");
                    $('#content').load('/plan/recommendListMain');
                }
       })
   })