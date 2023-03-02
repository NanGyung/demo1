package com.kh.demo1.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
public class apiSampleController {

  @RequestMapping(value="/getApiCall.do", method={RequestMethod.POST,RequestMethod.GET})
  public void getSampleApi(HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception{

// API 신청 시 발급받은 인증키 설정
    String AUTH_KEY = "IlvVoOePCdew/zsza5XiZAO2VxqSllu7PAHJ0LuRpxU=";

// API 호출 시 조회 할 변수 설정 - 요청 변수 참조(jsp화면에서 입력 받은 값 셋팅)
    String localcode = req.getParameter("localcode");
    String bgnYmd = req.getParameter("bgnYmd");
    String endYmd = req.getParameter("endYmd");

// 발급받은 API 유형(통합(TO0),그룹(GR0))
    String apiurl = "http://www.localdata.go.kr/platform/rest/GR0/openDataApi?authKey=IlvVoOePCdew/zsza5XiZAO2VxqSllu7PAHJ0LuRpxU="+AUTH_KEY;

//조건 설정에 따른 URL변경
    if(localcode !=null){
      apiurl += "&localCode="+localcode;
    }
    if(bgnYmd !=null && endYmd !=null){
      apiurl +="&bgnYmd="+bgnYmd +"&endYmd="+endYmd;
    }

    URL url = new URL(apiurl );
    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));

    StringBuffer sb = new StringBuffer();
    String tempStr = null;
    while(true){
      tempStr = br.readLine();
      if(tempStr == null) break;
      sb.append(tempStr);
    }
    br.close();
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/xml");
    response.getWriter().write(sb.toString());
  }
}
