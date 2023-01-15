package com.project1.planner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import com.project1.mybatis.PlanMapper;


@Service
@Transactional
public class PlanListService {
	
	@Autowired
	PlatformTransactionManager manager;
	TransactionStatus status;
	
	@Autowired
	PlanMapper planMapper;
	Object savePoint;
	
	public List<PlanVo> selectAllPlan(String purchaseSerial){
		List<PlanVo> list = null;
		list = planMapper.selectAllPlan(purchaseSerial);
		
		return list;
	}
	
	public List<PlanVo> selectPlanByDate(PlanVo planVo){
		List<PlanVo> list = null;
		list = planMapper.selectPlanByDate(planVo);
		
		return list;
	}
	
	public boolean updatePlan(PlanVo planVo) {
		
		int cnt;
		int preDateCnt = planMapper.countPreDate(planVo);
		boolean flag = true;
		
		status = manager.getTransaction(new DefaultTransactionAttribute());
		savePoint = status.createSavepoint();
		
		// 수정하려는 곳의 값의 존재여부 체크
		int chk = planMapper.modifyCheck(planVo);
		
		
		// 다른날로 수정하고 수정하기 전의 값이 마지막행이 아닐때
		if(!(planVo.planDate.equals(planVo.prePlanDate)) && (preDateCnt != planVo.prePlanOrder)) {
			cnt = planMapper.updateSameDate(planVo);
			if(cnt < 1) {
				System.out.println("다른 날 수정전일차 순번수정 실패함");
				status.rollbackToSavepoint(savePoint);
				flag = false;
				return flag;
			}
			System.out.println("다른 날 수정전일차 순번수정 성공함");
		}
		
		
		// 수정하려고 하는 곳의 값이 존재하지 않는다면
		if(chk < 1) {
			cnt = planMapper.updateCheck(planVo);
			if(cnt < 1) {
				System.out.println("수정하려는 날짜 마지막 순번으로 수정실패함");
				status.rollbackToSavepoint(savePoint);
				flag = false;
				return flag;
			}
			
			
			System.out.println("수정하려는 날짜 마지막 순번으로 수정성공함");
			if(flag) manager.commit(status);
			return flag;
		}
		
		cnt = planMapper.updateOrder(planVo);
		
		if(cnt < 1) {
			System.out.println("수정일차 순번수정 실패함");
			flag = false;
			return flag;
		}else {
			System.out.println("수정일차 순번수정 성공함");
			planMapper.updatePlan(planVo);
			if(cnt < 1) {
				System.out.println("수정될 값으로 수정 실패함");
				status.rollbackToSavepoint(savePoint);
			}
		}
		
		if(flag) manager.commit(status);
		return flag;
	}
	
	public boolean deletePlan(PlanVo planVo) {
		boolean result = true;
		status = manager.getTransaction(new DefaultTransactionAttribute());
		savePoint = status.createSavepoint();
		
		int cnt = planMapper.deletePlan(planVo);
		
		if(cnt < 1) {
			result = false;
			return result;
		} 
		
		cnt = planMapper.deleteUpdateOrder(planVo);
		if(cnt < 1){
			result = false;
			return result;
		} 
		
		if(result) manager.commit(status);
		else  status.rollbackToSavepoint(savePoint);
		return result;
	}
	
	public boolean updateMemo(PlanVo planVo) {
		boolean result = true;
		status = manager.getTransaction(new DefaultTransactionAttribute());
		savePoint = status.createSavepoint();
		
		int cnt = planMapper.updateMemo(planVo);
		if(cnt < 1) {
			result = false;
			status.rollbackToSavepoint(savePoint);
			return result;
		} 
		
		
		if(result) manager.commit(status);
		return result;
	}
	
	public String showMemo(PlanVo planVo) {
		String msg = "";
		msg = planMapper.showMemo(planVo);
		
		return msg;
	}
	
	public void ResetMemo(PlanVo planVo) {
		planMapper.resetMemo(planVo);
	}
}