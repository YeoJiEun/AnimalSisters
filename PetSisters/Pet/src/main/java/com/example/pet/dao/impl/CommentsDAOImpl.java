package com.example.pet.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.CommentsDAO;
import com.example.pet.domain.Comments;
import com.example.repository.mapper.CommentsMapper;

@Repository
public class CommentsDAOImpl implements CommentsDAO{

	@Autowired
	private CommentsMapper commentMapper;
	
	//questionNum에 대한 모든 Question Comment 찾기   ||  uNum에 대한 모든 UsedMarket Comment 찾기
	@SuppressWarnings("rawtypes")
	@Override
	public List<Comments> selectAllComment(HashMap map) {
		return commentMapper.selectAllComment(map);
	}
	
	//questionNum에 대한 Question Comment 찾기   ||  uNum에 대한 UsedMarket Comment 찾기
	public Comments selectCommentByNum(int cNum) {
		return commentMapper.selectCommentByNum(cNum);
	}
	
	//추가된c_num 찾기
	@Override
	public List<Integer> selectCommentNum() {
		return commentMapper.selectCommentNum();
	}
		
	//Comment 추가
	@Override
	public void insertComment(Comments comment) {
		Integer result = commentMapper.insertComment(comment);
		if (result == 1)
			System.out.println("-----Insert Comment Success-----");	
	}
		
	//Comment 수정
	@Override
	public void updateComment(Comments comment) {
		Integer result = commentMapper.updateComment(comment);
		if (result == 1)
			System.out.println("-----Update Comment Success-----");	
	}
			
	//Comment 삭제
	@Override
	public void deleteComment(int cNum) {
		Integer result = commentMapper.deleteComment(cNum);
		if (result == 1)
			System.out.println("-----Delete Comment Success-----");	
	}
}
