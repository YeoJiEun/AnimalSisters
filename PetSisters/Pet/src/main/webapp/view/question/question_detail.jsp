<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html class='no-js' >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
		<title>Question 상세 정보</title>
		
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
		<link rel="stylesheet" type='text/css' href='<c:url value="/resources/css/bootstrap.css" />' />
		
		<script>
 		  function backQuestionMain(targetUri) {
 			 location.replace(targetUri);
 		  }
 		  
 		  function updateQuestion(targetUri) {
  				location.replace(targetUri);
 		  }
 		  
 		 function deleteQuestion(targetUri) {
 			 if(confirm("정말 삭제하시겠습니까?")) {
 				location.replace(targetUri);
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
				QnA Section
			===============================================================================-->			
				<div class='portfolio-block section-block' >
					
					<div class='container' >
					
						<div class='row' >
							<div class='col-md-6 col-md-offset-3' >
								<div class='section-header text-center' >
									<h2 class='animate text-over-block' >Question  #${questionByNumOrInsert.questionNum}  상세 정보</h2>
								
									<!--divider-->
									<div class='divider-draft center' ></div>
									<!--/divider-->
								</div>
							</div>
						</div>
						
						
						<table class="table table-hover">
							<tr>
								<c:if test="${updateFailed}">
									<td colspan="2" align="center">
      									<font color="red">Question을 수정 할 수 없습니다.</font>
      								</td>
								</c:if> 
								<c:if test="${deleteFailed}">
									<td colspan="2" align="center">
      									<font color="red">Question을 삭제 할 수 없습니다.</font>
      								</td>
								</c:if> 
								
							</tr>
							<tr>
								<th class="active" width="100">닉네임</th>
								<td>${questionByNumOrInsert.mNickname}</td>
							</tr>
							<tr>
								<th class="active" width="100">제목</th>
								<td>${questionByNumOrInsert.questionTitle}</td>
							</tr>
							<tr>
								<th class="active" width="100">내용</th>
								<td>${questionByNumOrInsert.questionContent}</td>
							</tr>
						</table>


						<br> <br>


						<div class='section-header text-center' >	
							<button type="submit" onclick="updateQuestion('<c:url value="/question/update/${questionByNumOrInsert.questionNum}"/>')" class="btn btn-default btn-lg">수정</button>
							
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
							<button type="submit" onclick="deleteQuestion('<c:url value="/question/delete/${questionByNumOrInsert.questionNum}" />')" class="btn btn-default btn-lg">삭제</button>

								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
							<button type="submit" onclick="backQuestionMain('<c:url value="/question/main.do/main"/>')" class="btn btn-default btn-lg">목록</button>
						</div>
						
						
						<br>
						
						<!--divider-->
						<div class='divider-draft center' ></div>
						<!--/divider-->
						
						<br>
						
						<!-- 댓글 파트 -->
						<div class="container">
    					  <form id="commentForm" name="commentForm" method="post">
    						<br><br>
        					<div>
            				 <div> <span><strong>Comments</strong></span>    <span id="cCnt"></span> </div>
            				 <div>
                				<table class="table">                    
                    			 <tr>
                        		   <td>
                                     <textarea style="width: 100%" rows="3" cols="30" id="cContent" name="cContent" placeholder="댓글을 입력하세요"></textarea>
                            		 <br>
                            		 <div>
                                	   <a href='#' onClick="fn_comment('${result.code }')" class="btn pull-right btn-success">등록</a>
                            		 </div>
                        		   </td>
                    			 </tr>
                				</table>
            				 </div>
        					</div>
        					<input type="hidden" id="crNum" name="crNum" value="${questionByNumOrInsert.questionNum}" />
        					<input type="hidden" id="cType" name="cType" value="Question" />   
    					  </form>
						</div>
						
						<div class="container">
    					  <form id="commentListForm" name="commentListForm" method="post">
        				  	<div id="commentList"> </div>
    					  </form>
						</div>
 
 						<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
 						<script>
							/* 댓글 등록하기(Ajax) */
							function fn_comment(code) {
    							if(commentForm.cContent.value == "") {
									alert("댓글 내용을 입력하세요.");
									commentForm.cContent.focus();
									return false;
								}
	
    							$.ajax({
        						type:'POST',
        						url : "<c:url value='/comment/addComment.do'/>",
        						data:$("#commentForm").serialize(),
        						success : function(data){
        							if(data=="success") {
        								getCommentList();
        								$("#comment").val("");
        							}
        						},
        						error:function(request,status,error){
            						//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        							}
    							});
							}

							
							/* 초기 페이지 로딩시 댓글 불러오기 */
    						$(document).ready(function() { getCommentList(); });
							
	 
							/* 댓글 불러오기(Ajax) */
							function getCommentList(){
								$.ajax({
									type:'GET',
									url : "<c:url value='/comment/commentList.do'/>",
									dataType : "json",
									data:$("#commentForm").serialize(),
									contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
									success : function(data){ 
										var html = "";
										var cCnt = data.length;
										var sessionmNum = '<%= (int)((User)session.getAttribute("user")).getM_num() %>';
								
										if(data.length > 0){
											for(i=0; i<data.length; i++){
												if(data[i].mNum == sessionmNum) {
													html += "<div>";
													html += "<div><table class='table'><h6><strong>" + data[i].mNickname + "</strong>  (" + data[i].cDate + ")";
													html += "<a href='<c:url value='/comment/updateFormComment.do/" + data[i].cNum + "'/>')' class='btn pull-right btn-success'>수정</a>";
													html += "<a href='#' onClick='delete_comment(" + data[i].cNum + ")' class='btn pull-right btn-success'>삭제</a>";	
													html += "</h6>" + data[i].cContent + "<tr><td></td></tr>";
													html += "</table></div>";
													html += "</div>";
												}
												else {
													html += "<div>";
													html += "<div><table class='table'><h6><strong>"+data[i].mNickname+"</strong>(" + data[i].cDate + ")</h6>";
													html += data[i].cContent + "<tr><td></td></tr>";
													html += "</table></div>";
													html += "</div>";
												}
											}
            							} else {
            								html += "<div>";
            								html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
            								html += "</table></div>";
            								html += "</div>";      
            							}
            
										$("#cCnt").html(cCnt);
										$("#commentList").html(html); },
										error:function(request,status,error){  }  
									});
								} 
							
							
							/* 댓글 삭제하기(Ajax) */
							function delete_comment(cNum) {
								if(confirm("정말 삭제하시겠습니까?"))  {
									$.ajax({
		        						type :'POST',
		        						url : "<c:url value='/comment/deleteComment.do/" + cNum + "'/>",
		        						data : cNum,
		        						success : function(data){
		        							if(data=="success") {
		        								getCommentList();
		        								$("#comment").val("");
		        							}
		        						},
		        						error:function(request,status,error){
		            						//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		        							}
		    							});	
								}
						 		else
						 			return false; 
							}
						
							</script>
						
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