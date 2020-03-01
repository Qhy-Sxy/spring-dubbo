package com.aaa.service.impl;

import com.aaa.entity.GradeDB;
import com.aaa.mapper.GradeMapper;
import com.aaa.service.GradeService;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 钱浩洋
 * @date 2020/3/1 - 21:23
 */
@Service(version = "${user.service.version}")
@Transactional
public class GradeServiceImpl implements GradeService {
    @Resource
    GradeMapper gradeMapper;
    @HystrixCommand
    @Override
    public List<GradeDB> findall() {
        return gradeMapper.findall();
    }
}
