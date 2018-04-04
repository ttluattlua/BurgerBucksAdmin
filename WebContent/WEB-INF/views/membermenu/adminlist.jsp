<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/> 

<!-- icon 불러오기 -->
<!--core first + styles last-->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>



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
           <h4 class="card-title">사원 리스트</h4>
           <h6 class="card-subtitle">Branch Manager List</h6>
           <div class="table-responsive m-t-40">
               <table id="myTable" class="table table-bordered table-striped">
               <col width="10%"/><col width="20%"/><col width="20%"/><col width="20%"/><col width="10%"/><col width="10%"/>
                   <thead>
                    <tr>
                    	<th>Store Code</th>
                        <th>ID</th>
                        <th>Password</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>SET/DEL</th>
                    </tr>
	                </thead>
	                <tbody>
                   <c:forEach items="${aList}" var="admin" varStatus="vs">
                    <tr>
                        <td>${admin.store_seq }</td>
                        <td>${admin.id }</td>
                        <td>${admin.password }</td>
                        <td>${admin.name }</td>
                        <td>${admin.phone }</td>
                        <td>
							<input type="button" id="${admin.seq}Btn" value="수정" class="btn btn-inverse" onclick="ListSet(${admin.seq})" data-toggle="modal" data-target="#updateAdmin"> 
                            <input type="button" value="삭제"  class="btn btn-inverse" onclick="ListDelete(${admin.seq})">
						</td>
                    </tr>
                   </c:forEach>
                   </tbody>
                   <tfoot>
			            <tr>
			               
			            </tr>
			        </tfoot>
               </table>
           </div>
       </div>
   </div>
   </div>
   </div>
   </div>
             
<!--              
<script>
//테이블 클릭
$(document).ready(function() {
    var table = $('#myTable').DataTable();
     
    $('#myTable tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        alert( 'You clicked on '+data[0]+'\'s row' );
    } );
} );
</script>   
 -->
 
