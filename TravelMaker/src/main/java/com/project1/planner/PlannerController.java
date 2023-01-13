package com.project1.planner;

import java.io.IOException;
import java.io.PrintWriter;
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
public class PlannerController {
	
	@Autowired
	PlanListService planService;
	
	
	@RequestMapping("/planner/planner")
	public ModelAndView planner() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("planner/planner");
		return mv;
	}
	
	@RequestMapping("/planner/planBucketList")
	public ModelAndView planBucketList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("planner/planBucketList");
		return mv;
	}
	
	@RequestMapping("/planner/planList")
	public ModelAndView planList(@RequestParam("purchaseSerial") String purchaseSerial) {
		ModelAndView mv = new ModelAndView();
		List<PlanVo> list = planService.selectAllPlan(purchaseSerial);
		mv.addObject("list",list);
		mv.setViewName("planner/planList");
		return mv;
	}
	
	@RequestMapping("/planner/planJson")
	public void planJson(@RequestParam("purchaseSerial") String purchaseSerial,
							   HttpServletResponse response,
							   ObjectMapper objectMapper) {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<PlanVo> list = planService.selectAllPlan(purchaseSerial);
		JSONArray jsonArray = new JSONArray();
		
		for(PlanVo vo : list) {
			try {
				String voStr = objectMapper.writeValueAsString(vo);
				jsonArray.add(voStr);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
		}
		
		String json = jsonArray.toJSONString();
		PrintWriter writer;
		
		try {
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/planner/planListByDate")
	public ModelAndView planListByDate(PlanVo planVo) {
		ModelAndView mv = new ModelAndView();
		List<PlanVo> list = planService.selectPlanByDate(planVo);
		
		mv.addObject("list",list);
		mv.setViewName("planner/planList");
		return mv;
	}
	
	@RequestMapping("/planner/planJsonByDate")
	public void planJsonByDate(PlanVo planVo,
							   HttpServletResponse response,
							   ObjectMapper objectMapper) {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<PlanVo> list = planService.selectPlanByDate(planVo);
		JSONArray jsonArray = new JSONArray();
		
		for(PlanVo vo : list) {
			try {
				String voStr = objectMapper.writeValueAsString(vo);
				jsonArray.add(voStr);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
		}
		
		String json = jsonArray.toJSONString();
		PrintWriter writer;
		
		try {
			writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/planner/planUpdate")
	public String planUpdate(PlanVo planVo) {
		boolean result = false;
		String msg = "";
		
		if(planVo.planDate.equals(planVo.prePlanDate) && planVo.planOrder == planVo.prePlanOrder) {
			msg = "수정할 값을 입력해주세요~";
			return msg;
		}
		
		result = planService.updatePlan(planVo);
		if(result) {
			msg = "수정 성공!";
		} else {
			msg = "수정 실패!";
		}
		
		return msg;
	}
	
	
	@RequestMapping("/planner/planDelete")
	public String planDelete(PlanVo planVo) {
		boolean result = false;
		String msg = "";
		result = planService.deletePlan(planVo);
		if(result) {
			msg = "삭제 성공!";
		} else {
			msg = "삭제 실패!";
		}
		
		return msg;
	}
	
	
}