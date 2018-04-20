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
<%if(store==0){ %>
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li class="nav-devider"></li>
                        <!--==================사이드바:홈/멤버관리/테이블관리/스토어관리/주문관리===================================-->
                        <li class="nav-label"><a href="main.do">Home</a></li>
						
                        <li class="nav-label">테이블관리</li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><img alt="" src="./icons/menuicon/fast-food.png"><span class="hide-menu"></span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="burgerlist.do">버거관리</a></li>
                                <li><a href="sidelist.do">사이드관리</a></li>
                                <li><a href="ingredientlist.do">재료관리</a></li>
                                <li><a href="beveragelist.do">음료관리</a></li>
                                <li><a href="menulist.do">메뉴관리</a></li>
                            </ul>
                        </li>

                        <!--=========================================================================================-->
                      
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
            
<%} %>



