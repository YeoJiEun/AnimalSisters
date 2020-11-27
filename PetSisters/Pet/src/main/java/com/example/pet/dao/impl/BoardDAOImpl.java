package com.example.pet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.pet.domain.Board;
import com.example.repository.mapper.BoardMapper;
import com.example.pet.dao.BoardDao;

@Repository
public class BoardDAOImpl implements BoardDao{
   @Autowired
   private BoardMapper boardMapper;

   //모든 Board 찾기
   public List<Board> selectAllBoard() {
      return boardMapper.selectAllBoard();
   }
   
   //findValue로 Board 찾기
   public List<Board> selectBoardByFindValue(String findValue) {
      return boardMapper.selectBoardByFindValue(findValue);
   }
   
   //board_num으로 Board 찾기
   public Board selectBoardByNum(int boardNum) {
      return boardMapper.selectBoardByNum(boardNum);
   }
      
   //m_type으로 Board 찾기
   public List<Board> selectBoardByMType(String mType) {
      return boardMapper.selectBoardByMType(mType);
   }
   
   //추가된 board_num
   public List<Integer> selectBoardNum() {
      return boardMapper.selectBoardNum();
   }
   public List<Integer> selectHaveBoardNum(int m_num) {
      return boardMapper.selectHaveBoardNum(m_num);
   }      
   
   //Board 추가
   public Integer insertBoard(Board board) {
      Integer result = boardMapper.insertBoard(board);
      return result;
   }
   
   //Board hits ++
   public Integer updateBoardHits(int boardNum) {
      Integer result = boardMapper.updateBoardHits(boardNum);
      return result;
   }
   
   //Board 수정
   public Integer updateBoard(Board board) {
      Integer result = boardMapper.updateBoard(board);
      return result;
   }
      
   //Board 삭제
   public Integer deleteBoard(int b_num) {
      Integer result = boardMapper.deleteBoard(b_num);
      return result;
   }

   public Integer insertBoardNPicture(Board board) {
        return boardMapper.insertBoardNPicture(board);
     }
}