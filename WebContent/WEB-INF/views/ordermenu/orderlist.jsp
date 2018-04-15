<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/> 



<!-- icon 불러오기 -->
<!--core first + styles last-->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="./DataTables/datatables.min.css"/>
<script type="text/javascript" src="./DataTables/datatables.min.js"></script>


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
     <!--========================== 주문 리스트 가져오기 ==============================-->

   
      <div class="card">
       <div class="card-body">
           <h4 class="card-title">주문 리스트</h4>
           <h6 class="card-subtitle">Order List</h6>
           <div class="table-responsive m-t-40">
           <div>
           <hr>
           	<button id="btn-show-all-children" type="button" class="btn btn-inverse" >Expand All</button>
			<button id="btn-hide-all-children" type="button" class="btn btn-inverse" >Collapse All</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div style="text-align: right;">
			<i class="material-icons">shopping_cart</i> 장바구니 / 
			<i class="material-icons">payment</i> 주문완료 / 
			<i class="material-icons">room_service</i> 준비중 / 
			<i class="material-icons">directions_bike</i> 배달시작 / 
			<i class="material-icons">assignment_turned_in</i> 배달완료 / 
			</div>
           </div>




<table id="orderTable" class="display" cellspacing="0" width="100%">
    <thead>
        <tr>
        	<th>No</th>
            <th>점포명</th>
            <th>주문자</th>
            <th>연락처</th>
            <th>주문일자</th>
            <th>현재상태</th>
            <th>상태변경</th>
            <th></th>
            <th class="none">배송지</th>
            <th class="none">배송지 메모</th>
            <th class="none">주문번호</th>
            <th class="none">메뉴 seq</th>
            <th class="none">수량</th>
            <th class="none">가격</th>
        </tr>
    </thead>
    <tfoot>
        <tr>
            <th>No</th>
            <th>점포명</th>
            <th>주문자</th>
            <th>연락처</th>
            <th>주문일자</th>
            <th>현재상태</th>
            <th>상태변경</th>
            <th></th>
            <th>배송지</th>
            <th>배송지 메모</th>
            <th>주문번호</th>
            <th>메뉴 seq</th>
            <th>수량</th>
            <th>가격</th>
            
        </tr>
    </tfoot>
    <tbody>
    
    <!-- private int seq;
	private int member_seq;
	private int member_addr;
	private int store_seq;
	private String date;
	private int status;
	private int del; -->
    
   <!--  model.addAttribute("olist", olist);
		model.addAttribute("memberList", memberList);
		model.addAttribute("addrList", addrList);
		model.addAttribute("storeList", storeList); -->
	
	
<%-- 	JSTL 문법의 for문 사용법
<c:forEach items="${리스트가 받아올 배열이름}" var=$"{for문안에서 사용할 변수}" varStatus="status">
status 는 for문의 돌아가는 상태를 알 수 있게 체크하여 준다

#{status.current}   현재의 for문에 해당하는 번호
#{status.index} 0부터의 순서
#{status.count} 1부터의 순서
#{status.first}  현재 루프가 처음인지 확인
#{status.last}  현재 루프가 마지막인지 확인
#{status.begin} for문의 시작 값
#{status.end}   for문의 끝 값
#{status.step}  for문의 증가값 --%>
	
	<!-- order menu -->
	<c:set var="orderMenuList" value="${orderMenuList }" />
	
	<!-- member list -->
	<c:set var="memberList" value="${memberList }" />
	
	<!-- address list -->
	<c:set var="addrList" value="${addrList }" />
	
	<!-- store list -->
	<c:set var="storeList" value="${storeList }" />
	
	<!-- order list -->
	
	
	<c:set var="i" value="0" />
    <c:forEach items="${olist}" var="order" varStatus="status">
   


        <tr id="tr${order.seq}">
        	<!-- 기본 정보 -->
        	
        	<!-- no -->
            <td>${status.count}</td>
            <!-- 점포명 -->
            <td>${storeList[i].name }</td>
            <!-- 주문자 -->
            <td>${memberList[i].id }</td>
            <!-- 연락처 -->
            <td>${memberList[i].phone }</td>
            <!-- 주문일자 -->
            <td>${order.order_date }</td>
            
            
			<!-- 현재 주문 상태 아이콘 -->
            <td>
			<c:choose>

		    <c:when test="${order.status eq '0'}">
            <i class="material-icons">shopping_cart</i>
		    </c:when>

		    <c:when test="${order.status eq '1'}">
            <i class="material-icons">payment</i>
		    </c:when>
		    
		    <c:when test="${order.status eq '2'}">
            <i class="material-icons">room_service</i>
		    </c:when>
		    
		    <c:when test="${order.status eq '3'}">
            <i class="material-icons">directions_bike</i>
		    </c:when>
		   
		    <c:otherwise>
            <i class="material-icons">assignment_turned_in</i>
		    </c:otherwise>

			</c:choose>
            </td>
            
            
            <!-- 상태 변경하기 -->
            <td>
            <select name="oSelect" title="선택하세요" class="form-control">
		    
		      <option value='0' <c:if test="${order.status eq '0'}">selected</c:if>>장바구니</option>
		      <option value='1' <c:if test="${order.status eq '1'}">selected</c:if>>주문완료</option>
		      <option value='2' <c:if test="${order.status eq '2'}">selected</c:if>>준비중</option>
		      <option value='3' <c:if test="${order.status eq '3'}">selected</c:if>>배달시작</option>
		      <option value='4' <c:if test="${order.status eq '4'}">selected</c:if>>배달완료</option>
		    </select>

			</td>
            <td style="text-align: right;">
            <button id="save" type="button" class="btn btn-inverse" onclick="saveOSelect(${order.seq})" >저장</button>
            </td>
            
            
            <!-- 상세정보 -->
            <td>${addrList[i].address }</td>
            <td>${addrList[i].memo }</td>

            <td>${orderMenuList[i].order_seq }</td>
            <td>${orderMenuList[i].menu_seq }</td>
            <td>${orderMenuList[i].quantity }</td>
            <td>${orderMenuList[i].price }</td>
            
        </tr>
        <c:set var="i" value="${i+1 }"></c:set>
    </c:forEach>
    </tbody>
