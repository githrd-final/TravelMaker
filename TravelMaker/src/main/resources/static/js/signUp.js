/**
 *
 */
$('.btnProfileSelect').on('click',function(){
    $('#content').load('/member/login');
})

$('.btnSubmit').on('click',function(){
    window.close();

    location.replace("http://localhost:9282");
})
