package com.aaa.mapper;

import com.aaa.entity.ClassDB;
import com.aaa.entity.ClassVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 钱浩洋
 * @date 2020/3/1 - 21:05
 */
@Mapper
public interface ClassMapper {
    public List<ClassVO> findAll();

    public int add(ClassVO classVO);

    void delClass(Integer classid);

    ClassDB selectClass(Integer classid);

    void updateClass(ClassDB classDB);

    void delall(List<Integer> int_ids);

    ClassVO findClassId(int i);
}