</table>
           </div>
       </div>
   </div>
   
   
   </div>
   </div>
   </div>
   

   <script>
   
   $(document).ready(function (){
	    var table = $('#orderTable').DataTable({
	        'responsive': true
	    });

	    // Handle click on "Expand All" button
	    $('#btn-show-all-children').on('click', function(){
	        // Expand row details
	        table.rows(':not(.parent)').nodes().to$().find('td:first-child').trigger('click');
	    });

	    // Handle click on "Collapse All" button
	    $('#btn-hide-all-children').on('click', function(){
	        // Collapse row details
	        table.rows('.parent').nodes().to$().find('td:first-child').trigger('click');
	    });
	});
   </script>

   
   
  
<script type="text/javascript">
/*---------------------------------------------------------------------------------------------
 * 상태 변경 클릭
 *----------------------------------------------------------------------------------------------*/

	function saveOSelect(seq){
		alert("상태 수정 클릭");
		
		$.ajax({
            url : "changeOrder.do",
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
                html += '<col width="15%"/><col width="15%"/><col width="15%"/><col width="15%"/><col width="20%"/><col width="20%"/>';
                html += '<thead><tr><th>Store Code</th><th>ID</th><th>Password</th><th>Name</th><th>Phone</th><th>SET/DEL</th></tr></thead>';
                html += '<tbody>';
                
                for(var i=0; i<data.length; i++){
                    if(data[i].del==0){
		               	html += '<tr>';
		                html += '<td>'+data[i].store_seq+'</td>';
		                html += '<td>'+data[i].id+'</td>';
		                html += '<td>'+data[i].password+'</td>';
		                html += '<td>'+data[i].name+'</td>';
		                html += '<td>'+data[i].phone+'</td>';
		                html += '<td><input type="button" id="'+data[i].seq+'Btn" value="수정" class="btn btn-inverse" onclick="ListSet('+data[i].seq+')" data-toggle="modal" data-target="#updateAdmin"> ';
						html += '<input type="button" value="삭제"  class="btn btn-inverse" onclick="ListDelete('+data[i].seq+')">';
		                html += '</tr>';
                    }else{
                    	html += '<tr>';
		                html += '<td>'+"삭제된 회원"+'</td>';
		                html += '<td>'+data[i].id+'</td>';
		                html += '<td>'+data[i].password+'</td>';
		                html += '<td>'+data[i].name+'</td>';
		                html += '<td>'+data[i].phone+'</td>';
		                html += '<td><input type="button" id="'+data[i].seq+'Btn" value="수정" class="btn btn-inverse" onclick="ListSet('+data[i].seq+')" data-toggle="modal" data-target="#updateAdmin"> ';
						html += '<input type="button" value="회복"  class="btn btn-inverse" onclick="ListRecovery('+data[i].seq+')">';
		                html += '</tr>';
                    }
                }
                
                html += '</tbody></table>';
                
                div.innerHTML = html;
                //$(".container-fluid").after(html);

            
                $(document).ready(function() {
                	  $.fn.DataTable.ext.pager.numbers_length = 5;
                	    $('#myTable').DataTable( {
                	       "pagingType":"full_numbers",
                	    } );  
                	} );
                
            },error : function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
	}
	 
	 
	/*---------------------------------------------------------------------------------------------
	 * 테이블 리스트에서 회복 클릭
	 *----------------------------------------------------------------------------------------------*/

		function ListRecovery(seq){
			alert("회복 클릭");
			
			$.ajax({
	            url : "recoveryAdmin.do",
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
	                html += '<col width="15%"/><col width="15%"/><col width="15%"/><col width="15%"/><col width="20%"/><col width="20%"/>';
	                html += '<thead><tr><th>Store Code</th><th>ID</th><th>Password</th><th>Name</th><th>Phone</th><th>SET/DEL</th></tr></thead>';
	                html += '<tbody>';
	                
	                for(var i=0; i<data.length; i++){
	                    if(data[i].del==0){
			               	html += '<tr>';
			                html += '<td>'+data[i].store_seq+'</td>';
			                html += '<td>'+data[i].id+'</td>';
			                html += '<td>'+data[i].password+'</td>';
			                html += '<td>'+data[i].name+'</td>';
			                html += '<td>'+data[i].phone+'</td>';
			                html += '<td><input type="button" id="'+data[i].seq+'Btn" value="수정" class="btn btn-inverse" onclick="ListSet('+data[i].seq+')" data-toggle="modal" data-target="#updateAdmin"> ';
							html += '<input type="button" value="삭제"  class="btn btn-inverse" onclick="ListDelete('+data[i].seq+')">';
			                html += '</tr>';
	                    }else{
	                    	html += '<tr>';
			                html += '<td>'+"삭제된 회원"+'</td>';
			                html += '<td>'+data[i].id+'</td>';
			                html += '<td>'+data[i].password+'</td>';
			                html += '<td>'+data[i].name+'</td>';
			                html += '<td>'+data[i].phone+'</td>';
			                html += '<td><input type="button" id="'+data[i].seq+'Btn" value="수정" class="btn btn-inverse" onclick="ListSet('+data[i].seq+')" data-toggle="modal" data-target="#updateAdmin"> ';
							html += '<input type="button" value="회복"  class="btn btn-inverse" onclick="ListRecovery('+data[i].seq+')">';
			                html += '</tr>';
	                    }
	                }
	                
	                html += '</tbody></table>';
	                
	                div.innerHTML = html;
	                //$(".container-fluid").after(html);

	            
	                $(document).ready(function() {
	                	  $.fn.DataTable.ext.pager.numbers_length = 5;
	                	    $('#myTable').DataTable( {
	                	       "pagingType":"full_numbers",
	                	    } );  
	                	} );
	                
	            },error : function(request,status,error){
	                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            }
	        });
		}
		 	
	


