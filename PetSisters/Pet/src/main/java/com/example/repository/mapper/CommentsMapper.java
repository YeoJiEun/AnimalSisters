package com.example.repository.mapper;

import java.util.HashMap;
import java.util.List;

import com.example.pet.domain.Comments;

public interface CommentsMapper {

	// questionNum에 대한 모든 Question Comment 찾기 || uNum에 대한 모든 UsedMarket Comment 찾기
	@SuppressWarnings("rawtypes")
	public List<Comments> selectAllComment(HashMap map);

	//questionNum에 대한 Question Comment 찾기   ||  uNum에 대한 UsedMarket Comment 찾기
	public Comments selectCommentByNum(int cNum);
	
	//추가된c_num 찾기
	public List<Integer> selectCommentNum();
	
	// Comment 추가
	public int insertComment(Comments comment);

	// Comment 수정
	public int updateComment(Comments comment);

	// Comment 삭제
	public int deleteComment(int cNum);
}
