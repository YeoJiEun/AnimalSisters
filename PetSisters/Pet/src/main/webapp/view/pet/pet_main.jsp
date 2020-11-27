
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class='no-js' >
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		
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
		
				

			<div class='row' >
				<div class='col-md-6 col-md-offset-3' >
						
					<div class='section-header text-center' >
									<p>
										등록된 pet의 정보입니다.
									</p>
								</div>
							
							</div>
						</div>
						
							<div class='col-md-8 col-md-offset-2' >
							<spring:hasBindErrors name="petForm" />
							<form id='petForm' class='petForm' method='post' data-toggle='validator' >
								<table class="table">
									<tr>
		                            	<th class="active" scope="row"><label for="id">이름</label></th>
		                            	<td>
											<input type="text" name="p_name" id="petName" value="${petForm.p_name}" class='form-control'/>
										</td>
									</tr>
									<tr>
		                            	<th class="active" scope="row"><label for="id">나이</label></th>
		                            	<td>
											<input type="text" name="p_age" id="petAge" value="${petForm.p_age}" class='form-control'/>
										</td>
									</tr>
									<tr>
                            	<th class="active" scope="row"><label for="p_gender">성별</label></th>
                            	<td>
                            		<select name="p_gender" class='form-control' id="p_gender" required>
                            			<c:if test="${petForm.p_gender == '남자'}">
	                            			<option value="남자" selected>남자</option>
	                            			<option value="여자">여자</option>
                            			</c:if>
                            			<c:if test="${petForm.p_gender == '여자'}">
	                            			<option value="남자" >남자</option>
	                            			<option value="여자" selected>여자</option>
                            			</c:if>
									</select>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="p_type">종류</label></th>
                            	<td>
                            		<select name="p_type" class='form-control' id="p_type" required>
                            		<c:if test="${petForm.p_type == '강아지'}">
                            			<option value="강아지" selected>강아지</option>
                            			<option value="고양이">고양이</option>
                            		</c:if>
                            		<c:if test="${petForm.p_type == '고양이'}">
                            			<option value="강아지">강아지</option>
                            			<option value="고양이" selected>고양이</option>
                            		</c:if>
									</select>
								</td>
							</tr>
									<tr>
		                            	<th class="active" scope="row"><label for="id">세부사항</label></th>
		                            	<td>
											<input type="text" name="p_detail" id="petDetail" value="${petForm.p_detail}" class='form-control'/>
										</td>
									</tr>
								</table>
							<div class='section-header text-center' >
								<button type="submit" class="btn btn-default btn-lg" formaction='<c:url value="/view/pet/update"/>'>수정</button>
								<button type="submit" class="btn btn-default btn-lg" formaction='<c:url value="/view/pet/delete"/>'>삭제</button>
							</div>
					</form>	
					</div>
			
								
</body>
	