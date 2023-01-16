package com.project1.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project1.planner.BucketVo;


@Repository
@Mapper
public interface PlanBucketMapper {
	//처음 로드시 날짜 출력
	public int TravelDay(String purchaseSerial);
	
	//plan에 insert할때 plan갯수 버킷리스트
	public int InsertCountPlan(String planbucketSerial);
	
	//구매고유번호로 출력할 버킷리스트
	public List<BucketVo> bucketSelect(String purchaseSerial);
	
	//구매고유번호와 구분으로 출력할 버킷리스트
	public List<BucketVo> bucketDetailSelect(BucketVo bVo);
		
	//plan에 insert할거임
	public int bucketToPlanInsert(BucketVo bVo);
	
	//예약고유번호로 둘다 delete할거임
	public int planBucketDelete(String planbucketSerial);
	
	//delete할 경우 plan에서의 겹치는 갯수가 1이상일 경우 생각
	public int bucketDeletePlanSelect(String planbucketSerial);
}
