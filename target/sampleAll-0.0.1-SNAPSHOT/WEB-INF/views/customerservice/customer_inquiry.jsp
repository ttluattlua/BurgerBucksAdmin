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
                    <h4 class="card-title">FAQ 현황</h4>
                    <h6 class="card-subtitle">등록된 FAQ 현황</h6>
                    <div class="table-responsive m-t-40">
                    	<!--===========================FAQ 버튼 ===================================-->
	                    <div align="right"> 
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addfaq">
                                  	FAQ 등록
							</button>
						</div>
						<!--===========================FAQ테이블 ===================================-->
                        <table id="myTable" class="table table-bordered table-striped">
                        	<colgroup>
                        	<col width="20%">
                        	<col width="40%">
                        	<col width="20%">
                        	<col width="30%">
                        	</colgroup>
                            <thead>
                                <tr>
                                	<th>No.</th>
                                    <th>아이디</th>
                                    <th>제목</th>
                                    <th>날짜</th>
                                    <th>--</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="idto" items="${InquiryList}" varStatus="status">
                            		<!--답글이 아닌경우-->
	    
		                                <tr id="tr${idto.seq}">
		                                	<td>${status.count }</td>
		                                	<td>${idto.email }</td>
		                                    <td>${idto.title }</td>
		                                    <td>${idto.regdate }</td>
		          							<td id="td_seq${idto.seq}">
			          							<c:if test="${idto.status == 0}"> 
			                                    	<input type="button" value="답변보내기"  class="btn btn-inverse" onclick='sendInquiryClick(${idto})' data-toggle="modal" data-target="#sendInquiryModal">
			                                    </c:if>
			                                    
			                                    <c:if test="${idto.status == 1}">
			                                     	<input type="button" value="답변완료" disabled="disabled" class="btn btn-inverse"> 
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
                
		                
<!--==========================고객문의 답변 모달창======================================= -->
<!-- The Modal -->
 <div class="modal fade" id="sendInquiryModal">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">답변 메일 보내기</h4>
	           </div>
	           <div class="card-body">
	               <form  method="post" enctype="multipart/form-data">
	               	   <input type="hidden" id="send_seq">
	                   <div class="form-body">
	                       <hr>
	                       
	                       <div class="row">
	                           <div class="col-md-12 ">
	                               <div class="form-group">
	                                   <label>제목</label>
	                                    <input type="text" class="form-control" id="send_titles">
	                               </div>
	                           </div>
	                       </div>
	                       <div class="row">
	                           <div class="col-md-12 ">
	                               <div class="form-group">
	                                   <label>받는사람</label>
	                                    <input type="text" class="form-control" id="send_email">
	                               </div>
	                           </div>
	                       </div>
	                       <div class="row">
	                           <div class="col-md-12 ">
	                               <div class="form-group">
	                                   <label>내용</label>
	                                    <textarea style="height: 300px" class="form-control" id="send_contents"></textarea>
	                               </div>
	                           </div>
	                       </div>

	         			  
	
	                   </div>
	                   <div class="form-actions" align="right">
	                       <button type="button" class="btn btn-success" id="sendCustomerInquiry" onclick="sendCustomerInquiryAf()"> <i class="fa fa-check"></i> 등록</button>
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



/*---------------------------------------------------------------------------------------------
 *문의 답변 보내기 
 *----------------------------------------------------------------------------------------------*/

 /*---------------------------------------------------------------------------------------------
  * FAQ 답글등록 버튼 클릭(FAQ 답글 등록하는 함수) 
  *----------------------------------------------------------------------------------------------*/
 function sendInquiryClick(object) {
 	alert("클릭");
 	var obj = JSON.stringify(object);
 	console.log(obj);
 	var bfdto =  JSON.parse(obj);
 	console.log(bfdto.title);
 	console.log(bfdto.seq);
 	console.log(bfdto.content);
 	console.log(bfdto.email);
 	$("#send_titles").val(bfdto.title+"에 대한 답변입니다.");
 	//해당 답글의 원래글 시퀀스의 status 를 1로 바꿔주기 위해
 	$("#send_seq").val(bfdto.seq);
 	//그룹맞춰주기위해
 	$("#send_email").val(bfdto.email);
 	$("#send_contents").val(bfdto.content+"\r\n----------------------------------------\r\n문의에 대한 답변 내용입니다.");
 }
 
 function sendCustomerInquiryAf() {
	//입력란에 다 입력했는지 막아주기 
	if($("#send_titles").val() == "" || $("#send_titles").val() == null){
		alert("제목을 입력해주세요");
		return;
	}
	if($("#send_contents").val() == "" || $("#send_contents").val() == null){
		alert("내용을 입력해주세요");
		return;
	}
	
    var data = {};
    
	data["title"]=$("#send_titles").val();
	data["contents"]=$("#send_contents").val();
	data["email"]=$("#send_email").val();
	data["seq"]=$("#send_seq").val();
	
	$.ajax({
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
		url:"sendMail.do",			// 재료
		type:'POST',
		success:function(data){
			alert("답변 보내기 성공");

			//맨마지막테이블 no구하기
			var tableId = "tr"+$("#send_seq").val();
			var tr = $('#'+tableId);
	        var td = tr.children();
			td.eq(4).html('<input type="button" value="답변완료" disabled="disabled" class="btn btn-inverse">');


		},
		error:function(req, status, error){
			alert("유효하지 않은 메일주소입니다.");
		}
	
	});
}



</script>
