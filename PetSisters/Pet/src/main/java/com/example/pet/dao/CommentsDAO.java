package com.example.pet.dao;

import java.util.HashMap;
import java.util.List;

import com.example.pet.domain.Comments;

public interface CommentsDAO {
	//questionNum에 대한 모든 Question Comment 찾기   ||  uNum에 대한 모든 UsedMarket Comment 찾기
	@SuppressWarnings("rawtypes")
	public List<Comments> selectAllComment(HashMap map);
	
	//questionNum에 대한 Question Comment 찾기   ||  uNum에 대한 UsedMarket Comment 찾기
	public Comments selectCommentByNum(int cNum);
	
	//추가된c_num 찾기
	public List<Integer> selectCommentNum();
	
	//Comment 추가
	public void insertComment(Comments comment);
	
	//Comment 수정
	public void updateComment(Comments comment);
		
	//Comment 삭제
	public void deleteComment(int cNum);
}
