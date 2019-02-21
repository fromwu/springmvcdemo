package com.gaussic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller     //明确地定义该类为处理请求的Controller类；
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)    //用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；
    public String index() {
        return "index";
    }
}
