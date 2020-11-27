<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<% request.setCharacterEncoding("UTF-8"); %>
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
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
   	<script>
  	function pwValid() {
  		var pw = $("#userPw").val();
  		var cPw = $("#confirmPw").val();
        if(cPw.match(pw)==null){
        	$('#pw_check').text('패스워드가 일치하지 않습니다.');
 			$('#pw_check').css('color', 'red');
 			$("#confirmPw").focus();
        }
        else
        	$('#pw_check').text("")
  	 }
  	 
  	 function phoneValid() {
  		var phoneExp = /^01([0|1|6|7|8|9]?)-([0-9]{3,4})-([0-9]{4})$/;
  		var phone = $("#userPhone").val();
        if(phone.match(phoneExp)==null){
        	$('#phone_check').text('양식은 01X-XXXX-XXXX(010-XXX-XXXX)입니다.');
 			$('#phone_check').css('color', 'red');
            $("#userPhone").focus();
        }
        else
        	$('#phone_check').text("")
  	 }
   </script>

<body>

	<div class='container'>
		<div class='row'>
			<div class='col-md-6 col-md-offset-3'>
				<div class='section-header main-title text-center'>
					<spring:hasBindErrors name="updateUser" />
						<form id='contact-form' class='contact-form' method='post' >
        				<fieldset>
			                <table class="table">
							<tr>
                            	<th class="active" scope="row"><label for="id">아이디</label></th>
                            	<td>
									<input type="text" name="id" id="userId" value="${updateUser.id}" class='form-control' readonly="readonly"/>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="pw">비밀번호</label></th>
                            	<td>
									<input type='password' class='form-control' name="pw" id="userPw" value="${updateUser.pw}" placeholder='PASSWORD' required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="pw">비밀번호 확인</label></th>
                            	<td>
									<input type='password' class='form-control' name="confirmPw" id="confirmPw" value="${updateUser.confirmPw}" placeholder='CONFIRMPASSWORD' onkeyup="pwValid()" required>
									<div class="check_font" id="pw_check"></div>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="username">이름</label></th>
                            	<td>
									<input type="text" class='form-control' name="name" id="userName" value="${updateUser.name}" required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userNickame">닉네임</label></th>
                            	<td>
									<input type="text" class='form-control' name="nickname" id="userNickName" value="${updateUser.nickname}" required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userphone">전화번호</label></th>
                            	<td>
									<input type="text" class='form-control' name="phone" id="userPhone" value="${updateUser.phone}" onkeyup="phoneValid()" required>
									<div class="check_font" id="phone_check"></div>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userphone">주소</label></th>
                            	<td>
									<input type="text" class='form-control' name="addr" id="userAddr" value="${updateUser.addr}" required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userType">타입</label></th>
                            	<td>
                            		<input type="text" name="type" id="userType" value="${updateUser.m_type}" class='form-control' readonly="readonly"/>
								</td>
							</tr>
                			</table>
                			
                			<div class='form-group text-center'>
                				<button class="btn btn-default btn-lg" type="submit" onclick="updateRegi('<c:url value="/user/mypage/mypage_profile"/>')">확인</button>
                				<button class="btn btn-default btn-lg" type="reset">리셋</button>
                				<button class="btn btn-default btn-lg" type="button" onclick="location.href='${pageContext.request.contextPath}/view/user/mypage/mypage_delete'">탈퇴</button>
                			</div>
                		</fieldset>
                		</form>
						
					</div>
			</div>
		</div>
	</div>


	<!--=============================================================================
			JavaScript Files
		===============================================================================-->
	<script src='<c:url value="/resources/js/jquery.min.js" />'></script>
	<script src='<c:url value="/resources/js/jquery.stellar.min.js" />'></script>
	<script src='<c:url value="/resources/js/modernizr.js" />'></script>
	<script src='<c:url value="/resources/js/owl.carousel.min.js" />'></script>
	<script src='<c:url value="/resources/js/jquery.shuffle.min.js" />'></script>
	<script
		src='<c:url value="/resources/js/jquery.magnific-popup.min.js" />'></script>
	<script src='<c:url value="/resources/js/validator.min.js" />'></script>
	<script src='<c:url value="/resources/js/smoothscroll.js" />'></script>
	<script src='<c:url value="/resources/js/script.js" />'></script>


</body>

</html>
