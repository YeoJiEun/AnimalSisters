<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html class='no-js' >
   
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
   
      <title>USED MARKET</title>
      
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

         var loc;

         function findValueFunction() {
            var findval = document.getElementById('findValue').value;

            if (findval)
               loc = findval;
         }

         function replaceLocationFunction() {
            var link_url = "/Pet/used_market/search/" + loc;

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
            Used Market Section
         ===============================================================================-->
         
            <div class='container' >
               <div class='row' >
                  <div class='col-md-6 col-md-offset-3' >
                     <div class='section-header text-center' >
                        <h2>USED MARKET</h2>
                        
                        <!--divider-->
                        <div class='divider-draft center' ></div>
                        <!--/divider-->
                        
                        <br><br>
                           
                        <div class='search-box' >   
                           <input type='text' id="findValue" placeholder='Search' class='search-input'  onblur="findValueFunction()">
   
                           <a class='search-btn' onclick="replaceLocationFunction()" >
                              <i class='ion-ios-search' ></i>
                           </a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
      
            <c:if test="${insertFailed}">
               <% out.println("<script>alert('로그인 후 글을 등록해주세요.');</script>"); %>
            </c:if>
         
            <div class='posts-block section-block' >
              <div class='container' >
               <div class='row'>
               <div class='col-md-8'>

                  <c:choose>
                     <c:when test="${select eq 'all'}">
                        <c:forEach var="usedMarket" items="${allUsedMarketList}">
                     <div class='post'>
                           <% int count = 0; %>
                            <div class="testimonials-slider">
                             <c:forEach var = "photo" items="${allPhoto}">
                                <c:if test="${photo.uNum == usedMarket.uNum}">
                                <c:choose>
                                <c:when test="${photo.photoPath.contains('C')}">
                                <div class='testimonial' >
                                    <div class='media'>
                                     <img src="${photo.photoPath}" alt="이미지를 찾을 수 없습니다"/> 
                                     <% count++; %>
                                    </div>
                                  </div> 
                                </c:when>
                                 <c:otherwise>
                                 <div class='testimonial' >
                                    <div class='media'>
                                     <img src="${pageContext.request.contextPath}/resources/img/used_market/${photo.photoPath}" alt="이미지를 찾을 수 없습니다"/> 
                                     <% count++; %>
                                    </div>
                                  </div> 
                                 </c:otherwise>
                                 </c:choose>
                                 </c:if>
                              </c:forEach>
                             </div>
                              <% if(count == 0) { %>
                                 <div class='media' >
                           <img alt='symp' src='<c:url value="/resources/img/bg2.jpg" />' >
                         </div>
                       <% } %>
                              

                              <div class='content'>
                                 <h4>
                                    <a href='/Pet/used_market/unum/${usedMarket.uNum}'>
                                       ${usedMarket.uTitle} </a>
                                 </h4>

                                 <ul class='post-icons'>
                                    <li><i class='ion-ios-person'></i> <span>${usedMarket.mNickname}</span> </li>
                                    <li><i class='ion-ios-clock'></i> <span>${usedMarket.uDate}</span></li>
                                    
                                    <c:choose>
                                        <c:when test="${usedMarket.uCompleteTF eq 'T'}">
                                         <li><i class="icon ion-checkmark-circled"></i> <span>거래 완료</span></li>
                                       </c:when>
                                        <c:otherwise>
                                         <li><i class="icon ion-checkmark-circled"></i> <span>거래 중</span></li>
                                       </c:otherwise>
                                    </c:choose>
                                    
                                    <li><i class='ion-ios-chatbubble'></i> <span>${usedMarket.uHits}</span></li>
                                 </ul>

                                 <p>${usedMarket.uContent}</p>

                                 <a href="/Pet/used_market/unum/${usedMarket.uNum}"
                                    class='read-more'> Read More <i
                                    class='ion-ios-arrow-thin-right'></i>
                                 </a>
                              </div>
                           </div>
                        </c:forEach>
                     </c:when>
                     <c:when test="${select eq 'category'}">
                        <c:forEach var="usedMarket" items="${selectUsedMarketByGoodsType}">
                     <div class='post'>
                             <% int count = 0; %>
                              <div class="testimonials-slider">
                               <c:forEach var = "photo" items="${allPhoto}">
                                <c:if test="${photo.uNum == usedMarket.uNum}">
                                  <div class='testimonial' >
                                    <div class='media'>
                                     <img src="${pageContext.request.contextPath}/resources/img/used_market/${photo.photoPath}" alt="이미지를 찾을 수 없습니다"/> 
                                     <% count++; %>
                                    </div>
                                  </div> 
                                 </c:if>
                                </c:forEach>
                               </div> 
                              <% if(count == 0) { %>
                                 <div class='media' >
                           <img alt='symp' src='<c:url value="/resources/img/bg2.jpg" />' >
                         </div>
                       <% } %>

                              <div class='content'>
                                 <h4>
                                    <a href='/Pet/used_market/unum/${usedMarket.uNum}'> ${usedMarket.uTitle} </a>
                                 </h4>

                                 <ul class='post-icons'>
                                    <li><i class='ion-ios-person'></i> <span>${usedMarket.mNickname}</span></li>
                                    <li><i class='ion-ios-clock'></i> <span>${usedMarket.uDate}</span></li>
                                    
                                    <c:choose>
                                        <c:when test="${usedMarket.uCompleteTF eq 'T'}">
                                         <li><i class="icon ion-checkmark-circled"></i> <span>거래 완료</span></li>
                                       </c:when>
                                        <c:otherwise>
                                         <li><i class="icon ion-checkmark-circled"></i> <span>거래 중</span></li>
                                       </c:otherwise>
                                    </c:choose>
                                    
                                    <li><i class='ion-ios-chatbubble'></i> <span>${usedMarket.uHits}</span></li>
                                 </ul>

                                 <p>${usedMarket.uContent}</p>

                                 <a href="/Pet/used_market/unum/${usedMarket.uNum}"
                                    class='read-more'> Read More <i
                                    class='ion-ios-arrow-thin-right'></i>
                                 </a>
                              </div>
                           </div>
                        </c:forEach>
                     </c:when>
                     <c:when test="${select eq 'findValue'}">
                        <c:forEach var="usedMarket" items="${searchQuestionList}">

                           <div class='post'>
                             <% int count = 0; %>
                              <div class="testimonials-slider">
                               <c:forEach var = "photo" items="${allPhoto}">
                                <c:if test="${photo.uNum == usedMarket.uNum}">
                                  <div class='testimonial' >
                                    <div class='media'>
                                     <img src="${pageContext.request.contextPath}/resources/img/used_market/${photo.photoPath}" alt="이미지를 찾을 수 없습니다"/> 
                                     <% count++; %>
                                    </div>
                                  </div> 
                                 </c:if>
                                </c:forEach>
                               </div> 
                              <% if(count == 0) { %>
                                 <div class='media' >
                           <img alt='symp' src='<c:url value="/resources/img/bg2.jpg" />' >
                         </div>
                       <% } %>

                              <div class='content'>
                                 <h4>
                                    <a href='/Pet/used_market/unum/${usedMarket.uNum}'> ${usedMarket.uTitle} </a>
                                 </h4>

                                 <ul class='post-icons'>
                                    <li><i class='ion-ios-person'></i> <span>${usedMarket.mNickname}</span></li>
                                    <li><i class='ion-ios-clock'></i> <span>${usedMarket.uDate}</span></li>
                                    
                                    <c:choose>
                                        <c:when test="${usedMarket.uCompleteTF eq 'T'}">
                                         <li><i class="icon ion-checkmark-circled"></i> <span>거래 완료</span></li>
                                       </c:when>
                                        <c:otherwise>
                                         <li><i class="icon ion-checkmark-circled"></i> <span>거래 중</span></li>
                                       </c:otherwise>
                                    </c:choose>
                                    
                                    <li><i class='ion-ios-chatbubble'></i> <span>${usedMarket.uHits}</span></li>
                                 </ul>

                                 <p>${usedMarket.uContent}</p>

                                 <a href="/Pet/used_market/unum/${usedMarket.uNum}"
                                    class='read-more'> Read More <i
                                    class='ion-ios-arrow-thin-right'></i>
                                 </a>
                              </div>
                           </div>
                        </c:forEach>
                     </c:when>
                  </c:choose>

                  <!-- <div class='post-more'>
                     <a href='#' class='more-link'> Load More </a>
                  </div> -->
               </div>


               <div class='col-md-4'>
                  <div class='sidebar'>
                     <div class='sidebar-widget'>
                        <c:choose>
                           <c:when test="${sessionScope.user == null}">
                              <button type="submit" onclick="insertUsedMarket('no_user')"
                                 class="btn btn-default btn-lg">글쓰기</button>
                           </c:when>
                           <c:when test="${sessionScope.user.getM_type() == 0}">
                              <button type="submit" onclick="insertUsedMarket('mType_0')"
                                 class="btn btn-default btn-lg">글쓰기</button>
                           </c:when>
                           <c:otherwise>
                              <button type="submit"
                                 onclick="insertUsedMarket('<c:url value="/used_market/insertForm.do"/>')"
                                 class="btn btn-default btn-lg">글쓰기</button>
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