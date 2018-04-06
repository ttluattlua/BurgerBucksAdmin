<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="utf-8"/>   

            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                        <li class="nav-devider"></li>
                        <!--==================사이드바:홈/멤버관리/테이블관리/스토어관리/주문관리===================================-->
                        <li class="nav-label"><a href="main.do">Home</a></li>
						<li class="nav-label">멤버관리</li>
                        <li> <a class="has-arrow  " href="#" aria-expanded="false"><img alt="" src="./icons/menuicon/users.png"><span class="hide-menu"></span></a>
                            <ul aria-expanded="false" class="collapse">
                                <li><a href="adminplus.do">사원등록</a></li>
                                <li><a href="adminlist.do">사원관리</a></li>
                                <li><a href="customerlist.do">고객관리</a></li>
                            </ul>
                        </li>
                                 
                  
                        <!--=========================================================================================-->
                      
                    </ul>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
            




