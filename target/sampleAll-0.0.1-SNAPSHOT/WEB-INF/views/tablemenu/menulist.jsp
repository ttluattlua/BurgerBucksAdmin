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
                    <h4 class="card-title">메뉴 현황</h4>
                    <h6 class="card-subtitle">등록된 메뉴 현황</h6>
                    <div class="table-responsive m-t-40">

						<!--===========================메뉴테이블 ===================================-->
                        <table id="myTable" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>메뉴명</th>
                                    <th>버거</th>
                                    <th>사이드</th>
                                    <th>음료</th>
                                    <th>만든사람</th>
                                    <th>가격</th>
                                    <th>칼로리</th>
                                    <th>--</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="bmdto" items="${mList}">

                                <tr id="tr${bmdto.seq}">
                                	
                                    <td>${bmdto.name }</td>
                                    <td>${bmdto.burger_name }</td>
                                    <td>${bmdto.side_name }</td>
                                    <td>${bmdto.beverage_name }</td>
                                    <td>${bmdto.creatorID }</td>
                                    <td>${bmdto.price }</td>
                                    <td>${bmdto.cal }</td>
                                    <td id="td_seq${bmdto.seq}">
	                                    <c:if test="${bmdto.del == 0}">
	                                    <input type="button" id="${bmdto.seq}Btn" value="상세보기" class="btn btn-inverse" onclick='detailMenuFunc(${bmdto})' data-toggle="modal" data-target="#detailMenuModal"> 
	                                    <input type="button" value="삭제"  class="btn btn-inverse" onclick="deleteMenu(${bmdto.seq })" data-toggle="modal" data-target="#deletemenu">
	                                    </c:if>
	                                    
	                                    <c:if test="${bmdto.del != 0}">
	                                   		<p style="color: #a33b2b">삭제된 메뉴입니다.</p>
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
                
                
		                
		<!--==========================재료 상세보기 모달창======================================= -->
		 <!-- The Modal -->
		  <div class="modal fade" id="detailMenuModal">
		    <div class="modal-dialog modal-lg">
		      <div class="modal-content">
		      
		        <!-- Modal body -->
		        <div class="modal-body">
			         <div class="card card-outline-primary">
				           <div class="card-header">
				               <h4 class="m-b-0 text-white">메뉴 상세보기</h4>
				           </div>
				           <div class="card-body">
				               <form action="registerStore.do" method="post">
				                   <div class="form-body">
									   <input type="hidden" id="seq" name="_seq">
				                       <hr>
				                       <div class="row p-t-20">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label class="control-label">메뉴명</label>
				                                   <input type="text" name="name" id="_name" class="form-control" value="" readonly="readonly">
				                                   <small class="form-control-feedback"></small></div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group has-danger">
				                                   <label class="control-label">만든사람</label>
				                                   <input type="text" name="creatorID" id="_creatorID" class="form-control form-control-danger" value="" readonly="readonly">
				                                   <small class="form-control-feedback"></small> </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <!--/row-->
				                       
				                       <div class="row p-t-20">
				                           <div class="col-md-6">
				                               <div class="form-group">
				                                   <label class="control-label">가격(원)</label>
				                                   <input type="text" name="price" id="_price" class="form-control" value="" readonly="readonly">
				                                   <small class="form-control-feedback"></small></div>
				                           </div>
				                           <!--/span-->
				                           <div class="col-md-6">
				                               <div class="form-group has-danger">
				                                   <label class="control-label">칼로리</label>
				                                   <input type="text" name="cal" id="_cal" class="form-control form-control-danger" value="" readonly="readonly">
				                                   <small class="form-control-feedback"></small> </div>
				                           </div>
				                           <!--/span-->
				                       </div>
				                       <!--/row-->
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>햄버거</label>
				                                   <table table id="myTable" class="table table-bordered table-striped">
				                                   <colgroup>
				                                   	<col width="20%"><col width="20%"><col width="30%"><col width="15%"><col width="15%">
				                                   </colgroup>
				                                   	<thead>
				                                   		<th>사진</th>
				                                   		<th>햄버거명</th>
				                                   		<th>재료</th>
				                                   		<th>가격</th>
				                                   		<th>칼로리</th>
				                                   	</thead>
				                                   	<tbody>
				                                   		<td id="t_burger_picture"></td>
				                                   		<td id="t_burger_name"></td>
				                                   		<td id="t_burger_ingredients"></td>
				                                   		<td id="t_burger_price"></td>
				                                   		<td id="t_burger_cal"></td>
				                                   	</tbody>
				                                   </table>
				                                  
				                               </div>
				                           </div>
				                       </div>
				                       <!--/row-->
				                       <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>사이드</label>
				                                   <table table id="myTable" class="table table-bordered table-striped">
				                                   <colgroup>
				                                   	<col width="25%"><col width="25%"><col width="25%"><col width="25%">
				                                   </colgroup>
				                                   	<thead>
				                                   		<th>사진</th>
				                                   		<th>사이드명</th>
				                                   		<th>가격</th>
				                                   		<th>칼로리</th>
				                                   	</thead>
				                                   	<tbody>
				                                   		<td id="t_side_picture" ></td>
				                                   		<td id="t_side_name"></td>
				                                   		<td id="t_side_price"></td>
				                                   		<td id="t_side_cal"></td>
				                                   	</tbody>
				                                   </table>
				                                  
				                               </div>
				                           </div>
				                       </div>
				         			  <div class="row">
				                           <div class="col-md-12 ">
				                               <div class="form-group">
				                                   <label>음료</label>
				                                   <table table id="myTable" class="table table-bordered table-striped">
				                                   <colgroup>
				                                   	<col width="25%"><col width="25%"><col width="25%"><col width="25%">
				                                   </colgroup>
				                                   	<thead>
				                                   		<th>사진</th>
				                                   		<th>음료명</th>
				                                   		<th>가격</th>
				                                   		<th>칼로리</th>
				                                   	</thead>
				                                   	<tbody>
				                                   		<td id="t_beverage_picture">
				                                   			
				                                   		</td>
				                                   		<td id="t_beverage_name"></td>
				                                   		<td id="t_beverage_price"></td>
				                                   		<td id="t_beverage_cal"></td>
				                                   	</tbody>
				                                   </table>                         		
				                               </div>
				                           </div>
				                       </div>
				
				                   </div>
				                   <div class="form-actions" align="right">
				                       <button type="button" class="btn btn-success" id="registerStoreBtn" onclick="d()"> <i class="fa fa-check"></i> 삭제</button>
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
  <div class="modal fade" id="deletemenu">
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
		  
		  

