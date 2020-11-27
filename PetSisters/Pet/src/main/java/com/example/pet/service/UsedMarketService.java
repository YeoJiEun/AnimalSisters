package com.example.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dao.UsedMarketDAO;
import com.example.pet.domain.UsedMarket;

@Service
public class UsedMarketService {
	@Autowired
	private UsedMarketDAO usedMarketDAO;

	//모든 UsedMarket 찾기
	public List<UsedMarket> selectAllUsedMarket() {
		return usedMarketDAO.selectAllUsedMarket();
	}
	
	//조회순 내림차순 5개 UsedMarket 찾기
	public List<UsedMarket> selectDescHitsUsedMarket() {
		return usedMarketDAO.selectDescHitsUsedMarket();
	}
	
	//findValue로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketByFindValue(String findValue) {
		return usedMarketDAO.selectUsedMarketByFindValue(findValue);
	}
	
	//u_num으로 UsedMarket 찾기
	public UsedMarket selectUsedMarketByNum(int uNum) {
		return usedMarketDAO.selectUsedMarketByNum(uNum);
	}
	
	//goods_type으로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketByGoodsType(int goodsType) {
		return usedMarketDAO.selectUsedMarketByGoodsType(goodsType);
	}
	
	//추가된 u_num 찾기
	public List<Integer> selectUsedMarketNum() {
		return usedMarketDAO.selectUsedMarketNum();
	}
	
	//m_num으로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketBymNum(int mNum) {
		return usedMarketDAO.selectUsedMarketBymNum(mNum);
	}
	
	
	
	//UsedMarket 추가
	public void insertUsedMarket(UsedMarket usedMarket) {
		usedMarketDAO.insertUsedMarket(usedMarket);
	}
	
	//UsedMarket NoExpiredate 추가
	public void insertUsedMarketNoExpiredate(UsedMarket usedMarket) {
		usedMarketDAO.insertUsedMarketNoExpiredate(usedMarket);
	}
	
	//UsedMarket 수정
	public void updateUsedMarket(UsedMarket usedMarket) {
		usedMarketDAO.updateUsedMarket(usedMarket);
	}
	
	//UsedMarket NoExpiredate 수정
	public void updateUsedMarketNoExpiredate(UsedMarket usedMarket) {
		usedMarketDAO.updateUsedMarketNoExpiredate(usedMarket);
	}
	
	//UsedMarket NoExpireUsedate 수정
	public void updateUsedMarketNoExpireUsedate(UsedMarket usedMarket) {
		usedMarketDAO.updateUsedMarketNoExpireUsedate(usedMarket);
	}
		
	//UsedMarket NoUsedate 수정
	public void updateUsedMarketNoUsedate(UsedMarket usedMarket) {
		usedMarketDAO.updateUsedMarketNoUsedate(usedMarket);
	}
	
	//UsedMarket U_COMPLETETF 수정
	public void updateUsedMarketTF(int uNum) {
		usedMarketDAO.updateUsedMarketTF(uNum);
	}
	
	//UsedMarket 조회수++
	public void updateUsedMarketHits(int nNum) {
		usedMarketDAO.updateUsedMarketHits(nNum);
	}
	
	//UsedMarket 삭제
	public void deleteUsedMarket(int uNum) {
		usedMarketDAO.deleteUsedMarket(uNum);
	}
}
