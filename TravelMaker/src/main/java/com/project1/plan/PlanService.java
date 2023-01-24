package com.project1.plan;

import com.project1.mybatis.OrderMapper;
import com.project1.mybatis.PlanMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional
@Slf4j
@NoArgsConstructor
public class PlanService {

    @Autowired
    PlatformTransactionManager transactionManager;
    TransactionStatus status;

    @Autowired
    PlanMapper planMapper;

    public String findMapX(String city) throws Exception {
        log.info("serviceFindMapX");
        String mapX = planMapper.findMapX(city);
        log.info("mapX : " + mapX);
        return mapX;
    }

    public String findMapY(String city) throws Exception {
        log.info("serviceFindMapY");
        String mapY = planMapper.findMapY(city);
        log.info("mapY : " + mapY);
        return mapY;
    }

    public String findAreaCode(String city) throws Exception {
        log.info("findAreaCode");
        String areaCode = planMapper.findAreaCode(city);
        log.info("areaCode : " + areaCode);
        return areaCode;
    }
    
    public String findSigunguCode(String city) throws Exception {
        log.info("findSigunguCode");
        String sigunguCode = planMapper.findSigunguCode(city);
        log.info("sigunguCode : " + sigunguCode);
        return sigunguCode;
    }
    
    public int checkAdded(String planbucketSerial) throws Exception {
    	log.info("serviceCheckAdded");
    	int checkAdded = planMapper.checkAdded(planbucketSerial);
    	log.info("checkAdded : " + checkAdded);
    	return checkAdded;
    }

    public void insertPlanBucket(HashMap map){
        log.info("serviceInsertPlanBucket");
        planMapper.insertPlanBucket(map);
    }

    public void deletePlanBucket(HashMap map){
        log.info("serviceDeletePlanBucket");
        planMapper.deletePlanBucket(map);
    }
}