/*---------------------------------------------------------------------------------------------
 * 사원 수정
 *----------------------------------------------------------------------------------------------*/
function ListSet(seq) {	
		 
	    alert("사원 수정클릭");
	    alert(seq);
    
		
	    var data = {};
	    
		data["seq"]=seq;
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
			url:"updateAdmin.do",			// admin
			type:'POST',
			success:function(data){
				
				alert(data.map.id);
				
				document.getElementById('_updatename').value = data.map.name;
				document.getElementById('_updateid').value = data.map.id;
				document.getElementById('_updatepassword').value = data.map.password;
				document.getElementById('_updatestorename').value = data.map.store_seq;
				document.getElementById('_updatestorecode').value = data.map.store_seq;
				document.getElementById('_updatephone').value = data.map.phone;
				document.getElementById('updateseq').value = seq;
				
				
			},
			error:function(req, status, error){
				alert("error");
			}
		
		});
		
			
}

/*---------------------------------------------------------------------------------------------
 * 사원 수정 후
 *----------------------------------------------------------------------------------------------*/
function updateAdminAf() {	
		 
	    alert("사원 수정완료클릭");
	    var data = {};
		var seq = document.getElementById('updateseq').value;
	    var id= document.getElementById('_updateid').value;
	    var password= document.getElementById('_updatepassword').value;
	    var name = document.getElementById('_updatename').value;
	    var phone = document.getElementById('_updatephone').value;
	    var store_seq = document.getElementById('_updatestorecode').value;
	    
	    
		data["seq"]=seq;
		data["id"]=id;
		data["password"]=password;
		data["name"]=name;
		data["phone"]=phone;
		data["store_seq"]=store_seq;
		
		
		$.ajax({
			contentType:'application/json',
			dataType:'json',
			data:JSON.stringify(data), 		//JavaScript 값을 JSON으로 변환 한다
			url:"updateAdminAf.do",			// store
			type:'POST',
			
			success:function(data){
				alert("수정완료");
				//해당 테이블 row일단 삭제
				var deleteRowId = "tr"+$("#updateseq").val();
				deleteTableRow(deleteRowId);
				//수정된걸로 다시생성
			
			
				$('#myTable tr:last').after('<tr id="tr'+seq+'">'+
						'<td>'+store_seq+'</td>'+
						'<td>'+id+'</td>'+
						'<td>'+password+'</td>'+
						'<td>'+name+'</td>'+
						'<td>'+phone+'</td>'+
						'<td><input type="button" value="수정" class="btn btn-inverse" onclick="ListSet('+seq+')" data-toggle="modal" data-target="#updateAdmin">&nbsp;<input type="button" value="삭제" class="btn btn-inverse" onclick="ListDelete('+seq+')"></td>'+
						'</tr>');
				
				//$(".modal-fade").modal("hide");
				//$(".modal-backdrop").remove();
				//$(".modal").modal("hide");
				$("updateAdmin").modal("hide");
				//location.reload();
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
  

