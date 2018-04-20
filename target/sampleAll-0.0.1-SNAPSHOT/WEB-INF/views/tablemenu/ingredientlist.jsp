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
                    <h4 class="card-title">재료 현황</h4>
                    <h6 class="card-subtitle">등록된 재료 현황</h6>
                    <div class="table-responsive m-t-40">
                    	<!--===========================사이드 버튼 ===================================-->
	                    <div align="right"> 
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#adding">
                                  	재료 등록
							</button>
						</div>
						<!--===========================사이드테이블 ===================================-->
                        <table id="myTable" class="table table-bordered table-striped">
                        	<colgroup>
                        	<col width="20%">
                        	<col width="15%">
                        	<col width="15%">
                        	<col width="15%">
                        	<col width="10%">
                        	<col width="10%">
                        	<col width="15%">
                        	</colgroup>
                            <thead>
                                <tr>
                                	<th>이미지</th>
                                    <th>재료명</th>
                                    <th>재료타입</th>
                                    <th>사진타입</th>
                                    <th>가격</th>
                                    <th>칼로리</th>
                                    <th>--</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="bigdto" items="${IngList}">
                            	
                                <tr id="tr${bigdto.seq}">
                                	<td>
                                	<img alt="재료사진" src="${bigdto.image_Src}" style="width: 200px">
                                	</td>
                                    <td>${bigdto.name }</td>
									<c:choose>
									    <c:when test="${bigdto.types eq 1}">
									       <td>번</td>
									    </c:when>					
									    <c:when test="${bigdto.types eq 2}">
									       <td>패티</td>
									    </c:when>		
									    <c:when test="${bigdto.types eq 3}">
									        <td>채소</td>
									    </c:when>	
									    <c:otherwise>
									       	<td>기타</td>
									    </c:otherwise>
									</c:choose>
									<td>${bigdto.what_Image }</td>
                                    <td>${bigdto.price }</td>
                                    <td>${bigdto.cal }</td>
                                    
          							<td id="td_seq${bigdto.seq}">
	          							<c:if test="${bigdto.del == 0}">
	                                     <input type="button" id="${bigdto.seq}Btn" value="수정" class="btn btn-inverse" onclick="updateIng(${bigdto.seq }, ${bigdto.image_Seq}, '${bigdto.image_Src}', '${bigdto.what_Image}')" data-toggle="modal" data-target="#updateing"> 
	                                    <input type="button" value="삭제"  class="btn btn-inverse" onclick="deleteIng(${bigdto.seq }, ${bigdto.image_Seq})" data-toggle="modal" data-target="#deleteing">
	                                    </c:if>
                                    
	                                    <c:if test="${bigdto.del == 1}">
	                                   	<p style="color: #a33b2b">삭제된 재료입니다.</p>
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
                
                
		                
<!--==========================재료 등록 모달창======================================= -->
<!-- The Modal -->
 <div class="modal fade" id="adding">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">재료 등록</h4>
	           </div>
	           <div class="card-body">
	               <form action="registerIng.do" method="post" enctype="multipart/form-data" id="fileForm">
	                   <div class="form-body">
	                       <hr>
	                       <div class="row p-t-20">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label class="control-label">재료명</label>
	                                   <input type="text" name="name" id="name" class="form-control" placeholder="재료명" required="required">
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
 
 
               
