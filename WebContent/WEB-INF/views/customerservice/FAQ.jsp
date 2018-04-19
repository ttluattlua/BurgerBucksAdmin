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
                                    <th>제목</th>
                                    <th>조회수</th>
                                    <th>--</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="faqdto" items="${faqList}" varStatus="status">
                            		<!--답글이 아닌경우-->
	                            	<c:if test="${faqdto.step == 0}">
		                                <tr id="tr${faqdto.seq}">
		                                    <td>${status.count }</td>
		                                    <td>${faqdto.title }</td>
		                                    <td>${faqdto.readcount }</td>
		          							<td id="td_seq${faqdto.seq}">
			          							<c:if test="${faqdto.status == 0 && faqdto.del==0}">
			                                     <input type="button" id="${faqdto.seq}Btn" value="수정" class="btn btn-inverse" onclick='updateFaq(${faqdto})' data-toggle="modal" data-target="#updatefaq"> 
			                                    <input type="button" value="답글달기"  class="btn btn-inverse" onclick='registerAnswerClick(${faqdto})' data-toggle="modal" data-target="#answerfaqmodal">
			                                    </c:if>
			                                    
			                                    <c:if test="${faqdto.del == 1}">
			                                     <p style="color: #a33b2b">삭제된 FAQ입니다.</p>
			                                    </c:if>
			                                    
			                                    <c:if test="${faqdto.status == 1 && faqdto.del==0}">
			                                    	 <input type="button" id="${faqdto.seq}Btn" value="수정" class="btn btn-inverse" onclick='updateFaq(${faqdto})' data-toggle="modal" data-target="#updatefaq">
			                                    	 <input type="button" value="답변완료" disabled="disabled" class="btn btn-inverse"> 
			                                    </c:if>
		                                    </td>
		                                    
		                                </tr>
	                                </c:if>
                                
                                	<!--답글일 경우-->
	                                <c:if test="${faqdto.step != 0}">
		                                <tr id="tr${faqdto.seq}">
		                                    <td>${status.count }</td>
		                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;<span class='label label-info'>RE:</span>답변입니다</td>
		                                    <td>${faqdto.readcount }</td>
		          							<td id="td_seq${faqdto.seq}">
			          							<c:if test="${faqdto.del == 0}">
			                                    <input type="button" value="수정" class="btn btn-inverse" onclick='updateFaq(${faqdto})' data-toggle="modal" data-target="#updatefaq">
			                                    </c:if>
			                                    
			                                    <c:if test="${faqdto.del == 1}">
			                                     <p style="color: #a33b2b">삭제된 FAQ입니다.</p>
			                                    </c:if>
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
                
		                
<!--==========================FAQ 등록 모달창======================================= -->
<!-- The Modal -->
 <div class="modal fade" id="addfaq">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">FAQ 등록</h4>
	           </div>
	           <div class="card-body">
	               <form  method="post" enctype="multipart/form-data">
	                   <div class="form-body">
	                       <hr>
	                       
	                      	<div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label>제목</label>
	                                   <input type="text" class="form-control" id="register_title" placeholder="제목">
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
	                                <div class="form-group">
                                        <label class="control-label">카테고리</label>
                                        <select class="form-control" id="register_categories">
                                        	<option value="1">회원가입</option>
                                        	<option value="2">주문</option>
                                        	<option value="3">배달문의</option>
                                        	<option value="4">결제</option>
                                        </select>
                                     </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       
	                       <div class="row">
	                           <div class="col-md-12 ">
	                               <div class="form-group">
	                                   <label>내용</label>
	                                    <textarea style="height: 300px" class="form-control" id="register_contents"></textarea>
	                               </div>
	                           </div>
	                       </div>
	         			  
	
	                   </div>
	                   <div class="form-actions" align="right">
	                       <button type="button" class="btn btn-success" id="registerFaqBtn" onclick="registerFaqClick()"> <i class="fa fa-check"></i> 등록</button>
	                       <button type="button" class="btn btn-inverse" data-dismiss="modal">취소</button>
	                   </div>
	               </form>
	           </div>
           </div>
       </div>	
     </div>
   </div>
 </div>                

