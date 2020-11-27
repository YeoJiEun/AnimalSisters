<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

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
				About Section
			===============================================================================-->
				<div class='basic-info section-block' >
					<div class='container' >					
						<div class='section-header text-center' >							
							<h2>Info About 'Hello, Pet World!'</h2>
							
							<!--divider-->
							<div class='divider-draft center' ></div>
							<!--/divider-->														
						</div>
						
						<div class='row' >							
							<div class='col-md-4' >
								<div class='about-person-img' >									
									<img src='<c:url value="/resources/img/about/pet_sitter.png" />' alt='Symp' />									
								</div>							
							</div>
														
							<div class='col-md-8 about-info' >
								<br><br><br>
								<h4>배경</h4>
								<p>
									예기치 못한 상황에서 반려동물을 오랜 기간 혼자 둬야 할 경우나 정기적으로 업무시간 동안 반려동물을 집에 홀로 두어야
									하는 직장인 등 반려동물을 돌보지 못하는 경우가 많은 주인들이 존재
								</p>
								
								<br><br><br>
								
								<h4>목적</h4>
								<p>
									반려동물을 돌봐주기 위해 믿을 수 있는 “펫시터”의 구인/구직 중개 사이트 애완동물 관련 중고물품에 대한 구매/판매 가능 
								</p>
							</div>						
						</div>						
					</div>					
				</div>
				
				<div class='about-icons section-block' >					
					<div class='container' >						
						<div class='row' >							
							<div class='col-md-3' >
								<div class='service' >
									<div class='icon' >
										<i class="icon ion-ios-paw"></i>
									</div>
									<div class='content' >
										<h4>돌봄 서비스</h4>
										<p>
											가족과 같은 반려동물을 믿을 수 있는 <br>
											사람에게 돌봄 받을 수 있는 서비스 제공 
										</p>
									</div>
								</div>
							</div>
							
							<div class='col-md-3' >
								<div class='service' >
									<div class='icon' >
										<i class="icon ion-android-clipboard"></i>
									</div>
									<div class='content' >
										<h4>프로필 기능</h4>
										<p>
											 “펫시터” 프로필을 통해 <br>
											 반려동물에 맞는 펫시터 구인 가능
										</p>
									</div>
								</div>
							</div>
							
							<div class='col-md-3' >
								<div class='service' >
									<div class='icon' >
										<i class="icon ion-android-chat"></i>
									</div>
									<div class='content' >
										<h4>실시간 구인/구직</h4>
										<p> 실시간 구인/구직 가능 </p>
									</div>
								</div>
							</div>
							
							<div class='col-md-3' >
								<div class='service' >
									<div class='icon' >
										<i class="icon ion-ios-cart"></i>
									</div>
									<div class='content' >
										<h4>중고 거래</h4>
										<p>
											반려동물 용품 관련 중고 거래<br>
											댓글을 이용한 중고 거래 방식 
										</p>
									</div>
								</div>
							</div>
							
							<div class='col-md-3' >
								<div class='service' >
									<div class='icon' >
										<i class="icon ion-ios-people"></i>
									</div>
									<div class='content' >
										<h4>추천 기능</h4>
										<p>
											추천 기능을 활용해 일반회원에게<br>
											맞는 펫시터 3명을 랜덤 나열
										</p>
									</div>
								</div>
							</div>
							
							<div class='col-md-3' >
								<div class='service' >
									<div class='icon' >
										<i class="icon ion-android-calendar"></i>
									</div>
									<div class='content' >
										<h4>구글 Calendar API</h4>
										<p>
											구글 캘린더 API를 이용해<br>
											스케줄 확인 및 예약 기능
										</p>
									</div>
								</div>
							</div>
							
							<div class='col-md-3' >
								<div class='service' >
									<div class='icon' >
										<i class="icon ion-social-usd"></i>
									</div>
									<div class='content' >
										<h4>포인트</h4>
										<p>
											포인트를 이용한 매칭, 거래<br> 
											마이페이지에서 포인트 거래 내역 확인 
										</p>
									</div>
								</div>
							</div>	
							
						</div>
						
					</div>
				</div>
				
				<div class='funfacts-block section-block' data-stellar-background-ratio='.2' >
					<div class='container' >
						<div class='row' >
							<div class='col-md-3 col-sm-6 funfact' >
								<div class='content' >
								</div>
							</div>
							<div class='col-md-3 col-sm-6 funfact' >
								<div class='content' >
								</div>
							</div>
							<div class='col-md-3 col-sm-6 funfact' >
								<div class='content' >
								</div>
							</div>
							<div class='col-md-3 col-sm-6 funfact' >
								<div class='content' >								
								</div>
							</div>	
						</div>					
					</div>
				</div>
				
				<div class='testimonials-block section-block' >
					<div class='container' >
						<div class='section-header text-center' >
							<h2 class='animate text-over-block' >Team Members</h2>
							
							<!--divider-->
							<div class='divider-draft center' ></div>
							<!--/divider-->
						</div>
						
						<div class='row' >
							<div class='col-md-8 col-md-offset-2' >
								<div class='testimonials-slider' >
									<div class='testimonial' >
										<p>
											* Main(메인 화면, 네비게이션 바, About section, bootstrap 등 구현)<br>
											* QnA(검색, 리스트, 세부정보, 질의 등록/수정/삭제, 응답 등록/수정/삭제)<br>
											* Used Market(검색, 리스트, 세부정보, 댓글, 등록/삭제/수정)
										</p>
										<div class='author' >
											<h4>송혜진</h4>
											<p>20160966 컴퓨터학과</p>
										</div>
									</div>
									
									<div class='testimonial' >
										<p>
											* 관심 관리(생성/조회/삭제, 추천 펫시터 조회)<br>
											* 예약 관리(생성/조회/삭제)<br>
											* 구인 게시글 관리(생성/조회/삭제/수정) 
										</p>
										<div class='author' >
											<h4>여지은</h4>
											<p>20160971 컴퓨터학과</p>
										</div>
									</div>
									
									<div class='testimonial' >
										<p>
											* 포인트 관리(포인트 내역 조회/입력)<br>
											* 스케쥴 관리(조회/삭제/수정)<br>
											* 동물(새로운 동물 등록, 등록한 동물 조회/삭제/수정)
										</p>
										<div class='author' >
											<h4>정윤진</h4>
											<p>20160999 컴퓨터학과</p>
										</div>
									</div>
									
									<div class='testimonial' >
										<p>
											* 사용자 기능(회원가입, 로그인, 마이페이지 관리, 정보수정, 탈퇴, 펫시터 등록)
										</p>
										<div class='author' >
											<h4>정윤희</h4>
											<p>20161000 컴퓨터학과</p>
										</div>
									</div>
									
								</div>
								
							</div>
							
						</div>
					
					</div>
				</div>
				
				
				<%@ include file="/view/include/bottom.jsp"%>

			<!--=============================================================================
				/About Section
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