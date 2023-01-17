<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='./css/restaurants.css'/>
<script defer src='./js/restaurants.js'></script>
<title>맛집 추천 리스트</title>
</head>
<body>
<div class='check'>
	<input type="checkbox" id="cb1" name='cb' onclick='checkOnlyOne(this)'>
	<label for="cb1" >거리순(역 기준)</label>
			
	<input type="checkbox" id="cb2" name='cb' onclick='checkOnlyOne(this)'>
	<label for="cb2" >추천순</label>
</div>
<br/>

<div id='restaurantsBack'>

	<div id='restaurants'>
		<span><img src='./images/matzip.png'/></span>
		<div id='title'>삼포가든</div>
		<div id='location'>전라북도 남원시 요천로 2264</div>
		<div id='doc'>삼포가든’은 1977년부터 지금까지 남원 지리산 자락에서 한 자리를 지켜오고 있는 곳입니다. 전국 각지에서 공수한 국내산 식재료와 텃밭에서 직접 재배한 채소로 건강과 맛을 동시에 잡은 음식을 선보입니다. 대표 메뉴는 불그스름한 양념 옷을 입은 장어 위로 얇게 채 썬 제주산 더덕을 소복하게 올려 나오는 ‘고추장 더덕 장어구이’입니다. 고창에서 들여온 풍천장어에 수제 고추주를 발라 숙성시켜 특유의 비린내를 완벽하게 잡은 점이 맛의 비결입니다. 고춧가루에 꿀, 된장, 조청을 넣어 은은한 단맛을 낸 양념장과 고소한 장어가 조화롭게 어울립니다. 매콤달콤한 장어에 더덕이 향긋한 풍미를 더하며 고급스러운 맛을 살려줍니다. 평일에는 돌솥밥, 주말에는 공깃밥이 함께 제공됩니다.</div>
	</div>
	
	<div id='restaurants'>
		<span><img src='./images/matzip2.png'/></span>
		<div id='title'>이조갈비</div>
		<div id='location'>전라북도 남원시 쌍교동 66-1</div>
		<div id='doc'>합리적인 가격, 신선한 채소 & 육류, 친절과 따뜻함, '음식'에 대한 책임감</div>
	</div>
	
	<div id='restaurants'>
		<span><img src='./images/matzip3.png'/></span>
		<div id='title'>남원추어탕</div>
		<div id='location'>전북 남원시 쌍교동 58-6</div>
		<div id='doc'>추어탕과 미꾸라지 튀김미꾸라지튀김 등을 맛 볼 수 있습니다.</div>
	</div>
	<div id='restaurants'>
		<span><img src='./images/matzip.png'/></span>
		<div id='title'>삼포가든</div>
		<div id='location'>전라북도 남원시 요천로 2264</div>
		<div id='doc'>삼포가든’은 1977년부터 지금까지 남원 지리산 자락에서 한 자리를 지켜오고 있는 곳입니다. 전국 각지에서 공수한 국내산 식재료와 텃밭에서 직접 재배한 채소로 건강과 맛을 동시에 잡은 음식을 선보입니다. 대표 메뉴는 불그스름한 양념 옷을 입은 장어 위로 얇게 채 썬 제주산 더덕을 소복하게 올려 나오는 ‘고추장 더덕 장어구이’입니다. 고창에서 들여온 풍천장어에 수제 고추주를 발라 숙성시켜 특유의 비린내를 완벽하게 잡은 점이 맛의 비결입니다. 고춧가루에 꿀, 된장, 조청을 넣어 은은한 단맛을 낸 양념장과 고소한 장어가 조화롭게 어울립니다. 매콤달콤한 장어에 더덕이 향긋한 풍미를 더하며 고급스러운 맛을 살려줍니다. 평일에는 돌솥밥, 주말에는 공깃밥이 함께 제공됩니다.</div>
	</div>
	
	<div id='restaurants'>
		<span><img src='./images/matzip2.png'/></span>
		<div id='title'>이조갈비</div>
		<div id='location'>전라북도 남원시 쌍교동 66-1</div>
		<div id='doc'>합리적인 가격, 신선한 채소 & 육류, 친절과 따뜻함, '음식'에 대한 책임감</div>
	</div>
	
	<div id='restaurants'>
		<span><img src='./images/matzip3.png'/></span>
		<div id='title'>남원추어탕</div>
		<div id='location'>전북 남원시 쌍교동 58-6</div>
		<div id='doc'>추어탕과 미꾸라지 튀김미꾸라지튀김 등을 맛 볼 수 있습니다.</div>
	</div>
	
	<div id='restaurants'>
		<span><img src='./images/matzip.png'/></span>
		<div id='title'>삼포가든</div>
		<div id='location'>전라북도 남원시 요천로 2264</div>
		<div id='doc'>삼포가든’은 1977년부터 지금까지 남원 지리산 자락에서 한 자리를 지켜오고 있는 곳입니다. 전국 각지에서 공수한 국내산 식재료와 텃밭에서 직접 재배한 채소로 건강과 맛을 동시에 잡은 음식을 선보입니다. 대표 메뉴는 불그스름한 양념 옷을 입은 장어 위로 얇게 채 썬 제주산 더덕을 소복하게 올려 나오는 ‘고추장 더덕 장어구이’입니다. 고창에서 들여온 풍천장어에 수제 고추주를 발라 숙성시켜 특유의 비린내를 완벽하게 잡은 점이 맛의 비결입니다. 고춧가루에 꿀, 된장, 조청을 넣어 은은한 단맛을 낸 양념장과 고소한 장어가 조화롭게 어울립니다. 매콤달콤한 장어에 더덕이 향긋한 풍미를 더하며 고급스러운 맛을 살려줍니다. 평일에는 돌솥밥, 주말에는 공깃밥이 함께 제공됩니다.</div>
	</div>
	
	<div id='restaurants'>
		<span><img src='./images/matzip2.png'/></span>
		<div id='title'>이조갈비</div>
		<div id='location'>전라북도 남원시 쌍교동 66-1</div>
		<div id='doc'>합리적인 가격, 신선한 채소 & 육류, 친절과 따뜻함, '음식'에 대한 책임감</div>
	</div>
	
	<div id='restaurants'>
		<span><img src='./images/matzip3.png'/></span>
		<div id='title'>남원추어탕</div>
		<div id='location'>전북 남원시 쌍교동 58-6</div>
		<div id='doc'>추어탕과 미꾸라지 튀김미꾸라지튀김 등을 맛 볼 수 있습니다.</div>
	</div>
	
</div>
</body>
</html>