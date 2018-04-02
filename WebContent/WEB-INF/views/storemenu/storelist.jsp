<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/> 

<!-- Bread crumb -->
            <div class="row page-titles">
                <div class="col-md-5 align-self-center">
                    <h3 class="text-primary">${doc_title }</h3> </div>
                <div class="col-md-7 align-self-center">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">${doc_menu }</a></li>
                        <li class="breadcrumb-item active">${doc_title }</li>
                    </ol>
                </div>
            </div>
            <!-- End Bread crumb -->
            <!-- Container fluid  -->
            <div class="container-fluid">
                <!-- Start Page Content -->
                <div class="row">
                    <div class="col-12">
                    <!--==========================지도 마크업==============================-->
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">스토어 현황</h4>
                                <h6 class="card-subtitle">BurgerBucks전국 지점</h6>
                                <div class="table-responsive m-t-40">
                                	<!--=========================스토어 등록을 위한 모달 버튼==========================-->
                                    <div align="right"> 
	                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addstore">
	                                    	스토어 등록
										</button>
									</div>
									<div id="map" style="height: 400px;width: 100%;"></div>
                                </div>
                            </div>
                        </div>
                        
                        <!--==========================지도 마크업==============================-->
                     <!--==========================table1==============================-->
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">스토어 현황</h4>
                                <h6 class="card-subtitle">스토어 현황을 자세히 보고 싶거나 정보를 수정하시려면 더블클릭을 해주세요</h6>
                                <div class="table-responsive m-t-40">
                                    <table id="myTable" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>지점명</th>
                                                <th>주소</th>
                                                <th>전화번호</th>
                                                <th>대표</th>
                                                <th>전화번호</th>
                                                <th>--</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       
                                            <tr>
                                                <td>Tiger Nixon</td>
                                                <td>System Architect</td>
                                                <td>Edinburgh</td>
                                                <td>61</td>
                                                <td>2011/04/25</td>
                                                <td>
                                                <input type="button" value="수정" class="btn btn-inverse"> 
                                                <input type="button" value="삭제" class="btn btn-inverse">
                                                </td>
                                            </tr>
                                         
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        
                        <!--==========================table1==============================-->
                    </div>
                </div>
                
              </div>
                

<!--==========================스토어 등록 모달창======================================= -->
 <!-- The Modal -->
  <div class="modal fade" id="addstore">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
        <!-- Modal body -->
        <div class="modal-body">
        	<div class="row">
		         <div class="col-lg-6">
			         <div class="card card-outline-primary">
				           <div class="card-header">
				               <h4 class="m-b-0 text-white">스토어 등록</h4>
				           </div>
				           <div class="card-body">
				               <form action="#" method="post">
				                   <div class="form-body">
									   <input type="hidden" id="_latLng">
				                       <hr>
				                       <div class="row p-t-20">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label class="control-label">지점명</label>
				                                   <input type="text" name="name" id="_name" class="form-control" placeholder="지점명" required="required">
				                                   <small class="form-control-feedback"></small> </div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group has-danger">
				                                   <label class="control-label">전화번호</label>
				                                   <input type="text" name="phone" id="_phone" class="form-control form-control-danger" placeholder="전화번호" required="required">
				                                   <small class="form-control-feedback"></small> </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <!--/row-->
				
				                        <div class="row">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label>Post Code</label>
				                                   <input type="text" class="form-control" id="sample4_postcode" placeholder="우편번호" readonly="readonly" required="required">
				                               </div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group">
													<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="btn btn-inverse" style="margin-top: 30px;">
				                               </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>도로명 주소</label>
				                                   <input type="text" class="form-control" id="sample4_roadAddress" placeholder="도로명주소" readonly="readonly" required="required">
				                               </div>
				                           </div>
				                       </div>
				         			  <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>지번 주소 </label>
				                                   <input type="text" class="form-control" id="sample4_jibunAddress" placeholder="지번주소" readonly="readonly" required="required">
				                               		<span id="guide" style="color:#999"></span>                               		
				                               </div>
				                           </div>
				                       </div>
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>상세 주소  </label>
				                                   <input type="text" class="form-control" placeholder="상세주소" required="required">                          		
				                               </div>
				                           </div>
				                       </div>
				
				                   </div>
				                   <div class="form-actions" align="right">
				                       <button type="submit" class="btn btn-success"> <i class="fa fa-check"></i> 등록</button>
				                       <button type="button" class="btn btn-inverse">Cancel</button>
				                   </div>
				               </form>
				           </div>
			           </div>
		           </div> <!--왼쪽 사이드 -->
		           
		           <div class="col-lg-6">
                        <div class="card card-outline-primary">
                            <div class="card-header">
                                 <h4 class="m-b-0 text-white">지도 확인</h4>
                            </div>
                            <div class="card-body">
                            		 <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <div id="searchmap" style="top: 10px; left: 10px; width:300px; height:550px"></div>                               		
				                               </div>
				                           </div>
				                       </div>

                            </div>
                        </div>
                    </div><!--오른쪽 사이드 - 지도-->
           </div><!-- ROW -->
        </div>
        

      </div>
    </div>
  </div>



