
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html class='no-js' >
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->		
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
		
	<div class='contact-block section-block' >
		<div class='container' >
			<div class='row' >
				<div class='col-md-6 col-md-offset-3' >
						
					<div class='section-header text-center' >
						<!--/divider-->
									<p>
										등록할 pet의 정보를 입력해주세요.
									</p>
								</div>
							
							</div>
						</div>
						
						<div class='row' >
							<div class='col-md-8 col-md-offset-2' >
								<spring:hasBindErrors name="petForm" />
								<form id='petForm' class='petForm' method='post' data-toggle='validator' >
								<table class="table" >
								<tr>
                            	<th class="active" scope="row"><label for="p_name">이름</label></th>
                            	<td>
									<input type="text" name="p_name" id="p_name" class='form-control' placeholder='Name' required/>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="p_age">나이</label></th>
                            	<td>
									<input type='text' class='form-control' name="p_age" id="p_age" placeholder='Age' required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="p_gender">성별</label></th>
                            	<td>
                            		<select name="p_gender" class='form-control' id="p_gender" required>
                            			<option value="남자">남자</option>
                            			<option value="여자">여자</option>
									</select>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="p_type">종류</label></th>
                            	<td>
                            		<select name="p_type" class='form-control' id="p_type" required>
                            			<option value="강아지">강아지</option>
                            			<option value="고양이">고양이</option>
									</select>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="p_detail">세부사항</label></th>
                            	<td>
									<input type="text" class='form-control' name="p_detail" id="p_detail" placeholder='Detail' required>
								</td>
							</tr>
                			</table>
	                			<div class='form-group text-center'>
	                				<button class="btn btn-default btn-lg" type="submit" formaction='<c:url value="/view/pet/insert"/>'>등록</button>
	                				<button class="btn btn-default btn-lg" type="reset">리셋</button>
	                			</div>
							</form>
							</div>
						</div>

						
					</div>
				</div>
			
				
	
								
</body>
	