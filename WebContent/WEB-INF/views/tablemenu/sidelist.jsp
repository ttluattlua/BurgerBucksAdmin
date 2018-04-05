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
                    <h4 class="card-title">사이드 현황</h4>
                    <h6 class="card-subtitle">등록된 사이드 현황</h6>
                    <div class="table-responsive m-t-40">
                    	<!--===========================사이드 버튼 ===================================-->
	                    <div align="right"> 
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addside">
                                  	사이드 등록
							</button>
						</div>
						<!--===========================사이드테이블 ===================================-->
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
                            	<c:forEach var="bsdto" items="${sideList}">
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
                
                
		                
		<!--==========================사이드 등록 모달창======================================= -->
		 <!-- The Modal -->
		  <div class="modal fade" id="addside">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		      
		        <!-- Modal body -->
		        <div class="modal-body">
			         <div class="card card-outline-primary">
				           <div class="card-header">
				               <h4 class="m-b-0 text-white">사이드 등록</h4>
				           </div>
				           <div class="card-body">
				               <form action="registerSide.do" method="post" enctype="multipart/form-data" id="fileForm">
				                   <div class="form-body">
				                       <hr>
				                       <div class="row p-t-20">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label class="control-label">사이드명</label>
				                                   <input type="text" name="name" id="name" class="form-control" placeholder="사이드명" required="required">
				                                   <small class="form-control-feedback"></small></div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group has-danger">
				                                   <label class="control-label">가격</label>
				                                   <input type="number" min="0" name="price" id="price" class="form-control form-control-danger" placeholder="가격" required="required">
				                                   <small class="form-control-feedback"></small> </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <!--/row-->

				
				                        <div class="row">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label>칼로리</label>
				                                   <input type="number" min="0" name="cal"  class="form-control" id="cal" placeholder="칼로리" required="required">
				                               </div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
					                          <div class="form-group">
                                                   <label class="control-label">이미지 타입</label>
                                                   <select name="what_Image" id="what_Image"  class="form-control custom-select" data-placeholder="이미지 타입을 선택해주세요" tabindex="1" style="height: 40px;">
                                                       <option value="실물사진">실물사진</option>
                                                       <option value="일러스트">일러스트</option>
                                                   </select>
	                                           </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <!--/row-->
				                       
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>사진등록</label>
				                                    <input type="file" id="image_src" name="image_src" class="form-control"/>
				                               </div>
				                           </div>
				                       </div>
				         			  
				
				                   </div>
				                   <div class="form-actions" align="right">
				                       <button type="button" class="btn btn-success" id="registerSideBtn" onclick="registerSideClick()"> <i class="fa fa-check"></i> 등록</button>
				                       <button type="button" class="btn btn-inverse" data-dismiss="modal">취소</button>
				                   </div>
				               </form>
				           </div>
			           </div>
		        </div>	
		      </div>
		    </div>
		  </div>
		  
		  




<script type="text/javascript">

function registerSideClick() {
	alert("클릭");
    var formData = new FormData($("#fileForm")[0]);
    $.ajax({
        type : 'post',
        url : 'registerSide.do',
        dataType:'json',
        data : formData,
        processData : false,
        contentType : false,
        success : function(data) {
            alert("파일 업로드하였습니다.");
            console.log(data);
            console.log(data.name);
            console.log(data.price);
            console.log(data.cal);
            console.log(data.del);

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
