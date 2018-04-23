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
                        	<colgroup>
                        	<col width="20%">
                        	<col width="20%">
                        	<col width="20%">
                        	<col width="20%">
                        	<col width="40%">
                        	</colgroup>
                            <thead>
                                <tr>
                                	<th>이미지</th>
                                    <th>사이드명</th>
                                    <th>가격</th>
                                    <th>칼로리</th>
                                    <th>--</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="bsdto" items="${sideList}">
                            	
                                <tr id="tr${bsdto.seq}">
                                	<td>
                                	<img alt="사이드사진" src="${bsdto.image_Src}" style="width: 200px">
                                	</td>
                                    <td>${bsdto.name }</td>
                                    <td>${bsdto.price }</td>
                                    <td>${bsdto.cal }</td>
          							<td id="td_seq${bsdto.seq}">
          							<c:if test="${bsdto.del == 0}">
                                     <input type="button" id="${bsdto.seq}Btn" value="수정" class="btn btn-inverse" onclick="updateSide(${bsdto.seq }, ${bsdto.image_Seq}, '${bsdto.image_Src}')" data-toggle="modal" data-target="#updateside"> 
                                    <input type="button" value="삭제"  class="btn btn-inverse" onclick="deleteSide(${bsdto.seq }, ${bsdto.image_Seq})" data-toggle="modal" data-target="#deleteside">
                                    </c:if>
                                    <c:if test="${bsdto.del == 1}">
                                   		<p style="color: #a33b2b">삭제된 사이드입니다.</p>
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
                                                   <!--  <option value="일러스트">일러스트</option> -->
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
	                       <button type="button" class="btn btn-inverse" data-dismiss="modal" id="addsidecansel">취소</button>
	                   </div>
	               </form>
	           </div>
           </div>
       </div>	
     </div>
   </div>
 </div>
 
 
               
<!--==========================사이드 수정 모달창======================================= -->
<!-- The Modal -->
 <div class="modal fade" id="updateside">
   <div class="modal-dialog modal-lg">
     <div class="modal-content">
     
       <!-- Modal body -->
       <div class="modal-body">
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">사이드 수정</h4>
	           </div>
	           <div class="card-body">
	               <form action="updateSideAf.do" method="post" enctype="multipart/form-data" id="update_fileForm">
	                   <input type="hidden" name="image_Seq" id="update_image_Seq">
	                   <input type="hidden" name="seq" id="update_Seq">
	                   <input type="hidden" name="image_Src" id="original_image">
	                   <div class="form-body">
	                       <hr>
	                       <div class="row p-t-20">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                                   <label class="control-label">사이드명</label>
	                                   <input type="text" name="name" id="updatename" class="form-control" placeholder="사이드명" required="required">
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
                                                </select>
                                         </div>
	                           </div>
	                           <!--/span-->
	                       </div>
	                       <!--/row-->
	                       
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
	                       <button type="button" class="btn btn-success" id="updateSideBtn" onclick="updateSideAf()"> <i class="fa fa-check"></i> 등록</button>
	                       <button type="button" class="btn btn-inverse" data-dismiss="modal" id="updatesidecansel">취소</button>
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
  <div class="modal fade" id="deleteside">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal body -->
        <div class="modal-body">
     
         <div class="card card-outline-primary">
	           <div class="card-header">
	               <h4 class="m-b-0 text-white">사이드 삭제</h4>
	           </div>
	           <div class="card-body">
	               <form action="deleteSide.do" method="post">
	                   <div class="form-body">
						   <input type="hidden" id="deleteseq" name="del_seq">
						   <input type="hidden" id="delete_image_Seq" name="del_image_seq">
	                       <hr>
	                       <div class="row p-t-20">
	                           <div class="col-md-6">
	                               <div class="form-group">
	                               <button type="button" class="btn btn-success" id="deleteSideAfBtn" onclick="deleteSideAf()" style="width: 200px;"> <i class="fa fa-check" ></i> 삭제</button>
	                                   <small class="form-control-feedback"></small> </div>
	                           </div>
	                           <!--/span-->
	                           <div class="col-md-6">
	                               <div class="form-group has-danger">
										<button type="button" class="btn btn-inverse" style="width: 200px;" data-dismiss="modal" id="deletesidecansel">취소</button>
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
 * 재료등록
 *----------------------------------------------------------------------------------------------*/
