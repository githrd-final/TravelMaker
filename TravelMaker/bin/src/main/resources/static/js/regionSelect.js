$('.regionSelectAll').on('click',function(){
    $('#content').load('/plan/itemList/부산');
})

$('.regionSelectGang').on('click',function(){
    $('#content').load('/order/purchaseCheck');
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