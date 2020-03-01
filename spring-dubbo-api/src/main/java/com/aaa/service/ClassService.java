package com.aaa.service;

import com.aaa.entity.ClassDB;
import com.aaa.entity.ClassVO;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2020/3/1 - 22:10
 */
public interface ClassService {
    List<ClassVO> findAll();

    int add(ClassVO classVO);

    void delClass(Integer classid);

    ClassDB selectClass(Integer classid);

    void updateClass(ClassDB classDB);

    void delall(List<Integer> int_ids);

    ClassVO findClassId(int i);
}
