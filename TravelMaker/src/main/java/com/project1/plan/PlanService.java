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

    public String findMapX(String region) throws Exception {
        log.info("serviceFindMapX");
        log.info(region);
        String mapX = planMapper.findMapX(region);
        log.info("mapX : " + mapX);
        return mapX;
    }

    public String findMapY(String region) throws Exception {
        log.info("serviceFindMapY");
        log.info(region);
        String mapY = planMapper.findMapY(region);
        log.info("mapY : " + mapY);
        return mapY;
    }
}
