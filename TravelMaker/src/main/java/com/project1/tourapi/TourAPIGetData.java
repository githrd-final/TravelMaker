package com.project1.tourapi;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Slf4j

public class TourAPIGetData {
	
	InputStream is;
	BufferedReader br;
	
	// APIkey 는 본인의 것을 입력
	public String APIkey = "Fqd8%2BHKkArEPTxQGOP%2FX7ZbbAmG2D7Lu1K0dDiShmyOx9wOG0rq%2BwzD7CpKMCQOsCO36RthiCyIqnug6aIUnow%3D%3D";
	public String MobileOS = "ETC";
	public String MobileApp = "APPTest";
	public String type = "json";
	public String pageNo = "1";
	public String numOfRows = "20";
	
	
	public static void main(String[] args) {
		
		// tourAPI 위치기반정보검색 test를 위한 서울역의 x,y 좌표
		String seoulStationX = "126.971042";
		String seoulStationY = "37.5523812";
		
		// 음식점,관광지,숙박별 정보검색 test를 위한 contentTypeId
		String foodContentTypeId = "39";
		String spotContentTypeId = "12";
		String hotelContentTypeId = "32";
		
		TourAPIGetData tourAPIParsingData = new TourAPIGetData();
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		
		// tourAPI의 위치기반정보검색을 이용한 json데이터입니다.
		String locationJson = tourAPIParsingData.getLocationJsonData(seoulStationX, seoulStationY);
		System.out.println(locationJson);
		
		// 받아온 json데이터의 contentId의 리스트를 반환해주는 메서드입니다.
		List<String> contentIdList = tourAPIJsonParsing.getContentIdList(locationJson);
		System.out.println("[contentIdList by locationJson] : " + contentIdList.toString());
		
		// contentId의 리스트를 받아 공통정보 json을 종류구분없이 모두 반환해주는 메서드입니다.
		List<String> detailJsonList = tourAPIParsingData.getDetailJsonDataList(contentIdList);
		System.out.println("[detailJsonList by locationJson] : " + detailJsonList.toString());
		
		// contendId의 리스트를 받아 공통정보json을 음식점만 반환해주는 메서드입니다.
		List<String> detailJsonFoodList = tourAPIParsingData.getDetailJsonDataListByType(contentIdList, foodContentTypeId);
		System.out.println("[detailJsonFoodList by locationJson] : " + detailJsonFoodList.toString());
		
		String json = tourAPIParsingData.getKeywordJsonData("김치", "1", "23");
		System.out.println("keywordjson:" + json);
		
	}
	
