/**
 * 
 */
var purchaseSerial = "purchaseSerial="+$('#purchaseSerial')[0].value;
var totalTravelDay = $('#totalTravelDay')[0].value;
var pSerial = $('#purchaseSerial')[0].value;
var map;
var markers=[];
var planPositions = [];
var planPositionDayOne = [];
var planPositionDayTwo = [];
var planPositionDayThree = [];
var planPositionDays = [];
var customoverlays=[]
var infowindow;
var polylines = [];
		

$.post("/mplan/mPlanBucketList", purchaseSerial, function(data){
            $('.mList').html(data);
 })
$( document ).ready(function() {
	kakao.maps.disableHD();
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: new kakao.maps.LatLng(35, 125), //지도의 중심좌표.
				level: 9 //지도의 레벨(확대, 축소 정도)
			};
				
		map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			
		
			
		// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
		var bounds;
		markers=[];   
		var linepath = [];
		var polyline;
		customoverlays=[];
		
		planPositions = [];
		planPositionDayOne = [];
		planPositionDayTwo = [];
		planPositionDayThree = [];
		planPositionDays = [];
		
		polylines = [];
		
		// 버킷버튼 클릭, 커스텀 출력 및 지도 범위 설정
		BucketBtnClicked= function(positions){
			
			
			if(infowindow!=null){
      			infowindow.close();  
      		}
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
				
				
				if(polylines.length != 0){
					for(var i=0; i<polylines.length; i++){
						polylines[i].setMap(null);
					}
				}
				if(polyline!= null){
					polyline.setMap(null);
				}
				markers=[];
				polylines=[];
				customoverlays=[];
				for (var i = 0; i < positions.length; i ++) {
					var json = JSON.parse(positions[i]);					 // 마커를 생성합니다
					 var p=new kakao.maps.LatLng(json.mapY, json.mapX);
					 
					 
					 var marker = new kakao.maps.Marker({
					     map: map, // 마커를 표시할 지도
					     position: p, // 마커를 표시할 위치
					     title : json.locationName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					     clickable: true, // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
					 });
					 
				    bounds.extend(p);
					marker.setZIndex(1);
				    map.setBounds(bounds);
				    linepath.push(p);
				    markers.push(marker);
				    
				    // 마커에 클릭이벤트를 등록합니다
					kakao.maps.event.addListener(marker, 'click', function() {
						if(infowindow!=null){
      						infowindow.close();  
      					}  
						var iwContent = '<div style="padding:5px;">'+this.getTitle()+'</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				    
						// 인포윈도우를 생성합니다
						infowindow = new kakao.maps.InfoWindow({
						    content : iwContent,
						    zIndex : 10
						});
					    
					    // 이동할 위도 경도 위치를 생성합니다 
						var moveLatLon = this.getPosition();
		    
		    			map.setLevel(8);
		    			map.panTo(moveLatLon);
					      
					    // 마커 위에 인포윈도우를 표시합니다
      					infowindow.open(map, this);      
					});
					if($('#mPlanList').hasClass("clickbtn") === true){
						
						$('#mPlanList').click();
					}
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
			if(infowindow!=null){
      			infowindow.close();  
      		}
			// 이동할 위도 경도 위치를 생성합니다 
		    var moveLatLon = new kakao.maps.LatLng(y, x);
		    
		    map.setLevel(5);
		    map.panTo(moveLatLon);   
		}
		
		
	$('#mPlanSerial').value = "0"
})

		
		
	var bucketFilterBtnClicked = function(filterbtn){
		if(infowindow!=null){
      		infowindow.close();  
      	}
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
		
		if(customoverlays.length!=0){
					for(var i =0; i< customoverlays.length;i++){
						customoverlays[i].setMap(null);	
					}
				}
				
				
				if(polylines.length != 0){
					for(var i=0; i<polylines.length; i++){
						polylines[i].setMap(null);
					}
				}
				markers=[];
				polylines=[];
				customoverlays=[];
				
		$.post("/mplan/mPlanBucketList", purchaseSerial, function(data){
            $('.mList').html(data);
 		}) 
	})
	

	
	$('#mPlanList').on('click', function(){
		if(infowindow!=null){
      		infowindow.close();  
      	}
		$('#mPlanList').attr("class","clickbtn");
		$('#mPlanBucketList').attr("class","nonclickbtn");
		$.post("/mplan/mPlanList", purchaseSerial, function(data){
            $('.mList').html(data);
 		}) 
 		
			$.ajax({
					type : 'post',
					url : '/mplan/planJson',
					data : purchaseSerial,
					dataType: 'json',
					async : false,
					success : function(data){
						setPlanPositions(data);
						setCustomOverlays(planPositions);
					},
					error : function(request,status,error){
						alert("error : " + error);
					}
				})
			
	})
	
	
	function setPlanPositions(data){
		
		
		planPositions = [];
		planPositionDayOne = [];
		planPositionDayTwo = [];
		planPositionDayThree = [];
		planPositionDays = [];
		
		bounds = new kakao.maps.LatLngBounds();  
			
		for(var i=0; i<data.length; i++){
			var json = JSON.parse(data[i]);
			var title = json.locationName;
			
			var mapX = json.mapX;
			var mapY = json.mapY;
			var planDate = json.planDate;
			
			if(planDate == '1일자'){
				planPositionDayOne.push({
					title : title,
					latlng : new kakao.maps.LatLng(mapY,mapX),
				});
			} else if ( planDate == '2일자'){
				planPositionDayTwo.push({
					title : title,
					latlng : new kakao.maps.LatLng(mapY,mapX),
				});
			} else if (planDate == '3일자') {
				planPositionDayThree.push({
					title : title,
					latlng : new kakao.maps.LatLng(mapY,mapX),
				});
				
			}
			
			planPositions.push({
				title : title,
				latlng : new kakao.maps.LatLng(mapY,mapX),
			});
			
		} // end of for
		
		planPositionDays.push(planPositionDayOne,planPositionDayTwo,planPositionDayThree);
		
	} //setPlanPositions
	
	var setCustomOverlays = function(){
		bounds = new kakao.maps.LatLngBounds();    

		if(customoverlays.length != 0){
			for(var i=0; i<customoverlays.length; i++){
				customoverlays[i].setMap(null);
			}
		}
		
		if(polylines.length != 0){
			for(var i=0; i<polylines.length; i++){
				polylines[i].setMap(null);
			}
		}
		customoverlays=[];
		polylines=[];
		var customColor = ['tomato','blue','green'];
		for(var i=0; i<planPositionDays.length; i++){
			if(planPositionDays[i].length != 0){
				linePath = [];
				for(var j=0; j<planPositionDays[i].length; j++){
					linePath.push(planPositionDays[i][j].latlng);
					bounds.extend(planPositionDays[i][j].latlng);
					//같은 xy축 좌표가 존재하면 makers의 그 부분을 찾아서 map에서 지워버리기
					for(var k=0; k<markers.length;k++){
						if(markers[k].getPosition().getLat().toFixed(10)==planPositionDays[i][j].latlng.getLat().toFixed(10)){
							if(markers[k].getPosition().getLng().toFixed(10)==planPositionDays[i][j].latlng.getLng().toFixed(10)){
								
								markers[k].setMap(null);							
							}
						}
					}
					var customOverlay = new kakao.maps.CustomOverlay({
					    position: planPositionDays[i][j].latlng,
					    content: '<div class="customOverlay" style="border : 7px outset '+customColor[i]+'">' +
					    				(j+1) +
					    			'<div> DAY' + (i+1) + '</div>' +
					    		 '</div>' 
					});
					customOverlay.setZIndex(10);
					customOverlay.setMap(map);
					
					customoverlays.push(customOverlay);
				}
				
				var polyline = new kakao.maps.Polyline({
				    path: linePath, // 선을 구성하는 좌표배열 입니다
				    strokeWeight: 8, // 선의 두께 입니다
				    strokeColor: customColor[i], // 선의 색깔입니다
				    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
				    strokeStyle: 'solid', // 선의 스타일입니다
				    zIndex: 20
				});
				
				
				polyline.setMap(map);
				polylines.push(polyline);
				map.setBounds(bounds);
				
			}
	  }
		
	} //setCustomOverlays
	
	
	function setCustomView(bucketPositions){
		
		for(var i=0; i<bucketPositions.length; i++){
			
			var addr = bucketPositions[i].addr;
			var contenttypeId = bucketPositions[i].contenttypeId;
			var locationName = bucketPositions[i].locationName;
			var locationPhoto = bucketPositions[i].locationPhoto;
			var overview = bucketPositions[i].overview.split(".")[0];
			
			var mapX = bucketPositions[i].mapX;
			var mapY = bucketPositions[i].mapY;
			var planbucketSerial = bucketPositions[i].planbucketSerial;
			var purchaseSerial = bucketPositions[i].purchaseSerial;
			
			var content = '<div class="customView">' + 
						  '    <div class="customViewHeader">' + 
						  '        <span class="cvTitle">' + 
						  				locationName + 
						  '        </span>' + 
						  '        <span class="cvXIcon"><i class="fa-solid fa-xmark fa-xl" onclick="customClose()"></i></span>'+
						  '    </div>' +    
						  '    <div class="customViewBody">' + 
						  '         <div class="cvImgZone">' +
						  '             <img class="cvImg" src="' + locationPhoto + '">' +
						  '         </div>' + 
						  '         <div class="cvOverView">' + 
						                overview + 
						  '         </div>' + 
						  '    </div>' + 
						  '    <div class="customViewFooter">'+
						  '  	  <form id="planInsertFrm">'+
						  '			<input type="hidden" name="purchaseSerial" value="'+ purchaseSerial +'"/> ' +
						  '			<input type="hidden" name="planbucketSerial" value="'+ planbucketSerial +'"/> ' +
						  '			<input type="hidden" name="contenttypeId" value="'+ contenttypeId +'"/> ' +
						  '			<input type="hidden" name="locationName" value="'+ locationName +'"/> ' +
						  '			<input type="hidden" name="mapX" value="'+ mapX +'"/> ' +
						  '			<input type="hidden" name="mapY" value="'+ mapY +'"/> ' +
						  ' 	  </form>' +
						  '        <span class="cvPlusIcon" onclick="openDateModal(this.previousElementSibling)"><i class="fa-regular fa-square-plus"></i></span>'+
						  '    </div>'+
			              '</div>';	
			
			var customView = new kakao.maps.CustomOverlay({
			    position: new kakao.maps.LatLng(mapY, mapX),
			    content: content,
			    yAnchor: 1.3
			});
			customViews.push(customView);
		}
	} // setCustomView
	
	
	
	$('#goReview').on('click',function(){
		$('#content').load('/myTour/myTourSelect');
	})
	
	$('#goRecommend').on('click',function(){
		$.post("/mplan/goRecommend", purchaseSerial, function(data){            
			$('#content').html(data);
 		}) 
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
		$.post('/mplan/mBucketToPlan', param, function(data){ 
			if(data!=""){
			alert(data);
			}
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

	$('#btnPlanModalAdd').on('click', function(){
		var frm = $('.frm_PlanUpdate')[0];
		var param = $(frm).serialize();
		$('#modal2').css('display', 'none');
		$.post('/mplan/planUpdate', param, function(){
			$('.mList').load('/mplan/mPlanList', purchaseSerial);
			$.ajax({
				type : 'post',
				url : '/mplan/planJson',
				data : purchaseSerial,
				dataType: 'json',
				async : false,
				success : function(data){
					setPlanPositions(data);
					setCustomOverlays(planPositions);
				},
				error : function(request,status,error){
					alert("error : " + error);
				}
			}) 
		});
				

	})
	
	$('#btnPlanModalSubtract').on('click', function(){
		var frm = $('.frm_PlanUpdate')[0];
		var param = $(frm).serialize();
		$('#modal2').css('display', 'none');
		$.post('/mplan/planDelete', param, function(){ 
			$('.mList').load('/mplan/mPlanList', purchaseSerial);
			$.ajax({
				type : 'post',
				url : '/mplan/planJson',
				data : purchaseSerial,
				dataType: 'json',
				async : false,
				success : function(data){
					setPlanPositions(data);
					setCustomOverlays(planPositions);
				},
				error : function(request,status,error){
					alert("error : " + error);
				}
			})
		});
				

	})	
	
	$('#btnCheck3').on('click', function(){
		var frm = $('.frm_PlanMemoUpdate')[0];
		var param = $(frm).serialize();
		$('#modal3').css('display', 'none');
		$.post('/mplan/memoUpdate', param, function(){ 
			$('.mList').load('/mplan/mPlanList', purchaseSerial);
		});
	})	
	
	var planFilterBtnClicked = function(filterbtn){
		var filterSerial=filterbtn.value;
		
		
		
		var param="planDate="+filterSerial+"&"+purchaseSerial;
		$.post("/mplan/mPlanFilterList", param, function(data){
            $('.mList').html(data);
 		})
 		$.ajax({
					type : 'post',
					url : '/mplan/planJsonByDate',
					data : param,
					dataType: 'json',
					async : false,
					success : function(data){
						setPlanPositions(data);
						setCustomOverlays(planPositions);
					},
					error : function(request,status,error){
						alert("error : " + error);
					}
				}) 
	}
	
	var memo=1;
	//modal update
	$('#modalBack2').on('click', function(){
		$('#modal2').css('display', 'none');
	})	
	
	
	$('#btnClose2').on('click', function(){
		$('#modal2').css('display', 'none');
	})	
		
	modalView2 = function(th){
		if(memo==1){
			$('#UpdateModallocationItem').text(th.querySelector('#planListLocationName').value);
			$('.UpdatePlanOrder').val(th.querySelector('#planListPlanOrder').value);
			$('.UpdatePlanDate option[value='+th.querySelector('#planListPlanDate').value+']').prop('selected', true);
			$('#UpdatePurchaseSerial').val(pSerial);
			$('#UpdatePrePlanDate').val(th.querySelector('#planListPlanDate').value);
			$('#UpdatePrePlanOrder').val(th.querySelector('#planListPlanOrder').value);
			$('#UpdatePlanbucketSerial').val(th.querySelector('#planListPlanbucketSerial').value);
			
		
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
	
	var modalView3 = function(memoTag){
		memo=0;		
		this.memoTag = memoTag;
		$('.MemoArea').val(memoTag.value);
		$('#modal3').css('display', 'block');	
	}
			
	var memoUpdate= function(pbSerial){
		memo=0;	
		console.log(pbSerial);
		$('#MemoUpdatePlanbucketSerial').val(pbSerial);
	}

	
	memoInsert = function(){
		memo=1;
		$('#modal3').css('display', 'none');
		this.memoTag.src="img/memo.png";
	}
	
