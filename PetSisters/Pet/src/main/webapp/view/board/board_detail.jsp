<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class='no-js' >
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<title>게시물 정보</title>
		
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
 		  function backBoardMain(targetUri) {
 			 location.replace(targetUri);
 		  }
 		  function insertBasket(targetUri) {
  			 location.replace(targetUri);
  		  }
 		  function insertReservation(targetUri) {
 			 location.replace(targetUri);
 		  }
 		 
 		  function updateBoard(targetUri) {
 			 if(${sessionScope.user.getM_num()} == ${boardByNum.m_num})
					location.replace(targetUri);
			 else 
					alert("자신의게시물만 수정해주세요");
 		  }
 		  
 		  function deleteBoard(targetUri) {
 			 if(confirm("정말 삭제하시겠습니까?")) {
 				 if(${sessionScope.user.getM_num()} == ${boardByNum.m_num})
 					location.replace(targetUri);
 				 else 
 					 alert("자신의게시물만 삭제해주세요");
 		 	 }
 		 	 else
 			  	return false; 
		  }
 		 
 		 var request = new XMLHttpRequest();
 		 
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
				Used Market Section
			===============================================================================-->
			
				<div class='container' >
					<div class='row' >
						<div class='col-md-6 col-md-offset-3' >
							<div class='section-header text-center' >
								<h2>구직 게시물</h2>
								
								<!--divider-->
								<div class='divider-draft center' ></div>
								<!--/divider-->
					
							</div>
						</div>
					</div>
				</div>
				
			
					
				<div class='posts-block section-block' >
					<div class='container' >
						<div class='row' >
							<div class='col-md-8' >			
								<div class='post' >	
								<div class='testimonials-slider' >
				
									<div class='testimonial' >
										<div class='media' >
										<img src="${pageContext.request.contextPath}/resources/img/board/${boardByNum.b_picture}"/>
									</div>

									</div>
									
									<div class='testimonial' >
										<div class='media' >
										<img alt='symp' src='<c:url value="/resources/img/bg2.jpg" />' >
									</div>
												
									</div>	
									<div class='testimonial' >
										<div class='media' >
										<img alt='symp' src='<c:url value="/resources/img/bg2.jpg" />' >
									</div>
								</div>			
								</div>				
									<div class='content' >
										<h4>
											${boardByNum.b_title}
										</h4>
										${boardByNum.b_date}
										<br><br>
										<ul class='post-icons' >
											<li>
												<i class='ion-ios-person' ></i>
												<span>${boardByNum.m_num}</span>
											</li>
											<li>
												<i class='ion-ios-clock' ></i>
												<span>${boardByNum.price}원</span>
											</li>											
											<li>
												<i class='ion-ios-chatbubble' ></i>
												<span>${boardByNum.b_type}</span>
											</li>																																	
										</ul>
										
										<p>
											${boardByNum.b_detail }
										</p>

									</div>
								</div>								
							</div>
													
							<div class='col-md-4' >
								<div class='sidebar' style="border:solid 1px #F0F0F0;">
			
									<div class='sidebar-widget'   >
										<div class='categories-widget'  >
											<div class='widget-header' >
												<h4>
													<i class='ion-ios-folder' ></i> Sitter Info
												</h4>
											</div>
											
										<div class='media' style="height:150px; width:250px;" >
										<img src="${pageContext.request.contextPath}/resources/img/petsitter/petsitter${sitter.picture}"/>
										<img src="${sitter.picture}" width="150px" height="150px"/>
										</div>
											이름 : ${sitter.name}<br>
											나이 : ${sitter.age}<br>
											돌봄횟수 : ${sitter.careNum	}<br>							
											전화번호 : ${sitter.phone}<br>
											지역 : ${sitter.addr}<br>
										</div>
										<br>
										<c:if test="${sessionScope.user.getId() != null && sessionScope.user.getM_type() == 1}">
										<table><tr align="center" ><td width="270">
											<button style="" type="submit" onclick="insertReservation('<c:url value="/reservation/insert/${boardByNum.b_num}"/>')" class="btn btn-default btn-lg">예약하기</button>
										</td></tr></table>
										<br><br>
										</c:if>
									</div>			
									</div>
																	
								</div>
								
							</div>
								<div class='section-header text-center' >	
								<c:if test="${ boardByNum.m_num eq sessionScope.user.getM_num()}">
									<button type="submit" onclick="updateBoard('<c:url value="/board/update/select/${boardByNum.b_num}"/>')" class="btn btn-default btn-lg">수정</button>
								
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
						
									<button type="submit" onclick="deleteBoard('<c:url value="/board/delete/${boardByNum.b_num}" />')" class="btn btn-default btn-lg">삭제</button>		
			
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>	
								<c:if test="${sessionScope.user.getId() != null && sessionScope.user.getM_type() == 1 && overSize == 'false' && isHave == 'false' }">	
									<button type="submit" onclick="insertBasket('<c:url value="/basket/insert/${sessionScope.user.getM_num()}/${boardByNum.b_num}"/>')" class="btn btn-default btn-lg">관심 추가</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
								</c:if>
			
								
									<button type="submit" onclick="backBoardMain('<c:url value="/board/main.do"/>')" class="btn btn-default btn-lg">목록</button>
							
								<%-- 	<button type="submit" onclick="backBoardMain('<c:url value="/board/main.do"/>')" class="btn btn-default btn-lg">목록</button> --%>
								
						</div>					
						</div>						
					</div>
			
				
				
				
				<%@ include file="/view/include/bottom.jsp"%>

			<!--=============================================================================
				/Used Market Section
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