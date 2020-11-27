package com.example.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pet.dao.BasketDao;

import com.example.pet.domain.Basket;
import com.example.pet.domain.Board;

@Service
public class BasketService {
	@Autowired
	private BasketDao BasketRepository;

	//모든 Basket 찾기
	public List<Basket> selectAllBasket(int m_num) {
		return BasketRepository.selectAllBasket(m_num);
	}
			
	//findValue로 Basket 찾기
	public List<Basket> selectBasketByFindValue(String findValue) {
		return BasketRepository.selectBasketByFindValue(findValue);
	}
		
	//Basket_num으로 Basket 찾기
	public List<Board> selectBasketByNum(int BasketNum) {
		return BasketRepository.selectBasketByNum(BasketNum);
	}
			
	//m_type으로 Basket 찾기
	public List<Basket> selectBasketByMType(String mType) {
		return BasketRepository.selectBasketByMType(mType);
	}
			
			
	//Basket 추가
	@Transactional
	public Integer insertBasket(Basket Basket) {
		return BasketRepository.insertBasket(Basket);
	}
			
	//Basket 수정
	public Integer updateBasket(Basket Basket) {
		return BasketRepository.updateBasket(Basket);
	}
			
	//Basket 삭제
	public Integer deleteBasket(int BasketNum) {
		return BasketRepository.deleteBasket(BasketNum);
	}
}
