<%@page import="bba.com.a.model.Bb_AdminDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/> 

<%
String id="";
int store=-1;
Bb_AdminDto admin = new Bb_AdminDto();

if(session.getAttribute("login") != null){	
	admin = (Bb_AdminDto)session.getAttribute("login");
	id = admin.getId();
	store = admin.getStore_seq();
}
%>

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
     <!--========================== 고객 리스트 가져오기 ==============================-->
   <div class="card">
       <div class="card-body">
           <h4 class="card-title">고객 리스트</h4>
           <h6 class="card-subtitle">Customer List</h6>
           <div class="table-responsive m-t-40">
               <table id="myTable" class="table table-bordered table-striped">
                   <thead>
                       <tr>
                           <th></th>
                           <th>이메일</th>
                           <th>비밀번호</th>
                           <th>이름</th>
                           <th>연락처</th>
                           <th>등급</th>
                           <th>마일리지</th>
                           <th>생년월일</th>
                           <%if(store==0){ %>
                           <th></th>
                           <%} %>
                       </tr>
                   </thead>
                   <tbody>
                   <c:forEach items="${cList }" var="custom" varStatus="vs">
                   <c:if test="${custom.del eq '0'}">
                    <tr id="tr${custom.seq }">
                    	<td> ${vs.count}</td>
                        <td>${custom.id }</td>
                        <td>${custom.password }</td>
                        <td>${custom.name }</td>
                        <td>${custom.phone }</td>
                        <td>${custom.grade }</td>
                        <td>${custom.mileage }</td>
                        <td>${custom.bday }</td>
                        <%if(store==0){ %>
                        <td>
							<input type="button" id="${custom.seq}Btn" value="수정" class="btn btn-inverse" onclick="ListSet(${custom.seq})" data-toggle="modal" data-target="#updateCustomerModal" data-backdrop="static" data-keyboard="false"> 
                            <input type="button" value="삭제"  class="btn btn-inverse" onclick="ListDelete(${custom.seq})">
						</td>
						<%} %>
                    </tr>
                    </c:if>
                    
                    <c:if test="${custom.del eq '1'}">
                    <tr id="tr${custom.seq }">
                    	<td>삭제된 회원</td>
                        <td>${custom.id }</td>
                        <td>${custom.password }</td>
                        <td>${custom.name }</td>
                        <td>${custom.phone }</td>
                        <td>${custom.grade }</td>
                        <td>${custom.mileage }</td>
                        <td>${custom.bday }</td>
                        <%if(store==0){ %>
                        <td>
							<input type="button" id="${custom.seq}Btn" value="수정" class="btn btn-inverse" onclick="ListSet(${custom.seq})" data-toggle="modal" data-target="#updateCustomerModal" data-backdrop="static" data-keyboard="false"> 
                            <input type="button" value="삭제"  class="btn btn-inverse" onclick="ListDelete(${custom.seq})">
						</td>
						<%} %>
                    </tr>
                    </c:if>
                   </c:forEach>
                       
                   </tbody>
	            
                   <tfoot>
			        </tfoot>
               </table>
           </div>
       </div>
   </div>
   </div>
   </div>
   </div>
 
 
