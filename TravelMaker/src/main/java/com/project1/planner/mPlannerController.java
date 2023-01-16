package com.project1.planner;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class mPlannerController {

	@Autowired
	PlanBucketService service;

	@Autowired
	PlanListService planService;
	
	int travelDay;
	
	@RequestMapping("/mplan/mPlanner")
	public ModelAndView mPlannerSelect() {
		ModelAndView mv = new ModelAndView();//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		travelDay = service.TravelDay("1234");
		System.out.println(travelDay);
		mv.addObject("purchaseSerial", "1234");
		mv.addObject("totalTravelDay",travelDay);
		mv.setViewName("mplan/mPlanner");	//응답할 view(페이지)이름 설정
		return mv;
	}
	@RequestMapping("/mplan/mPlanBucketList")
	public ModelAndView mPlanBucketListSelect(String purchaseSerial) {
		ModelAndView mv = new ModelAndView();	//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		List<BucketVo> list = service.bucketselect(purchaseSerial);
		mv.addObject("list", list);
		mv.setViewName("mplan/mPlanBucketList");	//응답할 view(페이지)이름 설정
		return mv;
	}
	
	@RequestMapping("/mplan/mplanJson")
	public void mPlanMapperJson(@RequestParam("purchaseSerial") String purchaseSerial, HttpServletResponse response, ObjectMapper objectMapper) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<BucketVo> list = service.bucketselect(purchaseSerial);
		JSONArray jsonArray = new JSONArray();
		
		for(BucketVo vo:list) {
			try {
				String voStr = objectMapper.writeValueAsString(vo);
				jsonArray.add(voStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String json = jsonArray.toJSONString();
		PrintWriter writer;
		
		try {
			writer=response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/mplan/mplanFilterJson")
	public void mPlanFilterMapperJson(BucketVo bVo, HttpServletResponse response, ObjectMapper objectMapper) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<BucketVo> list = service.bucketDetailSelect(bVo);
		JSONArray jsonArray = new JSONArray();
		
		for(BucketVo vo:list) {
			try {
				String voStr = objectMapper.writeValueAsString(vo);
				jsonArray.add(voStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String json = jsonArray.toJSONString();
		PrintWriter writer;
		
		try {
			writer=response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/mplan/mPlanBucketFilterList")
	public ModelAndView mPlanBucketListFilterSelect(BucketVo bVo) {
		ModelAndView mv = new ModelAndView();	//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		
		List<BucketVo> list = service.bucketDetailSelect(bVo);
		mv.addObject("list", list);
		mv.setViewName("mplan/mPlanBucketList");	//응답할 view(페이지)이름 설정
		return mv;
	}
	
	@RequestMapping("/mplan/mBucketToPlan")
	public String mBucketToPlanList(BucketVo bVo) {
		String msg = service.bucketToPlanInsert(bVo);
		mPlanBucketListSelect(bVo.getPurchaseSerial());
		return msg;
	}
	
	
	@RequestMapping("/mplan/mPlanList")
	public ModelAndView mPlanListSelect(@RequestParam("purchaseSerial") String purchaseSerial) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Controller travelDay:"+travelDay);
		List<PlanVo> list = planService.selectAllPlan(purchaseSerial);
		System.out.println(list);
		System.out.println(travelDay);
		mv.addObject("list",list);
		mv.addObject("totalTravelDay",travelDay);
		
		//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		mv.setViewName("mplan/mPlanList");	//응답할 view(페이지)이름 설정
		return mv;
	}
	
	@RequestMapping("/mplan/mPlanFilterList")
	public ModelAndView mPlanListFilterSelect(PlanVo pVo) {
		ModelAndView mv = new ModelAndView();	//컨트롤러 처리 결과 후 응답할 view와 view에 전달할 값을 저장 및 전달하는 클래스
		
		List<PlanVo> list = planService.selectPlanByDate(pVo);
		mv.addObject("list", list);
		mv.addObject("totalTravelDay",travelDay);
		
		mv.setViewName("mplan/mPlanList");	//응답할 view(페이지)이름 설정
		return mv;
	}
	
	@RequestMapping("/mplan/planUpdate")
	public void planUpdate(PlanVo planVo) {
		boolean result = false;
		System.out.println("UpdateController purchaseSerial:"+planVo.getPurchaseSerial()+" preplanorder:"+planVo.getPrePlanOrder()+" planOrder:"+planVo.getPlanOrder()+" planDate:"+planVo.getPlanDate()+" preplanDate:"+planVo.getPrePlanDate());
		result = planService.updatePlan(planVo);
		
	}
	
	@RequestMapping("/mplan/mPlanBucketDelete")
	public void mPlanBucketDelete(BucketVo bVo, HttpServletResponse resp) {
		service.planBucketDelete(bVo);

	}
	@RequestMapping("/mplan/planDelete")
	public void mplanDelete(PlanVo planVo) {
		boolean result = false;
		result = planService.deletePlan(planVo);
	
	}

	@RequestMapping("/mplan/memoUpdate")
	public void memoUpdate(PlanVo planVo) {
		
		planService.updateMemo(planVo);
		
	}

}
