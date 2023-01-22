/**
 *
 */
var frm = $("#frm");
var purchaseDto = frm.serialize();
var contentId = document.querySelector('.item-contentId').value;

if(width_size<=450){
    $('.itemModaltoMyPlan').on('click',function(){
        $.post('plan/itemModaltoMyPlan/', purchaseDto, function(data){
            $('#content').load('/mplan/mPlanner');
        });
    })
}else{
    $('.itemModaltoMyPlan').on('click',function(){
        $.post('plan/itemModaltoMyPlan/', purchaseDto, function(data){
            $('#content').load('/planner/planner');
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