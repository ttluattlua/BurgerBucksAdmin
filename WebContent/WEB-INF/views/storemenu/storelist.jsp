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
                                                <th>--</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach var="bsdto" items="${bslist}">
                                            <tr id="${bsdto.seq}">
                                            	
                                                <td>${bsdto.name }</td>
                                                <td>${bsdto.address }</td>
                                                <td>${bsdto.phone }</td>
                                                <td>
                                                <input type="button" id="${bsdto.seq}Btn" value="수정" class="btn btn-inverse" onclick="updateStore(${bsdto.seq })" data-toggle="modal" data-target="#updatestore"> 
                                                <input type="button" value="삭제" class="btn btn-inverse" onclick="deleteStore(${bsdto.seq })" data-toggle="modal" data-target="#deletestore">
                                                </td>
                                                
                                            </tr>
                                            </c:forEach>
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
				               <form action="registerStore.do" method="post">
				                   <div class="form-body">
									   <input type="hidden" id="_latLng" name="latlng">
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
				                                   <input type="text" name="postcode" class="form-control" id="register_postcode" placeholder="우편번호" readonly="readonly" required="required">
				                               </div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group">
													<input type="button" onclick="DaumPostcode(0)" value="우편번호 찾기" class="btn btn-inverse" style="margin-top: 30px;">
				                               </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>도로명 주소</label>
				                                   <input type="text" name="roadAddress" class="form-control" id="register_roadAddress" placeholder="도로명주소" readonly="readonly" required="required">
				                               </div>
				                           </div>
				                       </div>
				         			  <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>지번 주소 </label>
				                                   <input type="text" name="jibunAddress" class="form-control" id="register_jibunAddress" placeholder="지번주소" readonly="readonly" required="required">
				                               		<span id="register_guide" style="color:#999"></span>                               		
				                               </div>
				                           </div>
				                       </div>
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>상세 주소  </label>
				                                   <input type="text" name="detailAddress" id="_detailAddress" class="form-control" placeholder="상세주소" required="required">                          		
				                               </div>
				                           </div>
				                       </div>
				
				                   </div>
				                   <div class="form-actions" align="right">
				                       <button type="button" class="btn btn-success" id="registerStoreBtn" onclick="registerStore()"> <i class="fa fa-check"></i> 등록</button>
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
  
