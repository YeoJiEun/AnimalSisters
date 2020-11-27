<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class='no-js' >
	<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
   <script>
      function logout() {
    	  $.ajax ({
    		 type : "POST", 
    		 dataType : "text", 
    		 url : "/logout", 
    		 data : query,
    		 success : function() {
    			 alert("로그아웃 되었습니다!");
    			 location.href = ctx;
    		 }
    	  });
      }
   </script>
	<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/Pet/main"> <i
					class="icon ion-ios-paw"></i> Hello, Pet World!
				</a>
			</div>
	<!-- class="nav navbar-nav navbar-right" -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a class="navbar-brand" href="/Pet/main"> 
						<span class="icon-bar">
						<i class="icon ion-home"> Home</i></span></a>
					</li>
					<c:if test="${sessionScope.user.getId() != null && sessionScope.user.getM_type() == 1}">
					<li>
						<a class="navbar-brand" href="/Pet/basket/main/${sessionScope.user.getM_num()}"> 
						<span class="icon-bar">
						<i class="icon ion-heart"> 관심 </i></span></a>
					</li>
					</c:if>
					<c:if test="${sessionScope.user.getId() != null}">
					<li>
						<a class="navbar-brand" href="/Pet/reservation/main.do"> 
						<span class="icon-bar">
						<i class="icon ion-clipboard"> 예약현황 </i></span></a>
					</li>
					</c:if>
					<li>
						<form class="navbar-form navbar-right">
							<c:choose>
								<c:when test="${sessionScope.user.getId() == null }">
									<button type="button" class="btn btn-default"
										onclick="location.href='${pageContext.request.contextPath}/login'">Login</button>
									
									&nbsp;&nbsp;&nbsp;
									
									<button type="button" class="btn btn-default"
										onclick="location.href='${pageContext.request.contextPath}/register'">Register</button>
								</c:when>
								<c:otherwise>
									${sessionScope.user.getName()}님이 로그인중입니다.
									 
									 &nbsp;&nbsp;&nbsp;
									 
									<button type="button" class="btn btn-default"
										onclick="location.href='${pageContext.request.contextPath}/logout'">Logout</button>
								</c:otherwise>
							</c:choose>
						</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</body>

</html>