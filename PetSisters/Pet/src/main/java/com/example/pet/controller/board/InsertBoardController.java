package com.example.pet.controller.board;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.example.pet.comment.boardComment;

import com.example.pet.domain.Board;

import com.example.pet.service.BoardService;
import com.example.pet.service.MemberService;

@Controller
@RequestMapping("/board/*")
public class InsertBoardController implements ApplicationContextAware {
   
   @Inject
   BoardService boardService;
   @Inject
   MemberService memberService;
   
   private WebApplicationContext context;   
   private String uploadDir;

   @Override               // life-cycle callback method
   public void setApplicationContext(ApplicationContext appContext) throws BeansException {
      this.context = (WebApplicationContext) appContext;
   }
   
   @ModelAttribute("boardForm")
   public boardComment formBacking(HttpServletRequest request, HttpSession session) {      
      String path = request.getSession().getServletContext().getRealPath("/");
   
      String[] s = path.split(".metadata");
      path = s[0] + "Pet\\src\\main\\webapp\\resources\\img\\board\\";
      System.out.println(path);
      
      uploadDir = path;
      
      boardComment boardForm = new boardComment();
      
      return boardForm;
   }
   
   @RequestMapping("insertBoard.do")
   public String insertBoard(@ModelAttribute("boardForm") boardComment boardForm, HttpServletRequest request,HttpSession session, BindingResult bindingResult, Model model) throws Exception {
      System.out.println("command객체 : " + boardForm);
      System.out.println("**************insertBoard***************");

      System.out.println("@#@@#@#@#@"+request.getParameter("b_picture"));
      String path = "";
      int boardNum = 0;
      for(int val : boardService.selectBoardNum())
         boardNum = val;   
      
      System.out.println("************** 마지막 넘 : " + boardNum + "***************");
      boardNum += 1;
      System.out.println("************** 추가할 넘 : " + boardNum + "***************");
      Date date = new Date();
      if(request.getParameter("b_title") == "" || request.getParameter("b_where") == "" || request.getParameter("b_detail") == "" || request.getParameter("price") == "") {
         path = "redirect:/board/insertForm.do";   
         return path;
      }
      
      MultipartFile picture = boardForm.getB_picture();
      uploadFile(picture);
      String file = picture.getOriginalFilename();
      
      System.out.println("**************file이름="+file+"**************");
      Board board = new Board(boardNum, Integer.parseInt(request.getParameter("m_num")), date, request.getParameter("b_where"), Integer.parseInt(request.getParameter("price")),request.getParameter("b_detail"), 
            request.getParameter("b_type"), request.getParameter("b_title"),  file);
      boardService.insertBoardNPicture(board);
      
      
      path = "redirect:/board/b_num/"+boardNum;
      return path;
   }
   
   
   private boolean uploadFile(MultipartFile report) {
      System.out.println(this.uploadDir);
      System.out.println("업로드 한 파일: " + report.getOriginalFilename());
      
      File file = new File(this.uploadDir + report.getOriginalFilename());
      try {
         report.transferTo(file);
         return true;
      } catch (IllegalStateException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return false;
   }
}