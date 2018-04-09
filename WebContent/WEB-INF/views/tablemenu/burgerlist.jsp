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
        
         <!--==========================table1==============================-->
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">버거 현황</h4>
                    <h6 class="card-subtitle">등록된 버거 현황</h6>
                    <div class="table-responsive m-t-40">
                    	<!--===========================버거 버튼 ===================================-->
	                    <div align="right"> 
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addburger">
                                  	버거 등록
							</button>
						</div>
						<!--===========================버거테이블 ===================================-->
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
                            	<c:if test="${bsdto.del == 0}">
                                <tr id="tr${bsdto.seq}">
                                	
                                    <td>${bsdto.name }</td>
                                    <td>${bsdto.address }</td>
                                    <td>${bsdto.phone }</td>
                                    <td>
                                    <input type="button" id="${bsdto.seq}Btn" value="수정" class="btn btn-inverse" onclick="updateStore(${bsdto.seq })" data-toggle="modal" data-target="#updatestore"> 
                                    <input type="button" value="삭제"  class="btn btn-inverse" onclick="deleteStore(${bsdto.seq })" data-toggle="modal" data-target="#deletestore">
                                    </td>
                                    
                                </tr>
                                </c:if>
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
                
 
  
                        
		<!--==========================버거 등록 모달창======================================= -->
	<!-- The Modal -->
 <div class="modal fade" id="addburger">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">버거 등록</h4>
	           </div>
	           <div class="card-body">
	               <form action="registerIng.do" method="post" enctype="multipart/form-data" id="fileForm">
	                   <div class="form-body">
	                       <hr>
	                         <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                  <label class="control-label">번</label>
                                       <select name="bun" id="bun"  class="form-control custom-select" onchange="showImage(this.value)" tabindex="1" style="height: 40px;">
                                           <c:forEach var="bigdto" items="${IngList}">
                                           		<c:if test="${bigdto.types == 1}">
                                           		<option value="{'seq':'${bigdto.seq}','url':'${bigdto.image_Src}'}" >${bigdto.name}</option>
                                           		</c:if>
                                           </c:forEach>
                                       </select>
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">패티</label>
                                       <select name="patty" id="patty"  class="form-control custom-select" onchange="showImage(this.value)" tabindex="1" style="height: 40px;">
										   <c:forEach var="bigdto" items="${IngList}">
                                           		<c:if test="${bigdto.types == 2}">
                                           		<option value="{'seq':'${bigdto.seq}','url':'${bigdto.image_Src}'}">${bigdto.name}</option>
                                           		</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       <!--/row-->

	
	                        <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                  <label class="control-label">채소</label>
                                       <select name="veggie" id="veggie"  class="form-control custom-select" tabindex="1" style="height: 40px;" onchange="showImage(this.value)">
										   <c:forEach var="bigdto" items="${IngList}">
                                           		<c:if test="${bigdto.types == 3}">
                                           			<option value="${bigdto.seq}--something--${bigdto.image_Src}">${bigdto.name}</option>
                                           		</c:if>
                                           </c:forEach>
                                       </select>
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">기타</label>
                                       <select name="etc" id="etc"  class="form-control custom-select" onchange="showImage(this.value)" tabindex="1" style="height: 40px;">
										   <c:forEach var="bigdto" items="${IngList}">
                                           		<c:if test="${bigdto.types == 4}">
                                           			<option onclick="showImage(${bigdto.seq}, '${bigdto.image_Src}')" value="{'seq':'${bigdto.seq}','url':'${bigdto.image_Src}'}" >${bigdto.name}</option>
                                           		</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       <!--/row-->
	                       <div class="row">
	                           <div class="col-md-12 ">
	                               <div class="form-group">
	                                   <label>재료 이미지  </label>
	                                   
	                                   <table>
	                                   		<tr>
	                                   			<td>
	                                   				<img alt="" src="" id="bunImage" style="width: 100px;">
	                                   			</td>
	                                   			<td>재료1</td>
	                                   			<td>재료2</td>
	                                   			<td>재료3</td>
	                                   			<td>재료4</td>
	                                   			<td>재료5</td>
	                                   			<td>재료6</td>
	                                   			<td>재료7</td>
	                                   			<td>재료8</td>
	                                   			<td>재료9</td>
	                                  	 	</tr>
	                                   </table>    		
	                               </div>
	                           </div>
				           </div>
	                       <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label>사진등록</label>
	                                    <input type="file" id="image_src" name="image_src" class="form-control"/>
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
                                        <label class="control-label">재료 타입</label>
                                        <select name="types" id="types"  class="form-control custom-select" data-placeholder="재료타입을 선택해주세요" tabindex="1" style="height: 40px;">
                                            <option value="1">번</option>
                                            <option value="2">패티</option>
                                            <option value="3">채소</option>
                                            <option value="4">기타</option>
                                        </select>
                                   </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       <!--/row-->
	                       
	                       
	                       
	                       
	         			  
	
	                   </div>
	                   <div class="form-actions" align="right">
	                       <button type="button" class="btn btn-success" id="registerIngBtn" onclick="registerIngClick()"> <i class="fa fa-check"></i> 등록</button>
	                       <button type="button" class="btn btn-inverse" data-dismiss="modal">취소</button>
	                   </div>
	               </form>
	           </div>
           </div>
       </div>	
     </div>
   </div>
 </div>
 
 <!--=============================스크립트=======================================-->
 <script>
/*  function showImage(image) {
	 var imageUrl = JSON.stringify(image);
	 console.log(imageUrl);
	 var obj = JSON.parse(imageUrl);
	 console.log(obj);
	 console.log(obj.seq);
	 console.log(obj);
	 alert("imageUrl:" + imageUrl);
	 alert("imageUrl.r:" + obj.url);
	$("#bunImage").attr("src", obj.url);
} */
function showImage(tempValue) {
    var temp = tempValue.split('--something--');
	var seq = parseInt(temp[0]);
	var src = temp[1];
	
	$("#bunImage").attr("src", src);
}
 
 </script>