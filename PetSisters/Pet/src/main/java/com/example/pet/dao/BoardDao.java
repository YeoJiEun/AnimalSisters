package com.example.pet.dao;

import java.util.List;

import com.example.pet.domain.Board;

public interface BoardDao {
   List<Board> selectAllBoard();
   
   //findValue로 Board 찾기
   List<Board> selectBoardByFindValue(String findValue);
   
   //board_num으로 Board 찾기
   Board selectBoardByNum(int boardNum);
      
   //m_type으로 Board 찾기
   List<Board> selectBoardByMType(String mType);
   
   //추가된 board_num
   List<Integer> selectBoardNum();
   
   //Board 추가
   Integer insertBoard(Board board);
      
   //Board 수정
   Integer updateBoard(Board board);
   
   //Board hits ++
   Integer updateBoardHits(int boardNum);   
      
   //Board 삭제
   Integer deleteBoard(int b_num);

   List<Integer> selectHaveBoardNum(int m_num);

   Integer insertBoardNPicture(Board board);
}