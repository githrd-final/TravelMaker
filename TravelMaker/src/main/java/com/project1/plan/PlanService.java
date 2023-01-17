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
}
