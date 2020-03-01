package com.aaa.service.impl;

import com.aaa.entity.ClassDB;
import com.aaa.entity.ClassVO;
import com.aaa.mapper.ClassMapper;
import com.aaa.service.ClassService;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 钱浩洋
 * @date 2020/3/1 - 21:11
 */
@Service(version = "${user.service.version}")
@Transactional
public class ClassServiceImpl implements ClassService {
    @Resource
    ClassMapper classMapper;
    @HystrixCommand
    @Override
    public List<ClassVO> findAll() {
        return classMapper.findAll();
    }
    @HystrixCommand
    @Override
    public int add(ClassVO classVO) {
        return classMapper.add(classVO);
    }
    @HystrixCommand
    @Override
    public void delClass(Integer classid) {
        classMapper.delClass(classid);
    }
    @HystrixCommand
    @Override
    public ClassDB selectClass(Integer classid) {
        return classMapper.selectClass(classid);
    }
    @HystrixCommand
    @Override
    public void updateClass(ClassDB classDB) {
        classMapper.updateClass(classDB);
    }
    @HystrixCommand
    @Override
    public void delall(List<Integer> int_ids) {
        classMapper.delall(int_ids);
    }
    @HystrixCommand
    @Override
    public ClassVO findClassId(int i) {
        return classMapper.findClassId(i);
    }
}
