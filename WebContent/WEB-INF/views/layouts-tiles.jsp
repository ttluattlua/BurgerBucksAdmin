<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
<html>
<title>BurgerBucksAdmin</title>

<tiles:insertAttribute name="header"/>

</head>
<body class="fix-header fix-sidebar">

<div id="main-wrapper">

	    <!-- Preloader - style you can find in spinners.css -->
	    <div class="preloader">
	        <svg class="circular" viewBox="25 25 50 50">
				<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
	    </div>
	    <!-- Main wrapper  -->
	    
		<div class="header">
			<tiles:insertAttribute name="top_menu"/>
		</div>
		
		<div  class="left-sidebar">
			<tiles:insertAttribute name="left_main"/>
		</div>		
		
		<div class="page-wrapper" data-interval="false">
			<tiles:insertAttribute name="main"/>
		</div>			

		<div>
			<tiles:insertAttribute name="footer"/>		
		</div>			
</div>


</body>

</html>



