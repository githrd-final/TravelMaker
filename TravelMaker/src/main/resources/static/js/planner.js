
/*  Map */
var kakaoMap = (function(){
		
	var map = null;
	var bounds = new kakao.maps.LatLngBounds();  
	var bucketMarkers = [];  // 마커객체들이 담긴 배열
	var linePath = [];		 // polyline 연결할 마커의 좌표들이 담긴 배열
	var customViews = []; 	 // customView객체들이 담긴 배열
	var customOverlays = []; // cunstomOverlay객체들이 담긴 배열
	var targetCustom = null;
	
	var purchaseSerial = document.querySelector('#purchaseSerial').value;
	var planItems = document.querySelector('#planListMenu').children;
	var bucketItems = document.querySelector('#planBucketListMenu').children;
	
	var mapX = 37.51424591;
	var mapY = 127.1040305;
	
	var container = document.getElementById('MapZone'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(mapX,mapY), //지도의 중심좌표.
		level: 5 //지도의 레벨(확대, 축소 정도)
	};
	
	var bucketPositions = [];
	
	var planPositions = [];
	var planPositionDayOne = [];
	var planPositionDayTwo = [];
	var planPositionDayThree = [];
	var planPositionDays = [];
	
	var polylines = [];
	
	function MenuActive(items,target){
		
		if(items == bucketItems){
			for(var i=0; i<items.length; i++){
				
				if(items[i].hasAttribute('id','BucketMenuActive')){
					items[i].removeAttribute('id','BucketMenuActive');
					break;
				}
			}
			
			target.setAttribute('id','BucketMenuActive')
		}
		
		if(items == planItems){
			for(var i=0; i<items.length; i++){
				
				if(items[i].hasAttribute('id','PlanMenuActive')){
					items[i].removeAttribute('id','PlanMenuActive');
					break;
				}
			}
			
			target.setAttribute('id','PlanMenuActive');
		}
	}
	
	function initMap(container,options){
		map = new kakao.maps.Map(container,options)
	}
	function setBounds(bounds){
		
		for(var i=0; i<linePath.length; i++){
			bounds.extend(linePath[i]);
		}
		map.setBounds(bounds);
	}
	
	function setBucketPositions(data){
		bucketPositions = [];
		
		for(var i=0; i<data.length; i++){
			
			var json = JSON.parse(data[i]);
			console.log("셋 버킷 포지션스 제이슨 ", json);
			var addr = json.addr;
			var contenttypeId = json.contenttypeId;
			var locationName = json.locationName;
			var locationPhoto = json.locationPhoto;
			var overview = json.overview;
			console.log("셋 버킷 포지션스 오버뷰 ", overview);
			var mapX = json.mapX;
			var mapY = json.mapY;
			var planbucketSerial = json.planbucketSerial;
			var purchaseSerial = json.purchaseSerial;
			
			bucketPositions.push({
				locationName : locationName,
				locationPhoto : locationPhoto,
				latlng : new kakao.maps.LatLng(mapY,mapX),
				contenttypeId : contenttypeId,
				overview : overview,
				mapX : mapX,
				mapY : mapY,
				planbucketSerial : planbucketSerial,
				purchaseSerial : purchaseSerial
			});
			
		}
	}
	
	function setPlanPositions(data){
		planPositions = [];
		planPositionDayOne = [];
		planPositionDayTwo = [];
		planPositionDayThree = [];
		planPositionDays = [];
		
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
	
	
	function setCustomView(bucketPositions){
		customViews = [];
		console.log("버킷포지션렝스",bucketPositions.length);
		for(var i=0; i<bucketPositions.length; i++){
			console.log(bucketPositions[i]);
			var addr = bucketPositions[i].addr;
			var contenttypeId = bucketPositions[i].contenttypeId;
			var locationName = bucketPositions[i].locationName;
			var locationPhoto = bucketPositions[i].locationPhoto;
			console.log("오버뷰 ", bucketPositions[i].overviews);
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
	
	function setMarkers(bucketPositions){
		if(bucketMarkers.length != 0){
			for(var i=0; i<bucketMarkers.length; i++){
					bucketMarkers[i].setMap(null);
			}
		}
		
		var imageSrc = './images/MapFood.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(32, 32)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		
		bucketMarkers = [];
		linePath = [];
		
		for(var i = 0; i<bucketPositions.length; i++){
			linePath.push(bucketPositions[i].latlng);
			if(bucketPositions[i].contenttypeId == "숙박"){
				imageSrc = './images/MapHotel.png';
			}else if (bucketPositions[i].contenttypeId == "관광지"){
				imageSrc = './images/MapTour.png';
			}else { imageSrc = './images/MapFood.png';}
			
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
		    markerPosition = linePath[i]; // 마커가 표시될 위치입니다
			
			var marker = new kakao.maps.Marker({
			     map: map, // 마커를 표시할 지도
			     position: bucketPositions[i].latlng, // 마커를 표시할 위치
			     title : bucketPositions[i].locationName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			     image: markerImage // 마커이미지 설정
			 });
			
			marker.setMap(map);
			bucketMarkers.push(marker);
		}
	} //setMarkers
	
	
	function setCustomOverlays(planPositions){
		if(customOverlays.length != 0){
			for(var i=0; i<customOverlays.length; i++){
				customOverlays[i].setMap(null);
			}
		}
		
		if(polylines.length != 0){
			for(var i=0; i<polylines.length; i++){
				polylines[i].setMap(null);
			}
		}
		
		var customColor = ['tomato','blue','green'];
		
		for(var i=0; i<planPositionDays.length; i++){
			
			if(planPositionDays[i].length != 0){
				linePath = [];
				for(var j=0; j<planPositionDays[i].length; j++){
					linePath.push(planPositionDays[i][j].latlng);
					var customOverlay = new kakao.maps.CustomOverlay({
					    position: planPositionDays[i][j].latlng,
					    content: '<div class="customOverlay" style="border : 7px outset '+customColor[i]+'">' +
					    				(j+1) +
					    			'<div> DAY' + (i+1) + '</div>' +
					    		 '</div>' 
					});
					
					customOverlay.setMap(map);
					customOverlays.push(customOverlay);
				}
				
				var polyline = new kakao.maps.Polyline({
				    path: linePath, // 선을 구성하는 좌표배열 입니다
				    strokeWeight: 8, // 선의 두께 입니다
				    strokeColor: customColor[i], // 선의 색깔입니다
				    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
				    strokeStyle: 'solid' // 선의 스타일입니다
				});
				
				setBounds(bounds);
				polyline.setMap(map);
				polylines.push(polyline);
				
			}
		}
		
	} //setCustomOverlays
	
	
	
	$('#goReview').on('click',function(){
		$('#content').load('/myTour/myTourSelect');
	})
	
	
	$(document).ready(function(){
		
		initMap(container,options);
		
		
		
		$('#planBucketList').load('/planner/bucketList',{"purchaseSerial" : purchaseSerial},function(data){
			
			$('.planBucketMenuItemAll').on('click',function(ev){
				var target = ev.target;
				var param = {"purchaseSerial" : purchaseSerial}
				MenuActive(bucketItems,target);
				$('#planBucketList').load('/planner/bucketList',param);
				
				$.ajax({
					type : 'post',
					url : '/planner/bucketJson',
					data : param,
					dataType: 'json',
					async : false,
					success : function(data){
						setBucketPositions(data);
						setCustomView(bucketPositions);
						setMarkers(bucketPositions);
						setBounds(bounds);
						
					},
					error : function(request,status,error){
						alert("error : " + error);
					}
				})
			})
			
			var planBucketMenuItemAll = document.querySelector('.planBucketMenuItemAll');
			planBucketMenuItemAll.click();
			
			$('.planBucketMenuItem').on('click',function(ev){
				var target = ev.target;
				var contenttypeId = ev.target.firstChild.nextSibling.value;
				var param = {"contenttypeId" : contenttypeId,
							 "purchaseSerial" : purchaseSerial}
				
				MenuActive(bucketItems,target);
				$('#planBucketList').load('/planner/bucketListByType',param);
				
				$.ajax({
					type : 'post',
					url : '/planner/bucketJsonByType',
					data : param,
					dataType: 'json',
					async : false,
					success : function(data){
						setBucketPositions(data);
						setMarkers(bucketPositions);
						setBounds(bounds);
					},
					error : function(request,status,error){
						alert("error : " + error);
					}
				})
				
			})
			
			
			$('#btnPlanInsert').on('click',function(){
				var param = $(planInsertFrm).serialize();
				var planDate = $('#planInsertDate').val();
				param += "&planDate="+planDate;
				
				$.post('planner/bucketInsert',param,function(data){
					alert('입력성공!');
					closeModal();
					$('#PlanMenuActive').click();
					if(targetCustom != null){
						customClose();
					}
				})
			})
			
			customView = function(mapX,mapY){
				
				console.log("눌렸다고");
				if(customViews.length != 0){
					for(var i=0; i<customViews.length; i++){
						customViews[i].setMap(null);
					}
				}
				console.log("눌렸다고!!"+customViews.length);
				
				for(var i=0; i<customViews.length; i++){
					var customMapX = customViews[i].getPosition().La.toString();
					var customMapY = customViews[i].getPosition().Ma.toString();
						console.log("눌렸다고1");
					if(customMapX.includes(mapX) && customMapY == mapY){
						
						console.log("눌렸다고2");
						customViews[i].setMap(map);
						map.setCenter(new kakao.maps.LatLng(parseFloat(mapY)+0.001, mapX));
						map.setLevel(3);
						targetCustom = customViews[i];
						break;
					};
				}
			}
			
			customClose = function(){
				for(var i = 0; i<customViews.length; i++){
					if(customViews[i] == targetCustom){
						customViews[i].setMap(null);
					}
				}
			}
			
			
			
			
		}); // end of planBucket load

		
		
		
		$('#planList').load('/planner/planList',{"purchaseSerial" : purchaseSerial},function(data){
			
			
			bounds = new kakao.maps.LatLngBounds();  
			
			$('.planListMenuItemAll').on('click',function(ev){
				
				var target = ev.target;
				var param = {"purchaseSerial" : purchaseSerial}
				
				if(targetCustom != null){
					customClose();
				}
				MenuActive(planItems,target);
				$('#planList').load('/planner/planList',param);
				
				$.ajax({
					type : 'post',
					url : '/planner/planJson',
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
			})
			
			var planListMenuItemAll = document.querySelector('.planListMenuItemAll');
			planListMenuItemAll.click();
			
			
			planMenuClick = function(target){
				
				var planMenuFrm = target.children[0];
				var planDate = planMenuFrm.planDate.value;
				
				
				if(targetCustom != null){
					customClose();
				}
				MenuActive(planItems,target);
				
				var param = {"planDate" : planDate, "purchaseSerial" : purchaseSerial};
				
				$.post("/planner/planListByDate",param,function(data){
					$('#planList').html(data);
				})
				
				$.ajax({
					type : 'post',
					url : '/planner/planJsonByDate',
					data : param,
					dataType: 'json',
					async : false,
					success : function(data){
						if(data.length != 0){
							var planDate = JSON.parse(data[0]).planDate;
							setPlanPositions(data);
							setCustomOverlays(planPositions);
						}
					}
				})
			}; // end of planListMenuItem onclick
			
			$('#btnPlanModify').on('click',function(){
				var param = $('#planModifyFrm').serialize();
				$.post('planner/planUpdate',param,function(data){
					alert(data);
					closeModal();
					$('#PlanMenuActive').click();
				})
			})
			
			$('#btnPlanDelete').on('click',function(){
				var param = $(planListItemFrm).serialize();
				$.post('planner/planDelete',param,function(data){
					alert(data);
					closeModal();
					$('#PlanMenuActive').click();
				})
			})
			
			$('#btnUpdateMemo').on('click',function(){
				
				var param =$(planMemoFrm).serialize();
				
				$.post("/planner/memoUpdate",param,function(flag){
					
					if(flag == 0){
						alert('내용을 입력해 주세요!');
					}else if(flag == 1){
						alert('메모 작성 성공!');
						closeModal();
						$('#PlanMenuActive').click();
						
					}else if(flag == -1){
						alert('메모 작성 실패!');
					}
				})
			})
			
			$('#btnResetMemo').on('click',function(){
				
				var param =$(planMemoFrm).serialize();
				console.log(param);
				var reset = confirm("메모를 초기화 시키겠습니까?");
				
				if(reset){
					$.post("/planner/memoReset",param,function(){
						$('#memoText').val("");
						closeModal();
						$('#PlanMenuActive').click();
						$('#btnResetMemo').prop('type','hidden');
					})
				}
			})
			
			// 리스트의 메모 보기를 클릭했을 떄 
			ShowMemo = function(planbucketSerial){
				$('#btnResetMemo').prop('type','button');
				var param = {'planbucketSerial' : planbucketSerial};

				$.post("/planner/memoShow",param,function(memo){
					openMemoModal(planbucketSerial);
					$('#memoText').val(memo);
					
				})
			};
			
				
		});  // end of planlist load 
		
		
		
		
	})// end of document Ready
	
	
	
})();