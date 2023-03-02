package com.kh.demo1.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j  //lon.info(), log.error(), log.debug(), log.trace(), log.warning() : 콘솔에 찍을 때
@Controller
@RequestMapping("/pubData2")
public class PublicData2Controller {
  @GetMapping("/bn")
  public String businessNumberChk(){
    return "pub/businessNumberChk";
  }
}
