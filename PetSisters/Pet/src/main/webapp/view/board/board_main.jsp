<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>

<html class='no-js' >
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
   
      <title>펫시터게시판</title>
      
      
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/bootstrap/css/bootstrap.min.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/ionicons.min.css" />' />
      
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.carousel.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.theme.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.transitions.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/magnific-popup.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/style.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/color-default.css" />' />
      <script type="text/javascript">
         function insertBoard(targetUri) {      
           if(targetUri == "no_user") {
              alert("게시물을 등록하시려면 로그인 해주세요.");
              return false;
            } 
           else
               location.replace(targetUri);
         }
         var loc;
         
         function findValueFunction() {
           var findval = document.getElementById('findValue').value;
            
           if(findval)
              loc = "search/"+findval;
         }
         function replaceLocationFunction() {
           var link_url = "/Pet/board/" +loc;
              
              location.replace(link_url);
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
            Services Section
         ===============================================================================-->               
            <div class='container' >
               <div class='row' >
                  <div class='col-md-6 col-md-offset-3' >
                     <div class='section-header main-title text-center' >
                        
                        <h2 class='animate text-over-block' >펫시팅 게시판</h2>
                     <c:if test="${sessionScope.user.getM_type() != 2}">
                        <!--divider-->
                        <div class='divider-draft center' ></div>
                        <!--/divider-->
                     </c:if>
                     <c:if test="${sessionScope.user.getId() != null && sessionScope.user.getM_type() == 2}">
                        <button type="submit" onclick="insertBoard('<c:url value="/board/insertForm.do"/>')" class="btn btn-default btn-lg">게시물 등록</button>
                     </c:if>
                        <br>
                        <p>
                           반려동물을 돌봐줄수 없을 때 펫시터 회원님들의 손길을 빌려보세요!
                        </p>
                        <div class='search-box' >   
                                 <input type='text' id="findValue" placeholder='Search' class='search-input' onblur="findValueFunction()">
                                 
                                 <a class='search-btn' onclick="replaceLocationFunction()">
                                    <i class='ion-ios-search' ></i>
                                 </a>
                                 
                        </div>               
                        <br>
                   <div id='portfolio-filters' >
                     <ul>
                        <li>
                           <a href="/Pet/board/search/방문시팅">방문 시팅</a>
                        </li>
                        <li>
                           <a href="/Pet/board/search/위탁시팅">위탁 시팅</a>
                        </li>
                     </ul>
                   </div>
                  
                  
                  
                     </div>
                  </div>
               </div>
            </div>
            
            <div class='services-block section-block' >
               
               <div class='container' >
                  <c:if test="${select eq 'findValue'}">
                     <c:set var="name" value="${searchBoardList}" />
                  </c:if>
                  <c:if test ="${select eq 'all'}">
                     <c:set var="name" value="${allBoardList}" />
                  </c:if>
                  <c:forEach var="board" items="${name}" varStatus="status">
                  <c:set var ="count" value = "${status.count}"/>
                  <c:if test="${count % 4 == 0}">
                  <div class='row' >   
                     <div class='col-md-3' >
                           <div class='service' >
                                 <div class='icon' >
                              
                              //사진
                                    <img src='<c:url value="/resources/img/board/dog_icon.png" />' alt='Symp' />
   
                                 
                                 </div>
                           <div class='content' >
                     <h4>   <a href="/Pet/board/b_num/${board.b_num}">${board.b_title}   </a></h4>
                              <p>
                                 ${board.b_where}
                              </p>   
                           </div>
                        </div>
                     </div>
                     
                     </div>   
                  </c:if>
                  <c:if test="${count % 4 != 0}">
                  <div class='col-md-3' >
                        <div class='service' >
                           <div class='icon' >
                              <img src='<c:url value="/resources/img/board/dog_icon.png" />' alt='Symp' />
                           </div>
                           <div class='content' >
                              <h4><a href="/Pet/board/b_num/${board.b_num}">${board.b_title}   </a></h4>
                              <p>
                                 ${board.b_where}
                              </p>   
                           </div>
                        </div>
                  </div>
                  </c:if>
                  </c:forEach>
                                          
               </div>
               
            </div>
         

            
         <%@ include file="/view/include/bottom.jsp"%>

         <!--=============================================================================
            /Services Section
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