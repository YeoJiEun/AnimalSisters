<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*,com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html class='no-js' >
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
   
      <title>게시물 등록</title>
      
      
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/bootstrap/css/bootstrap.min.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/ionicons.min.css" />' />
      
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.carousel.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.theme.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/owl.transitions.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/magnific-popup.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/style.css" />' />
      <link rel='stylesheet' type='text/css' href='<c:url value="/resources/css/color-default.css" />' />
      
      <script type="text/javascript">
         function insertBoard() {
           if(form.b_title.value == "") {
                alert("제목을 입력하세요.");
                form.b_title.focus();
                return false;
             }
             else if(form.price.value == "") {
                alert("가격을 입력하세요.");
                form.price.focus();
                return false;
             }
             else if(form.b_where.value == "") {
                alert("장소를 입력하세요.");
                form.b_where.focus();
                return false;
             }
             else if(form.b_detail.value == "") {
                  alert("내용을 입력하세요.");
                  form.b_detail.focus();
                  return false;
             }
             else
                form.submit();
         }
   
         function updateBoard() {   
              if(form.b_title.value == "") {
                 alert("제목을 입력하세요.");
                 form.b_title.focus();
                 return false;
              }
              else if(form.price.value == "") {
                 alert("가격을 입력하세요.");
                 form.price.focus();
                 return false;
              }
              else if(form.b_where.value == "") {
                 alert("장소를 입력하세요.");
                 form.b_where.focus();
                 return false;
              }
              else if(form.b_detail.value == "") {
                   alert("내용을 입력하세요.");
                   form.b_detail.focus();
                   return false;
              }
              else
                 form.submit();
        }
         function backBoardMain(targetUri) {
             location.replace(targetUri);
         }
        function backBoardDetail(targetUri) {
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
                        
                           <h2 class='animate text-over-block' >게시물 등록</h2>
                           
                           <!--divider-->
                           <div class='divider-draft center' ></div>
                           <!--/divider-->
                        </div>
                     </div>
                  </div>
                  <c:if test='${detail eq "update"}'>   
                  
                  <form name="form" action="<c:url value='/board/update/${boardByNum.b_num }'/>" enctype="multipart/form-data" >
                        <input type="hidden" name="m_num" value="${sessionScope.user.getM_num()}">
                          <div align="center" >
                        
                          <label><br>방문 시팅<input type="radio" value="방문시팅" class="form-control" name="b_type" checked/></label>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <label>위탁 시팅<input type="radio" value="위탁시팅" class="form-control" name="b_type" /></label>
                          </div>
                       <div class="form-group">
                            <label for="b_title">제목</label>
                         <input type="text" class="form-control" name="b_title" id="b_title" placeholder="제목을 입력하세요" value="${boardByNum.b_title}">
                       </div>
                       
                       <div class="form-group">
                         <label for="b_detail">내용</label>
                         <textarea class="form-control" rows="20" name="b_detail" id="b_detail" placeholder="내용을 입력하세요" >${boardByNum.b_detail}</textarea>
                       </div>
                       <div class="form-group">
                            <label for="b_where">위치</label>
                         <input type="text" class="form-control" name="b_where" id="b_where" placeholder="위치를 입력하세요" value="${boardByNum.b_where}">
                       </div>
                    
                       <div class="form-group">
                            <label for="b_price">가격(1회)</label>
                         <input type="text" class="form-control" name="price" id="price" placeholder="가격을 입력하세요" value="${boardByNum.price}">
                       </div>
                          <div>
                          <spring:hasBindErrors name="boardForm" />
                                   <label for="picture">대표사진</label>
                                  <!-- <img src="resources/img/user.png" width="300px" height="200px"/> -->
                                  <input type="file" name="b_picture" value="${boardForm.b_picture}" />
                                  
                        </div>
                       <br><br>
                       
                       <div class='section-header text-center'>
                        <input type="submit" value="수정" onclick="updateBoard()" class="btn btn-default btn-lg">
                        
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     
                        <button type="button" onclick="backBoardDetail('<c:url value='/board/b_num/${boardByNum.b_num }'/>')" class="btn btn-default btn-lg">취소</button>
                     </div>                
                     
                  </form>
                     </c:if>   
               <c:if test='${detail ne "update"}'>   
                     <form name="form" method='post' action="<c:url value='/board/insertBoard.do'/>" enctype="multipart/form-data">
                        <input type="hidden" name="m_num" value="${sessionScope.user.getM_num()}">
                          <div align="center" >
                        
                          <label><br>방문 시팅<input type="radio" value="방문시팅" class="form-control" name="b_type" checked/></label>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <label>위탁 시팅<input type="radio" value="위탁시팅" class="form-control" name="b_type" /></label>
                          </div>
                       <div class="form-group">
                            <label for="b_title">제목</label>
                         <input type="text" class="form-control"name="b_title" id="b_title" placeholder="제목을 입력하세요">
                       </div>
                       
                       <div class="form-group">
                         <label for="b_detail">내용</label>
                         <textarea class="form-control" rows="20" id="b_detail" name="b_detail" placeholder="내용을 입력하세요" ></textarea>
                       </div>
                       <div class="form-group">
                            <label for="b_where">위치</label>
                         <input type="text" class="form-control" id="b_where" name="b_where" placeholder="위치를 입력하세요">
                       </div>
                    
                       <div class="form-group">
                            <label for="price">가격(1회)</label>
                         <input type="text" class="form-control" id="price" name="price" placeholder="가격을 입력하세요">
                       </div>
                          <div class="form-group">
                          <spring:hasBindErrors name="boardForm" />
                                <label for="picture">대표사진</label>
                               <img src="resources/img/user.png" width="300px" height="200px"/>
                               <input type="file" name="b_picture" value="${boardForm.b_picture}" />
                                  
                        </div>
                            
                     
                       <br><br>
                       
                       <div class='section-header text-center'>
                        <input type="submit" value="게시물 등록" onclick="insertBoard()" class="btn btn-default btn-lg">
                        
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     
                        <button type="button" onclick="backBoardMain('<c:url value="main.do"/>')" class="btn btn-default btn-lg">취소</button>
                     </div>                
                     
                  </form>
            </c:if>
               </div>
               
         
            
            
            <%@ include file="/view/include/bottom.jsp"%>

         <!--=============================================================================
            /QnA Section
         ===============================================================================-->

      </div>
      <!--=============================================================================
         /Main Wrapper
      ===============================================================================-->
      
      </div>
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