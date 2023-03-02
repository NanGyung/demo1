package com.kh.demo1.svc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@Service
public class PublicData {
//  public String getPublicData(){
//    try {
  public static void main(String[] args) throws IOException {
      final String SERVICE_KEY = "0NaJ3Too2tAbbSQCEYslLOmbEnEp9VWZFDTFvIPH=co=";
      StringBuilder urlBuilder = new StringBuilder("http://www.localdata.go.kr/platform/rest/GR0/openDataApi"); /*URL*/
      urlBuilder.append("?" + URLEncoder.encode("authKey","UTF-8") + "=" + SERVICE_KEY); /*Service Key*/
//      urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//      urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
      urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
//    urlBuilder.append("&" + URLEncoder.encode("UC_SEQ","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 ID*/
      URL url = new URL(urlBuilder.toString());
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Content-type", "application/json");
      log.info("Response code: {}" , conn.getResponseCode());
      BufferedReader rd;
      if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      } else {
        rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
      }
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = rd.readLine()) != null) {
        sb.append(line);
      }
      rd.close();
      conn.disconnect();
      log.info("result = {}",sb.toString());
//     return sb.toString();
//    }

//    catch (Exception e) {
//      e.printStackTrace();
//    }
//    return null;
  }

}
