package com.aaa.controller;

import com.aaa.entity.ClassDB;
import com.aaa.entity.ClassVO;
import com.aaa.entity.GradeDB;
import com.aaa.service.ClassService;
import com.aaa.service.GradeService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 钱浩洋
 * @date 2020/3/1 - 21:32
 */
@Controller
public class ClassController {
    @Reference(version = "${user.service.version}")
    ClassService classService;
    @Reference(version = "${user.service.version}")
    GradeService gradeService;
    //查询
    //如果sayHi方法调用失败,启动熔断 调用hiError方法
    @HystrixCommand(fallbackMethod = "findallError")
    @RequestMapping("findall")
    public String findall(Integer currentPage, Model model){
        if(currentPage==null){
            currentPage=1;
        }
        PageHelper.startPage(currentPage,5);
        List<ClassVO> classes = classService.findAll();
        PageInfo pageInfo = new PageInfo(classes);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
    public String findallError(Integer currentPage, Model model){
        return "请检查您的网络";
    }
    //添加
    @HystrixCommand(fallbackMethod = "addclassError")
    @RequestMapping("addclass")
    public String add(Model model){
        List<GradeDB> gs = gradeService.findall();
        model.addAttribute("gs",gs);
        return "add";
    }
    public String addclassError(Model model){
        return "请检查您的网络";
    }

    @HystrixCommand(fallbackMethod = "add_doError")
    @RequestMapping("add_do")
    public String add_do(ClassVO classVO){
        classService.add(classVO);
        return "redirect:findall";
    }
    public String add_doError(ClassVO classVO){
        return "请检查您的网络";
    }
    //删除
    @HystrixCommand(fallbackMethod = "delClassError")
    @RequestMapping("delClass")
    public String delClass(Integer classid){
        classService.delClass(classid);
        return "redirect:findall";
    }
    public String delClassError(Integer classid){
        return "请检查您的网络";
    }
    //修改
    @HystrixCommand(fallbackMethod = "updClassError")
    @RequestMapping("updClass")
    public String updClass(Integer classid, Model model){
        List<GradeDB> gs2 = gradeService.findall();
        ClassDB cla=classService.selectClass(classid);
        model.addAttribute("cla",cla);
        model.addAttribute("gs2",gs2);
        return "updateClass";
    }
    public String updClassError(Integer classid, Model model){
        return "请检查您的网络";
    }
    @HystrixCommand(fallbackMethod = "upd_doError")
    @RequestMapping("upd_do")
    public String upd_do(ClassDB classDB){
        classService.updateClass(classDB);
        return "redirect:findall";
    }
    public String upd_doError(ClassDB classDB){
        return "请检查您的网络";
    }
    @HystrixCommand(fallbackMethod = "delallError")
    @RequestMapping("delall")
    @ResponseBody
    public String delall(String ids){
        String[] str_ids=ids.split(",");
        List<Integer> int_ids = new ArrayList<>();
        for (int i = 0; i < str_ids.length; i++) {
            int_ids.add(Integer.parseInt(str_ids[i]));
        }
        classService.delall(int_ids);
        return "success";
    }
    public String delallError(String ids){
        return "请检查您的网络";
    }
}