<!--==========================FAQ 답변달기 모달창======================================= -->
<!-- The Modal -->
 <div class="modal fade" id="answerfaqmodal">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">FAQ 답변 등록</h4>
	           </div>
	           <div class="card-body">
	               <form  method="post" enctype="multipart/form-data">
	               		<input type="hidden" id="register_answer_seq">
	               		<input type="hidden" id="register_answer_groups">
	               		<input type="hidden" id="register_answer_data">
	                   <div class="form-body">
	                       <hr>
	                       
	                      	<div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label>제목</label>
	                                   <input type="text" class="form-control" id="register_answer_title" placeholder="제목" readonly="readonly">
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
	                                <div class="form-group">
                                        <label class="control-label">카테고리</label>
                                        <select class="form-control" id="register_answer_categories" disabled="disabled">
                                        	<option value="1">회원문의</option>
                                        	<option value="2">주문</option>
                                        	<option value="3">배달문의</option>
                                        	<option value="4">결제</option>
                                        </select>
                                     </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       
	                       <div class="row">
	                           <div class="col-md-12 ">
	                               <div class="form-group">
	                                   <label>내용</label>
	                                    <textarea style="height: 300px" class="form-control" id="register_answer_contents"></textarea>
	                               </div>
	                           </div>
	                       </div>
	         			  
	
	                   </div>
	                   <div class="form-actions" align="right">
	                       <button type="button" class="btn btn-success" id="registerAnswerBtn" onclick="registerAnswerAfClick()"> <i class="fa fa-check"></i> 답변등록</button>
	                       <button type="button" class="btn btn-inverse" data-dismiss="modal">취소</button>
	                   </div>
	               </form>
	           </div>
           </div>
       </div>	
     </div>
   </div>
 </div>        		                
<!--==========================FAQ 수정 모달창======================================= -->
<!-- The Modal -->
 <div class="modal fade" id="updatefaq">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">FAQ 수정</h4>
	           </div>
	           <div class="card-body">
	               <form  method="post" enctype="multipart/form-data">
	               	   <input type="hidden" id="update_data">
	               	   <input type="hidden" id="update_seq">
	               	   <input type="hidden" id="update_step">
	               	   <input type="hidden" id="update_groups">
	               	   <input type="hidden" id="update_status">
	                   <div class="form-body">
	                       <hr>
	                       
	                       <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group" id="update_title_div">
	                                   <label>제목</label>
	                                   <input type="text" class="form-control" id="update_title" placeholder="제목">
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6" id="update_categories_div">
	                                <div class="form-group">
                                        <label class="control-label">카테고리</label>
                                        <select class="form-control" id="update_categories">
                                        	<option value="1">회원가입</option>
                                        	<option value="2">주문</option>
                                        	<option value="3">배달문의</option>
                                        	<option value="4">결제</option>
                                        </select>
                                     </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       	<div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label>등록날짜</label>
	                                   <input type="text" class="form-control" id="update_regidate" placeholder="제목" readonly="readonly">
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
	                                <div class="form-group">
                                        <label class="control-label">조회수</label>
										<input type="text" class="form-control" id="update_readcount" placeholder="조회수" readonly="readonly">
                                     </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       <div class="row">
	                           <div class="col-md-12 ">
	                               <div class="form-group">
	                                   <label>내용</label>
	                                    <textarea style="height: 300px" class="form-control" id="update_contents"></textarea>
	                               </div>
	                           </div>
	                       </div>
	         			  
	
	                   </div>
	                   <div class="form-actions" align="right">
	                       <button type="button" class="btn btn-success" id="updateFaqBtn" onclick="updateFaqAf()"> <i class="fa fa-check"></i> 수정</button>
	                       <button type="button" class="btn btn-success" id="deleteFaqBtn" onclick="deleteFaqClick()"> <i class="fa fa-check"></i> 삭제</button>
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
 * FAQ 등록 버튼 클릭(FAQ 등록하는 함수) 
 *----------------------------------------------------------------------------------------------*/
