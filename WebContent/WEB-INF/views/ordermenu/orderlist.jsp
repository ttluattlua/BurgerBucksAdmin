<%@page import="bba.com.a.model.Bb_AdminDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
           <!-- 	<button id="btn-show-all-children" type="button" class="btn btn-inverse" >Expand All</button>
			<button id="btn-hide-all-children" type="button" class="btn btn-inverse" >Collapse All</button> -->
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div style="text-align: right;">
			<i class="material-icons">shopping_cart</i> 장바구니 / 
			<i class="material-icons">payment</i> 주문완료 / 
			<i class="material-icons">room_service</i> 준비중 / 
			<i class="material-icons">directions_bike</i> 배달시작 / 
			<i class="material-icons">assignment_turned_in</i> 배달완료 / 
			</div>
           </div>


<!-- 점포 / 본사 구분 -->
<input type="hidden" name="chStoreSeq" value="<%=store%>">

<table id="orderTable" class="display" cellspacing="0" width="100%">

    <thead>
        <tr>
        	<th>No</th>
            <th>점포명</th>
            <th>주문자</th>
            <th>연락처</th>
            <th>주문일자</th>
            <th>배송지</th>
            <th>메모</th>
            <th>상태</th>
            <th>변경</th>
            <th></th>
            <th></th>

            
            <%-- 
            <c:forEach items="${olist}" var="chorder" varStatus="status">
            <c:forEach items="${orderMenuList}" var="chorderMenu" varStatus="status">
            <c:if test="${chorder.seq eq chorderMenu.order_seq}">
            <th class="none">배송지</th>
            <th class="none">주문번호</th>
            <th class="none">메뉴 seq</th>
            </c:if>
            </c:forEach>
            </c:forEach>
             --%>
        </tr>
    </thead>
    
    <tbody>
    
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

 	<!-- member list -->
	<c:set var="memberList" value="${memberList }" />
	
	<!-- address list -->
	<c:set var="addrList" value="${addrList }" />
	
	<!-- store list -->
	<c:set var="storeList" value="${storeList }" />
	
	<!-- 접속한 점포 코드 -->
	<c:set var="storeCode" value="<%=store %>"></c:set>
	
	<!-- order list -->
	<c:set var="i" value="0" />
    <c:forEach items="${olist}" var="order" varStatus="status">
    
    <!-- 본사 직원 로그인 시 -->
   	<c:if test="${storeCode eq '0' }">

        <tr id="tr${order.seq}">
        	<!-- 기본 정보 -->
        	
        	<!-- no -->
            <td> ${status.count}</td>
            <!-- 점포명 -->
            <td>${storeList[i].name }</td>
            <!-- 주문자 -->
            <td>${memberList[i].id }</td>
            <!-- 연락처 -->
            <td>${memberList[i].phone }</td>
            <!-- 주문일자 -->
            <td>${order.order_date }</td>
            
            <!-- 배송지 -->
            <td>${addrList[i].address }</td>
            <!-- 배송메모 -->
            <td>${addrList[i].memo }</td>
            
            
			<!-- 현재 주문 상태 아이콘 -->
            <td id="tdPre${order.seq}">
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
            <td id="tdChPre${order.seq}">
            <select name="${order.seq}oSelect1" title="선택하세요" class="form-control">
		      <option value='0' <c:if test="${order.status eq '0'}">selected</c:if>>장바구니</option>
		      <option value='1' <c:if test="${order.status eq '1'}">selected</c:if>>주문완료</option>
		      <option value='2' <c:if test="${order.status eq '2'}">selected</c:if>>준비중</option>
		      <option value='3' <c:if test="${order.status eq '3'}">selected</c:if>>배달시작</option>
		      <option value='4' <c:if test="${order.status eq '4'}">selected</c:if>>배달완료</option>
		    </select>
			</td>
			
			
			
			<!-- 상태 저장 버튼 -->
            <td style="text-align: right;">
            <button id="save" type="button" class="btn btn-inverse" onclick="saveOSelect(${order.seq})" >저장</button>
            </td>
            
            <!-- 상세보기 버튼 -->
            <td style="text-align: right;">
            <button  id="detailBtn" type="button" class="btn btn-inverse" value="0" onclick="orderDetail(${order.seq})" >주문상세</button>
            </td>

        </tr>
        </c:if>
        
        
        <!-- 점포 매니저 로그인 시 -->
        <c:set var="s" value="1" />
        <c:if test="${storeCode eq storeList[i].seq }">

        <tr id="tr${order.seq}">
        	<!-- 기본 정보 -->
        	
        	<!-- no -->
            <td> ${s}</td>
            <!-- 점포명 -->
            <td>${storeList[i].name }</td>
            <!-- 주문자 -->
            <td>${memberList[i].id }</td>
            <!-- 연락처 -->
            <td>${memberList[i].phone }</td>
            <!-- 주문일자 -->
            <td>${order.order_date }</td>
            
            <!-- 배송지 -->
            <td>${addrList[i].address }</td>
            <!-- 배송메모 -->
            <td>${addrList[i].memo }</td>
            
            
			<!-- 현재 주문 상태 아이콘 -->
            <td id="tdPre${order.seq}" style="text-align: center;">
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
            <td id="tdChPre${order.seq}" style="text-align: center;">
            <select name="${order.seq}oSelect2" title="선택하세요" class="form-control">
		      <option value='0' <c:if test="${order.status eq '0'}">selected</c:if>>장바구니</option>
		      <option value='1' <c:if test="${order.status eq '1'}">selected</c:if>>주문완료</option>
		      <option value='2' <c:if test="${order.status eq '2'}">selected</c:if>>준비중</option>
		      <option value='3' <c:if test="${order.status eq '3'}">selected</c:if>>배달시작</option>
		      <option value='4' <c:if test="${order.status eq '4'}">selected</c:if>>배달완료</option>
		    </select>
			</td>
			
			<!-- 상태 저장 버튼 -->
            <td style="text-align: right;">
            <button id="save" type="button" class="btn btn-inverse" onclick="saveOSelect(${order.seq})" >저장</button>
            </td>
            
            <!-- 상세보기 버튼 -->
            <td style="text-align: right;">
            <button  id="detailBtn" type="button" class="btn btn-inverse" value="0" onclick="orderDetail(${order.seq})" >주문상세</button>
            </td>
		<c:set var="ss" value="${s+1 }"></c:set>
        </tr>
        </c:if>
        
        
        
        
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
		
		var oSelect = '-1';
		
		//var chStore = document.getElementsByClassName(".chStoreSeq");
		var chStore = $('input[name=chStoreSeq]').val();
		//alert("점포 코드 : "+chStore);
		if(chStore==0){
			oSelect = $('select[name="'+seq+'"oSelect1]').val();
			//alert("상태 선택 코드 : [0] "+oSelect);
		}else{
			oSelect = $('select[name="'+seq+'"oSelect2]').val();
			//alert("상태 선택 코드 : "+oSelect);
		}
		
		$.ajax({
            url : "changeOrder.do",
            type: "get",
            data : { "seq" : seq, 
            		"status" : oSelect	},
            dataType: 'json',
    		contentType : "application; charset=utf-8",
    		traditional : true,
            success : function(data){
                
                //alert(JSON.stringify(data));
                
                //성공하면 이 함수 찾아서 고!
                updateRow(data);
                
            },error : function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
	}
	 
	 
/*---------------------------------------------------------------------------------------------
 * 주문상세 클릭
 *----------------------------------------------------------------------------------------------*/

	function orderDetail(seq){
		alert("상세 보기 클릭");
		
		$.ajax({
            url : "orderDetail.do",
            type: "get",
            data : { "seq" : seq },
            dataType: 'json',
    		contentType : "application; charset=utf-8",
    		traditional : true,
            success : function(data){
                //$("#ajax").remove();
                
                //alert(JSON.stringify(data));
                //alert("길이 : " +data.length);

           		var x = document.getElementById("detailBtn").value;
           	 
           	 	
                for(var i=0; i<data.length; i++){
                
                	if(x==0){
                	
	                	$( '#tr'+seq ).after( 
	                		'<tr class="trtr'+seq+'"><td colspan="11">'+
	                		'<b>주문번호 : </b> '+data[i].order_seq+ '&nbsp&nbsp&nbsp&nbsp<b>메뉴명 : </b>'+data[i].menu_name+'&nbsp&nbsp&nbsp&nbsp<b>가격 : </b>'+data[i].orderMenu_price+ '&nbsp&nbsp&nbsp&nbsp<b>수량 : </b> '+data[i].orderMenu_quantity +
	                		'<br><b>버거 : </b>'+data[i].burger_name+'&nbsp&nbsp&nbsp&nbsp<b>음료 : </b>'+data[i].beverage_name+'&nbsp&nbsp&nbsp&nbsp<b>사이드 : </b>'+data[i].side_name+
	                		'<br><br>'+
	                		'<b>버거 만들기</b>'+
	                		'<br>'+
	                		data[i].burger_Ingredient +
	                		'</tr></td>'
	                	);
	                	
	                	document.getElementById("detailBtn").value = "1";
                	}else if(x==1){
                		$( '.trtr'+seq ).remove();
                		document.getElementById("detailBtn").value = "0";
                	}
                
                	
                }
                
            },error : function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
	}
	 	
	
function updateRow(data){

	console.log(data);
	
	if(data.status==0){
		$( '#tdPre'+data.seq ).html('<i class="material-icons">shopping_cart</i>');
	}else if(data.status==1){
		$( '#tdPre'+data.seq ).html('<i class="material-icons">payment</i>');
	}else if(data.status==2){
		$( '#tdPre'+data.seq ).html('<i class="material-icons">room_service</i>');
	}else if(data.status==3){
		$( '#tdPre'+data.seq ).html('<i class="material-icons">directions_bike</i>');
	}else if(data.status==4){
		$( '#tdPre'+data.seq ).html('<i class="material-icons">assignment_turned_in</i>');
	}
	
	//$( '#tdPre'+data.seq ).html('랄라');
	
	
    

}


</script>
  
