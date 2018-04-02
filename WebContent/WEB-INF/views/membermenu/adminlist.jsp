<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/> 


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
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Password</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Store Code</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${aList}" var="admin" varStatus="vs">
                    <tr>
                        <td>${admin.id }</td>
                        <td>${admin.password }</td>
                        <td>${admin.name }</td>
                        <td>${admin.phone }</td>
                        <td>${admin.store_seq }</td>
                    </tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
                     