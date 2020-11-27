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
	
		<title>관심 목록</title>
		
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
 		  function insertBasket(targetUri) {		
		 	  location.replace(targetUri);
 		  }
	
 		  var loc;
 		  
 		  function findValueFunction() {
  			var findval = document.getElementById('findValue').value;
   			
  			if(findval)
  				loc = "search/"+findval;
  			
  			
 		  }
 		 function deleteBasket(targetUri) {		
		 	  location.replace(targetUri);
		  }
 		 function recommand(targetUri) {		
		 	  location.replace(targetUri);
		  }
 		  function replaceLocationFunction() {
 	 		var link_url = "/Pet/basket/" +loc;
 		 		
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
				Services Section
			===============================================================================-->					
				<div class='container' >
					<div class='row' >
						<div class='col-md-6 col-md-offset-3' >
							<div class='section-header main-title text-center' >
								
								<h2 class='animate text-over-block' >관심 목록</h2>
								
								<!--divider-->
								<div class='divider-draft center' ></div>
								<!--/divider-->
								<br>				
								<p>
									    회원님이 관심 추가했던 목록입니다.<br> *추천 생성을 눌러 추천 게시물을 확인할 수 있습니다*
								</p>
								<br>		
							</div>
						</div>
					
				<table class="table table-hover">
							<tr class="active">
								
								<th>제목</th>
								<th>위치</th>
								<th>가격</th>
								<th>종류</th>
								<th></th>
							
							</tr>
		
							<c:choose>
								<c:when test="${select eq 'all'}">
									<c:forEach var="basket" items="${allBasketList}">										
										<tr style="text-align: center;" >
											<td><a href="/Pet/board/b_num/${basket.b_num}">${basket.b_title}</a></td>							
											<td>${basket.b_where}</td>
											<td>${basket.price}</td>
											<td>${basket.b_type}</td>
											<td><input type="button" name="del_num" onclick="deleteBasket('<c:url value="/basket/delete/${basket.b_num}"/>')" value="삭제" ></td>
										</tr>
									</c:forEach>
									
								</c:when>
								<c:when test="${select eq 'nohave'}">
										<tr style="text-align: center;" >
								
											
									
											<td colspan="5">펫시팅 게시판에서 관심 추가를 하셔야 추천 생성이 가능합니다. 
											<input type="button" name="del_num" onclick="deleteBasket('<c:url value="/board/main.do"/>')" value="보러가기" ></td>									
										</tr>
								</c:when>
							</c:choose>
						
						</table>
						<c:if test="${select ne 'nohave'}">
						<div class='section-header text-center' >	
						<button  type="submit" onclick="recommand('<c:url value="/basket/recommand.do"/>')" class="btn btn-default btn-lg">추천 생성</button>
						</div>
						</c:if>
					<br><br>
					</div>
				</div>

					<div class='process-block bg-lightgray section-block' >
					<div class='container' >
						
						<div class='section-header text-center' >
							<h2>Work Process</h2>
							<!--divider-->
							<div class='divider-draft center' ></div>
							<!--/divider-->
						</div>
						
						<div class='row' >	
							<div class='col-md-3' >	
								<div class='process' >
									
									<div class='number' >
										<span>01</span>
									</div>
									
									<div class='content' >
										
										<h4>게시물 확인</h4>
										<p>
											펫시터 찾기 게시판에서 원하시는 펫시터를 찾아보세요!
										</p>
										
									</div>	</div>	</div>
							
							<div class='col-md-3' >
								
								<div class='process' >
									
									<div class='number' >
										<span>02</span>
									</div>
									
									<div class='content' >
										
										<h4>관심 등록</h4>
										<p>
											마음에 드는 펫시터의 게시물에서 관심추가를 눌러 관심목록에 추가해주세요.
											<br>최대 5개까지 등록 가능합니다. 
										</p>
										
									</div> </div> </div>
							
							<div class='col-md-3' >
								
								<div class='process' >
									
									<div class='number' >
										<span>03</span>
									</div>
									<div class='content' >
										
										<h4>추천 시터</h4>
										
										<p>
											추가한 관심목록을 토대로 회원님께 펫시터를 추천해드립니다 .
										</p>
										
									</div>	</div></div>
							
							<div class='col-md-3' >
								
								<div class='process last' >
									
									<div class='number' >
										<span>04</span>
									</div>
									<div class='content' >
										
										<h4>확인 후 예약</h4>
										
										<p>
											추천된 펫시터 게시물을 확인하고 원하시는 펫시터에게 예약신청해주세요!
										</p>
										
									</div>
								</div>
							 </div>
							</div>	
				
			
						
						</div>
					
						<div class='section-header text-center' >
						<%-- <form action='<c:url value="/basket/insertForm.do"/>' method="get"> --%>
							
						<!-- 	<button type="submit" class="btn btn-default btn-lg">Question 등록-button</button>
							<input type="submit" value="Question 등록" class="btn btn-default btn-lg">
						</form> -->
						</div>
						
					</div>
			
				
				
			<%@ include file="/view/include/bottom.jsp"%>

			<!--=============================================================================
				/Services Section
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