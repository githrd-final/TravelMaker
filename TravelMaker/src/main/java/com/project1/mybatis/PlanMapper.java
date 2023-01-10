/*package com.project1.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PlanMapper {
	//로드시 날짜 필요함
	public int dateselect(int planbucketSerial);
	
	//구매고유번호 또는 날짜로 출력할 일정리스트
	public List<PlanVo> select(PlanVo pVo);
	
	//plan에 update할거임
	public int update(PlanVo pVo);

	//plan에 memo update할거임, string이랑 예약고유번호 둘다 넣어줘야해서 planvo로 함
	public int memoUpdate(PlanVo pVo);
	
	//예약고유번호로 delete할거임
	public int deleteplan(int planbucketSerial);

}
*/