package com.zora.example.controller;

import com.zora.example.entity.Emp;
import com.zora.example.service.AddPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AddPart addPart;
    @PostMapping("/addemp")
    public String addEmp(@ModelAttribute(value = "emp") Emp emp){
        addPart.addEmp(emp);
        return "redirect:/";
    }

    @RequestMapping("/")
    public ModelAndView index(String keyword) {
        ModelAndView mav = new ModelAndView("index");
        List<Emp> filter = new ArrayList<>();
        List<Emp> emps = new ArrayList<>();
        //没有keyword关键字时，查询全部
        emps = addPart.findAll();
        if(keyword == null || keyword.trim().equals("")){
            filter = emps;
        }else{
            for(Emp emp : emps){
                if(emp.getEname().toLowerCase().indexOf(keyword.toLowerCase()) != -1){
                    filter.add(emp);
                }
            }
        }
        mav.addObject("emps" , filter);
        return mav;
    }

    @GetMapping("/add")
    public String add(@ModelAttribute(value = "emp")Emp emp ,BindingResult result){
        return "add";
    }
    //只需要加上下面这段即可，注意不能忘记注解
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
    /*@InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }*/

}
