<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class='no-js' >
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<title>Hello, Pet World!</title>
		
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
		<c:if test="${msg == 'regiSuccess'}">
            <script type="text/javascript">
            	alert("회원가입 되었습니다!")
            </script>
        </c:if>
        <c:if test="${msg == 'logout'}">
            <script type="text/javascript">
            	alert("로그아웃 되었습니다!")
            </script>
        </c:if>
			
			<!--=============================================================================
				Front Section
			===============================================================================-->
			<section class='front-section' >
				<div class='container' >
					<div class='transition-mask' ></div>
					
					<div class='front-person-img' >					
						<img src='<c:url value="/resources/img/main_cat2.png" />' alt='Symp' />
					</div>
					
					
					<nav class='front-person-links' >						
						<ul>							
							<li>
								<a href='<c:url value="/about" />'>About 'Hello, Pet World!'</a>
							</li>					
							<li>
								<a href="board/main.do">PetSitting 게시판</a>
							</li>							
							<li>
								<a href="/Pet/question/main.do/main">Question 게시판</a>
							</li>							
							<li>
								<a href="/Pet/used_market/main.do/main">Used Market</a>	
							</li>							
							<li>
								<c:if test="${sessionScope.user != null }">
									<a href="/Pet/mypage_main">My Page</a>
								</c:if>
							</li>						
						</ul>						
					</nav>					
					
					
					<div class='front-heading text-center' >
						<h2>
							Hello, Pet World!
						</h2>
					</div>		
				</div>
				
			</section>
			<!--=============================================================================
				/Front Section
			===============================================================================-->
					
		</div>
		<!--=============================================================================
			/Main Wrapper
		===============================================================================-->
		
		
		<!--=============================================================================
			JavaScript Files
		===============================================================================-->
		<script src='<c:url value="/resources/js/jquery.min.js" />' ></script>
		<script src='<c:url value="/resources/js/jquery.stellar.min.js" />' ></script>
		<script src='<c:url value="/resources/js/modernizr.js" />' ></script>
		<script src='<c:url value="/resources/js/owl.carousel.min.js" />' ></script>
		<script src='<c:url value="/resources/js/jquery.shuffle.min.js" />' ></script>
		<script src='<c:url value="/resources/js/jquery.magnific-popup.min.js" />' ></script>
		<script src='<c:url value="/resources/js/validator.min.js" />' ></script>
		<script src='<c:url value="/resources/js/smoothscroll.js" />' ></script>
		<script src='<c:url value="/resources/js/script.js" />' ></script>
		
		
	</body>
	
</html>