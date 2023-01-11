package com.project1.planner;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class mPlannerController {

	@Autowired
	PlanBucketService service;
	
	@RequestMapping("/mplan/mPlanner")
	public ModelAndView mPlannerSelect() {
		ModelAndView mv = new ModelAndView();//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스

		mv.addObject("purchaseSerial", "1235");
		mv.setViewName("mplan/mPlanner");	//응답할 view(페이지)이름 설정
		return mv;
	}
	@RequestMapping("/mplan/mPlanBucketList")
	public ModelAndView mPlanBucketListSelect(String purchaseSerial) {
		ModelAndView mv = new ModelAndView();	//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		System.out.println(purchaseSerial);
		List<BucketVo> list = service.bucketselect(purchaseSerial);
		mv.addObject("list", list);
		mv.setViewName("mplan/mPlanBucketList");	//응답할 view(페이지)이름 설정
		return mv;
	}
	@RequestMapping("/mplan/mPlanBucketFilterList")
	public ModelAndView mPlanBucketListFilterSelect(BucketVo bVo) {
		ModelAndView mv = new ModelAndView();	//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		
		List<BucketVo> list = service.bucketDetailSelect(bVo);
		mv.addObject("list", list);
		mv.setViewName("mplan/mPlanBucketList");	//응답할 view(페이지)이름 설정
		return mv;
	}
//	@RequestMapping("/mplan/mBucketToPlan")
//	public void mBucketToPlanList(BucketVo bVo) {
//		service.bucketToPlanInsert(bVo);
//		mPlanBucketListSelect(bVo.getPurchaseSerial());
//	}
	@RequestMapping("/mplan/mPlanList")
	public ModelAndView mPlanListSelect() {
		ModelAndView mv = new ModelAndView();	//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		mv.setViewName("mplan/mPlanList");	//응답할 view(페이지)이름 설정
		return mv;
	}
//	@RequestMapping("/mplan/mPlanBucketDelete")
//	public void mPlanBucketDelete(String serial) {
//		boolean b = service.delete(vo);
//		
//		try {
//			PrintWriter out = resp.getWriter();
//			if(!b) {
//				out.print("<script>");
//				out.print("   alert('삭제 중 오류 발생')");
//				out.print("</script>");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	/*
	 * @RequestMapping("/kakao.do") public void kakao(HttpServletResponse resp) {
	 * 
	 * // tourAPI 위치기반정보검색 test를 위한 서울역의 x,y 좌표 String seoulStationX = "126.971042";
	 * String seoulStationY = "37.5523812";
	 * 
	 * // 음식점,관광지,숙박별 정보검색 test를 위한 contentTypeId String foodContentTypeId = "39";
	 * String spotContentTypeId = "12"; String hotelContentTypeId = "32";
	 * 
	 * // contentId의 리스트를 받아 공통정보 json을 종류구분없이 모두 반환해주는 메서드입니다. List<String>
	 * detailJsonList = tourAPIParsingData.getDetailJsonDataList(contentIdList);
	 * System.out.println("[detailJsonList by locationJson] : " +
	 * detailJsonList.toString());
	 * 
	 * JSONArray jsonArray = new JSONArray();
	 * 
	 * for(String detailJson : detailJsonList) { jsonArray.add(detailJson); }
	 * 
	 * System.out.println(jsonArray.toJSONString()); PrintWriter writer; try {
	 * writer = resp.getWriter(); writer.write(jsonArray.toJSONString());
	 * writer.flush(); writer.close(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
}