<!--==========================스토어 수정 모달창======================================= -->
 <!-- The Modal -->
  <div class="modal fade" id="updatestore">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
        <!-- Modal body -->
        <div class="modal-body">
        	<div class="row">
		         <div class="col-lg-6">
			         <div class="card card-outline-primary">
				           <div class="card-header">
				               <h4 class="m-b-0 text-white">스토어 수정</h4>
				           </div>
				           <div class="card-body">
				               <form action="registerStore.do" method="post">
				                   <div class="form-body">
									   <input type="hidden" id="update_latLng" name="updatelatlng">
				                       <hr>
				                       <div class="row p-t-20">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label class="control-label">지점명</label>
				                                   <input type="text" name="updatename" id="update_name" class="form-control" placeholder="지점명" required="required">
				                                   <small class="form-control-feedback"></small> </div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group has-danger">
				                                   <label class="control-label">전화번호</label>
				                                   <input type="text" name="updatephone" id="update_phone" class="form-control form-control-danger" placeholder="전화번호" required="required">
				                                   <small class="form-control-feedback"></small> </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <!--/row-->
				
				                        <div class="row">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label>Post Code</label>
				                                   <input type="text" name="postcode" class="form-control" id="update_postcode" placeholder="우편번호" readonly="readonly" required="required">
				                               </div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group">
													<input type="button" onclick="DaumPostcode(1)" value="우편번호 찾기" class="btn btn-inverse" style="margin-top: 30px;">
				                               </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>도로명 주소</label>
				                                   <input type="text" name="updateroadAddress" class="form-control" id="update_roadAddress" placeholder="도로명주소" readonly="readonly" required="required">
				                               </div>
				                           </div>
				                       </div>
				         			  <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>지번 주소 </label>
				                                   <input type="text" name="updatejibunAddress" class="form-control" id="update_jibunAddress" placeholder="지번주소" readonly="readonly" required="required">
				                               		<span id="update_guide" style="color:#999"></span>                               		
				                               </div>
				                           </div>
				                       </div>
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>상세 주소  </label>
				                                   <input type="text" name="update_detailAddress" id="_update_detailAddress" class="form-control" placeholder="상세주소" required="required">                          		
				                               </div>
				                           </div>
				                       </div>
				
				                   </div>
				                   <div class="form-actions" align="right">
				                       <button type="button" class="btn btn-success" id="updateStoreAfBtn" onclick="updateStoreAf()"> <i class="fa fa-check"></i> 등록</button>
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
				                                   <div id="updatemap" style="top: 10px; left: 10px; width:300px; height:550px"></div>                               		
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
 var map; //지도1
 var map2; //지도2(검색용)
 var map3;
 var geocoder;	//좌표 가져오는 함수에서 사용
 var addStoreMarker; //등록하고 latlng저장 하는 변수

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
			zoom:7,
			center:{
				lat:36.487935 ,
				lng:127.857758 
			}
	}
	
	var options3 ={
			zoom:7,
			center:{
				lat:36.487935 ,
				lng:127.857758 
			}
	}
	//new map(기본맵)
	map = new google.maps.Map(document.getElementById('map'), options);
	//등록모달맵
	map2 = new google.maps.Map(document.getElementById('searchmap'), options2);
	//수정모달맵
	map3 = new google.maps.Map(document.getElementById('updatemap'), options3);
	//검색했을때 지오코드 해주기 위함(map2)
    geocoder = new google.maps.Geocoder();

	//listen for click on map (클릭하면 마커생김)
	/*
	google.maps.event.addListener(map, 'click', function(event) {
		//Add marker
		addMarker({coords:event.latLng});
		alert(event.latLng);
	});
	 */

	
	
	//Array of markers(array로 마커 집어넣기 )
	 var markers= [
		${markers}
	] 
	
	/*---------------------------------------------------------------------------------------------
	 *반복해서 marker넣어줌 
	 *----------------------------------------------------------------------------------------------*/
	for(var i = 0; i < markers.length; i++){
		//add marker
		addMarker(markers[i]);
	}


	/*---------------------------------------------------------------------------------------------
	 *스토어 등록 누르면 map(본페이지 지도)에 마커 추가 
	 *----------------------------------------------------------------------------------------------*/
	$("#registerStoreBtn").click(function() {
		 var marker = new google.maps.Marker({
	           map: map,
	           position: addStoreMarker
	     });
		 //등록 지점명 content에 넣어줌(addStoreName은 지점명 입력해두는 변수)
		 var addStoreName = $("#_name").val(); 
		 var infowindow = new google.maps.InfoWindow({
		 		content:addStoreName
		 	});
		 	
		 	marker.addListener('click', function () {
				infowindow.open(map, marker);
		 });
		 
	}); 
	
	/*---------------------------------------------------------------------------------------------
	 *스토어 수정 누르면 map(본페이지 지도)에 마커 추가 
	 *----------------------------------------------------------------------------------------------*/
	$("#updateStoreAfBtn").click(function() {
		 var marker = new google.maps.Marker({
	           map: map,
	           position: addStoreMarker
	     });
		 //등록 지점명 content에 넣어줌(addStoreName은 지점명 입력해두는 변수)
		 var addStoreName = $("#update_name").val(); 
		 var infowindow = new google.maps.InfoWindow({
		 		content:addStoreName
		 	});
		 	
		 	marker.addListener('click', function () {
				infowindow.open(map, marker);
		 });
		 
	}); 
 
 
 	
	 
}
 /*--------------------------------------------------------------------------------
 *지도에 마커 추가하는 함수	
 *------------------------------------------------------------------------------*/ 
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
 

/*--------------------------------------------------------------------------------
*검색된 주소 오른쪽 지도(모달지도)에 마커로 표현 해주는 함수 
*------------------------------------------------------------------------------*/

 function geocodeAddress(geocoder, resultsMap, num) {
	 var address;
	 if(num == 0){
     address = document.getElementById('register_jibunAddress').value;
	 }else if(num == 1){
	 address = document.getElementById('update_jibunAddress').value;	 
	 }
     geocoder.geocode({'address': address}, function(results, status) {
     	//위도 경도 가져오기 
       var lat = results[0].geometry.location;

        //가져온 주소 밑에 시티에 입력
       /*$("#_city").val($("#address").val());*/
        //위도경도 value에 합쳐주기
       if(num == 0){
       $("#_latLng").attr("value", lat);
       alert( $("#_latLng").attr("value"));
       }else if(num == 1){
   	   $("#update_latLng").attr("value", lat);
       alert( $("#update_latLng").attr("value"));   
       }
       //등록눌렀을때 위도 경도 마커에 표시해주기 위해 임의로 addStoreMarket 글로벌 변수에 저장해둠
       addStoreMarker = lat;
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
 function DaumPostcode(num) {
	 var postcode=['register_postcode', 'update_postcode'];
	 var roadAddres=['register_roadAddress', 'update_roadAddress'];
	 var jibunAddres=['register_jibunAddress', 'update_jibunAddress'];
	 var guide=['register_guide','update_guide'];
	 
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
             document.getElementById(postcode[num]).value = data.zonecode; //5자리 새우편번호 사용
             document.getElementById(roadAddres[num]).value = fullRoadAddr;
             document.getElementById(jibunAddres[num]).value = data.jibunAddress;
             //지도 자동으로 검색
             if(num == 0){
             geocodeAddress(geocoder, map2, 0);
             }else if(num == 1){
             geocodeAddress(geocoder, map3, 1);	 
             }
             // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
             if(data.autoRoadAddress) {
                 //예상되는 도로명 주소에 조합형 주소를 추가한다.
                 var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                 document.getElementById(guide[num]).innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

             } else if(data.autoJibunAddress) {
                 var expJibunAddr = data.autoJibunAddress;
                 document.getElementById(guide[num]).innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

             } else {
                 document.getElementById(guide[num]).innerHTML = '';
             }
         }
     }).open();
        
 }


 
