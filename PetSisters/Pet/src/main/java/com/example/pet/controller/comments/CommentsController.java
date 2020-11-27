package com.example.pet.controller.comments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.pet.domain.Comments;
import com.example.pet.domain.User;
import com.example.pet.service.CommentsService;

@Controller
@RequestMapping("/comment/*")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;
	
	// 게시물 댓글 불러오기(Ajax)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/comment/commentList.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity ajax_commentList(@ModelAttribute("comments") Comments comments, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("################ List Comment #################");
		System.out.println(comments.toString());
		
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("crNum", comments.getCrNum());
		map.put("cType", comments.getcType());
			System.out.println("뭐가 crNum : " + comments.getCrNum() + ", cType : " + comments.getcType());
		// 해당 게시물 댓글
		List<Comments> commentList = commentsService.selectAllComment(map);

		if (commentList.size() > 0) {
			for (int i = 0; i < commentList.size(); i++) {
				HashMap hm = new HashMap();
				hm.put("cNum", commentList.get(i).getcNum());
				hm.put("mNum", commentList.get(i).getmNum());
				hm.put("cContent", commentList.get(i).getcContent());
				hm.put("cDate", commentList.get(i).getcDate());
				hm.put("mNickname", commentList.get(i).getmNickname());

				hmlist.add(hm);
			}
		}
		System.out.println(hmlist);
		JSONArray json = new JSONArray(hmlist);
		
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}

	// 댓글 등록(Ajax)
	@RequestMapping("addComment.do")
	@ResponseBody
	public String ajax_addComment(@ModelAttribute("comments") Comments comments, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("################ Add Comment #################");
		System.out.println(comments.toString());

		//1. session에있는 user 가져오기
		User user = (User) session.getAttribute("user");
		int sessionmNum = user.getM_num();

		//2. insert 할 cNum 찾기
		int cNum = 0;
		for(int val : commentsService.selectCommentNum())
			cNum = val;	
		cNum += 1;
		System.out.println("************** 추가할 넘 : " + cNum + "***************");

		
		//3. insert 할 comment 객체 생성
		int crNum = comments.getCrNum();
		String cType = comments.getcType();
		String cContent = comments.getcContent();
		
		Comments comment = new Comments(cNum, sessionmNum, crNum, cType, cContent);
		
		System.out.println(comment.toString());
		
		//4. insert comment
		commentsService.insertComment(comment);

		return "success";
	}
	
	// 댓글 수정 Form으로 가기
	@RequestMapping("updateFormComment.do/{cNum}")
	public ModelAndView goToUpdateCommentForm(@PathVariable("cNum") int cNum, HttpServletRequest request) throws Exception {
		System.out.println("################ Go To Update Comment Form #################");

		Comments comment = commentsService.selectCommentByNum(cNum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("comment", comment);
		
		if(comment.getcType().equals("Question"))
			mav.setViewName("/question/updateCommentForm");
		else
			mav.setViewName("/used_market/updateCommentForm");
		
		return mav;
	}
	
	// 댓글 수정
	@RequestMapping("updateComment.do/{cNum}")
	public String updateComment(@PathVariable("cNum") int cNum, HttpServletRequest request) throws Exception {
		System.out.println("################ Update Comment #################");
		
		Comments comment = new Comments(cNum, request.getParameter("c_content"));

		commentsService.updateComment(comment);
		
		Comments commentByNum = commentsService.selectCommentByNum(cNum);
		
		String path = "";
		
		if(commentByNum.getcType().equals("Question")) {
			path = "redirect:/question/qnum/" + commentByNum.getCrNum();
		}
		else {
			path = "redirect:/used_market/unum/" + commentByNum.getCrNum();
		}
		
		return path;
	}
	
	// 댓글 삭제(Ajax)
	@RequestMapping("deleteComment.do/{cNum}")
	@ResponseBody
	public String ajax_deleteComment(@PathVariable("cNum") int cNum, HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("################ Delete Comment #################");
		System.out.println(cNum);

		commentsService.deleteComment(cNum);

		return "success";
	}
}
