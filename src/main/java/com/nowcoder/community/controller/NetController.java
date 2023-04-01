package com.nowcoder.community.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test")
@Controller
public class NetController {
    @RequestMapping("/user")
    public void userMethod(HttpServletRequest request, HttpServletResponse response) {
        Enumeration<String> headername = request.getHeaderNames();
        while (headername.hasMoreElements()) {
            String name = headername.nextElement();
            String value = request.getHeader(name);
        }

        String value = request.getParameter("KEY");

        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //设置访问方式为post   localhost/test/student?student=1&student1=2
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    public void student(@RequestParam(name = "student", required = false, defaultValue = "1") String student,
                        @RequestParam(name = "student1", required = false, defaultValue = "1") String student1) {
        //从请求头中拿取参数，是否必须设置为false，默认值为1
    }

    //设置访问方式为post localhost/test/student/wjd
    @RequestMapping(path = "/student/{id}", method = RequestMethod.POST)
    public void student1(@PathVariable(name = "id", required = false) String student) {
        //从请求路径中拿取参数，是否必须设置为false
    }

    //响应post请求，返回字符
    @RequestMapping(path = "/student2", method = RequestMethod.POST)
    @ResponseBody
    public String student2() {
        return "hello";
    }

    //响应post请求，返回html
    @RequestMapping(path = "/student3", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView student3() {//模型和视图对应的时底层DispatcherServlet将模型和view模板输入给视图层。
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "zhangsan");
        mav.addObject("age", "13");
        mav.setViewName("/controller/student");
        return  mav;
    }
    @RequestMapping(path = "/student4", method = RequestMethod.GET)
//    @RequestMapping(path = "/student4", method = RequestMethod.GET) 注释掉Responsebody后，会将返回的字符串解释名称。会尝试找到这个文件并进行渲染。
    public String student4(Model model) {
        model.addAttribute("name","wangwu");
        model.addAttribute("age","17");
        return "controller/student";
    }
    //我们的使用java编写，网页运行于javascript。spring会自动的把返回值封装为json文件。
    @RequestMapping(path = "/student5", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> student4() {//也可以使用list再封装一层
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","lisi");
        return map;
    }

}


