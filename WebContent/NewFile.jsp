<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!--========================다음 도로명주소위한 스크립트 꼭사용해야함========================-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!--===================================구글 지도 사용하기위한 스크립트 =========================================-->
 <!--the Key values of key Parameter is gittp92's. you should use yours. go to google '
    https://console.developers.google.com' and get your key value
    > 파라미터 key 값 제 코드라서 각자 받아서 써야해요  https://console.developers.google.com 여기들어가서 키값받으면 됨
      -->
<!-- jquery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>

<form action="" method="post">
<input type="hidden" id="latlng" name="latlng"> <!--위도 경도 저장해놓는부분-->
<input type="text" id="postcode" placeholder="우편번호" name="postcode">
<input type="button" onclick="findPostCode()" value="우편번호 찾기"><br>
<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소">
<input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소">
<input type="text" id="msg" name="msg" placeholder="배달특이사항">
<span id="guide" style="color:#999"></span>
<div>
 <div id="map" style="width: 400px; height: 400px;"></div> <!--지도부분-->
</div>
</form>

<script>
var map;  //map을 글로벌 변수로 빼줌 (해당변수를 findPostCode() 와 geocodeAddress 에서 같이 사용 하기때문에)
var geocoder; //map을 글로벌 변수로 빼줌 (해당변수를 initMap() 와 geocodeAddress 에서 같이 사용 하기때문에)

function initMap() {
     map = new google.maps.Map(document.getElementById('map'), { //화면상 맵 위치나타내주는 위도경도 :(한국 위도경도)
     	zoom:7,
		center:{
			lat:36.487935 ,
			lng:127.857758 
		}
     });
     geocoder = new google.maps.Geocoder();
    
}


//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function findPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('roadAddress').value = fullRoadAddr;
            document.getElementById('jibunAddress').value = data.jibunAddress;

            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                //예상되는 도로명 주소에 조합형 주소를 추가한다.
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                document.getElementById('roadAddress').value = expRoadAddr;

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                document.getElementById('jibunAddress').value = expJibunAddr;

            } else {
                document.getElementById('guide').innerHTML = '';
            }
            
            geocodeAddress(geocoder, map);
        }
    }).open();
}
    

/*------------------------------------------------------------------------------  
 *위도 경도 가져오는 함수 
 *----------------------------------------------------------------------------*/
 function geocodeAddress(geocoder, resultsMap) {
	 var address = document.getElementById('jibunAddress').value;

     geocoder.geocode({'address': address}, function(results, status) {
     	//위도 경도 가져오기 
       var lat = results[0].geometry.location;
       //위도 경도를 특정 input 필드에 저장해둠(아이디 값이 latlng인 곳에 저장해둠)
       //위도 경도 (위도, 경도) 이렇게 받아오기 때문에 controller에서 위도 경도 집어넣을때 따로 파싱해줘야함 
       document.getElementById('latlng').value = lat;
		alert("위도경도:" +  document.getElementById('latlng').value); 
     	if (status === 'OK') {
         resultsMap.setCenter(results[0].geometry.location);
         var marker = new google.maps.Marker({
           map: resultsMap,
           position: results[0].geometry.location
         });
         markersForMap2And3.push(marker);
         
         

       } else {
         alert('Geocode was not successful for the following reason: ' + status);
       }

     });
     
}

</script>

<!--언니 여기서 key값은 제아이디로 받은거라서 일단 우리 프로젝트에는 이 key값으로 사용하고 제가 나중에 구글에서 지도 key값 받는 사이트 알려드릴게용-->
<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCxS09DQjD3WePPaHn8KNG5beXCleuL3Ls&callback=initMap">
</script>


</body>
</html>