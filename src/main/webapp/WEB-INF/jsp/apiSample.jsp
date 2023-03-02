<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API 호출 예제 소스</title>
<script src="/js/jquery-1.11.0.js" ></script>

<script>
function getData(){
      $.ajax({
        url : "/getApiCall.do",
        type: "POST",
        data:$("#form").serialize(),
        dataType:"xml",
        success:function(resultData){
            $("#list").html("");
            var resultCode = $(resultData).find("code").text();
            var resultMessage = $(resultData).find("message").text();
            if(resultCode != "00"){
              alert("에러발생");
            }else{
            if(resultData !=null){
              dataList(resultData);
            }
          }
        }
        ,error : function(xhr,status, error){
          alert("에러발생");
        }
      });
}
function dataList(resultData){
      var items ="";
      items +="<table><thead><tr><th>번호</th><th>자치단체코드(신고지역)</th><th>인허가번호</th><th>서비스ID</th></tr></thead><tbody>";
      $(resultData).find("row").each(function(){
        //API 신청 시 선택한 제공항목 입력
        items +="<tr>";
        items +="<td>" + $(this).find('rowNum').text()+"</td>";
        items +="<td>" + $(this).find('opnSfTeamCode').text()+"</td>";
        items +="<td>" + $(this).find('mgtNo').text()+"</td>";
        items +="<td>" + $(this).find('opnSvcId').text()+"</td>";
        items +="</tr>";
      });
        items += "</tbody></table>";
        $("#list").html(items);
      }
</script>

</head>
<body>
<form name="form" id="form" method="post">
<input type="text" name="localcode" id="localcode" value=""/><!-- 요청 변수 설정(조회 지역코드-가이드 참조) -->
<input type="text" name="bgnYmd" id="bgnYmd" value=""/><!-- 요청 변수 설정(시작날짜(YYYYMMDD 형식)) -->
<input type="text" name="endYmd" id="endYmd" value=""/><!-- 요청 변수 설정(종료날짜(YYYYMMDD 형식)) -->
<input type="button" onClick="getData();" value="API호출하기" />
</form>
<div id="list"></div><!-- 조회 결과 -->
</body>
</html>
