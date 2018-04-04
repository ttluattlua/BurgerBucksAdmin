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
                  <h3 class="text-primary">Custom List</h3> </div>
              <div class="col-md-7 align-self-center">
                  <ol class="breadcrumb">
                      <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                      <li class="breadcrumb-item active">Custom List</li>
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
           <h4 class="card-title">고객 리스트</h4>
           <h6 class="card-subtitle">Custom List</h6>
           <div class="table-responsive m-t-40">
               <table id="myTable" class="table table-bordered table-striped" style="width: 80%">
               <col width="200"/><col width="200"/><col width="200"/><col width="200"/><col width="200"/>
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
							<a href="#" onclick="show('')"  class="settings" title="Settings">수정</a>
							<a href="#" onclick="ListDelete('${admin.seq}')" id="delete" class="delete" title="Delete" >삭제</a>
						</td>
                    </tr>
                   </c:forEach>
                   </tbody>
                   <tfoot>
			            <tr>
			                <th>Store Code</th>
	                        <th>ID</th>
	                        <th>Password</th>
	                        <th>Name</th>
	                        <th>Phone</th>
	                        <th>SET/DEL</th>
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
                html += '<thead><tr><th>Store Code</th><th>ID</th><th>Password</th><th>Name</th><th>Phone</th><th>SET/DEL</th></tr></thead>';
                html += '<tbody>';
                
                
                for(var i=0; i<data.length; i++){
                	
               	html += '<tr>';
                html += '<td>'+data[i].store_seq+'</td>';
                html += '<td>'+data[i].id+'</td>';
                html += '<td>'+data[i].password+'</td>';
                html += '<td>'+data[i].name+'</td>';
                html += '<td>'+data[i].phone+'</td>';
                html += '<td>'+data[i].id+'</td>';
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
</script>

