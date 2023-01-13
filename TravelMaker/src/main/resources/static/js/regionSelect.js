var people = $('#people').val();
var startDate = $('.startDate').val();
var endDate = $('.endDate').val();
var startDateTime = $('.startDateTime').val();
var endDateTime = $('.endDateTime').val();


$('.regionSelectAll').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=전국&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime);
})


$('.regionSelectGang').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=강원도&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime);
})

$('.regionSelectGyeong').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=경상도&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime);
})

$('.regionSelectJeolla').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=전라도&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime);
})

$('.regionSelectChung').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=충청도&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime);
})