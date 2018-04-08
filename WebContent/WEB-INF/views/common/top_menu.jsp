<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="utf-8"/>    
 <!-- Preloader - style you can find in spinners.css -->
 <div class="preloader">
     <svg class="circular" viewBox="25 25 50 50">
<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
 </div>
  <!--============================================헤더부분, 버거벅스 로고랑 검색창, 종, 메시지 부분=======================================================  -->

            <nav class="navbar top-navbar navbar-expand-md navbar-light">
                <!-- 버거벅스 로고 헤더부분(왼쪽)-->
                <div class="navbar-header">
                    <a class="navbar-brand" href="main.do">
                        <!-- Logo icon -->
                        <b><img src="./images/logo.png" style="width: 40px; height: 40px;" alt="homepage" class="dark-logo" /></b>
                        <!--End Logo icon -->
                        <!-- Logo text -->
                        <span><!-- <img src="images/logo-text.png" alt="homepage" class="dark-logo" /> -->버거벅스</span>
                    </a>
                </div>
                <!--왼쪽 헤더 부분-->
                <div class="navbar-collapse">
                    <!-- toggle and nav items -->
                    <ul class="navbar-nav mr-auto mt-md-0">
                       <!-- 왼쪽 헤더바 메뉴들 -->
                       
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted  " href="javascript:void(0)"><i class="fa mdi-menu"></i></a> </li>
                       <!-- 1) 홈-->
                       
                        <!-- <li class="nav-item m-l-10"> <a class="nav-link sidebartoggler hidden-sm-down text-muted  " href="javascript:void(0)"><i class="fa fa-home"></i></a> </li> -->
                        <!-- 2) 메뉴들 --> 
                        <!-- 왼쪽 헤더바 메뉴들 -->
                        <li class="nav-item dropdown mega-dropdown"> <a class="nav-link dropdown-toggle text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-th-large"></i></a>
                            <div class="dropdown-menu animated zoomIn">
                                <ul class="mega-dropdown-menu row">

<!--                                     <li class="col-lg-3 col-xlg-3 m-b-30">
                                        <h4 class="m-b-20">List style</h4>
                                        List style
                                        <ul class="list-style-none">
                                            <li><a href="javascript:void(0)"><i class="fa fa-check text-success"></i> This Is Another Link</a></li>
                                            <li><a href="javascript:void(0)"><i class="fa fa-check text-success"></i> This Is Another Link</a></li>
                                            <li><a href="javascript:void(0)"><i class="fa fa-check text-success"></i> This Is Another Link</a></li>
                                            <li><a href="javascript:void(0)"><i class="fa fa-check text-success"></i> This Is Another Link</a></li>
                                            <li><a href="javascript:void(0)"><i class="fa fa-check text-success"></i> This Is Another Link</a></li>
                                        </ul>
                                    </li> -->
                                    <!--회원 관리 메뉴 -->
                                    <li class="col-lg-3 col-xlg-3 m-b-30">
                                        <h4 class="m-b-20"><img alt="" src="./icons/menuicon/users.png"></h4>
                                        <!-- 회원관리 메뉴/사원등록/사원관리/고객관리 -->
                                        <ul class="list-style-none">
                                            <li><a href="adminplus.do"><img alt="" src="./icons/menuicon/userplus.png"> 사원 등록</a></li>
                                            <li><a href="adminlist.do"><img alt="" src="./icons/menuicon/worker.png"> 사원 관리</a></li>
                                            <li><a href="customerlist.do"><img alt="" src="./icons/menuicon/customer.png"> 고객 관리</a></li>
                                        </ul>
                                    </li>
                                    <!--버거/재료/음료/사이드/메뉴 관리 바-->
                                    <li class="col-lg-3 col-xlg-3 m-b-30">
                                        <h4 class="m-b-20"><img alt="" src="./icons/menuicon/fast-food.png"></h4>
                                        <!-- List style -->
                                        <ul class="list-style-none">
                                            <li><a href="burgerlist.do"><img alt="" src="./icons/menuicon/hamburger.png"> 버거관리</a></li>
                                            <li><a href="sidelist.do"><img alt="" src="./icons/menuicon/french-fries.png"> 사이드관리</a></li>
                                            <li><a href="ingredientlist.do"><img alt="" src="./icons/menuicon/cabbage.png"> 재료관리</a></li>
                                            <li><a href="beveragelist.do"><img alt="" src="./icons/menuicon/coke.png"> 음료관리</a></li>
                                            <li><a href="menulist.do"><img alt="" src="./icons/menuicon/menu.png"> 메뉴관리</a></li>
                                        </ul>
                                    </li>
                                    <!--스토어 수정/등록-->
                                    <li class="col-lg-3 col-xlg-3 m-b-30">
                                        <h4 class="m-b-20"><img alt="" src="./icons/menuicon/store.png"></h4>
                                        <!-- List style -->
                                        <ul class="list-style-none">
                                            <li><a href="storelist.do"><img alt="" src="./icons/menuicon/store-new-badges.png"> 스토어 관리</a></li>
                                        </ul>
                                    </li>
                                    <!--주문관리-->
                                    <li class="col-lg-3 col-xlg-3 m-b-30">
                                        <h4 class="m-b-20"><img alt="" src="./icons/menuicon/order-food-24px.png"></h4>
                                        <!-- List style -->
                                        <ul class="list-style-none">
                                            <li><a href="orderlist.do"><img alt="" src="./icons/menuicon/order-food.png"> 주문관리</a></li>                                    
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <!-- End Messages -->
                    </ul>
                    <!-- User profile and search  유저 프로필과 검색 부분 -->
                    <ul class="navbar-nav my-lg-0">
     
                        <!-- 프로필 이미지 부분 -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted  " href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="./images/userimage.jpg" alt="user" class="profile-pic" /></a>
                            <!-- 프로필 이미지 드롭다운 메뉴 -->
                            <div class="dropdown-menu dropdown-menu-right animated zoomIn">
                                <ul class="dropdown-user">
                                    <li><a href="#"><i class="ti-user"></i> 회원정보</a></li>
                                    <li><a href="#"><i class="ti-wallet"></i> Balance</a></li>
                                    <li><a href="#"><i class="ti-email"></i> Inbox</a></li>
                                    <li><a href="#"><i class="ti-settings"></i> Setting</a></li>
                                    <li><a href="login.do"><i class="fa fa-power-off"></i> 로그아웃</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>

        <!--=========================헤더 끝======================================================-->
        





