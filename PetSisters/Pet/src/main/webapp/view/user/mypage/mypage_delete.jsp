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
	
		<title>MY PAGE</title>
		
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
		
		<script type="text/javascript">
   		</script>
		
	</head>
	
	<body>
			
		<!--=============================================================================
			Preloader
		===============================================================================-->
		<div id='preloader' >
			<div class='loader' >
				<img src='<c:url value="/resources/img/load.gif" />' alt='symp' />
			</div>
		</div>
		
		<!--=============================================================================
			Main Wrapper
		===============================================================================-->
		<div id='wrapper' >
			
		<%@ include file="/view/include/navbar.jsp"%>	
		<div class='portfolio-block section-block' >
					
					<div class='container' >
					
						<div class='row' >
							<div class='col-md-6 col-md-offset-3' >
								<div class='section-header text-center' >
								
									<h2 class='animate text-over-block' >DELETE ACCOUNT</h2>
									
									<!--divider-->
									<div class='divider-draft center' ></div>
									<!--/divider-->
									<p>
										정말 탈퇴하시겠습니까?<br />
										작성한 글/댓글은 삭제되지 않습니다.
									</p>
								</div>
							</div>
						</div>
						<div class='container'>
						<div class='row'>
							<div class='col-md-6 col-md-offset-3'>
								<div class='section-header main-title text-center'>
									<form id='contact-form' class='contact-form' method='post' >
				        			<fieldset>
							        <table class="table">
										<tr>
											<td class="active" scope="row" colspan="2"><label for="id">비밀번호 확인</label></td>
										</tr>
										<tr>
				                            <td colspan="2">
												<input type='password' class='form-control' name="confirmPw" required>
											</td>
										</tr>
				                	</table>
				                	<div class='form-group text-center'>
				                		<button class="btn btn-default btn-lg" type="submit" onclick="deleteRegi('<c:url value="/user/mypage/mypage_delete"/>')">확인</button>
				                	</div>
				                	</fieldset>
				                	</form>
										
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				
				<%@ include file="/view/include/bottom.jsp"%>
				
				
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
