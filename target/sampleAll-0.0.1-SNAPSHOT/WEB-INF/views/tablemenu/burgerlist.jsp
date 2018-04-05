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
				               <form action="registerStore.do" method="post">
				                   <div class="form-body">
									   <input type="hidden" id="_latLng" name="latlng">
				                       <hr>
				                       <div class="row p-t-20">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label class="control-label">지점명</label>
				                                   <input type="text" name="name" id="_name" class="form-control" placeholder="지점명" required="required">
				                                   <small class="form-control-feedback"></small></div>
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
				                       <button type="button" class="btn btn-inverse" data-dismiss="modal">취소</button>
				                   </div>
				               </form>
				           </div>
			           </div>
		        </div>	
		      </div>
		    </div>
		  </div>