/*---------------------------------------------------------------------------------------------
 * store 등록 Ajax (주소는 : 우편번호#도로명주소#지번주소#상세주소 로 가져가서 저장- 나중에 데이터 보여줄때는 #으로 자를거임)
 *----------------------------------------------------------------------------------------------*/
		
 function registerStore() {	
	 
	 	
	    alert("스토어등록클릭");
		var data = {};
		
		data["name"]= $("#_name").val();
		data["phone"]= $("#_phone").val();
		data["address"]= $("#register_postcode").val()+"#"+$("#register_roadAddress").val()+"#"+$("#register_jibunAddress").val()+"#"+$("#_detailAddress").val();
		data["latlng"]= $("#_latLng").val();
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
			url:"registerStore.do",			// store
			type:'POST',
			success:function(data){

				//성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
				$('#myTable tr:last').after('<tr id="'+data.map.seq+'"><td>'+data.map.name+'</td>'+
						'<td>'+data.map.address+'</td>'+
						'<td>'+data.map.phone+'</td>'+
						'<td><input type="button" value="수정" class="btn btn-inverse" onclick="updateStore('+data.map.seq+')" data-toggle="modal" data-target="#updatestore">'+
						'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteStore('+data.map.seq+')" data-toggle="modal" data-target="#deletestore"></td>'+
						'</tr>');
				//맵 addmarker도 해줘야함

					
			},
			error:function(req, status, error){
				alert("error");
			}
		
		});
		
			
}

 
 /*---------------------------------------------------------------------------------------------
  * store 수정 Ajax (주소는 : 우편번호#도로명주소#지번주소#상세주소 로 가져가서 저장- 나중에 데이터 보여줄때는 #으로 자를거임)
  *----------------------------------------------------------------------------------------------*/

  function updateStore(seq) {	
		 
	 	
	    alert("스토어 수정클릭");
	    alert(seq);
		var data = {};
		
		data["seq"]= seq;
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
			url:"updateStore.do",			// store
			type:'POST',
			success:function(data){
				//데이터 잘 가져오는지 확인용
				/* alert(data.map.name);
				alert(data.map.phone);
				alert(data.map.address);
				alert(data.map.latlng);
				alert(data.map.seq); */
				//성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
				$('#myTable tr:last').after('<tr><td>'+data.map.name+'</td>'+
						'<td>'+data.map.address+'</td>'+
						'<td>'+data.map.phone+'</td>'+
						'<td><input type="button" value="수정" class="btn btn-inverse" onclick="updateStore('+data.map.seq+')">'+
						'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteStore('+data.map.seq+')"></td>'+
						'</tr>');
				//맵 addmarker도 해줘야함

					
			},
			error:function(req, status, error){
				alert("error");
			}
		
		});
		
			
}
 

  /*---------------------------------------------------------------------------------------------
   * store 삭제 Ajax (주소는 : 우편번호#도로명주소#지번주소#상세주소 로 가져가서 저장- 나중에 데이터 보여줄때는 #으로 자를거임)
   *----------------------------------------------------------------------------------------------*/

   function deleteStore(seq) {	
 		 
 	 	
 	    alert("스토어 삭제클릭");
 		var data = {};
 		alert(seq);
 		data["seq"]= seq;

 		$.ajax({
 			contentType:'application/json',
 			dataType:'json',
 			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
 			url:"deleteStore.do",			// store
 			type:'POST',
 			success:function(data){
 				//데이터 잘 가져오는지 확인용
 				/* alert(data.map.name);
 				alert(data.map.phone);
 				alert(data.map.address);
 				alert(data.map.latlng);
 				alert(data.map.seq); */
 				//성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
 				$('#myTable tr:last').after('<tr><td>'+data.map.name+'</td>'+
 						'<td>'+data.map.address+'</td>'+
 						'<td>'+data.map.phone+'</td>'+
 						'<td><input type="button" value="수정" class="btn btn-inverse" onclick="updateStore('+data.map.seq+')">'+
 						'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteStore('+data.map.seq+')"></td>'+
 						'</tr>');
 				//맵 addmarker도 해줘야함

 					
 			},
 			error:function(req, status, error){
 				alert("error");
 			}
 		
 		});
 		
 			
 }
 

 </script> 
 <!--=======================구글 맵 API (key 내꺼임 나중에 지우고 올려야함)===============================-->
 <script async defer
 src="https://maps.googleapis.com/maps/api/js?key=Your_Api_Key&callback=initMap">
 </script>
  <!--=======================우편번호 스크립트===============================-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

