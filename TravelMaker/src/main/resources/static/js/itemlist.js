/**
 *
 */

// const modal = document.getElementById("modal");
var modal = document.querySelector(".modal-overlay");

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

//var contentId = document.querySelector('.item-contentId').value;
/*$('#item').on('click',function(abc){
    $('#modal').load('/plan/itemDetailModal/' + abc.value);
    $('#modal').css('display', 'flex');
})*/

function openModal(frm) {
    $('#modal').load('/plan/itemDetailModal/' + frm.contentID.value);
    $('#modal').css('display', 'flex');
}

/*if(width_size<=450){
    $('.itemModaltoMyPlan').on('click',function(){
        $('#content').load('/mplan/mPlanner');
    })
}else{
    $('.itemModaltoMyPlan').on('click',function(){
        $('#content').load('/planner/planner');
    })} */

var frm = $("#frm");
var purchaseDto = frm.serialize();
var itemForm = document.querySelector('#item');
function orderByDistance(){

}

if(width_size<=450){
    $('.itemModaltoMyPlan').on('click',function(){
        $.post('plan/itemModaltoMyPlan/', purchaseDto, function(data){
            $('#content').html(data);
        });
    })
}else{
    $('.itemModaltoMyPlan').on('click',function(){
        $.post('plan/itemModaltoMyPlan/', purchaseDto, function(data){
            $('#content').html(data);
        });
    })}

/*$('#insertPlanBucket').on('click',
    function (frm) {
        alert("asdf");
        $.ajax({
            type : "POST",
            url : "plan/insertPlanBucket/"+frm.abc.value,
            data : purchaseDto,
            success : function(data) {
                alert("일정에 추가되었습니다!");
            },
            error: function(data) {
                alert("오류가 발생했습니다");
            }
        });
    })*/

/*$('#deletePlanBucket').on('click',function (frm) {
    $.post('plan/deletePlanBucket/' + frm.abc.value, purchaseDto, function(data){
        console.log("deleted");
    });
})*/