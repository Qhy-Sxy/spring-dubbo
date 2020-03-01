package com.aaa.mapper;

import com.aaa.entity.GradeDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2020/3/1 - 21:06
 */
@Mapper
public interface GradeMapper {
    public List<GradeDB> findall();
}