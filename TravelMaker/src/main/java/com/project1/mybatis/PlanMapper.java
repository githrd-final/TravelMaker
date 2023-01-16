package com.project1.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PlanMapper {

    public String findMapX(String region);

    public String findMapY(String region);
}
