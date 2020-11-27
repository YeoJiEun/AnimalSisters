<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	
		<title>USED MARKET 상세 정보</title>
		
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
		  function insertUsedMarket(targetUri) {
			if (targetUri == "no_user") {
				alert("Used Market에 게시글을 등록하시려면 로그인은 필수입니다.");
				return false;
			} else {
				if (targetUri == "mType_0") {
					alert("관리자는 Used Market에 게시글을 등록할 수 없습니다.");
					return false;
				} else {
					location.replace(targetUri);
				}
			}
		  }
		  
		  function backUsedMarketMain(targetUri) {
	 		location.replace(targetUri);
	 	  }
	 		  
	 	  function updateUsedMarket(targetUri) {
	  		location.replace(targetUri);
	  	  }
	 		  
	 	  function deleteUsedMarket(targetUri) {
	 		if(confirm("정말 삭제하시겠습니까?")) 
	 			location.replace(targetUri);
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
								<h2>USED MARKET 상세 정보</h2>
								
								<!--divider-->
								<div class='divider-draft center' ></div>
								<!--/divider-->
							</div>
						</div>
					</div>
				</div>
				
			
				<div class='posts-block section-block' >
					<div class='container' >
					
					<c:if test="${updateFailed}">
						<table style="width:100%">
							<tr> <td align="center"> <font color="red">UsedMarket은 관리자와 글쓴이만 수정 할 수 있습니다.</font> </td> </tr>
							<tr> <td> <br><br> </td> </tr>
					  </table>
					</c:if> 
					<c:if test="${deleteFailed}">
						<table style="width:100%">
							<tr> <td align="center"> <font color="red">UsedMarket은 관리자와 글쓴이만 삭제 할 수 있습니다.</font> </td> </tr>
							<tr> <td> <br><br> </td> </tr>
					  </table>
					</c:if> 		

						<div class='row' >
							<div class='col-md-8' >
							  <div class='post'>
							   <% int count = 0; %>
							   <div class="testimonials-slider">
                                <c:forEach var = "photo" items="${selectPhotoByuNum}">
                                <c:choose>
                                <c:when test="${photo.photoPath.contains('C')}">
                                <div class='testimonial'>
                                   <div class='media'>
                                	 <img src="${photo.photoPath}" alt="이미지를 찾을 수 없습니다"/> 
                                	  <% count++; %>
                                   </div>
                                 </div> 
                                </c:when>
                                <c:otherwise>
                                <div class='testimonial'>
                                   <div class='media'>
                                	 <img src="${pageContext.request.contextPath}/resources/img/used_market/${photo.photoPath}" alt="이미지를 찾을 수 없습니다"/> 
                                	  <% count++; %>
                                   </div>
                                 </div> 
                                </c:otherwise>
                                 </c:choose>
                                </c:forEach>
                                </div>
                                <% if(count == 0) { %>
                                 <div class='media' >
									<img alt='symp' src='<c:url value="/resources/img/bg2.jpg" />' >
								 </div>
							  	<% } %>
								
								<div class='content'>
								  <h4> ${usedMarketByNumOrInsert.uTitle} </h4>

									<br>
									
									<table>
										<tr>
											<td width = "200" height="30"><i class='ion-ios-person'></i> 닉네임    :    <span>${usedMarketByNumOrInsert.mNickname}</span></td>
											<td width = "200" height="30"><i class='ion-ios-clock'></i> 올린 날짜    :    <span>${usedMarketByNumOrInsert.uDate}</span></td>
											<td width = "200" height="30"><i class='icon ion-social-usd'></i> 가격    :    <span><fmt:formatNumber value="${usedMarketByNumOrInsert.uPrice}" pattern="#,###,###" /></span></td>
											<td width = "200" height="30">
											  <c:choose>
											    <c:when test="${usedMarketByNumOrInsert.uCompleteTF eq 'T'}">
												  <i class="icon ion-checkmark-circled"></i> <span>거래 완료</span>
											    </c:when>
											    <c:otherwise>
											      <i class="icon ion-checkmark-circled"></i> <span>거래 중</span>
											    </c:otherwise>
											  </c:choose>
										  	</td>
										</tr>																	
										<tr>
											<td width = "200" height="30"><i class='icon ion-information'></i> 물건 종류    :    <span>${usedMarketByNumOrInsert.gType}</span></td>
											<c:choose>
											  <c:when test="${empty usedMarketByNumOrInsert.uUsedate}">
											  	<td width = "200" height="30"><i class='icon ion-android-alarm-clock'></i> 사용 기간    :    <span>X</span></td>
											  </c:when>
											  <c:otherwise>
											  	<td width = "200" height="30"><i class='icon ion-android-alarm-clock'></i> 사용 기간    :    <span>${usedMarketByNumOrInsert.uUsedate}</span></td>
											  </c:otherwise>
											</c:choose>
											<c:choose>
											  <c:when test="${empty usedMarketByNumOrInsert.uExpiredate}">
											  	<td width = "200" height="30" colspan="2"><i class='icon ion-calendar'></i> 유통 기한    :    <span>X</span></td>
											  </c:when>
											  <c:otherwise>
											  	<td width = "200" height="30" colspan="2"><i class='icon ion-calendar'></i> 유통 기한    :    <span>${usedMarketByNumOrInsert.uExpiredate}</span></td>
											  </c:otherwise>
											</c:choose>
										</tr>
									</table>

								  <br>

								  <p>${usedMarketByNumOrInsert.uContent}</p>
										
								  <!--divider-->
								  <br><br><div class='divider-draft center' ></div><br>
								  <!--/divider-->			
											
								  <!-- 댓글 파트 -->
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
                            		 	  <div> <a href='#' onClick="fn_comment('${result.code }')" class="btn pull-right btn-success">등록</a> </div>
                        		   		 </td>
                    			 		</tr>
                					  </table>
            				 		</div>
        						   </div>
        						   <input type="hidden" id="crNum" name="crNum" value="${usedMarketByNumOrInsert.uNum}" />
        						   <input type="hidden" id="cType" name="cType" value="UsedMarket" />   
    					 	 	  </form>
						
    					  		  <form id="commentListForm" name="commentListForm" method="post">
        				  			<div id="commentList"> </div>
    					  		  </form>
 
 								  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
 								  <script>
									/* 댓글 등록하기(Ajax) */
									function fn_comment(code) {
    									if(commentForm.cContent.value == "") {
											alert("댓글 내용을 입력하세요.");
											commentForm.cContent.focus();
											return false;
										}
    							
    									var user = '<%= ((User)session.getAttribute("user")) %>';
    									
    									if(user == "null") {
    										alert("로그인 후 댓글 내용을 입력할 수 있습니다.");
    										return false;
    									}
    									else {
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
												var user = '<%= ((User)session.getAttribute("user")) %>';
								
												if(user == "null") {
													if(data.length > 0){
														for(i=0; i<data.length; i++){
																html += "<div>";
																html += "<div><table class='table'><h6><strong>"+data[i].mNickname+"</strong>(" + data[i].cDate + ")</h6>";
																html += data[i].cContent + "<tr><td></td></tr>";
																html += "</table></div>";
																html += "</div>";
														}
		            								} else {
		            									html += "<div>";
		            									html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
		            									html += "</table></div>";
		            									html += "</div>";      
		            								}
												}
												else {
													var sessionmNum = (user.split(",")[0]).split("=")[1];
										
													if(data.length > 0) {
														for(i=0; i<data.length; i++) {
															if(data[i].mNum == sessionmNum || sessionmNum == 1) {
																html += "<div>";
																html += "<div><table class='table'><h6><strong>" + data[i].mNickname + "</strong>  (" + data[i].cDate + ")";
																html += "<a href='#' onClick='delete_comment(" + data[i].cNum + ")' class='btn pull-right btn-success'>삭제</a>&nbsp;&nbsp;&nbsp;";	
																html += "<a href='<c:url value='/comment/updateFormComment.do/" + data[i].cNum + "'/>')' class='btn pull-right btn-success'>수정</a>";
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
							</div>
						
					<div class='col-md-4'>
						<div class='sidebar'>
							<div class='sidebar-widget'>
								<c:choose>
									<c:when test="${sessionScope.user == null}">
										<button type="submit" onclick="insertUsedMarket('no_user')"
											class="btn btn-default btn-lg">글쓰기</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" onclick="updateUsedMarket('<c:url value="/used_market/updateForm.do/${usedMarketByNumOrInsert.uNum}"/>')"
											class="btn btn-default btn-lg">글 수정</button>
										<br><br>
										<button type="submit" onclick="deleteUsedMarket('<c:url value="/used_market/delete/${usedMarketByNumOrInsert.uNum}"/>')"
											class="btn btn-default btn-lg">글 삭제</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" onclick="backUsedMarketMain('<c:url value="/used_market/main.do/main"/>')" 
											class="btn btn-default btn-lg">목록</button>
									</c:when>
									<c:when test="${sessionScope.user.getM_type() == 0}">
										<button type="submit" onclick="insertUsedMarket('mType_0')"
											class="btn btn-default btn-lg">글쓰기</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" onclick="updateUsedMarket('<c:url value="/used_market/updateForm.do/${usedMarketByNumOrInsert.uNum}"/>')"
											class="btn btn-default btn-lg">글 수정</button>
										<br><br>
										<button type="submit" onclick="deleteUsedMarket('<c:url value="/used_market/delete/${usedMarketByNumOrInsert.uNum}"/>')"
											class="btn btn-default btn-lg">글 삭제</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" onclick="backUsedMarketMain('<c:url value="/used_market/main.do/main"/>')" 
											class="btn btn-default btn-lg">목록</button>
									</c:when>
									<c:otherwise>
										<button type="submit" onclick="insertUsedMarket('<c:url value="/used_market/insertForm.do"/>')"
											class="btn btn-default btn-lg">글쓰기</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" onclick="updateUsedMarket('<c:url value="/used_market/updateForm.do/${usedMarketByNumOrInsert.uNum}"/>')"
											class="btn btn-default btn-lg">글 수정</button>
										<br><br>
										<button type="submit" onclick="deleteUsedMarket('<c:url value="/used_market/delete/${usedMarketByNumOrInsert.uNum}"/>')"
											class="btn btn-default btn-lg">글 삭제</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="submit" onclick="backUsedMarketMain('<c:url value="/used_market/main.do/main"/>')" 
											class="btn btn-default btn-lg">목록</button>
									</c:otherwise>
								</c:choose>
							</div>

							<div class='sidebar-widget'>
								<div class='categories-widget'>
									<div class='widget-header'>
										<h4>
											<i class='ion-ios-folder'></i> Categories
										</h4>
									</div>

									<ul class='sidebar-list'>
										<li><a href='/Pet/used_market/category/1'>사료</a></li>
										<li><a href='/Pet/used_market/category/2'>간식</a></li>
										<li><a href='/Pet/used_market/category/3'>하우스</a></li>
										<li><a href='/Pet/used_market/category/4'>급식기/급수기</a></li>
										<li><a href='/Pet/used_market/category/5'>미용/목욕</a></li>
										<li><a href='/Pet/used_market/category/6'>배변용품</a></li>
										<li><a href='/Pet/used_market/category/7'>의류/패션</a></li>
										<li><a href='/Pet/used_market/category/8'>장난감</a></li>
										<li><a href='/Pet/used_market/category/9'>기타</a></li>
									</ul>
								</div>
							</div>

							<div class='sidebar-widget'>
								<div class='widget-header'>
									<h4> <i class='ion-document'></i> Recent Posts </h4>
								</div>

								<ul class='sidebar-list'>
									<c:forEach var="descHitsUsedMarket" items="${descHitsUsedMarketList}">
										<li><a href='/Pet/used_market/unum/${descHitsUsedMarket.uNum}'> ${descHitsUsedMarket.uTitle} </a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
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