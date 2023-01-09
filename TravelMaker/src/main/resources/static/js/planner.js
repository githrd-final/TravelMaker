	



/*  Map */
var kakaoMap = (function(){
	
	$('.planBucketMenuItem').on('click',function(ev){
		var planBucketMenuItem = document.querySelectorAll('.planBucketMenuItem');
		for(var i=0; planBucketMenuItem.length; i++){
			if(planBucketMenuItem[i].hasAttribute('id')){
				planBucketMenuItem[i].removeAttribute('id');
				break;
			}
		}
		var target = ev.target;
		target.setAttribute('id','BucketMenuActive');
	})
	
	$('.planListMenuItem').on('click',function(ev){
		var planListMenuItem = document.querySelectorAll('.planListMenuItem');
		for(var i=0; planListMenuItem.length; i++){
			if(planListMenuItem[i].hasAttribute('id')){
				planListMenuItem[i].removeAttribute('id');
				break;
			}
		}
		var target = ev.target;
		target.setAttribute('id','PlanMenuActive');
	})

	
	var map = null;
	var bucketMarkers = [];  // 마커객체들이 담긴 배열
	var linePath = [];		 // polyline 연결할 마커의 좌표들이 담긴 배열
	var customOverlays = []; // cunstomOverlay객체들이 담긴 배열
	
	var mapX = 37.51424591;
	var mapY = 127.1040305;
	
	
	var container = document.getElementById('MapZone'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(mapX,mapY), //지도의 중심좌표.
		level: 8 //지도의 레벨(확대, 축소 정도)
	};
	
	
	var content = '<div class="bucketWindow">' + 
				  '    <div class="bucketWindowHeader">' + 
				  '        <span class="bwTitle">' + 
				  ' 		  가나돈까스' + 
				  '        </span>' + 
				  '    </div>' +    
				  '    <div class="bucketWindowBody">' + 
				  '         <div class="bwImgZone">' +
				  '             <img class="bwImg" src="http://tong.visitkorea.or.kr/cms/resource/08/2871008_image2_1.JPG">' +
				  '         </div>' + 
				  '         <div class="bwOverView">' + 
				  '              합정역 8번 출구에서 도보 5분 거리에 있는 곰탕으로 유명한 음식점이다. 대표 메뉴는 곰탕과 수육무침이다 '+ 
				  '         </div>' + 
				  '    </div>' + 
				  '    <div class="bucketWindowFooter">'+
				  '        <span class="bwPlusIcon" onclick="openDateModal()"><i class="fa-regular fa-square-plus "></i></span>'+
				  '    </div>'+
                  '</div>';	
	
	
	var removeable = true;
	
	var bucketWindow = new kakao.maps.InfoWindow({
        content: content, // 인포윈도우에 표시할 내용
        removable : removeable 
    });
	
	var imageSrc = './images/food.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	
	var polyline = null;
	
	var positions = [
		 
		{
	        title: '가가밀라노 롯데백화점 에비뉴엘 월드타워점', 
	        latlng: new kakao.maps.LatLng(37.51424591, 127.1040305)
			
	    },
	    {
	        title: '가나돈까스의집', 
	        latlng: new kakao.maps.LatLng(37.5099674377, 127.0377755568)
	    },
	    {
	        title: '가나아트센터', 
	        latlng: new kakao.maps.LatLng(37.6122099878, 126.9751811398)
	    },
	    {
	        title: '가나아트파크',
	        latlng: new kakao.maps.LatLng(37.7254519094, 126.9497496852)
	    },
	    {
	        title: '가나안국수',
	        latlng: new kakao.maps.LatLng(37.6009169989, 126.8278865647)
	    }
	];
	
	
	function initMap(container,options){
		map = new kakao.maps.Map(container,options)
	}
	
	function setCenter(X,Y){
		mapX = X;
		mapY = Y;
	}
	
	function setMarkers(positions){
		bucketMarkers = [];
		
		for(var i = 0; i<positions.length; i++){
			linePath.push(positions[i].latlng);
			
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
		    markerPosition = linePath[i]; // 마커가 표시될 위치입니다
			
			var marker = new kakao.maps.Marker({
			     map: map, // 마커를 표시할 지도
			     position: positions[i].latlng, // 마커를 표시할 위치
			     title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			     image: markerImage // 마커이미지 설정
			 });
			
			bucketMarkers.push(marker);
			
		}
	}
	
	$('#goReview').on('click',function(){
		$('#content').load('/myTour/myTourSelect');
	})
	
	
	$(document).ready(function(){
		
		
		
		initMap(container,options);
		setMarkers(positions);
		
		
		$('#planBucketList').load('/planner/planBucketList',function(data){
			
			$('.planBucketItem').on('click',function(){
				if(polyline != null){
					polyline.setMap(null);
				}
				
				if(customOverlays.length != 0){
					for(var i=0; i<customOverlays.length; i++){
						
						customOverlays[i].setMap(null);
					}
				}
				
				for(var i=0; i<bucketMarkers.length; i++){
					bucketMarkers[i].setMap(map);
				}
				
				bucketWindow.open(map,bucketMarkers[0]);
				
			})
			
			
			
		});
		
		$('#planList').load('/planner/planList',function(data){
				polyline = new kakao.maps.Polyline({
			    path: linePath, // 선을 구성하는 좌표배열 입니다
			    strokeWeight: 8, // 선의 두께 입니다
			    strokeColor: 'tomato', // 선의 색깔입니다
			    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
			    strokeStyle: 'solid' // 선의 스타일입니다
			});
				
			var bounds = new kakao.maps.LatLngBounds();  
				
			
			$('.planListMenuItem').on('click',function(){
				
				for(var i=0; i<positions.length; i++){
					
					
					// 커스텀 오버레이를 생성합니다
					var customOverlay = new kakao.maps.CustomOverlay({
					    position: positions[i].latlng,
					    content: '<div class="customOverlay">' +
					    				(i+1) +
					    		 '</div>' 
					});
					
					customOverlay.setMap(map);
					customOverlays.push(customOverlay);
					console.log(bucketMarkers[i]);
					bucketMarkers[i].setMap(null);
					bucketWindow.close();
					
					bounds.extend(linePath[i]);
					
				}; // end of for
				
				polyline.setMap(map);
				map.setBounds(bounds);
				
			}); // end of onclick
				
				
		});
	})
	
	
	
	
})();


