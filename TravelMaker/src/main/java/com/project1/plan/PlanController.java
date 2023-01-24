package com.project1.plan;

import java.util.HashMap;
import java.util.List;

import com.project1.order.PurchaseDto;
import com.project1.planner.BucketVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.project1.tourapi.TourAPIGetData;
import com.project1.tourapi.TourAPIJsonParsing;
import com.project1.tourapi.testVo;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class PlanController {

	@Autowired
	PlanService planService;

	@RequestMapping("/plan/recommendListMain")
	public ModelAndView select(PurchaseDto purchaseDto, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		request.setAttribute("purchaseDto", purchaseDto);
		mv.setViewName("plan/recommendListMain");
		return mv;
	}
	// 추천 리스트 띄우기
	@RequestMapping("/plan/itemList/{contentTypeId}")
	public ModelAndView itemListCate(PurchaseDto purchaseDto, @PathVariable String contentTypeId) throws Exception {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		System.out.println("채찌가 보낸 정보가 갈까? "+ purchaseDto.getCity());
		String mapX = planService.findMapX(purchaseDto.getCity());
		String mapY = planService.findMapY(purchaseDto.getCity());
		String a = tourAPIGetData.getLocationCategoryJsonData(mapX, mapY, contentTypeId);
		List<String> b = tourAPIJsonParsing.getContentIdList(a);
		List<String> c = tourAPIGetData.getDetailJsonDataList(b);
		List<testVo> result = tourAPIJsonParsing.getOutputList(c);
		mv.addObject("result", result);
		mv.setViewName("plan/itemlist");
		return mv;
	}

	@RequestMapping("/plan/loading")
	public ModelAndView loading(PurchaseDto purchaseDto) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("plan/loadingPage");
		return mv;
	}

	/*@RequestMapping("/plan/itemList/{region}")
	public ModelAndView itemList(@PathVariable String region) {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		String a = tourAPIGetData.getKeywordJsonData(region);
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		List<String> b = tourAPIJsonParsing.getContentIdList(a);
		List<String> result = tourAPIGetData.getDetailJsonDataList(b);
		mv.addObject("result", result);
		mv.setViewName("plan/itemlist");
		return mv;
	}*/

	/*@RequestMapping("/plan/itemList/{region}/{contentTypeId}")
	public ModelAndView itemListCat(@PathVariable String region, @PathVariable String contentTypeId) {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		String a = tourAPIGetData.getKeywordJsonData(region);
		List<String> b = tourAPIJsonParsing.getContentIdList(a);
		List<String> c = tourAPIGetData.getDetailJsonDataListByType(b, contentTypeId);
		List<testVo> result = tourAPIJsonParsing.getOutputList(c);
		mv.addObject("result", result);
		mv.setViewName("plan/itemlist");
		return mv;
	}*/

	/*@RequestMapping("/plan/itemDetail/{contentId}")
	public ModelAndView itemDetail(@PathVariable String contentId) {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		String result1 = tourAPIGetData.getMoreDetailJsonData(contentId);
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		testVo result2 = tourAPIJsonParsing.getDetailItem(result1);
		mv.addObject("result", result2);
		mv.setViewName("plan/itemdetail");
		return mv;
	}*/

	@RequestMapping("/plan/itemDetailModal/{contentId}")
	public ModelAndView itemDetailModal(@PathVariable String contentId, PurchaseDto purchaseDto) throws Exception {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		String result1 = tourAPIGetData.getMoreDetailJsonData(contentId);
		testVo result2 = tourAPIJsonParsing.getDetailItem(result1);
		log.info(contentId);
		int checkAdded = planService.checkAdded(contentId);
		mv.addObject("purchaseDto", purchaseDto);
		mv.addObject("checkAdded", checkAdded);
		mv.addObject("result", result2);
		mv.setViewName("plan/itemdetailModal");
		return mv;
	}

	@RequestMapping("/plan/itemModalToMPlan")
	public ModelAndView itemModalToMPlan(String purchaseSerial) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("purchaseSerial", purchaseSerial);
		log.info(purchaseSerial);
		mv.setViewName("mplan/mPlanner");
		return mv;
	}

	@RequestMapping("/plan/itemModalToPlan")
	public ModelAndView itemModalToPlan(String purchaseSerial) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(purchaseSerial);
		mv.addObject("purchaseSerial", purchaseSerial);
		log.info(purchaseSerial);
		mv.setViewName("planner/planner");
		return mv;
	}


	@RequestMapping("/plan/insertPlanBucket/{contentId}")
	public String insertPlanBucket(@PathVariable String contentId, PurchaseDto purchaseDto) throws Exception {
		log.info("insertPlanBucket");
		String msg = "";
		String planbucketSerial = purchaseDto.getPurchaseSerial() + contentId;
		int checkAdded = planService.checkAdded(planbucketSerial);
		HashMap<String, Object> map = new HashMap<String, Object>();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		String result1 = tourAPIGetData.getMoreDetailJsonData(contentId);
		testVo result2 = tourAPIJsonParsing.getDetailItem(result1);
		map.put("planbucketSerial", planbucketSerial);
		map.put("contendId", contentId);
		map.put("purchaseDto", purchaseDto);
		map.put("result", result2);
		if (checkAdded == 0) {
			planService.insertPlanBucket(map);
			msg = "플랜 버켓에 추가되었습니다.";
		}
		else{
			msg = "이미 추가된 항목입니다.";
		}
		return msg;
	}

	@RequestMapping("/plan/deletePlanBucket/{contentId}")
	public void deletePlanBucket(@PathVariable String contentId, PurchaseDto purchaseDto) throws Exception {
		log.info(contentId);
		int checkAdded = planService.checkAdded(contentId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		String planbucketSerial = purchaseDto.getPurchaseSerial() + contentId;
		map.put("planbucketSerial", planbucketSerial);
		map.put("contendId", contentId);
		map.put("purchaseDto", purchaseDto);
		if (checkAdded == 1) {
			planService.deletePlanBucket(map);
		}
	}
}