function registerFaqClick() {
	//입력란에 다 입력했는지 막아주기 
	if($("#register_title").val() == "" || $("#register_title").val() == null){
		alert("제목을 입력해주세요");
		return;
	}
	if($("#register_contents").val() == "" || $("#register_contents").val() == null){
		alert("제목을 입력해주세요");
		return;
	}
	
  var data = {};
    
	data["title"]=$("#register_title").val();
	data["contents"]=$("#register_contents").val();
	data["categories"]=$("#register_categories").val();
	
	$.ajax({
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
		url:"registerFaq.do",			// 재료
		type:'POST',
		success:function(data){
			console.log(data);
			
			
			var dto = JSON.stringify(data);
			console.log(dto);
			
			
			//맨마지막테이블 no구하기
			var tr = $('#myTable tr:last');
	        var td = tr.children();
			var no = td.eq(0).text();
			var count = parseInt(no)+1;
			alert("count: " + count);
			
			//onclick 함수 묶어주기
			var updateMethod = "'"+"updateFaq("+dto+")"+"'";
			var answerMethod = "'"+"registerAnswerClick("+dto+")"+"'";
			
			//성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
 			$('#myTable tr:last').after('<tr id="tr'+data.seq+'">'+
 			'<td>'+count+'</td>'+
			'<td>'+data.title+'</td>'+
					'<td>'+data.contents+'</td>'+
					'<td id="td_seq'+data.seq+'"><input type="button" id="'+data.seq+'Btn" value="수정" class="btn btn-inverse" onclick='+updateMethod+' data-toggle="modal" data-target="#updatefaq"> '+
					'<input type="button" value="답글달기"  class="btn btn-inverse" onclick='+answerMethod+'  data-toggle="modal" data-target="#answerfaqmodal"></td>'+
					'</tr>');

		},
		error:function(req, status, error){
			alert("error");
		}
	
	});
}


/*---------------------------------------------------------------------------------------------
 * FAQ 답글등록 버튼 클릭(FAQ 답글 등록하는 함수) 
 *----------------------------------------------------------------------------------------------*/
function registerAnswerClick(object) {
	alert("클릭");
	var obj = JSON.stringify(object);
	console.log(obj);
	var bfdto =  JSON.parse(obj);
	console.log(bfdto.title);
	console.log(bfdto.categories);
	console.log(bfdto.contents);
	console.log(bfdto.seq);
	$("#register_answer_title").val(bfdto.title+"에 대한 답글입니다.");
	document.getElementById('register_answer_categories').getElementsByTagName('option')[bfdto.categories-1].selected = 'selected';
	//해당 답글의 원래글 시퀀스의 status 를 1로 바꿔주기 위해
	$("#register_answer_seq").val(bfdto.seq);
	//그룹맞춰주기위해
	$("#register_answer_groups").val(bfdto.groups);
	$("#register_answer_data").val(obj);
	console.log("확인용 ");
	console.log($("#register_answer_data").val());
}

