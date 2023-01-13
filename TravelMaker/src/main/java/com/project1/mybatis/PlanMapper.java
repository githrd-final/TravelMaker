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
	
	//plan에 memo update할거임, string이랑 예약고유번호 둘다 넣어줘야해서 planvo로 함
	public int updateMemo(PlanVo planVo);
	
	// ----- 수정 sql----//
	// 수정하려는 곳에 값이 존재하는지 확인
	public int modifyCheck(PlanVo planVo);
	// 수정하기 이전의 일자의 데이터 행 개수
	public int countPreDate(PlanVo planVo);
	// 다른일자로 변경될때 같은일자의 순번변경
	public int updateSameDate(PlanVo planVo);
	// 수정된 일자의 순번들변경
	public int updateOrder(PlanVo planVo);
	// 일정 수정
	public int updatePlan(PlanVo planVo);
	
	// ------삭제 sql ----//
	// 일정 삭제 //
	public int deletePlan(PlanVo planVo);
	// 삭제 후 순번 재수정 //
	public int deleteUpdateOrder(PlanVo planVo);

}
