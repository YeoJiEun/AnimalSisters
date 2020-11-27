package com.example.pet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.BasketDao;
import com.example.pet.domain.Basket;
import com.example.pet.domain.Board;
import com.example.repository.mapper.BasketMapper;

@Repository
public class BasketDAOImpl implements BasketDao{
	@Autowired
	private BasketMapper BasketMapper;

	//모든 Basket 찾기
	public List<Basket> selectAllBasket(int m_num) {
		return BasketMapper.selectAllBasket(m_num);
	}
	
	//findValue로 Basket 찾기
	public List<Basket> selectBasketByFindValue(String findValue) {
		return BasketMapper.selectBasketByFindValue(findValue);
	}
	
	//Basket_num으로 Basket 찾기
	public List<Board> selectBasketByNum(int BasketNum) {
		return BasketMapper.selectBasketByNum(BasketNum);
	}
		
	//m_type으로 Basket 찾기
	public List<Basket> selectBasketByMType(String mType) {
		return BasketMapper.selectBasketByMType(mType);
	}
		
		
	//Basket 추가
	public Integer insertBasket(Basket Basket) {
		Integer result = BasketMapper.insertBasket(Basket);
		return result;
	}
		
	//Basket 수정
	public Integer updateBasket(Basket Basket) {
		Integer result = BasketMapper.updateBasket(Basket);
		return result;
	}
		
	//Basket 삭제
	public Integer deleteBasket(int BasketNum) {
		Integer result = BasketMapper.deleteBasket(BasketNum);
		return result;
	}
}