<!--==========================재료 수정 모달창======================================= -->
<!-- The Modal -->
 <div class="modal fade" id="updateing">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">재료 수정</h4>
	           </div>
	           <div class="card-body">
	               <form action="updateIngAf.do" method="post" enctype="multipart/form-data" id="update_fileForm">
	                   <input type="hidden" name="image_Seq" id="update_image_Seq">
	                   <input type="hidden" name="seq" id="update_Seq">
	                   <input type="hidden" name="image_Src" id="original_image">
	                   <div class="form-body">
	                       <hr>
	                       <div class="row p-t-20">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label class="control-label">재료명</label>
	                                   <input type="text" name="name" id="updatename" class="form-control" placeholder="재료명" required="required">
	                                   <small class="form-control-feedback"></small></div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
	                               <div class="form-group has-danger">
	                                   <label class="control-label">가격</label>
	                                   <input type="number" min="0" name="price" id="updateprice" class="form-control form-control-danger" placeholder="가격" required="required">
	                                   <small class="form-control-feedback"></small> </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       <!--/row-->

	
	                        <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label>칼로리</label>
	                                   <input type="number" min="0" name="cal"  class="form-control" id="updatecal" placeholder="칼로리" required="required">
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
                                     <label class="control-label">이미지 타입</label>
                                     <select name="what_Image" id="update_what_Image"  class="form-control custom-select" data-placeholder="이미지 타입을 선택해주세요" tabindex="1" style="height: 40px;">
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
	                                   <label class="control-label">재료 타입</label>
                                        <select name="types" id="update_types"  class="form-control custom-select" data-placeholder="재료타입을 선택해주세요" tabindex="1" style="height: 40px;">
                                            <option value="1" >번</option>
                                            <option value="2" >패티</option>
                                            <option value="3" >채소</option>
                                            <option value="4" >기타</option>
                                        </select>
	                               </div>
	                           </div>
	                       </div>
	                       
	                       <div class="row">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <img alt="현재사진" src="" id="update_current_image" style="width: 200px; height: 200px;" >
	                               </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
		                          <div class="form-group">
                                                <label class="control-label">사진수정</label>
                                                 <input type="file" id="update_image_src" name="image_src" class="form-control"/>
                                         </div>
	                           </div>
	                           <!--/span-->
	         			  
							</div>
	                   </div>
	                   <div class="form-actions" align="right">
	                       <button type="button" class="btn btn-success" id="updateIngBtn" onclick="updateIngAf()"> <i class="fa fa-check"></i> 등록</button>
	                       <button type="button" class="btn btn-inverse" data-dismiss="modal">취소</button>
	                   </div>
	               </form>
	           </div>
           </div>
       </div>	
     </div>
   </div>
 </div>
 
		  
   
<!--==========================삭제 모달창======================================= -->
  <!-- The Modal -->
  <div class="modal fade" id="deleteing">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal body -->
        <div class="modal-body">
     
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">재료 삭제</h4>
	           </div>
	           <div class="card-body">
	               <form action="deleteIng.do" method="post">
	                   <div class="form-body">
						   <input type="hidden" id="deleteseq" name="del_seq">
						   <input type="hidden" id="delete_image_Seq" name="del_image_seq">
	                       <hr>
	                       <div class="row p-t-20">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                               <button type="button" class="btn btn-success" id="deleteIngAfBtn" onclick="deleteIngAf()" style="width: 200px;"> <i class="fa fa-check" ></i> 삭제</button>
	                                   <small class="form-control-feedback"></small> </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
	                               <div class="form-group has-danger">
										<button type="button" class="btn btn-inverse" style="width: 200px;" data-dismiss="modal">취소</button>
	                                   <small class="form-control-feedback"></small> </div>
	                           </div>
	                           <!--/span-->
	                       </div>
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
 * 재료등록 클릭했을때 실행되는 함수 
 *----------------------------------------------------------------------------------------------*/
