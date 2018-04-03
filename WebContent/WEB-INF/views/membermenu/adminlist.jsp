<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<fmt:requestEncoding value="utf-8"/> 

<!-- icon 불러오기 -->
<!--core first + styles last-->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>


<!-- Bread crumb -->
<div class="row page-titles">
    <div class="col-md-5 align-self-center">
        <h3 class="text-primary">Branch manager List</h3> </div>
    <div class="col-md-7 align-self-center">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
            <li class="breadcrumb-item active">Branch manager List</li>
        </ol>
    </div>
</div>
<!-- End Bread crumb -->

<!-- Container fluid  -->
<div class="card">
    <div class="card-body">
        <h4 class="card-title">지점 매니저 리스트</h4>
        <h6 class="card-subtitle">Branch manager List</h6>
        <div class="table-responsive m-t-40">
            <table id="myTable" class="table table-bordered table-striped">
            <col width="10%"/><col width="20%"/><col width="20%"/><col width="20%"/><col width="30%"/><col width="10%"/>
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
                        <td style="text-align: center;">
                            <a href="setadmin.do" onclick="${admin.seq}"  class="settings" title="Settings" data-toggle="tooltip"><i class="fas fa-cog"></i></a>&nbsp;&nbsp;&nbsp;
							<a href="deladmin.do" onclick="${admin.seq}" class="delete" title="Delete" data-toggle="tooltip"><i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
             
             
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