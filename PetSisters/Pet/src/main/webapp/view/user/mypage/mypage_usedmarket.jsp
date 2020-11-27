<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>

<html class='no-js' >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<title>My Used Market</title>
		
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

	<!-- Preloader -->
	<div id='preloader'>
		<div class='loader'>
			<img src='<c:url value="/resources/img/load.gif" />' alt='symp' />
		</div>
	</div>
	<!-- Preloader -->


	<div class='portfolio-block section-block'>
		<div class='container'>
			<div class='row'>
				<div class='col-md-6 col-md-offset-3'>
					<div class='section-header text-center'>
						<h4 class='animate text-over-block' >My Used Market</h4>
					</div>
				</div>
			</div>
			
			<table class="table table-hover">
				<tr class="active">
					<th>번호</th>
					<th>닉네임</th>
					<th>제목</th>
					<th>등록 시간</th>
					<th>조회</th>
					<th>거래완료 여부</th>
					<th style="width:150px">거래 완료하기</th>
				</tr>
				
			  <c:forEach var="usedmarket" items="${selectUsedMarketBymNum}">
					<tr>
						<td align="center">${usedmarket.uNum}</td>
						<td align="center">${usedmarket.mNickname}</td>
						<td align="center"><a href="/Pet/used_market/unum/${usedmarket.uNum}">${usedmarket.uTitle}</a></td>
						<td align="center">${usedmarket.uDate}</td>
						<td align="center">${usedmarket.uHits}</td>
	
						<td align="center">
						  <c:choose>
						    <c:when test="${usedmarket.uCompleteTF eq 'T'}">
							  거래 완료
							</c:when>
							<c:otherwise>
							  거래 중
							</c:otherwise>
						  </c:choose>
						</td>
						<td align="center">
						  <c:choose>
						    <c:when test="${usedmarket.uCompleteTF eq 'T'}">
							  &nbsp;&nbsp;
							</c:when>
							<c:otherwise><%-- '/Pet/used_market/updateTF/${usedmarket.uNum}'  --%>
							  <center> <a href='/Pet/view/point/used_market/${usedmarket.uNum}' class="btn pull-right btn-success">거래완료</a> </center>
							</c:otherwise>
						  </c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
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
	<script src='<c:url value="/resources/js/jquery.magnific-popup.min.js" />'></script>
	<script src='<c:url value="/resources/js/validator.min.js" />'></script>
	<script src='<c:url value="/resources/js/smoothscroll.js" />'></script>
	<script src='<c:url value="/resources/js/script.js" />'></script>


</body>

</html>		