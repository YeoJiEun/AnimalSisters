<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html class='no-js'>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Hello Pet World!</title>
	
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/bootstrap/css/bootstrap.min.css" />' />
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/css/ionicons.min.css" />' />
	
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/css/owl.carousel.css" />' />
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/css/owl.theme.css" />' />
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/css/owl.transitions.css" />' />
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/css/magnific-popup.css" />' />
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/css/style.css" />' />
	<link rel='stylesheet' type='text/css'
		href='<c:url value="/resources/css/color-default.css" />' />

	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
   	<script>
  	 function OnOff(v, id) {
  		 if (v == '1')
  			document.getElementById(id).style.display="none";
  		 if (v == '2')
  			 document.getElementById(id).style.display="";
  	 }
  	 
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
			login_format
		===============================================================================-->
		<div class='contact-block section-block'>
			<div class='container'>
				<div class='row'>
					<div class='col-md-6 col-md-offset-3'>

						<div class='section-header text-center'>
							<h2 class='animate text-over-block'>Register Form</h2>

							<!--divider-->
							<div class='divider-draft center'></div>
							<!--/divider-->
							<p>Input Your Information</p>
						</div>

					</div>
				</div>
				
				
				<div class='row'>
					<div class='col-md-8 col-md-offset-2'>
						<spring:hasBindErrors name="regiForm" />
						<form id='contact-form' class='contact-form' method='post' enctype="multipart/form-data" >
        				<fieldset>
			                <table class="table">
							<tr>
                            	<th class="active" scope="row"><label for="id">아이디</label></th>
                            	<td>
									<input type="text" name="id" id="userId" value="${regiForm.id}" class='form-control' placeholder='ID' required/>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="pw">비밀번호</label></th>
                            	<td>
									<input type='password' class='form-control' name="pw" id="userPw" value="${regiForm.pw}" placeholder='PASSWORD' required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="pw">비밀번호 확인</label></th>
                            	<td>
									<input type='password' class='form-control' name="confirmPw" id="confirmPw" value="${regiForm.confirmPw}" onkeyup="pwValid()" placeholder='CONFIRMPASSWORD' required>
									<div class="check_font" id="pw_check"></div>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="username">이름</label></th>
                            	<td>
									<input type="text" class='form-control' name="name" id="userName" value="${regiForm.name}" required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userNickame">닉네임</label></th>
                            	<td>
									<input type="text" class='form-control' name="nickname" id="userNickName" value="${regiForm.nickname}" required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userphone">전화번호</label></th>
                            	<td>
									<input type="text" class='form-control' name="phone" id="userPhone" value="${regiForm.phone}" onkeyup="phoneValid()" required>
									<div class="check_font" id="phone_check"></div>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userphone">주소</label></th>
                            	<td>
									<input type="text" class='form-control' name="addr" id="userAddr" value="${regiForm.addr}" required>
								</td>
							</tr>
							<tr>
                            	<th class="active" scope="row"><label for="userType">타입</label></th>
                            	<td>
                            		<select id="type" name="m_type" class='form-control' onclick="OnOff(this.value, 'hideForm')">
                            			<c:forEach var="userType" items="${userTypeList}">
											<option value="${userType.type}">${userType.value}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
                			</table>
                			<spring:hasBindErrors name="sitterForm" />
                			<table class="table" id="hideForm" style="display:none;">
	                			<tr>
	                            	<th class="active" scope="row" rowspan="3" colspan="2">
	                            		<img src="resources/img/user.png" width="150px" height="150px"/>
	                            	<input type="file" name="picture" value="${sitterForm.picture}" />
	                            	</th>
								</tr>
								<tr>
		                            <th class="active" width="80"><label for="age">나이</label></th>
		                            <td>
										<input type='text' class='form-control' name="age" id="age" value="${sitterForm.age}" placeholder='AGE' required>
									</td>
								</tr>
								<tr>
		                            <th class="active" scope="row"><label for="care">돌봄<br />횟수</label></th>
		                            <td width="200">
										<input type='text' class='form-control' name="careNum" id="careNum" value="${sitterForm.careNum}" readonly>
									</td>
								</tr>
                			</table>
                			<div class='form-group text-center'>
                				<button class="btn btn-default btn-lg" type="submit" onclick="register('<c:url value="/user/register"/>')">확인</button>
                				<button class="btn btn-default btn-lg" type="reset">리셋</button>
                			</div>
                		</fieldset>
                		</form>
						
					</div>
				</div>

		</div>
	</div>

		
		<section>
			<%@ include file="/view/include/bottom.jsp"%>
		</section>

		<!--close button-->
		<div class='close-btn'>
			<span></span> <span></span>
		</div>
		<!--/close button-->


	</div>
	<!--=============================================================================
			/Main Wrapper
		===============================================================================-->


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