<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,javax.servlet.*,java.util.*, java.util.List, java.util.Date, com.example.pet.service.*,com.example.pet.domain.*,org.springframework.context.*,org.springframework.context.support.*" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html class='no-js' >
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
   
      <title>Used Market 수정</title>
      
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
      
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
      <script type="text/javascript">
         function updateUsedMarket() {   
          if(form.usedmarket_title.value == "") {
             alert("제목을 입력하세요.");
             form.usedmarket_title.focus();
             return false;
          }
          
          if(form.usedmarket_content.value == "") {
               alert("내용을 입력하세요.");
               form.usedmarket_content.focus();
               return false;
          }
          
          if(form.usedmarket_price.value == "") {
               alert("가격을 입력하세요.");
               form.usedmarket_price.focus();
               return false;
          }
          
          if(form.usedmarket_gNum.value == "") {
               alert("카테고리를 선택하세요.");
               form.usedmarket_gNum.focus();
               return false;
          }
          
          var files = document.getElementById("file_view_list2").innerHTML;
           
          document.getElementById("filePath").value = files;

          form.submit();
         }
         
         function backUsedMarketMain(targetUri) {
             location.replace(targetUri);
         }

  
           $(document).ready( function() {    
           var fileListView = "";
           var fileListView2 = "";  
            <% int count = 0; %>
           $("input[type=file]").change(function () {   
  
              var fileListView = "";
                var fileListView2 = "";
               var formData = new FormData(); //ajax로 넘길 data                   
               var fileInput = document.getElementById("test_file"); //id로 파일 태그를 호출                   
               var files = fileInput.files; //업로드한 파일들의 정보를 넣는다.
        
               for (var i = 0; i < files.length; i++)
                   formData.append('file-'+i, files[i]); //업로드한 파일을 하나하나 읽어서 FormData 안에 넣는다.
           
                 $.ajax({
                    url: "<c:url value='/photo/addFile'/>", 
                    processData : false,
                    data: formData, 
                     contentType: false,  
                     type: 'POST',
                     success: function(data) { 
                         if(data.code == "OK") {
                          <% count++; %>
                              fileInfoList = data.fileInfoList; //응답 결과 데이터 fileInfoList
                                                         
                              $.each(fileInfoList, function( index, fileInfo ) {
                                   console.log("Path: "+fileInfo.fileFullPath); //전체경로
                                   console.log("FileName: "+fileInfo.originalFilename); //파일명
                                                          
                                 fileListView += "<p>"+fileInfo.originalFilename+"</p>"; //루프를 돌려서 화면에 보여줄 리스트 작성
                                 fileListView2 += fileInfo.fileFullPath + ","
                              }); 
                         
                             $("#file_view_list").html(fileListView); //리스트를 화면에 보여줌
                             $("#file_view_list2").html(fileListView2);
                         } else {
                             alert("파일 등록에 실패하였습니다.");
                         } 
                     },
                     error: function(xhr,textStatus,error){                    
                         console.log("textStatus: "+xhr.status+", error: "+error);
                           alert("예상치 못한 오류가 발생했습니다.");   
                     }
                 }); 
             });      
         }); 
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
         
            <div class='container' >
               <div class='row' >
                  <div class='col-md-6 col-md-offset-3' >
                     <div class='section-header text-center' >
                        <h2>USED MARKET #${usedMarketByNum.uNum}  수정</h2>
                        
                        <!--divider-->
                        <div class='divider-draft center' ></div>
                        <!--/divider-->
                     </div>
                  </div>
               </div>
            </div>
      
      
            <div class='posts-block section-block' >
              <div class='container' >
               <div class='row'>
               <div class='col-md-8'>
                 <div class='post'>
                  <div class='content'>
                   <form name="form" action="<c:url value='/used_market/updateUsedMarket/${usedMarketByNum.uNum}'/>" class="form-inline">
                    <table style="width:100%">
                       <tr>
                          <th width="100" align="center"> 제목 </th>
                            <td> 
                             <div class="form-group">
                             <input type="text" class="form-control" style="width:600px;" name="usedmarket_title" value="${usedMarketByNum.uTitle}">
                            </div> 
                            </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <tr>
                        <th> 내용 </th>
                       <td>
                        <div class="form-group">
                         <textarea class="form-control" rows="5" style="width:600px;" name="usedmarket_content"> ${usedMarketByNum.uContent} </textarea>
                        </div>
                        </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <tr>
                        <th> 사용 기간 </th>
                        <td>
                         <div class="form-group">
                         <c:choose>
                          <c:when test="${empty usedMarketByNum.uUsedate}">
                           <input type="text" class="form-control" style="width:300px;" name="usedmarket_usedate" value="X">
                          </c:when>
                          <c:otherwise>
                           <input type="text" class="form-control" style="width:300px;" name="usedmarket_usedate" value="${usedMarketByNum.uUsedate}">
                          </c:otherwise>
                        </c:choose>
                        </div>
                        </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <tr>
                        <th> 유통 기한 </th>
                        <td>
                          <div class="form-group">
                            <%
                                UsedMarket u = (UsedMarket)request.getAttribute("usedMarketByNum");
                              	Date d = u.getuExpiredate();
                              
                              if(d != null) {
                                  Calendar cal = Calendar.getInstance();
                                  cal.setTime(d);
                                  
                                  out.println("<input type='text' class='form-control' style='width:60px;  height:30px;' name='usedmarket_expiredate_year' value='" + cal.get(Calendar.YEAR) + "'>  년   ");
                              out.println("<input type='text' class='form-control' style='width:60px;  height:30px;' name='usedmarket_expiredate_month' value='" + (cal.get(Calendar.MONTH) + 1) + "'>  월   ");
                              out.println("<input type='text' class='form-control' style='width:60px;  height:30px;' name='usedmarket_expiredate_date' value='" + cal.get(Calendar.DATE) + "'>  일");
                              }
                              else {
                                 out.println("<input type='text' class='form-control' style='width:60px;  height:30px;' name='usedmarket_expiredate_year' value=''>  년   ");
                              out.println("<input type='text' class='form-control' style='width:60px;  height:30px;' name='usedmarket_expiredate_month' value=''>  월  ");
                              out.println("<input type='text' class='form-control' style='width:60px;  height:30px;' name='usedmarket_expiredate_date' value=''>  일");
                              }
                            %>
                         </div>
                        </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <tr>
                        <th> 가격 </th>
                        <td>
                          <div class="form-group">
                         <input type="text" class="form-control" style="width:300px;" name="usedmarket_price" value="${usedMarketByNum.uPrice}">  원
                         </div>
                        </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <tr> 
                        <th> 카테고리 </th>
                        <td>
                          <select class="form-control" id="usedmarket_gNum" name="usedmarket_gNum">
                           <option value="1" <c:if test="${usedMarketByNum.gNum eq 1}">selected="selected"</c:if>>사료</option>
                          <option value="2" <c:if test="${usedMarketByNum.gNum eq 2}">selected="selected"</c:if>>간식</option>
                         <option value="3" <c:if test="${usedMarketByNum.gNum eq 3}">selected="selected"</c:if>>하우스</option>
                          <option value="4" <c:if test="${usedMarketByNum.gNum eq 4}">selected="selected"</c:if>>급식기/급수기</option>
                          <option value="5" <c:if test="${usedMarketByNum.gNum eq 5}">selected="selected"</c:if>>미용/목욕</option>
                          <option value="6" <c:if test="${usedMarketByNum.gNum eq 6}">selected="selected"</c:if>>배변용품</option>
                          <option value="7" <c:if test="${usedMarketByNum.gNum eq 7}">selected="selected"</c:if>>의류/패션</option>
                          <option value="8" <c:if test="${usedMarketByNum.gNum eq 8}">selected="selected"</c:if>>장난감</option>
                          <option value="9" <c:if test="${usedMarketByNum.gNum eq 9}">selected="selected"</c:if>>기타</option>
                        </select>
                        </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <tr>
                        <th> 사진 </th>
                       <td>
                        <div class="form-group">
                         <input type="file" name="test_file" id="test_file" multiple class="form-control input-text" style="width:600px;"/>
                        </div>
                        </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <%
                          List<Photo> photos = (List<Photo>)request.getAttribute("selectPhotoByuNum");
                          
                          String paths = "";
                          for(int i = 0; i < photos.size(); i++) {
                             String path = photos.get(i).getPhotoPath();
                             
                             if(path.contains("/"))
                                paths += path.split("photo/")[1] + "<br>";
                             else if(path.contains("\\"))
                                paths += path.split("photo\\")[1] + "<br>";
                          }                  
                       %>
                                            
                       <tr>
                        <th> &nbsp;&nbsp; </th>
                       <td>    
                       <%                
                          if(count == 1)  
                             out.println("<div id='file_view_list'>" + paths + "</div>");
                       %>      
                          <div id="file_view_list"></div>
                         <div id="file_view_list2" style="display:none"></div>
                         <input type="hidden" id = "filePath" name = "filePath">
                        </td>
                       </tr>
                       
                       <tr><td  colspan="2"><br></td></tr>
                       
                       <tr>
                        <td colspan="2">
                          <br><br>
                          <div class='section-header text-center'>
                        <button type="button" onclick="updateUsedMarket()" class="btn btn-default btn-lg">게시글 수정</button>
                        
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     
                        <button type="button" onclick="backUsedMarketMain('<c:url value="/used_market/used_market_detail/${usedMarketByNum.uNum}"/>')" class="btn btn-default btn-lg">취소</button>
                        </div>   
                        </td>
                       </tr>
                    </table>
                   </form>
                  </div>
                 </div>
               </div>


               <div class='col-md-4'>
                  <div class='sidebar'>
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