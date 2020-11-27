<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
		
			<!--=============================================================================
				My Page Section
			===============================================================================-->			
				<div class='portfolio-block section-block' >
					
					<div class='container' >
					
						<div class='row' >
							<div class='col-md-6 col-md-offset-3' >
								<div class='section-header text-center' >
								
									<h2 class='animate text-over-block' >MY PAGE</h2>
									
									<!--divider-->
									<div class='divider-draft center' ></div>
									<!--/divider-->
								</div>
							</div>
						</div>
						
						
						 <div id='portfolio-filters' >
							<ul>
								<c:if test="${sessionScope.user.m_type != 0 }">
									<li>
										<a href="/Pet/view/user/mypage/mypage_profile">PROFILE</a>
									</li>
								</c:if>
								<c:if test="${sessionScope.user.m_type == 2 }">
									<li>
										<a href="/Pet/view/user/mypage/mypage_petsitter">PETSITTER</a>
									</li>
								</c:if>
								<li>
									<a href="/Pet/view/pet/pet_main">PET</a>
								</li>
								<li>
									<a href="/Pet/view/point/point_main">POINT</a>
								</li>
								<c:if test="${sessionScope.user.m_type == 2 }">
									<li>
										<a href="/Pet/view/schedule/schedule_main">SCHEDULE</a>
									</li>
								</c:if>
								<li>
									<a href="/Pet/question/mypage">QUESTION</a>
								</li>
								<li>
									<a href="/Pet/used_market/mypage/main">USED MARKET</a>
								</li>
							</ul>
						 </div>
						
						<c:if test="${pointFailed}">
              				<% out.println("<script>alert('Point가 부족합니다.');</script>"); %>
           	 			</c:if>
 
						 <c:if test="${url == 'profile'}">
                        	<%@ include file="/view/user/mypage/mypage_profile.jsp"%>	
                        </c:if>
                        <c:if test="${url == 'petsitter'}">
                        	<%@ include file="/view/user/mypage/mypage_petsitter.jsp"%>	
                        </c:if>
                         <c:if test="${url == 'pet_main'}">
                        	<%@ include file="/view/pet/pet_main.jsp"%>	
                        </c:if>
                        <c:if test="${url == 'pet_register'}">
                        	<%@ include file="/view/pet/pet_register.jsp"%>	
                        </c:if>
                        <c:if test="${url == 'point'}">
                        	<%@ include file="/view/point/point_main.jsp"%>	
                        </c:if>
                        <c:if test="${url == 'schedule'}">
                        	<%@ include file="/view/schedule/schedule_main.jsp"%>
                        </c:if>
                        <c:if test="${url == 'question'}">
                        	<%@ include file="/view/user/mypage/mypage_question.jsp"%>
                        </c:if>
                        <c:if test="${url == 'used_market'}">
                        	<%@ include file="/view/user/mypage/mypage_usedmarket.jsp"%>
                        </c:if>
					</div>
					
				</div>
				
				
				<%@ include file="/view/include/bottom.jsp"%>

		</div>
		
		
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