<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/> 

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
               <table id="myTable" class="table table-bordered table-striped">
                   <thead>
                       <tr>
                           <th>ID</th>
                           <th>Password</th>
                           <th>Name</th>
                           <th>Grade</th>
                       </tr>
                   </thead>
                   <tbody>
                   <c:forEach items="${cList}" var="custom" varStatus="vs">
                    <tr>
                        <td>${custom.id }</td>
                        <td>${custom.password }</td>
                        <td>${custom.name }</td>
                        <td>${custom.grade }</td>
                    </tr>
                   </c:forEach>
                       
                   </tbody>
               </table>
           </div>
       </div>
   </div>
   </div>
   </div>
   </div>