function registerSideClick() {
	
	//입력란에 다 입력했는지 막아주기 
	if($("#name").val() == "" || $("#name").val() == null){
		alert("사이드명 입력해주세요");
		return;
	}else if($("#price").val() == "" || $("#price").val() == null){
		alert("가격을 입력해주세요");
		return;
	}else if($("#cal").val() == "" || $("#cal").val() == null){
		alert("칼로리를 입력해주세요");
		return;
	}else if(document.getElementById("image_src").files.length == 0){
		alert("사이드사진을 선택해주세요");
		return;
	}
	
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
            var imageurl = "'"+data.image_Src+"'";
          //성공시 테이블에 등록된 스토어 row추가 (맨 마지막줄)
 			$('#myTable tr:last').after('<tr id="tr'+data.seq+'">'+
			'<td><img alt="사이드사진" src="'+data.image_Src+'" style="width: 200px"></td>'+		
			'<td>'+data.name+'</td>'+
					'<td>'+data.price+'</td>'+
					'<td>'+data.cal+'</td>'+
					'<td id="td_seq'+data.seq+'"><input type="button" value="수정" class="btn btn-inverse" onclick="updateSide('+data.seq+','+data.image_Seq+','+imageurl+')" data-toggle="modal" data-target="#updateside">'+
					'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteSide('+data.seq+','+data.image_Seq+')" data-toggle="modal" data-target="#deleteside"></td>'+
					'</tr>');
 			
 			$("#addsidecansel").click();



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
  * side 수정 Ajax 
  *----------------------------------------------------------------------------------------------*/
 function updateSide(seq, imageSeq, imageSrc) {	
 		 
		
 	    alert(seq); 
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
 			url:"updateSide.do",			// side
 			type:'POST',
 			success:function(data){
 				
				console.log(data);
				document.getElementById('updatename').value = data.name;
				document.getElementById('updateprice').value = data.price;
				document.getElementById('updatecal').value = data.cal;
				
 				
 			},
 			error:function(req, status, error){
 				alert("error");
 			}
 		
 		});
 		
 			
 }
  
  
 
 /*---------------------------------------------------------------------------------------------
  * side 수정 완료 ajax
  *----------------------------------------------------------------------------------------------*/
 function updateSideAf() {	
 		 
		if($("#updatename").val() == "" || $("#updatename").val() == null){
			alert("사이드명을 입력해주세요");
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
	        url : 'updateSideAf.do',
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
	            
	            var deleteRow= "tr"+data.seq;
	            var tr = $("#"+deleteRow);
	            var td = tr.children();
	            
	            
	          //해당 테이블 로우 수정
	            td.eq(0).html('<img alt="사이드사진" src="'+data.image_Src+'" style="width: 200px">');
	            td.eq(1).text(data.name);
	            td.eq(2).text(data.price);
	            td.eq(3).text(data.cal);
	            td.eq(4).html('<input type="button" value="수정" class="btn btn-inverse" onclick="updateSide('+data.seq+','+data.image_Seq+','+imageurl+')" data-toggle="modal" data-target="#updateside">'+
						'&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="deleteSide('+data.seq+','+data.image_Seq+')" data-toggle="modal" data-target="#deleteside">');
	            
	            $("#updatesidecansel").click();



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
  * side 삭제 Ajax
  *----------------------------------------------------------------------------------------------*/
  var deleteRow; //지울 테이블 row저장
 function deleteSide(seq, imageSeq) {	

 	 
 	 	$("#delete_image_Seq").attr("value", imageSeq);
 	 	console.log("seq:"+seq);
 		$("#deleteseq").attr("value", seq);
 		console.log("imageSeq:"+imageSeq);
 		/* alert($("#deleteseq").val());	 */
 		
  			
  }
  

 /*---------------------------------------------------------------------------------------------
  * side 삭제 Ajax 완료 
  *----------------------------------------------------------------------------------------------*/
 function deleteSideAf() {	
  		 
  	 	
  	    /* alert("사이드  삭제 완료"); */
  		var data = {};

  		data["seq"]= $("#deleteseq").val();
  		data["image_Seq"]= $("#delete_image_Seq").val();
  		$.ajax({
  			contentType:'application/json',
  			dataType:'json',
  			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
  			url:"deleteSide.do",			// store
  			type:'POST',
  			success:function(data){
 				alert(data.msg);
 				
 				var deleteRowId =	"td_seq"+$("#deleteseq").val();
				 console.log(deleteRowId);
				 $("#"+deleteRowId).html('<p style="color: #a33b2b">삭제된 사이드입니다.</p>');   
				 
				 $("#deletesidecansel").click();

  					
  			},
  			error:function(req, status, error){
  				alert("error");
  			}
  		
  		});
  		
  			
  }
  

</script>
