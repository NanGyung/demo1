package com.kh.demo1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController2 {
  @GetMapping("/apiSample.jsp")
  public String test2(){
    return "apiSample";
  }
}