<script>
function detailMenuFunc(object) {
	console.log(object);

	var obj = JSON.stringify(object);
	console.log(obj);
	var bmdto =  JSON.parse(obj);
	//세팅해주기 
	$("#_seq").attr("value", bmdto.seq);		//메뉴시퀀스
	$("#_name").attr("value", bmdto.name);		//메뉴이름
	$("#_creatorID").attr("value", bmdto.creatorID);	//메뉴만든이
	$("#_price").attr("value", bmdto.price);			//메뉴가격
	$("#_cal").attr("value", bmdto.cal);				//메뉴칼로리
	$("#t_burger_name").html(bmdto.burger_name);		//버거이름
	$("#t_side_name").html(bmdto.side_name);		//사이드이름
	$("#t_beverage_name").html(bmdto.beverage_name);		//사이드이름
	
    var data = {};
    
	data["seq"]=bmdto.seq;
	data["burger_seq"]=bmdto.burger_seq;
	data["side_seq"]=bmdto.side_seq;
	data["beverage_seq"]=bmdto.beverage_seq;
	
	$.ajax({
		contentType:'application/json',
		dataType:'json',
		data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
		url:"menuDetail.do",			// 재료
		type:'POST',
		success:function(data){
		var side = JSON.parse(data.sideJson);
		var bev = JSON.parse(data.bevJson);
		console.log(side);
		console.log(bev);
		
		if(side != null){
			$("#t_side_picture").html('<img alt="" src="'+side.image_Src+'" style="width: 100px; height: 100px">');
			$("#t_side_name").html(side.name);
			$("#t_side_price").html(side.price);
			$("#t_side_cal").html(side.cal);
		}else{
			$("#t_side_picture").html('x');
			$("#t_side_name").html('x');
			$("#t_side_price").html('x');
			$("#t_side_cal").html('x');
		}
		
		if(bev != null){
			$("#t_beverage_picture").html('<img alt="" src="'+bev.image_Src+'" style="width: 100px; height: 100px">');
			$("#t_beverage_name").html(bev.name);
			$("#t_beverage_price").html(bev.price);
			$("#t_beverage_cal").html(bev.cal);
		}else{
			$("#t_beverage_picture").html('x');
			$("#t_beverage_name").html('x');
			$("#t_beverage_price").html('x');
			$("#t_beverage_cal").html('x');
		}

		},
		error:function(req, status, error){
			alert("error");
		}
	
	});
 		
	
}


/*---------------------------------------------------------------------------------------------
 * 메뉴 삭제 Ajax
 *----------------------------------------------------------------------------------------------*/

function deleteMenu(seq) {	

	 	console.log("seq:"+seq);
		$("#deleteseq").attr("value", seq);
		
 			
 }
 

/*---------------------------------------------------------------------------------------------
 * side 삭제 Ajax 완료 
 *----------------------------------------------------------------------------------------------*/
function deleteSideAf() {	
 		 
 	 	
 	    /* alert("사이드  삭제 완료"); */
 		var data = {};

 		data["seq"]= $("#deleteseq").val();
 		$.ajax({
 			contentType:'application/json',
 			dataType:'json',
 			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
 			url:"deleteMenu.do",			// store
 			type:'POST',
 			success:function(data){
				alert(data.msg);
				
				var deleteRowId =	"td_seq"+$("#deleteseq").val();
				 console.log(deleteRowId);
				 $("#"+deleteRowId).html('<p style="color: #a33b2b">삭제된 메뉴입니다.</p>');   
					
 					
 			},
 			error:function(req, status, error){
 				alert("error");
 			}
 		
 		});
 		
 			
 }



</script>