<!--===================================마커 지도API Script/우편번호========================================-->

 <script type="text/javascript">
 var map2;
 var geocoder;
 function initMap() {
	//map options(처음맵위치 : 서울 위도 경도로 설정 )(기본 맵)
	var options ={
		zoom:8,
		center:{
			lat:37.487935 ,
			lng:126.857758 
		}
	}
	//(모달 맵)
	var options2 ={
			zoom:13,
			center:{
				lat:37.487935 ,
				lng:126.857758 
			}
	}
	//new map(기본맵)
	var map = new google.maps.Map(document.getElementById('map'), options);
	//모달맵
	map2 = new google.maps.Map(document.getElementById('searchmap'), options2);
	//검색했을때 지오코드 해주기 위함(map2)
    geocoder = new google.maps.Geocoder();

   /*  document.getElementById('submit').addEventListener('click', function() {
      geocodeAddress(geocoder, map2);
    }); */
/* 
	//listen for click on map (클릭하면 마커생김)
	google.maps.event.addListener(map, 'click', function(event) {
		//Add marker
		addMarker({coords:event.latLng});
		alert(event.latLng);
	});
	 */
	
 	/* //add marker
 	var marker = new google.maps.Marker({
 		position:{
 			lat:37,
			lng:126			
 		},
 		map:map
 	});
 	
 	var infowindow = new google.maps.InfoWindow({
 		content:'<h1>lynn Ma</h1>'
 	});
 	
 	marker.addListener('click', function () {
		infowindow.open(map, marker);
	}); */
 	
	
	
	//Array of markers(array로 마커 집어넣기 )
	var markers= [
		{
			coords:{lat:42.4668, lng:-70.9495},
			iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
			content:'<h1>lynn Ma</h1>'
		},
		{
			coords:{lat:42.4698, lng:-70.9295}
		},
		{
			coords:{lat:42.4689, lng:-70.9195}
		}
	]
	
	//loop through markers
	for(var i = 0; i < markers.length; i++){
		//add marker
		addMarker(markers[i]);
	}
	
	/* 
	addMarker(
			{coords:{lat:42.4668, lng:-70.9495},
			iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
			content:'<h1>lynn Ma</h1>'
			}
	);
	addMarker({coords:{lat:42.4698, lng:-70.9295}});
	addMarker({coords:{lat:42.4689, lng:-70.9195}});
	 */
	
 	function addMarker(props) {
		var marker = new google.maps.Marker({
	 		position:props.coords,
	 		map:map,
	 		//icon:props.iconImage
	 	});
		
		//check for cutomicon
		if(props.iconImage){
			//set icon image
			marker.setIcon(props.iconImage);
		}
		
		//check content
		if(props.content){
			var infowindow = new google.maps.InfoWindow({
		 		content:props.content
		 	});
		 	
		 	marker.addListener('click', function () {
				infowindow.open(map, marker);
			});
		}
	}
 }
 
 //검색된 주소 오른쪽 지도(모달지도)에 마커로 표현 해주는 함수 
 function geocodeAddress(geocoder, resultsMap) {
     var address = document.getElementById('sample4_jibunAddress').value;
     geocoder.geocode({'address': address}, function(results, status) {
     	//위도 경도 가져오기 
       var lat = results[0].geometry.location;

        //가져온 주소 밑에 시티에 입력
       /*$("#_city").val($("#address").val());*/
        //위도경도 value에 합쳐주기
       $("#_latLng").attr("value", lat);
       alert( $("#_latLng").attr("value"));

     	if (status === 'OK') {
         resultsMap.setCenter(results[0].geometry.location);
         var marker = new google.maps.Marker({
           map: resultsMap,
           position: results[0].geometry.location
         });
         
         
         alert("markerpositon:"+marker.position);

       } else {
         alert('Geocode was not successful for the following reason: ' + status);
       }

     });
     
   }
 
 /*--------------------------------------------------------------------------------
 *우편번호 스크립트 
 *------------------------------------------------------------------------------*/
 function sample4_execDaumPostcode() {
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
             document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
             document.getElementById('sample4_roadAddress').value = fullRoadAddr;
             document.getElementById('sample4_jibunAddress').value = data.jibunAddress;
             //지도 자동으로 검색
             geocodeAddress(geocoder, map2);
             // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
             if(data.autoRoadAddress) {
                 //예상되는 도로명 주소에 조합형 주소를 추가한다.
                 var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                 document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

             } else if(data.autoJibunAddress) {
                 var expJibunAddr = data.autoJibunAddress;
                 document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

             } else {
                 document.getElementById('guide').innerHTML = '';
             }
         }
     }).open();
 }
 </script> 
 <!--=======================구글 맵 API (key 내꺼임 나중에 지우고 올려야함)===============================-->
 <script async defer
 src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap">
 </script>
  <!--=======================우편번호 스크립트===============================-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