function registerIngClick() {

	//입력란에 다 입력했는지 막아주기 
	if($("#name").val() == "" || $("#name").val() == null){
		alert("재료명을 입력해주세요");
		return;
	}else if($("#price").val() == "" || $("#price").val() == null){
		alert("가격을 입력해주세요");
		return;
	}else if($("#cal").val() == "" || $("#cal").val() == null){
		alert("칼로리를 입력해주세요");
		return;
	}else if(document.getElementById("image_src").files.length == 0){
		alert("재료사진을 선택해주세요");
		return;
	}
    var formData = new FormData($("#fileForm")[0]);
    $.ajax({
        type : 'post',
        url : 'registerIng.do',
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
            var imageurl = "'"+data.image_Src+"'";
            var imageType = "'"+data.what_Image+"'";
          //성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
            if(data.types == 1){
            	data_type='번';
            }else if(data.types == 2){
            	data_type='패티';
            }else if(data.types == 3){
            	data_type='채소';
            }else{
            	data_type='기타';
            }
            //해당 테이블 로우 삭제
          //성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
            //성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
 			$('#myTable tr:last').after('<tr id="tr'+data.seq+'">'+
			'<td><img alt="재료사진" src="'+data.image_Src+'" style="width: 200px"></td>'+		
			'<td>'+data.name+'</td>'+
			'<td>'+data_type+'</td>'+
			'<td>'+data.what_Image+'</td>'+
			'<td>'+data.price+'</td>'+
			'<td>'+data.cal+'</td>'+
			'<td id="td_seq'+data.seq+'"><input type="button" value="수정" class="btn btn-inverse" onclick="updateIng('+data.seq+','+data.image_Seq+','+imageurl+','+imageType+')" data-toggle="modal" data-target="#updateing">'+
			'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteIng('+data.seq+','+data.image_Seq+')" data-toggle="modal" data-target="#deleteing"></td>'+
			'</tr>');

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
 
 
 /*---------------------------------------------------------------------------------------------
  * 재료 수정 Ajax 
  *----------------------------------------------------------------------------------------------*/
 function updateIng(seq, imageSeq, imageSrc, imageType) {	
 		 
		
 	    alert(seq); 
 	    $("#updatename").attr("value", "");
 	    $("#updateprice").attr("value", "");
 	    $("#updatecal").attr("value", "");
 	    $("#update_image_Seq").attr("value", imageSeq); //이미지 시퀀스(나중에 이미지수정위해)
		$("#update_current_image").attr("src", imageSrc);//이미지 src(현재 띄어주기위해)
		$("#update_Seq").attr("value", seq);//사이드 시퀀스(사이드 테이블 수정위해)
		$("#original_image").attr("value", imageSrc); //나중에 이미지 폴더에서 삭제해주기위해
 	    var data = {};
 	    
 		data["seq"]=seq;
 		data["image_Seq"]=imageSeq;
 		
 		$.ajax({
 			contentType:'application/json',
 			dataType:'json',
 			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
 			url:"updateIng.do",			// 재료
 			type:'POST',
 			success:function(data){
 				console.log(data);
 				var types =data.types;
				console.log(data);
				console.log(data.name);
				var image_type;
				if(imageType=='실물사진'){
					image_type=0;
				}else{
					image_type=1;
				}
				
				document.getElementById('updatename').value = data.name;
				document.getElementById('updateprice').value = data.price;
				document.getElementById('updatecal').value = data.cal;

				//선택한 재료종류를 selected로 걸어주기 
				document.getElementById('update_types').getElementsByTagName('option')[types-1].selected = 'selected';
				/* 	$('#update_types option[value='+types+']').attr('selected', 'selected'); */
				//선택한 이미지타입을 selected로 걸어주기 
					/* $('#update_what_Image option[value='+imageType+']').attr('selected', 'selected'); */
					document.getElementById('update_what_Image').getElementsByTagName('option')[image_type].selected = 'selected';
 				
 			},
 			error:function(req, status, error){
 				alert("error");
 			}
 		
 		});
 		
 			
 }
  
  
 
 /*---------------------------------------------------------------------------------------------
  * 재료 수정 완료 ajax
  *----------------------------------------------------------------------------------------------*/
 function updateIngAf() {	
	 
		if($("#updatename").val() == "" || $("#updatename").val() == null){
			alert("재료명을 입력해주세요");
			return;
		}else if($("#updateprice").val() == "" || $("#updateprice").val() == null){
			alert("가격을 입력해주세요");
			return;
		}else if($("#updatecal").val() == "" || $("#updatecal").val() == null){
			alert("칼로리를 입력해주세요");
			return;
		}
 		 
	    var formData = new FormData($("#update_fileForm")[0]);
	    $.ajax({
	        type : 'post',
	        url : 'updateIngAf.do',
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
	            
	            var imageurl = "'"+data.image_Src+"'";
	            var imageType = "'"+data.what_Image+"'";
	            var data_type;
	            console.log()
	            if(data.types == 1){
	            	data_type='번';
	            }else if(data.types == 2){
	            	data_type='패티';
	            }else if(data.types == 3){
	            	data_type='채소';
	            }else{
	            	data_type='기타';
	            }
	            
	            var deleteRow= "tr"+data.seq;
	            var tr = $("#"+deleteRow);
	            var td = tr.children();
	            
	            
	            //해당 테이블 로우 수정
	            td.eq(0).html('<img alt="재료사진" src="'+data.image_Src+'" style="width: 200px">');
	            td.eq(1).text(data.name);
	            td.eq(2).text(data_type);
	            td.eq(3).text(data.what_Image);
	            td.eq(4).text(data.price);
	            td.eq(5).text(data.cal);
	            td.eq(6).html('<input type="button" value="수정" class="btn btn-inverse" onclick="updateIng('+data.seq+','+data.image_Seq+','+imageurl+','+imageType+')" data-toggle="modal" data-target="#updateing">'+
	    				'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteIng('+data.seq+','+data.image_Seq+')" data-toggle="modal" data-target="#deleteing">');
	            
/* 	            //해당 테이블 로우 삭제
	            var deleteRow= "tr"+data.seq;
	            deleteTableRow(deleteRow); */
	          //성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
	            //성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
/* 	 			$('#myTable tr:last').after('<tr id="tr'+data.seq+'">'+
				'<td><img alt="재료사진" src="'+data.image_Src+'" style="width: 200px"></td>'+		
				'<td>'+data.name+'</td>'+
				'<td>'+data_type+'</td>'+
				'<td>'+data.what_Image+'</td>'+
				'<td>'+data.price+'</td>'+
				'<td>'+data.cal+'</td>'+
				'<td id="td_seq'+data.seq+'"><input type="button" value="수정" class="btn btn-inverse" onclick="updateIng('+data.seq+','+data.image_Seq+','+imageurl+','+imageType+')" data-toggle="modal" data-target="#updateing">'+
				'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteIng('+data.seq+','+data.image_Seq+')" data-toggle="modal" data-target="#deleteing"></td>'+
				'</tr>'); */

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
  * 재료 삭제 Ajax
  *----------------------------------------------------------------------------------------------*/
  var deleteRow; //지울 테이블 row저장
 function deleteIng(seq, imageSeq) {	

 	 
 	 	$("#delete_image_Seq").attr("value", imageSeq);
 	 	console.log("seq:"+seq);
 		$("#deleteseq").attr("value", seq);
 		console.log("imageSeq:"+imageSeq);
 		/* alert($("#deleteseq").val());	 */
 		
  			
  }
  

 /*---------------------------------------------------------------------------------------------
  * 재료 삭제 Ajax 완료 
  *----------------------------------------------------------------------------------------------*/
 function deleteIngAf() {	
  		 
  	 	
  	    /* alert("사이드  삭제 완료"); */
  		var data = {};

  		data["seq"]= $("#deleteseq").val();
  		data["image_Seq"]= $("#delete_image_Seq").val();
  		$.ajax({
  			contentType:'application/json',
  			dataType:'json',
  			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
  			url:"deleteIng.do",			// store
  			type:'POST',
  			success:function(data){
 				alert(data.msg);
 				
 				var deleteRowId =	"td_seq"+$("#deleteseq").val();
				 console.log(deleteRowId);
				 $("#"+deleteRowId).html('<p style="color: #a33b2b">삭제된 재료입니다.</p>');   
  					
  			},
  			error:function(req, status, error){
  				alert("error");
  			}
  		
  		});
  		
  			
  }
  

</script>
