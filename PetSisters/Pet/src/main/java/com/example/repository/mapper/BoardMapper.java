package com.example.repository.mapper;

import java.util.List;

import com.example.pet.domain.Board;

public interface BoardMapper {
	// 모든 Board 찾기
	List<Board> selectAllBoard();

	// findValue로 Board 찾기
	List<Board> selectBoardByFindValue(String findValue);

	// board_num으로 Board 찾기
	Board selectBoardByNum(int boardNum);

	// m_type으로 Board 찾기
	List<Board> selectBoardByMType(String mType);

	// 추가된 board_num
	List<Integer> selectBoardNum();

	// Board 추가
	int insertBoard(Board board);

	int insertBoardNPicture(Board board);

	// Board 수정
	int updateBoard(Board board);

	// Board hits ++
	int updateBoardHits(int boardNum);

	// Board 삭제
	int deleteBoard(int b_num);

	List<Integer> selectHaveBoardNum(int m_num);
}
