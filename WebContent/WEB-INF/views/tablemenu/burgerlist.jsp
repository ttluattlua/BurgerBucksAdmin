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
                                    <th>사진</th>
                                    <th>버거이름</th>
                                    <th>재료</th>
                                    <th>만든사람</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="bgdto" items="${burgerList}">

                                <tr id="tr${bgdto.seq}">
                                	
                                    <td>
                                    <c:if test="${bgdto.creator!=0 }">
                                    <img alt="버거사진" src="./images/AdminBurgerImage.png" style="width: 200px">
                                    </c:if>
                                    <c:if test="${bgdto.creator ==0 }">
                                    <img alt="버거사진" src="${bgdto.image_Src}" style="width: 200px">
                                    </c:if>
                                    <c:if test="${bgdto.image_Src =='없음' && bgdto.creator ==0}">
                                    <img alt="버거사진" src="./images/AdminBurgerImage.png" style="width: 200px">
                                    </c:if>
                                    </td>
                                    <td>${bgdto.name }</td>
                                    <td>
                                    ${bgdto.bread_name }
                                    ${bgdto.ingredient01_name }
                                    ${bgdto.ingredient02_name }
                                    ${bgdto.ingredient03_name }
                                    ${bgdto.ingredient04_name }
                                    ${bgdto.ingredient05_name }
                                    ${bgdto.ingredient06_name }
                                    ${bgdto.ingredient07_name }
                                    ${bgdto.ingredient08_name }
                                    ${bgdto.ingredient09_name }
                                    </td>
                                    <td>
                                      	<c:if test="${bgdto.creatorID =='0' }">
                                         	ad
                                    	</c:if>
                                    	<c:if test="${bgdto.creatorID !='0' }">
                                         	${bgdto.creatorID}
                                    	</c:if>
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
	                   <input type="hidden" name="creator" value="0">
	                   <div class="form-body">
	                   	
	                       <hr>
	                          <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label>버거 이름</label>
	                                    <input type="text" id="name" name="name" class="form-control"/>
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
	                                   <label>칼로리</label>
	                                   <input type="number" min="0" name="cal"  class="form-control" id="buger_cal" placeholder="칼로리" required="required">
	                               </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                         <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                  <label class="control-label">번</label>
                                       <select name="bread" id="bread"  class="form-control custom-select" tabindex="1" style="height: 40px;">
                                           <c:forEach var="bigdto" items="${IngList}">
                                           		<c:if test="${bigdto.types == 1}">                                          		
                                           		<option value="${bigdto.seq}" >${bigdto.name}</option>
                                           		</c:if>
                                           </c:forEach>
                                       </select>
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료1</label>
                                       <select name="ingredient01" id="ingredient01"  class="form-control custom-select"  tabindex="1" style="height: 40px;">
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           </c:if>
                                           </c:forEach>
                                           
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료2</label>
                                       <select name="ingredient02" id="ingredient02"  class="form-control custom-select" tabindex="1" style="height: 40px;">
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           	</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료3</label>
                                       <select name="ingredient03" id="ingredient03"  class="form-control custom-select" tabindex="1" style="height: 40px;">
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           	</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료4</label>
                                       <select name="ingredient04" id="ingredient04"  class="form-control custom-select"  tabindex="1" style="height: 40px;">
										   <option value="0">선택안함</option>
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           	</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료5</label>
                                       <select name="ingredient05" id="ingredient05"  class="form-control custom-select"  tabindex="1" style="height: 40px;">
										   <option value="0">선택안함</option>
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           	</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료6</label>
                                       <select name="ingredient06" id="ingredient06"  class="form-control custom-select"  tabindex="1" style="height: 40px;">
										   <option value="0">선택안함</option>
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           	</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료7</label>
                                       <select name="ingredient07" id="ingredient07"  class="form-control custom-select"  tabindex="1" style="height: 40px;">
										   <option value="0">선택안함</option>
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           	</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료8</label>
                                       <select name="ingredient08" id="ingredient08"  class="form-control custom-select"  tabindex="1" style="height: 40px;">
										   <option value="0">선택안함</option>
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
                                           	</c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
	                           </div>
	                           <div class="col-md-6">
		                          <div class="form-group">
                                       <label class="control-label">재료9</label>
                                       <select name="ingredient09" id="ingredient09"  class="form-control custom-select" onchange="showImage(this.value)" tabindex="1" style="height: 40px;">
										   <option value="0">선택안함</option>
										   <c:forEach var="bigdto" items="${IngList}">
										   <c:if test="${bigdto.types != 1 && igdto.types != 0}"> 
                                           		<option value="${bigdto.seq}">${bigdto.name}</option>
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
	                                   <label>사진등록</label>
	                                    <input type="file" id="image_src" name="image_src" class="form-control"/>
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
	                                   <label>가격</label>
	                                   <input type="number" min="0" name="price"  class="form-control" id="burger_price" placeholder="가격" required="required">
	                               </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       <!--/row-->
	                       
	                       
	                       
	                       
	         			  
	
	                   </div>
	                   <div class="form-actions" align="right">
	                       <button type="button" class="btn btn-success" id="registerIngBtn" onclick="registerBurgerClick()"> <i class="fa fa-check"></i> 등록</button>
	                       <button type="button" class="btn btn-inverse" data-dismiss="modal" id="addburgercansel">취소</button>
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
 

 /*---------------------------------------------------------------------------------------------
  * 버거등록 클릭했을때 실행되는 함수 
  *----------------------------------------------------------------------------------------------*/
 function registerBurgerClick() {

 	//입력란에 다 입력했는지 막아주기 
 	if($("#name").val() == "" || $("#name").val() == null){
 		alert("버거명을 입력해주세요");
 		return;
 	}else if($("#buger_cal").val() == "" || $("#buger_cal").val() == null){
 		alert("칼로리를 입력해주세요");
 		return;
 	}else if($("#burger_price").val() == "" || $("#burger_price").val() == null){
 		alert("가격을 입력해주세요");
 		return;
 	}else if(document.getElementById("image_src").files.length == 0){
 		alert("버거사진을 선택해주세요");
 		return;
 	}
     var formData = new FormData($("#fileForm")[0]);
     $.ajax({
         type : 'post',
         url : 'registerBurger.do',
         dataType:'json',
         data : formData,
         processData : false,
         contentType : false,
         success : function(data) {
             alert("파일 업로드하였습니다.");
             console.log(data);

  			$('#myTable tr:last').after('<tr id="tr'+data.seq+'">'+
 			'<td><img alt="버거사진" src="'+data.image_Src+'" style="width: 200px"></td>'+		
 			'<td>'+data.name+'</td>'+
 			'<td>'+
 			data.bread_name+ '&nbsp;'+
            data.ingredient01_name+ '&nbsp;'+
            data.ingredient02_name+ '&nbsp;'+
            data.ingredient03_name+ '&nbsp;'+
            data.ingredient04_name+ '&nbsp;'+
            data.ingredient05_name+ '&nbsp;'+
            data.ingredient06_name+ '&nbsp;'+
            data.ingredient07_name+ '&nbsp;'+
            data.ingredient08_name+ '&nbsp;'+
            data.ingredient09_name+ '&nbsp;'+
 			'</td>'+
 			'<td>admin</td>');
  			$("#addburgercansel").click();

         },
         error : function(req, status, error) {
             alert("파일 업로드에 실패하였습니다.");
             alert(req);
             alert(status);
             alert(error);
             console.log(error);
             console.log(error.status);
         }
     });
 }


 /*---------------------------------------------------------------------------------------------
  * tr 아이디값으로 해당 row 지우는 함수 
  *----------------------------------------------------------------------------------------------*/
  function deleteTableRow(deleteRowId){
 	 var row = document.getElementById(deleteRowId);
 	    var table = row.parentNode;
 	    while ( table && table.tagName != 'TABLE' )
 	        table = table.parentNode;
 	    if ( !table )
 	        return;
 	    table.deleteRow(row.rowIndex);
  }
 
 
 </script>