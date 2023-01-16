package com.project1.plan;

import java.util.List;

import com.project1.order.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.project1.tourapi.TourAPIGetData;
import com.project1.tourapi.TourAPIJsonParsing;
import com.project1.tourapi.testVo;

@RestController
public class PlanController {

	@Autowired
	PlanService planService;

	// 추천 리스트 띄우기
	@RequestMapping("/plan/itemList/{contentTypeId}")
	public ModelAndView itemListCate(PurchaseDto purchaseDto, @PathVariable String contentTypeId) throws Exception {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		String mapX = planService.findMapX(purchaseDto.getRegion());
		String mapY = planService.findMapY(purchaseDto.getRegion());
		String a = tourAPIGetData.getLocationJsonData(mapX, mapY);
		List<String> b = tourAPIJsonParsing.getContentIdList(a);
		List<String> c = tourAPIGetData.getDetailJsonDataListByType(b, contentTypeId);
		List<testVo> result = tourAPIJsonParsing.getOutputList(c);
		mv.addObject("result", result);
		mv.setViewName("plan/itemlist");
		return mv;
	}

	@RequestMapping("/plan/itemList/{region}")
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
	}

	@RequestMapping("/plan/itemList/{region}/{contentTypeId}")
	public ModelAndView itemListCat(@PathVariable String region, @PathVariable String contentTypeId) {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		String a = tourAPIGetData.getKeywordJsonData(region);
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		List<String> b = tourAPIJsonParsing.getContentIdList(a);
		List<String> c = tourAPIGetData.getDetailJsonDataListByType(b, contentTypeId);
		List<testVo> result = tourAPIJsonParsing.getOutputList(c);
		mv.addObject("result", result);
		mv.setViewName("plan/itemlist");
		return mv;
	}

	@RequestMapping("/plan/itemDetail/{contentId}")
	public ModelAndView itemDetail(@PathVariable String contentId) {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		String result1 = tourAPIGetData.getMoreDetailJsonData(contentId);
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		testVo result2 = tourAPIJsonParsing.getDetailItem(result1);
		mv.addObject("result", result2);
		mv.setViewName("plan/itemdetail");
		return mv;
	}

	@RequestMapping("/plan/itemDetailModal/{contentId}")
	public ModelAndView itemDetailModal(@PathVariable String contentId) {
		ModelAndView mv = new ModelAndView();
		TourAPIGetData tourAPIGetData = new TourAPIGetData();
		String result1 = tourAPIGetData.getMoreDetailJsonData(contentId);
		TourAPIJsonParsing tourAPIJsonParsing = new TourAPIJsonParsing();
		testVo result2 = tourAPIJsonParsing.getDetailItem(result1);
		mv.addObject("result", result2);
		mv.setViewName("plan/itemdetailModal");
		return mv;
	}
}
