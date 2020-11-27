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
	
		<title>Question 게시판</title>
		
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
		
		<script>
 		  function insertQuestion(targetUri) {
 			  if(targetUri == "no_user") {
 				 alert("Question을 등록하시려면 로그인은 필수입니다.");
 				 return false;
 			  } 
 			  else {
 				  if(targetUri == "mType_0") {
 					 alert("관리자는 Question을 등록할 수 없습니다.");
 	 				 return false;
 				  }
 				  else {
 					 location.replace(targetUri);
 				  }
 			  } 
 		  }
	
 		  var loc;
 		  
 		  function findValueFunction() {
  			var findval = document.getElementById('findValue').value;
   			
  			if(findval)
     			loc = findval;
 		  }
 		  
 		  function replaceLocationFunction() {
 		 		var link_url = "/Pet/question/search/" + loc;
 		 		
 		 		location.replace(link_url);
 		  }
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
				QnA Section
			===============================================================================-->			
				<div class='portfolio-block section-block' >
					
					<div class='container' >
					
						<div class='row' >
							<div class='col-md-6 col-md-offset-3' >
								<div class='section-header text-center' >
								
									<h2 class='animate text-over-block' >Question 게시판</h2>
									
									<!--divider-->
									<div class='divider-draft center' ></div>
									<!--/divider-->
									
									<br><br>
								
									<div class='search-box' >	
											<input type='text' id="findValue" placeholder='Search' class='search-input' onblur="findValueFunction()">
											
											<a class='search-btn' onclick="replaceLocationFunction()">
												<i class='ion-ios-search' ></i>
											</a>
									</div>
								</div>
							</div>
						</div>
						
						  <c:if test="${selectFailed}">
							<% out.println("<script>alert('Question의 내용은 글쓴이와 관리자만 볼 수 있습니다.');</script>"); %>
						  </c:if>
						  <c:if test="${insertFailed}">
							<% out.println("<script>alert('로그인 후 Question을 등록해주세요.');</script>"); %>
						  </c:if>
						
						<%--						
						 <table class="table table-hover">
							<tr>
								<c:if test="${selectFailed}">
									<td colspan="2" align="center">
      									<font color="red">Question의 내용은 글쓴이와 관리자만 볼 수 있습니다.</font>
      								</td>
								</c:if> 		
							</tr>
						</table> --%>
						
						 <div id='portfolio-filters' >
							<ul>
								<li>
									<a href="/Pet/question/m_type/all">All</a>
								</li>
								<li>
									<a href="/Pet/question/m_type/normal">일반 회원</a>
								</li>
								<li>
									<a href="/Pet/question/m_type/petsitter">펫시터</a>
								</li>
							</ul>
						 </div>

						<table class="table table-hover">
							<tr class="active">
								<th>번호</th>
								<th>닉네임</th>
								<th>제목</th>
								<th>등록 시간</th>
								<th>조회</th>
							</tr>
	
							
							<c:choose>
								<c:when test="${select eq 'all'}">
									<c:forEach var="question" items="${allQuestionList}">
										<tr>
											<td>${question.questionNum}</td>
											<td>${question.mNickname}</td>							
											<td><a href="/Pet/question/qnum/${question.questionNum}">${question.questionTitle}</a></td>
											<td>${question.questionDate}</td>
											<td>${question.questionHits}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:when test="${select eq 'mType'}">
									<c:forEach var="question" items="${mTypeQuestionList}">
										<tr>
											<td>${question.questionNum}</td>
											<td>${question.mNickname}</td>
											<td><a href="/Pet/question/qnum/${question.questionNum}">${question.questionTitle}</a></td>
											<td>${question.questionDate}</td>
											<td>${question.questionHits}</td>
										</tr>
									</c:forEach>								
								</c:when>
								<c:when test="${select eq 'findValue'}">
									<c:forEach var="question" items="${searchQuestionList}">
										<tr>
											<td>${question.questionNum}</td>
											<td>${question.mNickname}</td>
											<td><a href="/Pet/question/qnum/${question.questionNum}">${question.questionTitle}</a></td>
											<td>${question.questionDate}</td>
											<td>${question.questionHits}</td>
										</tr>
									</c:forEach>								
								</c:when>
							</c:choose>
						
							
						</table>


						<br> <br>


						<div class='section-header text-center' >
						  <c:choose>
							<c:when test="${sessionScope.user == null}">
								<button type="submit" onclick="insertQuestion('no_user')" class="btn btn-default btn-lg">Question 등록</button>
							</c:when>
							<c:when test="${sessionScope.user.getM_type() == 0}">
								<button type="submit" onclick="insertQuestion('mType_0')" class="btn btn-default btn-lg">Question 등록</button>
							</c:when>
							<c:otherwise>
								<button type="submit" onclick="insertQuestion('<c:url value="/question/insertForm.do"/>')" class="btn btn-default btn-lg">Question 등록</button>
							</c:otherwise>		
						  </c:choose>
						</div>
												
					</div>
					
				</div>
				
				
				<%@ include file="/view/include/bottom.jsp"%>

			<!--=============================================================================
				/QnA Section
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