	// 공통정보조회(한건의 데이터만 조회)
	public String getDetailJsonData(String contentId) {
		StringBuffer json = new StringBuffer();
		
		try {
			String url = "http://apis.data.go.kr/B551011/KorService/detailCommon?serviceKey=" + APIkey
						+"&pageNo="+pageNo
						+"&numOfRows="+numOfRows
					    +"&MobileOS="+ MobileOS
					    +"&MobileApp="+ MobileApp
					    +"&_type="+type
						+"&contentId=" + contentId;
			
			json = readURL(url);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return json.toString();
	}

	// 공통정보조회(한건의 데이터만 조회, 상세정보까지 표기)
	public String getMoreDetailJsonData(String contentId) {
		StringBuffer json = new StringBuffer();

		try {
			String url = "http://apis.data.go.kr/B551011/KorService/detailCommon?serviceKey=" + APIkey
					+"&pageNo="+pageNo
					+"&numOfRows="+numOfRows
					+"&MobileOS="+ MobileOS
					+"&MobileApp="+ MobileApp
					+"&_type="+type
					+"&contentId=" + contentId
					+"&defaultYN=Y"
					+"&firstImageYN=Y"
					+"&mapinfoYN=Y"
					+"&overviewYN=Y"
					+"&addrinfoYN=Y";

			json = readURL(url);

		}catch(Exception e) {
			e.printStackTrace();
		}

		return json.toString();
	}
	
	// 공통정보조회리스트
	public List<String> getDetailJsonDataList(List<String> contentIdList) {
		List<String> detailJsonDataList = new ArrayList<>();
		
		try {
			for(String contentId : contentIdList) {
				String url = "http://apis.data.go.kr/B551011/KorService/detailCommon?serviceKey=" + APIkey
							+"&pageNo="+pageNo
							+"&numOfRows="+numOfRows
						    +"&MobileOS="+ MobileOS
						    +"&MobileApp="+ MobileApp
						    +"&_type="+type
							+"&contentId=" + contentId
							+"&defaultYN=Y"
							+"&firstImageYN=Y"
							+"&mapinfoYN=Y"
							+"&overviewYN=Y"
							+"&addrinfoYN=Y";
				
				
				StringBuffer json = readURL(url);
				
				detailJsonDataList.add(json.toString());
			}
			
			close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return detailJsonDataList;
	}
	
	// contentTypeId에 따른 공통정보조회 리스트
	public List<String> getDetailJsonDataListByType(List<String> contentIdList,String contentTypeId) {
		List<String> detailJsonDataList = new ArrayList<>();
		
		try {
			for(String contentId : contentIdList) {
				String url = "http://apis.data.go.kr/B551011/KorService/detailCommon?serviceKey=" + APIkey
							+"&pageNo="+pageNo
							+"&numOfRows="+numOfRows
						    +"&MobileOS="+ MobileOS
						    +"&MobileApp="+ MobileApp
						    +"&_type="+type
							+"&contentId=" + contentId
							+"&contentTypeId=" + contentTypeId
							+"&defaultYN=Y"
							+"&firstImageYN=Y"
							+"&mapinfoYN=Y"
							+"&overviewYN=Y"
							+"&addrinfoYN=Y";

				StringBuffer json = readURL(url);
				detailJsonDataList.add(json.toString());
			}
			
			close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return detailJsonDataList;
	}
	
	// 키워드 검색 조회
	public String getKeywordJsonData(String keyword,String areaCode,String sigunguCode) {
			StringBuffer json = new StringBuffer();
		
			String Encodedkeyword;
			
			try {
				Encodedkeyword = URLEncoder.encode(keyword,"UTF-8");
				System.out.println("제발"+Encodedkeyword);
				String url = "http://apis.data.go.kr/B551011/KorService/searchKeyword?serviceKey=" + APIkey
						+"&pageNo="+pageNo
						+"&numOfRows="+numOfRows
					    +"&MobileOS="+ MobileOS
					    +"&MobileApp="+ MobileApp
					    +"&_type="+type
					    +"&areaCode="+areaCode
					    +"&arrange=R"
					    +"&sigunguCode="+sigunguCode
					    +"&keyword="+Encodedkeyword;
				System.out.println("url:"+url);
				json = readURL(url);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("jsontostring"+json.toString());
			
		
		return json.toString();
	}
	
	// 위치기반 검색 조회
	public String getLocationJsonData(String mapX,String mapY) {
		StringBuffer json = new StringBuffer();
		
		try {
			String url = "http://apis.data.go.kr/B551011/KorService/locationBasedList?serviceKey=" + APIkey
					+"&pageNo="+pageNo
					+"&numOfRows="+numOfRows
				    +"&MobileOS="+ MobileOS
				    +"&MobileApp="+ MobileApp
				    +"&arrange=O"
				    +"&_type="+type
					+"&mapX="+mapX
					+"&mapY="+mapY
					+"&radius=20000";
			
			
			json = readURL(url);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
		return json.toString();
	}

	// 위치기반&카테고리 검색 조회
	public String getLocationCategoryJsonData(String mapX,String mapY, String contentTypeId) {
		StringBuffer json = new StringBuffer();

		try {
			String url = "http://apis.data.go.kr/B551011/KorService/locationBasedList?serviceKey=" + APIkey
					+"&pageNo="+pageNo
					+"&numOfRows="+numOfRows
					+"&MobileOS="+ MobileOS
					+"&MobileApp="+ MobileApp
					+"&arrange=R"
					+"&_type="+type
					+"&contentTypeId="+contentTypeId
					+"&mapX="+mapX
					+"&mapY="+mapY
					+"&radius=20000";


			json = readURL(url);

		}catch(Exception e) {
			e.printStackTrace();
		}


		return json.toString();
	}

	// 지역&분류 조회

	public String getRegionCategoryJsonData(int areaCode, String cat1) {
		StringBuffer json = new StringBuffer();

		String EncodedRegion;
		try {
			//EncodedRegion = URLEncoder.encode(region,"UTF-8");
			String url = "http://apis.data.go.kr/B551011/KorService/searchKeyword?serviceKey=" + APIkey
					+"&pageNo="+pageNo
					+"&numOfRows="+numOfRows
					+"&MobileOS="+ MobileOS
					+"&MobileApp="+ MobileApp
					+"&_type="+type
					+"&areaCode="+areaCode
					+"&cat1="+cat1;

			json = readURL(url);


		} catch (Exception e) {
			e.printStackTrace();
		}




		return json.toString();
	}
	
	
	// api호출로 받은 json데이터를 문자열로 바꿔주는 메서드.
	public StringBuffer readURL(String url) {
		
		StringBuffer json = new StringBuffer();
		
		URLConnection conn;
		is = null;
		br = null;
		
	try {
		
		URL APIurl = new URL(url);
		conn = APIurl.openConnection();
		is = conn.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));
		
		String line = "";
		while((line=br.readLine()) != null) {
			json.append(line);
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
		
		return json;
	}
	
	
	public void close() {
		try {
			if(is != null) is.close();
			if(br != null) br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
}