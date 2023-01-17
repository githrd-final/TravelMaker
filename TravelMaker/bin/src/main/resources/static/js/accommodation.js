/**
 * 
 */
 
 	const modal = document.getElementById("modal");

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
 
 
$('.ex').on('click',function(){
    $('#modal').load('/plan/itemDetailModal/129156');
    $('#modal').css('display', 'flex');
})