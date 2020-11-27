<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>

<html class='no-js' >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<title>About 'HEllo, Pet World!'</title>
		
		<!--[if lt IE 9]>
		  <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/bootstrap/css/bootstrap.min.css" />' />
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/ionicons.min.css" />' />
		
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.carousel.css" />' />
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.theme.css" />' />
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.transitions.css" />' />
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/magnific-popup.css" />' />
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/style.css" />' />
		<link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/color-default.css" />' />
	</head>
<body>

	<div class='container'>
		<div class='row'>
			<div class='col-md-6 col-md-offset-3'>
				<div class='section-header main-title text-center'>
					<spring:hasBindErrors name="sitterForm" />
						<form id='contact-form' class='contact-form' method='post' enctype="multipart/form-data" >
        				<fieldset>
			                <table class="table">
							<tr>
                            	<th class="active" scope="row" rowspan="3" colspan="2">
                            		<img src="${pageContext.request.contextPath}/resources/img/petsitter/petsitter${sitterForm.pictureUrl}" width="150px" height="150px"/>
                            		<input type="file" name="picture" value="${sitterForm.picture}" />
                            	</th>
							</tr>
							<tr>
                            	<th class="active" width="80"><label for="age">나이</label></th>
                            	<td>
									<input type='text' class='form-control' name="age" id="age" value="${sitterForm.age}" placeholder="AGE" required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="care">돌봄<br />횟수</label></th>
                            	<td width="200">
									<input type='text' class='form-control' name="careNum" id="careNum" value="${sitterForm.careNum}" readonly="readonly">
								</td>
							</tr>
                			</table>
                			<div class='form-group text-center'>
                				<button class="btn btn-default btn-lg" type="submit" onclick="registerUpdate('<c:url value="/user/mypage/mypage_petsitter"/>')">수정</button>
                				<button class="btn btn-default btn-lg" type="reset">리셋</button>
                			</div>
                		</fieldset>
                		</form>
						
					</div>
			</div>
		</div>
	</div>


	<!--=============================================================================
			JavaScript Files
		===============================================================================-->
	<script src='<c:url value="/resources/js/jquery.min.js" />'></script>
	<script src='<c:url value="/resources/js/jquery.stellar.min.js" />'></script>
	<script src='<c:url value="/resources/js/modernizr.js" />'></script>
	<script src='<c:url value="/resources/js/owl.carousel.min.js" />'></script>
	<script src='<c:url value="/resources/js/jquery.shuffle.min.js" />'></script>
	<script
		src='<c:url value="/resources/js/jquery.magnific-popup.min.js" />'></script>
	<script src='<c:url value="/resources/js/validator.min.js" />'></script>
	<script src='<c:url value="/resources/js/smoothscroll.js" />'></script>
	<script src='<c:url value="/resources/js/script.js" />'></script>


</body>

</html>
