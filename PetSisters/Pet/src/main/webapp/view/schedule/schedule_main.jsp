
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	
				<div class='portfolio-block section-block' >
					
					<div class='container' >
					
						<div class='row' >
							<div class='col-md-6 col-md-offset-3' >
								<div class='section-header text-center' >
								
									<h4 class='animate text-over-block' >Schedule 조회</h4>
									
									<br><br>
						
								</div>
							</div>
						</div>
						
						<!-- 추가한 코드 -->
						<form id='scheduleForm' class='scheduleForm' method='post' data-toggle='validator' >
						<table class="table table-hover">
							<tr class="active">
								<th>날짜</th>
								<th>선택</th>
							</tr>
							<c:if test="${scheduleArr != null}">
								<c:forEach var="scheduleArr" items="${scheduleArr}">
									<tr >
										<td>${scheduleArr.s_date }</td>
										<td><input type="checkbox" name="deleteArr" id="deleteArr" value="${scheduleArr.s_num}"/></td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
						<div class='section-header text-center' >
							<button type="submit" class="btn btn-default btn-lg" formaction='<c:url value="/view/schedule/calendar"/>'>달력보기</button>
							<%-- <button type="submit" class="btn btn-default btn-lg" formaction='<c:url value="/view/schedule/delete"/>'>삭제</button> --%>
						</div>
						</form>
						</div>
						</div>
			</body>
				