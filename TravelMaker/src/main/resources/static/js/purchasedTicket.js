/**
 * 
 */
var frm = $("#frm");
   $('#btnPlan').on('click', function(){
       var purchaseDto = frm.serialize();
       $.post('plan/recommendListMain', purchaseDto, function(data) {
           $('#content').html(data);
       });
   })