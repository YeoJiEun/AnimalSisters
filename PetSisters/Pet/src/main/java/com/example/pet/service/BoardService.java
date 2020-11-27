package com.example.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pet.dao.BoardDao;
import com.example.pet.domain.Board;

@Service
public class BoardService {
   @Autowired
   private BoardDao boardRepository;
   //모든 Board 찾기
      public List<Board> selectAllBoard() {
         return boardRepository.selectAllBoard();
      }
            
      //findValue로 Board 찾기
      public List<Board> selectBoardByFindValue(String findValue) {
         return boardRepository.selectBoardByFindValue(findValue);
      }
         
      public Integer insertBoardNPicture(Board board) {
            return boardRepository.insertBoardNPicture(board);
         }
      //board_num으로 Board 찾기
      public Board selectBoardByNum(int boardNum) {
         return boardRepository.selectBoardByNum(boardNum);
      }
            
      //m_type으로 Board 찾기
      public List<Board> selectBoardByMType(String mType) {
         return boardRepository.selectBoardByMType(mType);
      }
      
      //추가된 board_num 찾기
      public List<Integer> selectBoardNum() {
         return boardRepository.selectBoardNum();
      }
      public List<Integer> selectHaveBoardNum(int m_num) {
         return boardRepository.selectHaveBoardNum(m_num);
      }      
            
      //Board 추가
      @Transactional
      public Integer insertBoard(Board board) {
         return boardRepository.insertBoard(board);
      }
            
      //Board 수정
      
      public Integer updateBoard(Board board) {
         return boardRepository.updateBoard(board);
      }
      
      //Board hits ++
      public Integer updateBoardHits(int boardNum) {
         return boardRepository.updateBoardHits(boardNum);
      }
            
      //Board 삭제
      /*
       public Integer deleteBoard(int boardNum) {
         return boardRepository.deleteBoard(boardNum);
      }
      */
      public Integer deleteBoard(int b_num) {
         return boardRepository.deleteBoard(b_num);
      }
   
}