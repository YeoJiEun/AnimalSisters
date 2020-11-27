<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>

<html class='no-js' >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<title>예약 목록</title>
		
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
 		  function insertReservation(targetUri) {		
		 	  location.replace(targetUri);
 		  }
	

 		 function completeReservation(targetUri) {		
		 	  location.replace(targetUri);
		  }
		 
 		 function deleteReservation(targetUri) {		
		 	  location.replace(targetUri);
		  }
 		 function confirmReservation(targetUri) {		
		 	  location.replace(targetUri);
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
								
								<h2 class='animate text-over-block' >예약 현황</h2>
								
								<!--divider-->
								<div class='divider-draft center' ></div>
								<!--/divider-->
								<br>
								<br>				
								<p>
									아래의 work Process 를 참고하여 진행해 주세요.
								</p>
								<br>		
							</div>
						</div>
					
				<table class="table table-hover">
							<c:choose>
								<c:when test="${detail eq 'm'}">
							<tr class="active">	
									<th>게시물 번호</th>
									<th>날짜</th>
									<th>시터 이름</th>
									
									<th>완료 여부</th>
									<th> </th>
							</tr>
									<c:forEach var="reservation" items="${reservationByNum}">										
										<tr style="text-align: center;" >
											<td><a href="/Pet/board/b_num/${reservation.b_num}">${reservation.b_title}</a></td>							
											<td>${reservation.r_date}</td>
											<td>${reservation.m_name}</td>
											<td>${reservation.r_completeTF}</td>
											<td>
											<c:if test="${reservation.r_confirmTF eq 'F' && reservation.r_completeTF eq 'F'}">
												<input type="button" name="del_num" onclick="deleteReservation('<c:url value="/reservation/delete/${reservation.b_num}/${ sessionScope.user.getM_num()}/${reservation.r_date}"/>')" value="취소" >
											</c:if>
											<c:if test="${reservation.r_confirmTF eq 'F' && reservation.r_completeTF eq 'T'}">
												거절됨
												<input type="button" onclick="deleteReservation('<c:url value="/reservation/delete/${reservation.b_num}/${ sessionScope.user.getM_num()}/${reservation.r_date}"/>')" value="삭제" >
											</c:if>
											<c:if test="${reservation.r_confirmTF eq 'T' && reservation.r_completeTF eq 'F'}">
												시터수락 &nbsp;
												<input type="button" name="complete_num" onclick="completeReservation('<c:url value="/reservation/update/complete/${reservation.b_num}/${ sessionScope.user.getM_num()}/${reservation.r_date}"/>')" value="시팅완료" >
											</c:if>
											<c:if test="${reservation.r_confirmTF eq 'T'&& reservation.r_completeTF eq 'T'}">
												완료됨  <input type="button" onclick="deleteReservation('<c:url value="/reservation/delete/${reservation.b_num}/${ sessionScope.user.getM_num()}/${reservation.r_date}"/>')" value="삭제" >
											</c:if>
											<td>
										</tr>
									</c:forEach>
								</c:when>
								<c:when test='${detail eq "sitter"}'>
								<tr class="active">	
									<th>게시물 이름</th>
									<th>날짜</th>
									<th>신청자 이름</th>
									<th>연락처</th>
									<th>완료여부</th>
									<th></th>
									
								</tr>
									
									<c:forEach var="reservation" items="${reservationBySitterNum}">
										<tr style="text-align: center;" >
											<td><a href="/Pet/board/b_num/${reservation.b_num}">${reservation.b_title}</a></td>							
											<td>${reservation.r_date}</td>
											<td>${reservation.m_name}</td>
											<c:if test="${reservation.r_confirmTF eq 'F'}">
												<td></td>
											</c:if>
											<c:if test="${reservation.r_confirmTF eq 'T'}">
												<td>${reservation.m_phone}</td>
											</c:if>
											<td>${reservation.r_completeTF}</td>
											<td>
											<c:if test="${reservation.r_confirmTF eq 'F' && reservation.r_completeTF eq 'F'}">
												<input type="button" name="confirm" onclick="confirmReservation('<c:url value="/reservation/update/confirm/${reservation.b_num}/${reservation.m_num}/${reservation.r_date}"/>')" value="수락" >
												<input type="button" name="del_num" onclick="completeReservation('<c:url value="/reservation/update/complete/${reservation.b_num}/${reservation.m_num}/${reservation.r_date}"/>')" value="거절" >
											</c:if>
											<c:if test="${reservation.r_confirmTF eq 'T' && reservation.r_completeTF eq 'F'}">
												수락함
											</c:if>
											<c:if test="${reservation.r_confirmTF eq 'T'&& reservation.r_completeTF eq 'T'}">
												완료됨
											</c:if>
											<c:if test="${reservation.r_confirmTF eq 'F'&& reservation.r_completeTF eq 'T'}">
												거절함
											</c:if>
											</td>
										</tr>
									</c:forEach>								
								</c:when>
								<c:when test="${select eq 'findValue'}">
									<c:forEach var="reservation" items="${searchQuestionList}">
										<tr>
											<td>${reservation.reservationNum}</td>
											<td>${reservation.mNickname}</td>
											<td><a href="/Pet/reservation/qnum/${reservation.reservationNum}">${reservation.reservationTitle}</a></td>
											<td>${reservation.reservationDate}</td>
											<td>${reservation.reservationHits}</td>
										</tr>
									</c:forEach>								
								</c:when>
							</c:choose>
						
							
						</table>
						
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
										
										<h4>예약 신청</h4>
										<p>
											원하시는 펫시터의 게시물을 보고 날짜를 선택하여 예약신청을 하세요.
											<br>*시터에게 연락하시면 빠른 수락여부를 확인 하실 수 있습니다*
										</p>
										
									</div>	</div>	</div>
							
							<div class='col-md-3' >
								
								<div class='process' >
									
									<div class='number' >
										<span>02</span>
									</div>
									
									<div class='content' >
										
										<h4>시터 확인</h4>
										<p>
											펫시터가 예약 신청한 것을 확인 후에 수락/거절합니다.
											<br>*펫시터의 개인사정에 따라 예약 신청은 거절될 수 있습니다*
										</p>
										
									</div> </div> </div>
							
							<div class='col-md-3' >
								
								<div class='process' >
									
									<div class='number' >
										<span>03</span>
									</div>
									<div class='content' >							
										<h4>시팅 진행</h4>
										<p>
											펫시터의 수락 여부를 확인하고 수락하였다면 펫시터와 연락하여  펫시팅을 진행해주세요
										</p>
										
									</div></div></div>
							
							<div class='col-md-3' >
								<div class='process last' >
									<div class='number' >
										<span>04</span>
									</div>
									<div class='content' >
										<h4>시팅 완료</h4>
										<p>
											펫 시팅을 무사히 완료하셨다면 시팅 완료 버튼을 눌러주세요!
										</p>
									</div> </div> </div>
							</div>
						</div>
					
						<div class='section-header text-center' >
						<%-- <form action='<c:url value="/reservation/insertForm.do"/>' method="get"> --%>
							
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