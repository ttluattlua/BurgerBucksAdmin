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

            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li class="nav-devider"></li>
                        <!--==================사이드바:홈/멤버관리/테이블관리/스토어관리/주문관리===================================-->
                        <li class="nav-label"><a href="main.do">Home</a></li>

                        <li class="nav-label">스토어관리</li>         
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><img alt="" src="./icons/menuicon/store.png"><span class="hide-menu"></span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="storelist.do">스토어관리</a></li>
                            </ul>
                        </li>
                                 
                  
                        <!--=========================================================================================-->
                      
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
            




