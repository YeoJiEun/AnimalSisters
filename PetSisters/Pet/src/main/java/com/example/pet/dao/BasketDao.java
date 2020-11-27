package com.example.pet.dao;

import java.util.List;

import com.example.pet.domain.Basket;
import com.example.pet.domain.Board;

public interface BasketDao {

	// 모든 Basket 찾기
	List<Basket> selectAllBasket(int m_num);

	// findValue로 Basket 찾기
	List<Basket> selectBasketByFindValue(String findValue);

	// Basket_num으로 Basket 찾기
	List<Board> selectBasketByNum(int BasketNum);

	// m_type으로 Basket 찾기
	List<Basket> selectBasketByMType(String mType);

	// Basket 추가
	Integer insertBasket(Basket Basket);

	// Basket 수정
	Integer updateBasket(Basket Basket);

	// Basket 삭제
	Integer deleteBasket(int BasketNum);
}
