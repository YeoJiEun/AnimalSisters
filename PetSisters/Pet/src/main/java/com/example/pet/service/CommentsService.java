package com.example.pet.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dao.CommentsDAO;
import com.example.pet.domain.Comments;

@Service
public class CommentsService {

	@Autowired
	private CommentsDAO commentDAO;

	// questionNum에 대한 모든 Question Comment 찾기 || uNum에 대한 모든 UsedMarket Comment 찾기
	@SuppressWarnings("rawtypes")
	public List<Comments> selectAllComment(HashMap map) {
		return commentDAO.selectAllComment(map);
	}
	
	//questionNum에 대한 Question Comment 찾기   ||  uNum에 대한 UsedMarket Comment 찾기
	public Comments selectCommentByNum(int cNum) {
		return commentDAO.selectCommentByNum(cNum);
	}
	
	//추가된c_num 찾기
	public List<Integer> selectCommentNum() {
		return commentDAO.selectCommentNum();
	}
	
	// Comment 추가
	public void insertComment(Comments comment) {
		commentDAO.insertComment(comment);
	}

	// Comment 수정
	public void updateComment(Comments comment) {
		commentDAO.updateComment(comment);
	}

	// Comment 삭제
	public void deleteComment(int cNum) {
		commentDAO.deleteComment(cNum);
	}
}
