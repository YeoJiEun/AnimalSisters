<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html class='no-js' >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<title>Question Comment 수정</title>
		
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
 		  function updateQuestionComment() {	
 			if(form.c_content.value == "") {
 			  	alert("내용을 입력하세요.");
 			  	form.c_content.focus();
 			  	return false;
 			}
 			
 			form.submit();
 		  }
	
 		  
 		  function backQuestionDetail(targetUri) {
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
				QnA Section
			===============================================================================-->			
				<div class='portfolio-block section-block' >
					
					<div class='container' >
					
						<div class='row' >
							<div class='col-md-6 col-md-offset-3' >
								<div class='section-header text-center' >
								
									<h2 class='animate text-over-block' >Comment  #${comment.cNum}  수정</h2>
									
									<!--divider-->
									<div class='divider-draft center' ></div>
									<!--/divider-->
								</div>
							</div>
						</div>
									
						<form name="form" action="<c:url value='/comment/updateComment.do/${comment.cNum}'/>">
  							<div class="form-group">
    							<label for="c_content">댓글 내용</label>
    							<textarea class="form-control" rows="5" name="c_content" >${comment.cContent}</textarea>
 			 				</div>
 			 				
 			 				<br><br>
 			 				
 			 				<div class='section-header text-center'>
								<input type="submit" value="Comment 수정" onclick="updateQuestionComment()" class="btn btn-default btn-lg">
								
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
								<button type="button" onclick="backQuestionDetail('<c:url value="/question/qnum/${comment.crNum}"/>')" class="btn btn-default btn-lg">취소</button>
							</div>					 
							
						</form>
				
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