package com.project1.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.planner.PlanVo;

@Repository
@Mapper
public interface PlanMapper {
	
	
	
	//로드시 날짜 필요함
	public int selectDate(String purchaseSerial);
	
	// 전체 일정리스트
	public List<PlanVo> selectAllPlan(String purchaseSerial);
	
	// 일자별 일정리스트
	public List<PlanVo> selectPlanByDate(PlanVo PlanVo);
	
	// ----- 수정 sql----//
	// 수정하려는 곳에 값이 존재하는지 확인
	public int modifyCheck(PlanVo planVo);
	// 수정하기 이전의 일자의 데이터 행 개수
	public int countPreDate(PlanVo planVo);
	// 수정하는 날의 마지막순번으로 업데이트
	public int updateToLastOrder(PlanVo planVo);
	// 다른일자로 변경될때 그전일자의 순번변경
	public int updatePreDateOrder(PlanVo planVo);
	// 같은일자로 변경될때 순번변경
	public int updateSameDayOrder(PlanVo planVo);
	// 다른일자로 변경될때 순번변경
	public int updateDiffDayOrder(PlanVo planVo);
	// 일정 수정
	public int updatePlan(PlanVo planVo);
	
	// ------삭제 sql ----//
	// 일정 삭제 //
	public int deletePlan(PlanVo planVo);
	// 삭제 후 순번 재수정 //
	public int deleteUpdateOrder(PlanVo planVo);
	
	//------메모 sql  ----- // 
	public int updateMemo(PlanVo planVo);
	public String showMemo(PlanVo planVo);
	public int resetMemo(PlanVo planVo);
}