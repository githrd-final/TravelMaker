/**
 *
 */
var frm = $("#frm");
var purchaseDto = frm.serialize();
var purchaseSerial = $("#purchaseSerial").val();
var contentId = document.querySelector('.item-contentId').value;

if(width_size<=450){
    $('.itemModalToMyPlan').on('click',function(){
        var p = "purchaseSerial="+purchaseSerial;
        $.post('/plan/itemModalToMPlan/', p, function(data){
            $('#content').html(data);
        });
    })
}else{
    $('.itemModalToMyPlan').on('click',function(){
        var p = "purchaseSerial="+purchaseSerial;
        $.post('/planner/planner/', p, function(data){
            $('#content').html(data);
        });
})}

    function insertIntoBucket(frm) {
        $.ajax({
            type: "POST",
            url: "plan/insertPlanBucket/" + frm.abc.value,
            data: purchaseDto,
            success: function (msg) {
                $('#modal').load('/plan/itemDetailModal/' + frm.abc.value);
                if (msg != "") {
                    alert(msg);
                }
            },
            error: function (data) {
                alert("오류가 발생했습니다");
            }
        });
    }

$('#deletePlanBucket').on('click',function (frm) {
    $.post('plan/deletePlanBucket/' + frm.abc.value, purchaseDto, function(data){
        console.log("deleted");
    });
})