/*---------------------------------------------------------------------------------------------
 * FAQ 답글등록 버튼 클릭(FAQ 답글 등록하는 함수) 
 *----------------------------------------------------------------------------------------------*/
 function registerAnswerAfClick() {
	//입력란에 다 입력했는지 막아주기 
	if($("#register_answer_contents").val() == "" || $("#register_answer_contents").val() == null){
		alert("답변내용을 입력해주세요");
		return;
	}

	var obj =  $("#register_answer_data").val();
	console.log("답글등록json잘들어왔는지확인:"+obj);

 	var data = {};
    
	data["title"]=$("#register_answer_title").val();
	data["contents"]=$("#register_answer_contents").val();
	data["categories"]=$("#register_categories").val();
	data["seq"]=$("#register_answer_seq").val();
	data["groups"]=$("#register_answer_groups").val();
	$.ajax({
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
		url:"registerAnswerFaq.do",			// 재료
		type:'POST',
		success:function(data){
			console.log(data);
			
			
			var dto = JSON.stringify(data);
			console.log(dto);
			
			
			
			var tableId= "tr"+$("#register_answer_seq").val();
			//해당 테이블 다음 no구하기
			var tr = $('#'+tableId);
	        var td = tr.children();
			var no = td.eq(0).text();
			var count = parseInt(no)+1;
			alert("count: " + count);
			//onclick 함수 묶어주기
			
			//본글 답변하기 버튼> 답변완료로 바꿔주기
	        var updateMethodFirst = "'"+"updateFaq("+obj+")"+"'";
			td.eq(3).html('<input type="button" id="'+data.seq+'Btn" value="수정" class="btn btn-inverse" onclick='+updateMethodFirst+' data-toggle="modal" data-target="#updatefaq">'+
			'&nbsp;<input type="button" value="답변완료" disabled="disabled" class="btn btn-inverse"> ');
			
			
			//답변글이 중간에 끼일 수 있으므로 뒤에 글들 number하나씩 밀어주기
			var rowCount = $('#myTable tr').length;
			alert("rowCount: " +rowCount);
			
			for (var i = 1; i < rowCount; i++) {
				var tdData = document.getElementById("myTable").rows[i].cells.item(0).innerHTML;
				alert(tdData);
				var tdCount = parseInt(tdData);
				if(tdCount>count-1){
					document.getElementById("myTable").rows[i].cells.item(0).innerHTML = tdCount+1; 
				}
				
			}
			
			//새로운 row 추가(등록 된 답변 글 데이터 추가)
			var updateMethod = "'"+"updateFaq("+dto+")"+"'";
			$('#'+tableId).after('<tr id="tr'+data.seq+'">'+
 			'<td>'+count+'</td>'+
			'<td>&nbsp;&nbsp;&nbsp;&nbsp;<span class="label label-info">RE:</span>답글입니다.</td>'+
					'<td>'+data.contents+'</td>'+
					'<td id="td_seq'+data.seq+'"><input type="button" id="'+data.seq+'Btn" value="수정" class="btn btn-inverse" onclick='+updateMethod+' data-toggle="modal" data-target="#updatefaq"> '+
					'</tr>');
			
			

		},
		error:function(req, status, error){
			alert("error");
		}
	
	});
}

 
 /*---------------------------------------------------------------------------------------------
  * FAQ 수정 Ajax 
  *----------------------------------------------------------------------------------------------*/
 function updateFaq(object) {	
 		 
		alert("수정클릭");
		var obj = JSON.stringify(object);
		console.log(obj);
		var bfdto =  JSON.parse(obj);
		console.log(bfdto.title);
		console.log(bfdto.categories);
		console.log(bfdto.contents);
		console.log(bfdto.seq);
		
		document.getElementById('update_categories').getElementsByTagName('option')[bfdto.categories-1].selected = 'selected';
		
		//답글수정이면 카테고리,제목,삭제 안보이기 
		if(bfdto.step == 1){
			$("#update_categories_div").css("display", "none");
			$("#update_title_div").css("display", "none");
			$("#deleteFaqBtn").css("display", "none");
			
		}else{
			$("#update_categories_div").css("display", "initial");
			$("#update_title_div").css("display", "initial");
			$("#deleteFaqBtn").css("display", "initial");
		}
		$("#update_step").val(bfdto.step);
		alert("수정step:"+$("#update_step").val());
		$("#update_title").val(bfdto.title);
		$("#update_seq").val(bfdto.seq);
		$("#update_contents").val(bfdto.contents);
		$("#update_readcount").val(bfdto.readcount);
		$("#update_regidate").val(bfdto.regdate);
		$("#update_groups").val(bfdto.groups);
		$("#update_status").val(bfdto.status);
		
		alert($("#update_seq").val());
 		
 			
 }
 
  
 
 /*---------------------------------------------------------------------------------------------
  * FAQ 수정 완료 ajax
  *----------------------------------------------------------------------------------------------*/
 function updateFaqAf() {	
 		

		if($("#update_title").val() == "" || $("#update_title").val() == null){
			alert("제목을 입력해주세요");
			return;
		}
		if($("#update_contents").val() == "" || $("#update_contents").val() == null){
			alert("내용을 입력해주세요 입력해주세요");
			return;
		}

	 	var data = {};
	 	
	 
	    
		data["title"]=$("#update_title").val();
		data["contents"]=$("#update_contents").val();
		data["categories"]=$("#update_categories").val();
		data["seq"]=$("#update_seq").val();
		data["step"]=$("#update_step").val();
		data["groups"]=$("#update_groups").val();
		data["status"]=$("#update_status").val();
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
			url:"faqUpdateAf.do",			// 재료
			type:'POST',
			success:function(data){
				alert("FAQ 수정완료");
				console.log(data);
				var dto = JSON.stringify(data);
				console.log(dto);
				
				var tableId= "tr"+$("#update_seq").val();
				
				//테이블 제목 수정
				var tr = $('#'+tableId);
		        var td = tr.children();
		        //답글일 경우 다음과같이수정
		        if(data.step == 1){
		        	td.eq(1).html($("&nbsp;&nbsp;&nbsp;&nbsp;<span class='label label-info'>RE:</span>"+"#update_title").val());	
		        }else{
		        	td.eq(1).text($("#update_title").val());
		        }
		        
		        var updateMethod = "'"+"updateFaq("+dto+")"+"'";
		        var answerMethod = "'"+"registerAnswerClick("+dto+")"+"'";
		        //답글을 이미 단 글일경우
		        if(data.step == 0 && data.status == 1){
			        td.eq(3).html('<input type="button" id="'+data.seq+'Btn" value="수정" class="btn btn-inverse" onclick='+updateMethod+' data-toggle="modal" data-target="#updatefaq">'+
					'&nbsp;<input type="button" value="답변완료" disabled="disabled" class="btn btn-inverse"> ');
		        
			      //답글을 아직 달지 않은경우 
		        }else if(data.step == 0 && data.status == 0){
		        	td.eq(3).html('<input type="button" id="'+data.seq+'Btn" value="수정" class="btn btn-inverse" onclick='+updateMethod+' data-toggle="modal" data-target="#updatefaq">'+
					'&nbsp;<input type="button" value="답변완료" disabled="disabled" class="btn btn-inverse">'+
					'<input type="button" value="답글달기"  class="btn btn-inverse" onclick='+answerMethod+'  data-toggle="modal" data-target="#answerfaqmodal"></td>');
		        
		        //답글일 경우
		        }else if(data.step == 1){
		        	 td.eq(3).html('<input type="button" id="'+data.seq+'Btn" value="수정" class="btn btn-inverse" onclick='+updateMethod+' data-toggle="modal" data-target="#updatefaq">');
		        }
				

			},
			error:function(req, status, error){
				alert("error");
			}
		
		});
 		
 			
 }


 /*---------------------------------------------------------------------------------------------
  * FAQ 삭제 Ajax 완료 
  *----------------------------------------------------------------------------------------------*/
 	function deleteFaqClick() {	
  		 
		var status = $("#update_status").val();
		console.log(status);
  		var data = {};
  		
		
		
  		data["seq"]= $("#update_seq").val();
  		data["groups"]=$("#update_groups").val();
  		data["status"]= $("#update_status").val();
  		
  		$.ajax({
  			contentType:'application/json',
  			dataType:'json',
  			data:JSON.stringify(data), 		
  			url:"deleteFaqMethod.do",			
  			type:'POST',
  			success:function(data){
 				alert(data.msg);
				var tableId= "tr"+$("#update_seq").val();
				//테이블 제목 수정
				var tr = $('#'+tableId);
		        var td = tr.children();
 				td.eq(3).html('<p style="color: #a33b2b">삭제된 FAQ입니다.</p> ');
 				if(status=="1"){
 					var answerIndex = tr.rowIndex+1;
 					var answerTd = answerIndex.children();
 					answerTd.eq(3).html('<p style="color: #a33b2b">삭제된 FAQ입니다.</p> ');
 				}
 			
  			},
  			error:function(req, status, error){
  				alert("error");
  			}
  		
  		});
  		
  			
   }

</script>
