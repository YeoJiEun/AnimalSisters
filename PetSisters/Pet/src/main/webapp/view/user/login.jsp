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
      $(document).ready(function(){
         $("#btnLogin").click(function(){
            var userId = $("#userId").val();
            var userPw = $("#userPw").val();
            if (userId == "") {
               alert("아이디를 입력하세요.");
               $("#userId").focus();
               return;
            }
            
            if (userPw == "") {
               alert("비밀번호를 입력하세요.");
               $("#userPw").focus();
               return;
            }
         });
      });
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
                     <h2 class='animate text-over-block'>Login</h2>

                     <!--divider-->
                     <div class='divider-draft center'></div>
                     <!--/divider-->
                     <p>
                     	Enjoy our page
                     </p>
                  </div>

               </div>
            </div>
            
            <spring:hasBindErrors name="userLogin" />
            
            <div class='row'>
               <div class='col-md-8 col-md-offset-2'>

                  <form id='contact-form' class='contact-form' method='post' >

                     <div id='contact-form-result'></div>

                     <div class='row'>
                        <div class='form-group text-center'>
                           <input type="text" name="id" id="userId" value="${userLogin.id}" class='form-control' placeholder='ID' required/>
                        </div>
                     </div>

                     <div class='row'>
                        <div class='form-group text-center'>
                           <input type='password' class='form-control' name="pw" id="userPw" value="${userLogin.pw}" placeholder='PASSWORD' required>
                        </div>
                     </div>

                     <div class='form-group text-center'>
                     	<c:if test="${msg == 'failure'}">
                        	<div style="color:red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
                        </c:if>
                        <c:if test="${msg == 'logout'}">
                        	<div style="color:red">로그아웃 되었습니다.</div>
                        </c:if>
                        <button type="submit" onclick="login('<c:url value="/user/login"/>')" class="btn btn-default btn-lg">Login</button>
                        <%-- <button type="button" onclick="find('<c:url value="/user/login"/>')" class="btn btn-default btn-lg">FIND ID/PW</button> --%>
                     </div>


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