/**
 * 
 */
 (review = function(){
	
	/**하트 1이상이면 빨간 하트  */
	for(i=0; i<10; i++){
		if(Math.abs($('.rs_content_heart_num').text()[i])!=0){
			$('.rs_content_heart_icon').eq(i).css('background-image','url("../images/heart-icon-clicked.png")');
		}
		
	}
	/**필터 체크박스 처리(잘못한 것) */
	/*
	$('#rs_filter_period').on('click', function(){
		var period_checkbox = $("#rs_filter_period_checkbox")
		if(period_checkbox.prop("checked")){
			period_checkbox.prop("checked", false);
			$('#rs_filter_period').css({'color': '#555','transform':'scale(1.0)'})
		}else{
			period_checkbox.prop("checked", true);
			$('#rs_filter_period').css({'color': '#Ff6347','transform':'scale(1.2)'})
			
		}
	})
	$('#rs_filter_region').on('click', function(){
		var period_checkbox = $("#rs_filter_region_checkbox")
		if(period_checkbox.prop("checked")){
			period_checkbox.prop("checked", false);
			$('#rs_filter_region').css({'color': '#555','transform':'scale(1.0)'})
		}else{
			period_checkbox.prop("checked", true);
			$('#rs_filter_region').css({'color': '#Ff6347','transform':'scale(1.2)'})
			
		}
	})
	$('#rs_filter_location').on('click', function(){
		var period_checkbox = $("#rs_filter_location_checkbox")
		if(period_checkbox.prop("checked")){
			period_checkbox.prop("checked", false);
			$('#rs_filter_location').css({'color': '#555','transform':'scale(1.0)'})
		}else{
			period_checkbox.prop("checked", true);
			$('#rs_filter_location').css({'color': '#Ff6347','transform':'scale(1.2)'})
			
		}
	})
	*/
	/**필터 콤보박스 처리 */
	//기간 선택
	$('#rs_filter_period_combo').change(function(){
		tempPeriod = (this.value);
		frm = $('#rs_header')[0];
		console.log(tempRegion);
		param = $(frm).serialize();
		$.post("review/reviewSelect", param, function(data){
			$('#content').html(data);
		})
		setTimeout(function(){
			param = "region="+$('#tempRegion').val();
			$.post("review/reviewRegion", param, function(data){
				$('#rs_filter_location_combo').children('option:not(:first)').remove();
				for(var i = 0; i<data.length; i++){
					var option = "<option value='"+data[i]+"'>"+data[i]+"</option>";
					$('#rs_filter_location_combo').append(option);
				}
		    })
		  },100)
		setTimeout(function(){
		    $('#rs_filter_period_combo option[value="'+tempPeriod+'"]').prop('selected', true);
		    $('#rs_filter_region_combo option[value="'+$('#tempRegion').val()+'"]').prop('selected', true);
		    $('#rs_filter_location_combo option[value="'+$('#tempCity').val()+'"]').prop('selected', true);
		    $('#myTourSelecFrm div[name="')
		},200)
	})
	//지역 선택
	$('#rs_filter_region_combo').change(function(){
		tempRegion = this.value;
		frm = $('#rs_header')[0];
		
		param = $(frm).serialize();
		$.post("review/reviewSelect", param, function(data){
			$('#content').html(data);
		})
		console.log(tempRegion);
		setTimeout(function() {
			frm.region.value = tempRegion;
			param = "region="+tempRegion;
			$.post("review/reviewRegion", param, function(data){
				$('#rs_filter_location_combo').children('option:not(:first)').remove();
				for(var i = 0; i<data.length; i++){
					var option = "<option value='"+data[i]+"'>"+data[i]+"</option>";
					$('#rs_filter_location_combo').append(option);
				}
		    })
		    
		    $('#rs_filter_period_combo option[value="'+$('#tempPeriod').val()+'"]').prop('selected', true);
		    $('#rs_filter_region_combo option[value="'+tempRegion+'"]').prop('selected', true);
		    $('#rs_filter_location_combo option[value="'+$('#tempCity').val()+'"]').prop('selected', true);
		    
		}, 200);
	})
	
	//도시 선택 
	$('#rs_filter_location_combo').change(function(){
		tempCity = (this.value);
		frm = $('#rs_header')[0];
		param = $(frm).serialize();
		$.post("review/reviewSelect", param, function(data){
			$('#content').html(data);
		
		})
		
		setTimeout(function(){
			param = "region="+$('#tempRegion').val();
			$.post("review/reviewRegion", param, function(data){
				$('#rs_filter_location_combo').children('option:not(:first)').remove();
				for(var i = 0; i<data.length; i++){
					var option = "<option value='"+data[i]+"'>"+data[i]+"</option>";
					$('#rs_filter_location_combo').append(option);
				}
		    })
		  },100)
		console.log(tempCity);
		setTimeout(function(){
		    $('#rs_filter_location_combo option[value="'+tempCity+'"]').prop('selected', true);
		    $('#rs_filter_region_combo option[value="'+$('#tempRegion').val()+'"]').prop('selected', true);
		    $('#rs_filter_period_combo option[value="'+$('#tempPeriod').val()+'"]').prop('selected', true);
		},200)
	})
	
	/**필터 내용 옵션 셀렉티드  */
	
	review.filter = function(){
-
		setTimeout(function(){
		    $('#rs_filter_location_combo option[value="'+$('#tempCity').val()+'"]').prop('selected', true);
		    $('#rs_filter_region_combo option[value="'+$('#tempRegion').val()+'"]').prop('selected', true);
		    $('#rs_filter_period_combo option[value="'+$('#tempPeriod').val()+'"]').prop('selected', true);
		},200)
		
	}
	/**페이지 이동 */
	review.move = function(nowPage){
		frm = $('#rs_header')[0];
		frm.nowPage.value = nowPage;
		param = $(frm).serialize();
		$.post("/review/reviewSelect", param, function(data){
			$('#content').html(data);
		})
		review.filter();
	}
	/**검색 엔터키 입력 */
	
	$(document).ready(function(){
		$('#rs_search_text').keydown(function (key){
			if(key.keyCode ==13){
				frm = $('#rs_header')[0];
				param = $(frm).serialize();
				$.post("/review/reviewSelect", param, function(data){
					$('#content').html(data);
				})
				review.filter();
			}
		})
	})
	
	/**최신순/과거순 정렬 */
	
	$('#rs_contents_filter_recent').on('click',function(){
		$('#rs_order').val($('#rs_contents_filter_recent').text());
		console.log("rs_order 밸류 값 "+$('#rs_order').val());
		frm = $('#rs_header')[0];
		param = $(frm).serialize();	
		
		$.post("/review/reviewSelect", param, function(data){
			$('#content').html(data);
		})
		review.filter();
		setTimeout(function(){
			if($('#rs_order').val()=="최신순"){
				$('#rs_contents_filter_recent').text("과거순");
				console.log("a"+$('#rs_contents_filter_recent').text())
			}else{
				$('#rs_contents_filter_recent').text("최신순");
				console.log("b"+$('#rs_contents_filter_recent').text())
			}
		},300)
	})
	/** 조회순 정렬  */
	$('#rs_contents_filter_view').on('click',function(){
		$('#rs_order').val($('#rs_contents_filter_view').text());
		console.log("rs_order 밸류 값 "+$('#rs_order').val());
		frm = $('#rs_header')[0];
		param = $(frm).serialize();	
		
		$.post("/review/reviewSelect", param, function(data){
			$('#content').html(data);
		})
		review.filter();
		setTimeout(function(){
			if($('#rs_order').val()=="조회 많은 순"){
				$('#rs_contents_filter_view').text("조회 적은 순");
				console.log("a"+$('#rs_contents_filter_recent').text())
			}else{
				$('#rs_contents_filter_view').text("조회 많은 순");
				console.log("b"+$('#rs_contents_filter_recent').text())
			}
		},300)
	})
	
	/** 추천순 정렬  */
	$('#rs_contents_filter_heart').on('click',function(){
		$('#rs_order').val($('#rs_contents_filter_heart').text());
		console.log("rs_order 밸류 값 "+$('#rs_order').val());
		frm = $('#rs_header')[0];
		param = $(frm).serialize();	
		
		$.post("/review/reviewSelect", param, function(data){
			$('#content').html(data);
		})
		review.filter();
		setTimeout(function(){
			if($('#rs_order').val()=="추천 많은 순"){
				$('#rs_contents_filter_heart').text("추천 적은 순");
				console.log("a"+$('#rs_contents_filter_recent').text())
			}else{
				$('#rs_contents_filter_heart').text("추천 많은 순");
				console.log("b"+$('#rs_contents_filter_recent').text())
			}
		},300)
	})
	/**상세 보기  */
	review.view = function(reviewSerial){
		frm = $('#rs_header')[0];
		frm.reviewSerial.value = reviewSerial;
		console.log('리뷰시리얼: ', reviewSerial);
		param = $(frm).serialize();
		$.post("/review/reviewView", param, function(data){
			$('#content').html(data);
		})
	}
})()