<script type="text/javascript">
/*---------------------------------------------------------------------------------------------
 * 테이블 리스트에서 삭제 클릭
 *----------------------------------------------------------------------------------------------*/

	function ListDelete(seq){
		alert("삭제 클릭");
		
		$.ajax({
            url : "delCustomer.do",
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
                    alert("존재하지 않는 고객입니다");
                    return false;
                }
                
                var div = document.querySelector('#myTable');
                var html = '<table>';
                html += '<col width="15%"/><col width="15%"/><col width="15%"/><col width="15%"/><col width="20%"/><col width="20%"/>';
                html += '<thead><tr><th>ID</th><th>Password</th><th>Name</th><th>Grade</th></thead>';
                html += '<tbody>';
                
                for(var i=0; i<data.length; i++){
                    
               	html += '<tr>';
                html += '<td>'+data[i].id+'</td>';
                html += '<td>'+data[i].password+'</td>';
                html += '<td>'+data[i].name+'</td>';
                html += '<td>'+data[i].grade+'</td>';
                html += '<td><input type="button" id="'+data[i].seq+'Btn" value="수정" class="btn btn-inverse" onclick="ListSet('+data[i].seq+')" data-toggle="modal" data-target="#updateCustomerModal" data-backdrop="static" data-keyboard="false"> ';
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
	
	
</script>



<!--========================== 고객 수정 모달창 ======================================= -->
 <!-- The Modal -->
  <div class="modal fade" id="updateCustomerModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
<!-- Modal body -->
<div class="modal-body">
	<div class="row">
   <div class="col-lg-12">
    <div class="card card-outline-primary">
       <div class="card-header">
           <h4 class="m-b-0 text-white">고객 수정</h4>
       </div>
       <div class="card-body">
           <form action="updateCustomerAf.do" method="post">
               <div class="form-body">
	   <input type="hidden" id="updateseq" name="seq">
	   
                  <hr>
                 
               
                  <!-- 개인 정보 -->
                  <div class="row">
                      <div class="col-md-9">
                          <div class="form-group">
                              <label class="control-label">이름</label>
                              <input type="text" name="updatename" id="_updatename" class="form-control" placeholder="이름" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      
                      <div class="col-md-3">
                          <div class="form-group">
                              <label class="control-label">성별</label>
                              <select class="form-control" onchange="document.getElementById('_updatesex').value = this.options[this.selectedIndex].value">
								<option selected value=''>선택하세요</option> 
								<option value='0'>남자</option>
								<option value='1'>여자</option>
							  </select>
                              <input type="text" name="updatesex" id="_updatesex" class="form-control" placeholder="성별" required="required" readonly="readonly">
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
                      
                      <div class="row">
                      <div class="col-md-6">
                          <div class="form-group">
                              <label class="control-label">전화번호</label>
                              <input type="text" name="updatephone" id="_updatephone" class="form-control" placeholder="전화번호" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      
                      <div class="col-md-6">
                          <div class="form-group">
                              <label class="control-label">생년월일</label>
                              <input type="date" name="updatebday" id="_updatebday" value="" class="form-control" placeholder="생년월일" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      </div>
                      
                      
                       <div class="row">
                      <div class="col-md-4">
                          <div class="form-group">
                              <label class="control-label">마일리지</label>
                              <input type="text" name="updatemileage" id="_updatemileage" class="form-control" placeholder="마일리지" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      
                      <div class="col-md-4">
                          <div class="form-group">
                              <label class="control-label">Grade</label>
                              <input type="text" name="updategrade" id="_updategrade" class="form-control" placeholder="Grade" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      
                      <div class="col-md-4">
                          <div class="form-group">
                              <label class="control-label">EXP</label>
                              <input type="text" name="updateexp" id="_updateexp" class="form-control" placeholder="EXP" required="required">
                              <small class="form-control-feedback"></small></div>
                      </div>
                      </div>
      
              </div>
              <div class="form-actions" align="right">
                  <button type="button" class="btn btn-success" id="updateCustomerAfBtn" onclick="updateCustomerAf()" data-target="#CompanyProfile"> <i class="fa fa-check"></i> 수정</button>
                  <button type="button" class="btn btn-success" id="deleteCustomerAfBtn" onclick="deleteCustomerAf()"> <i class="fas fa-minus"></i> 삭제</button>
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
/*---------------------------------------------------------------------------------------------
 * store 수정 Ajax (주소는 : 우편번호#도로명주소#지번주소#상세주소 로 가져가서 저장- 나중에 데이터 보여줄때는 #으로 자를거임)
 *----------------------------------------------------------------------------------------------*/

function ListSet(seq) {	
		 
	    alert("고객 수정클릭");
	    alert(seq);
		
	    var data = {};
	    
		data["seq"]=seq;
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
			url:"updateCustomer.do",			
			type:'POST',
			success:function(data){
				
				alert(data.map.id);
				
				/* var sex = "";
				if(data.map.sex==0){
					sex="남자";
				}else{
					sex="여자";
				} */
				/* 
				var ddate = (data.map.bday).split("/");
				var date = "20"+ddate[0]+"-"+ddate[1]+"-"+ddate[2];
				 */
				alert(data.map.bday);
				document.getElementById('_updatename').value = data.map.name;
				document.getElementById('_updateid').value = data.map.id;
				document.getElementById('_updatesex').value = data.map.sex;
				document.getElementById('_updatepassword').value = data.map.password;
				document.getElementById('_updatephone').value = data.map.phone;
				document.getElementById('_updatebday').value = data.map.bday;
				document.getElementById('_updatemileage').value = data.map.mileage;
				document.getElementById('_updategrade').value = data.map.grade;
				document.getElementById('_updateexp').value = data.map.exp;
				document.getElementById('updateseq').value = seq;
				
			},
			error:function(req, status, error){
				alert("error");
			}
		
		});
		
			
}


function updateCustomerAf() {	
		 
	    alert("사원 수정완료클릭");
	    
		
	    var data = {};
		var seq = document.getElementById('updateseq').value;
	    var name= document.getElementById('_updatename').value;
	    var id= document.getElementById('_updateid').value;
	    var password= document.getElementById('_updatepassword').value;
	    var phone= document.getElementById('_updatephone').value;
	    var sex= document.getElementById('_updatesex').value;
	    var bday= document.getElementById('_updatebday').value;
	    var mileage= document.getElementById('_updatemileage').value;
	    var grade = document.getElementById('_updategrade').value;
	    var exp = document.getElementById('_updateexp').value;
	    alert(bday);
	    
	    /* var ddate = bday.split("-");
	    var year = ddate[0].substr(2,4);
	    var month = ddate[1];
	    var day = ddate[2];
	    
	    var ccbday = year+"/"+month+"/"+day;
	     */
		data["seq"]=seq;
		data["name"]=name;
		data["id"]=id;
		data["password"]=password;
		data["phone"]=phone;
		data["sex"]=sex;
		data["bday"]=bday;
		data["mileage"]=mileage;
		data["grade"]=grade;
		data["exp"]=exp;
		
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
			url:"updateCustomerAf.do",			// store
			type:'POST',
			
			success:function(data){
				alert("수정완료");
				$("#updateCustomerModal").modal('hide');
				$('.modal-backdrop').remove();
				//해당 테이블 row일단 삭제
				var deleteRowId = "tr"+$("#updateseq").val();
				deleteTableRow(deleteRowId);
				
				//수정된걸로 다시생성
				$('#myTable tr:last').after(
						'<tr id="tr'+data.map.seq+'">'+
						'<td>'+"수정"+'</td>'+
						'<td>'+data.map.id+'</td>'+
						'<td>'+data.map.password+'</td>'+
						'<td>'+data.map.name+'</td>'+
						'<td>'+data.map.phone+'</td>'+
						'<td>'+data.map.grade+'</td>'+
						'<td>'+data.map.mileage+'</td>'+
						'<td>'+data.map.bday+'</td>'+
						'<td style="text-align: right;"><input type="button" value="수정" class="btn btn-inverse" onclick="ListSet('+data.map.seq+')" data-toggle="modal" data-target="#updateCustomerModal" data-backdrop="static" data-keyboard="false">&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="ListDelete('+data.map.seq+')"></td>'
						+'</tr>');
				
				
			},
			error : function(request,status,error){
	               alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
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
  


