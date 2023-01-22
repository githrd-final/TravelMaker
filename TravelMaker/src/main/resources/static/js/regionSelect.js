var people = $('#people').val();
var startDate = $('.startDate').val();
var endDate = $('.endDate').val();
var startDateTime = $('.startDateTime').val();
var endDateTime = $('.endDateTime').val();
var email = $('.email').val();


$('.regionSelectAll').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=7&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime+'&email='+email);
})


$('.regionSelectGang').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=1&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime+'&email='+email);
})

$('.regionSelectGyeong').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=3&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime+'&email='+email);
})

$('.regionSelectJeolla').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=4&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime+'&email='+email);
})

$('.regionSelectChung').on('click',function(){
    $('#content').load('/order/purchaseCheck?region=5&startDate='+startDate+'&endDate='+endDate+'&people='+people+'&startDateTime='+startDateTime+'&endDateTime='+endDateTime+'&email='+email);
})