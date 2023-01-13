$('.regionSelectAll').on('click',function(){
    $('#content').load('/plan/itemList/부산');
})


$('.regionSelectGang').on('click',function(){
var people = $('#people').val();
var startDate = $('.startDate').val();
var endDate = $('.endDate').val();
var startDateTime = $('.startDateTime').val();
var endDateTime = $('.endDateTime').val();
    console.log("gang");
    console.log(people);
    console.log(startDate);
    $('#content').load('/order/purchaseCheck?region=강원도&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime);
})

$('.regionSelectGyeong').on('click',function(){
    $('#content').load('/plan/itemDetail/129156');
})

$('.regionSelectJeolla').on('click',function(){
    $('#modal').load('/plan/itemDetailModal/129156');
    $('#modal').css('display', 'flex');
})

$('.regionSelectChung').on('click',function(){
    $('#content').load('/plan/itemList/부산');
})