<script type="text/javascript">
	function ListDelete(seq){
		alert("삭제 클릭");
		
		$.ajax({
            url : "deladmin.do",
            type: "get",
            data : { "seq" : seq },
            dataType: 'json',
    		contentType : "application; charset=utf-8",
    		traditional : true,
            success : function(data){
                //$("#ajax").remove();
                
                alert(JSON.stringify(data));
                //alert("성공" + data);
                alert("길이 : " +data.length);
                alert(data[0].id);
                if(!data){
                    alert("존재하지 않는 ID입니다");
                    return false;
                }
                
                var div = document.querySelector('#myTable');
                var html = '<table>';
                html += '<col width="10%"/><col width="20%"/><col width="20%"/><col width="20%"/><col width="10%"/><col width="10%"/>';
                html += '<thead><tr><th>Store Code</th><th>ID</th><th>Password</th><th>Name</th><th>Phone</th><th>SET/DEL</th></tr></thead>';
                html += '<tbody>';
                
                for(var i=0; i<data.length; i++){
                    
               	html += '<tr>';
                html += '<td>'+data[i].store_seq+'</td>';
                html += '<td>'+data[i].id+'</td>';
                html += '<td>'+data[i].password+'</td>';
                html += '<td>'+data[i].name+'</td>';
                html += '<td>'+data[i].phone+'</td>';
                html += '<td><input type="button" id="'+data[i].seq+'Btn" value="수정" class="btn btn-inverse" onclick="ListSet('+data[i].seq+')" data-toggle="modal" data-target="#updateAdmin"> ';
				html += '<input type="button" value="삭제"  class="btn btn-inverse" onclick="ListDelete('+data[i].seq+')">';
                html += '</tr>';

                }
                
                html += '</tbody></table>';
                
                div.innerHTML = html;
                //$(".container-fluid").after(html);
                
            },error : function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
	}
	
	
	
	
	function ListSet(seq){
		alert("수정");
	
	}
</script>



<!--==========================Admin 수정 모달창======================================= -->
 <!-- The Modal -->
  <div class="modal fade" id="updateAdmin">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
<!-- Modal body -->
<div class="modal-body">
	<div class="row">
   <div class="col-lg-12">
    <div class="card card-outline-primary">
       <div class="card-header">
           <h4 class="m-b-0 text-white">사원 수정</h4>
       </div>
       <div class="card-body">
           <form action="updateAdminAf.do" method="post">
               <div class="form-body">
	   <input type="hidden" id="update_latLng" name="updatelatlng">
	   <input type="hidden" id="updateseq" name="seq">
	   <input type="hidden" id="Beforejibun" name="Beforejibun"> <!--업데이트 전 이름 -->
                  <hr>
                  <div class="row p-t-20">
                      <div class="col-md-6">
                          <div class="form-group">
                              <label class="control-label">지점명</label>
                              <input type="text" name="updatestorename" id="_updatestorename" class="form-control" placeholder="지점명" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      
                      <div class="col-md-6">
                          <div class="form-group">
                              <label class="control-label">지점코드</label>
                              <input type="text" name="updatestorecode" id="_updatestorecode" class="form-control" placeholder="지점코드" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      </div>
                      
                      <div class="row">
                      <div class="col-md-12">
                          <div class="form-group">
                              <label class="control-label">전화번호</label>
                              <input type="text" name="updatephone" id="_updatephone" class="form-control" placeholder="전화번호" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      </div>
                      
                      <hr>
                      
                      <div class="row">
                      <div class="col-md-12">
                          <div class="form-group">
                              <label class="control-label">이름</label>
                              <input type="text" name="updatename" id="_updatename" class="form-control" placeholder="이름" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      </div>
                      
                      <div class="row">
                      <div class="col-md-6">
                          <div class="form-group">
                              <label class="control-label">아이디</label>
                              <input type="text" name="updateid" id="_updateid" class="form-control" placeholder="아이디" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      
                      <div class="col-md-6">
                          <div class="form-group">
                              <label class="control-label">비밀번호</label>
                              <input type="text" name="updatepassword" id="_updatepassword" class="form-control" placeholder="비밀번호" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      </div>
                    
<!-- 
                   <div class="row">
                      <div class="col-md-6">
                          <div class="form-group">
                              <label>Post Code</label>
                              <input type="text" name="postcode" class="form-control" id="update_postcode" placeholder="우편번호" readonly="readonly" required="required">
                          </div>
                      </div>
                      /span
                      <div class="col-md-6">
                          <div class="form-group">
				<input type="button" onclick="DaumPostcode(1)" value="우편번호 찾기" class="btn btn-inverse" style="margin-top: 30px;">
                          </div>
                      </div>
                      /span
                  </div> -->
                  
              </div>
              <div class="form-actions" align="right">
                  <button type="button" class="btn btn-success" id="updateStoreAfBtn" onclick="updateAdminAf()"> <i class="fa fa-check"></i> 수정</button>
                  <button type="button" class="btn btn-success" id="updateStoreAfBtn" onclick="updateStoreAf()"> <i class="fas fa-minus"></i> 삭제</button>
                  <button type="button" class="btn btn-inverse" data-dismiss="modal">취소</button>
              </div>
          </form>
      </div>
     </div>
    </div> <!--왼쪽 사이드 -->
  </div><!-- ROW -->
</div>
        

      </div>
    </div>
  </div>
  
  
  

<script>
$(document).ready(function() {
    $('#myTable').DataTable();
    $(document).ready(function() {
        var table = $('#example').DataTable({
            "columnDefs": [{
                "visible": true,
                "targets": 2
            }],
            "order": [
                [2, 'asc']
            ],
            "displayLength": 25,
            "drawCallback": function(settings) {
                var api = this.api();
                var rows = api.rows({
                    page: 'current'
                }).nodes();
                var last = null;
                api.column(2, {
                    page: 'current'
                }).data().each(function(group, i) {
                    if (last !== group) {
                        $(rows).eq(i).before('<tr class="group"><td colspan="7">' + group + '</td></tr>');
                        last = group;
                    }
                });
            }
        });
    });
});
</script>

