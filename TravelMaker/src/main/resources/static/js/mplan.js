/**
 * 
 */
var purchaseSerial = "purchaseSerial="+$('#purchaseSerial')[0].value;
var totalTravelDay = $('#totalTravelDay')[0].value;

$.post("/mplan/mPlanBucketList", purchaseSerial, function(data){
            $('.mList').html(data);
 })
//$('.mList').load('/mplan/mPlanBucketList');	/* 메인화면 들어가자마자 바로 뿌려주게*/ 
 // A $( document ).ready() block.
$( document ).ready(function() {
	kakao.maps.disableHD();
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: new kakao.maps.LatLng(35, 125), //지도의 중심좌표.
				level: 9 //지도의 레벨(확대, 축소 정도)
			};
				
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			
		
			
		// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
		var bounds;
		var markers=[];    
		var linepath = [];
		var polyline;
		var customoverlays=[];
		
		// 버킷버튼 클릭, 커스텀 출력 및 지도 범위 설정
		BucketBtnClicked= function(positions){
			if(positions==null){
				$.ajax({
					type:'post',
					url:'/mplan/mplanJson',
					data:purchaseSerial,
					dataType:'json',
					async:false,
					success:function(data){
						positions=data;
					},
					error : function(error){
						alert("error:"+error);
					}
				})	
			}
				bounds = new kakao.maps.LatLngBounds();
				if(markers.length!=0){
					for(var i =0; i< markers.length;i++){
						markers[i].setMap(null);	
					}
				}
				if(customoverlays.length!=0){
					for(var i =0; i< customoverlays.length;i++){
						customoverlays[i].setMap(null);	
					}
				}
				if(polyline!= null){
					polyline.setMap(null);
				}
				for (var i = 0; i < positions.length; i ++) {
					var json = JSON.parse(positions[i]);
					 // 마커를 생성합니다
					 var p=new kakao.maps.LatLng(json.mapY, json.mapX);
					 
					 var marker = new kakao.maps.Marker({
					     map: map, // 마커를 표시할 지도
					     position: p, // 마커를 표시할 위치
					     title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					 });
					
				    bounds.extend(p);
				    map.setBounds(bounds);
				    linepath.push(p);
				    markers.push(marker);
				} // for문의 끝

		}
		
		
		// 리스트 지도에 출력
		$.ajax({
			type:'post',
			url:'/mplan/mplanJson',
			data:purchaseSerial,
			dataType:'json',
			async:false,
			success:function(data){
				BucketBtnClicked(data);
			},
			error : function(error){
				alert("error:"+error);
			}
		})		
		// 리스트 클릭시
		ListClicked = function(x, y){
			
			// 이동할 위도 경도 위치를 생성합니다 
		    var moveLatLon = new kakao.maps.LatLng(y, x);
		    
		    map.setLevel(3);
		    map.panTo(moveLatLon);   
		}
		
		// 일정버튼 클릭, 커스텀 출력 및 지도 범위 설정
		PlanClicked= function(){
			polyline=null;
			customoverlays=[];
			for(var i =0;i<positions.length;i++){
				
				markers[i].setMap(null);
				var content = '<div class ="customoverlay">'+ (i+1) +'</div>';
				var customOverlay = new kakao.maps.CustomOverlay({
		    			position: positions[i].latlng,
		    			content: content   
		    		
				}); //end Customoverlay
							
			    map.setBounds(bounds);
			    customoverlays.push(customOverlay);
			    
				// 커스텀 오버레이를 지도에 표시합니다
				customOverlay.setMap(map);
		}//endfor


		//폴리라인 출력
		polyline = new kakao.maps.Polyline({
		    path: linepath, // 선을 구성하는 좌표배열 입니다
		    strokeWeight: 3, // 선의 두께 입니다
		    strokeColor: 'tomato', // 선의 색깔입니다
		    strokeOpacity: 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		    strokeStyle: 'solid' // 선의 스타일입니다
		});
		
		// 지도에 선을 표시합니다
		polyline.setMap(map);  
	};
	$('#mPlanSerial').value = "0"
})

	var bucketFilterBtnClicked = function(filterbtn){
		var filterSerial;
		if(filterbtn.value=="숙소"){
			filterSerial="32";
		}
		else if(filterbtn.value=="관광지"){
			filterSerial="12";
		}
		else if(filterbtn.value=="식당"){
			filterSerial="39"
		}
		
		var param="contenttypeId="+filterSerial+"&"+purchaseSerial;
		
		$.post("/mplan/mPlanBucketFilterList", param, function(data){
            $('.mList').html(data);
        })
		$.ajax({
			type:'post',
			url:'/mplan/mplanFilterJson',
			data:param,
			dataType:'json',
			async:false,
			success:function(data){
				BucketBtnClicked(data);
			},
			error : function(error){
				alert("error:"+error);
			}
		})
	}

	$('.bucketThrow').on('click', function(){
		var jsoninsertplan =  JSON.parse(this.value);
		
		$.ajax({
			type:'post',
			url:'/mplan/mplanJson',
			data:jsoninsertplan,
			dataType:'json',
			async:false,
			success:function(data){
				BucketBtnClicked(data);
			},
			error : function(error){
				alert("error:"+error);
			}
		})
	})
        
	$('#mPlanBucketList').on('click', function(){
		$('#mPlanBucketList').attr("class","clickbtn");
		$('#mPlanList').attr("class","nonclickbtn");
		$.post("/mplan/mPlanBucketList", purchaseSerial, function(data){
            $('.mList').html(data);
 		}) 
	})
	

	
	$('#mPlanList').on('click', function(){
		$('#mPlanList').attr("class","clickbtn");
		$('#mPlanBucketList').attr("class","nonclickbtn");
		$('.mList').load('/mplan/mPlanList');	/* 메인화면 들어가자마자 바로 뿌려주게*/ 
	})
	
	$('#goReview').on('click',function(){
		$('#content').load('/myTour/myTourSelect');
	})
	
	//modal - +btn
	$('#modalBack').on('click', function(){
		$('#BucketModal').css('display', 'none');
	})	
	
	
	$('#btnClose').on('click', function(){
		$('#BucketModal').css('display', 'none');
		
	})
	
	$('#btnBucketModalAdd').on('click', function(){
		var frm = $('.frm_bucketToPlanInsert')[0];
		var param = $(frm).serialize();
		$('#BucketModal').css('display', 'none');
		$.post('/mplan/mBucketToPlan', param, function(){ 
		});
		$.ajax({
			type:'post',
			url:'/mplan/mplanJson',
			data:param,
			dataType:'json',
			async:false,
			success:function(data){
				BucketBtnClicked(data);
			},
			error : function(error){
				alert("error:"+error);
			}
		})
	})
		
	
	
	var memo=1;
	//modal update
	$('#modalBack2').on('click', function(){
		$('#modal2').css('display', 'none');
	})	
	
	
	$('#btnClose2').on('click', function(){
		$('#modal2').css('display', 'none');
	})	
		
	modalView2 = function(frm){
		if(memo==1){
			$('#modal2').css('display', 'block');	
		}
	}
	
	
	//modal memo
	var memoTag;
	$('#modalBack3').on('click', function(){
		memo=1;
			$('#modal3').css('display', 'none');
	})	
	
	
	$('#btnClose3').on('click', function(){
		memo=1;
		$('#modal3').css('display', 'none');
		
	})		
	modalView3 = function(memoTag){
		memo=0;
		this.memoTag = memoTag;
		$('#modal3').css('display', 'block');	
	}
	
	memoInsert = function(){
		memo=1;
		$('#modal3').css('display', 'none');
		this.memoTag.src="img/memo.png";
	}