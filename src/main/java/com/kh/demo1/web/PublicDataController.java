package com.kh.demo1.web;

import com.kh.demo1.svc.PublicData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pubData")
public class PublicDataController {

  private final PublicData publicData;

//  @GetMapping("/restaurant")
//  public String restaurant(){
//    return publicData.getPublicData();
//  }


}
