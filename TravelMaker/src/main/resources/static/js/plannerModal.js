	/* MODAL 제어 */
	
	var plannerModal = document.querySelectorAll('.plannerModal');
	var plannerModifyModal = document.querySelector('#plannerModifyModal');
	var plannerMemoModal = document.querySelector('#plannerMemoModal');
	var modalWrap = document.querySelector('#modal-wrap');
	
	
	
	$('.planItemDataZone').on('click',function(ev){
		modalShow(plannerModifyModal);
	})
	
	$('.planItemIcon').on('click',function(){
		modalShow(plannerMemoModal);
	})
	
	$('.btnInsertMemo').on('click',function(){
		modalShow(plannerMemoModal);
	})
	
	$('.modalXicon').on('click',function(){
		modalHide(plannerModal);
	})
	
	$('#modal-wrap').on('click',function(){
		modalHide(plannerModal);
	})
	
	function modalShow(modal){
		modalWrap.style.display = 'block';
		modal.style.display = 'block';
	}
	
	function modalHide(modal){
		modalWrap.style.display = 'none';
		for(var i=0; i<modal.length; i++){
			modal[i].style.display = 'none';
		}
	}
	
	
	
	