package com.example.pet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.UsedMarketDAO;
import com.example.pet.domain.UsedMarket;
import com.example.repository.mapper.UsedMarketMapper;

@Repository
public class UsedMarketDAOImpl implements UsedMarketDAO {

	@Autowired
	private UsedMarketMapper usedMarketMapper;
	
	//모든 UsedMarket 찾기
	@Override
	public List<UsedMarket> selectAllUsedMarket() {
		return usedMarketMapper.selectAllUsedMarket();
	}

	//조회순 내림차순 5개 UsedMarket 찾기
	@Override
	public List<UsedMarket> selectDescHitsUsedMarket() {
		return usedMarketMapper.selectDescHitsUsedMarket();
	}
	
	//findValue로 UsedMarket 찾기
	@Override
	public List<UsedMarket> selectUsedMarketByFindValue(String findValue) {
		return usedMarketMapper.selectUsedMarketByFindValue(findValue);
	}
	
	//u_num으로 UsedMarket 찾기
	@Override
	public UsedMarket selectUsedMarketByNum(int uNum) {
		return usedMarketMapper.selectUsedMarketByNum(uNum);
	}
	
	//goods_type으로 UsedMarket 찾기
	@Override
	public List<UsedMarket> selectUsedMarketByGoodsType(int goodsType) {
		return usedMarketMapper.selectUsedMarketByGoodsType(goodsType);
	}
	
	//추가된 u_num 찾기
	@Override
	public List<Integer> selectUsedMarketNum() {
		return usedMarketMapper.selectUsedMarketNum();
	}
	
	//m_num으로 UsedMarket 찾기
	@Override
	public List<UsedMarket> selectUsedMarketBymNum(int mNum) {
		return usedMarketMapper.selectUsedMarketBymNum(mNum);
	}
	
	
	
	//UsedMarket 추가
	@Override
	public void insertUsedMarket(UsedMarket usedMarket) {
		Integer result = usedMarketMapper.insertUsedMarket(usedMarket);
		if (result == 1)
			System.out.println("-----Insert UsedMarket Success-----");	
	}
	
	//UsedMarket NoExpiredate 추가
	@Override
	public void insertUsedMarketNoExpiredate(UsedMarket usedMarket) {
		Integer result = usedMarketMapper.insertUsedMarketNoExpiredate(usedMarket);
		if (result == 1)
			System.out.println("-----Insert NoExpriedate UsedMarket Success-----");	
	}
	
	//UsedMarket 수정
	@Override
	public void updateUsedMarket(UsedMarket usedMarket) {
		Integer result = usedMarketMapper.updateUsedMarket(usedMarket);
		if (result == 1)
			System.out.println("-----Update UsedMarket Success-----");	
	}
	
	//UsedMarket NoExpiredate 수정
	@Override
	public void updateUsedMarketNoExpiredate(UsedMarket usedMarket) {
		Integer result = usedMarketMapper.updateUsedMarketNoExpiredate(usedMarket);
		if (result == 1)
			System.out.println("-----Update NoExpriedate UsedMarket Success-----");	
	}
	
	//UsedMarket NoExpireUsedate 수정
	@Override
	public void updateUsedMarketNoExpireUsedate(UsedMarket usedMarket) {
		Integer result = usedMarketMapper.updateUsedMarketNoExpireUsedate(usedMarket);
		if (result == 1)
			System.out.println("-----Update NoExpireUsedate UsedMarket Success-----");	
	}
		
	//UsedMarket NoUsedate 수정
	@Override
	public void updateUsedMarketNoUsedate(UsedMarket usedMarket) {
		Integer result = usedMarketMapper.updateUsedMarketNoUsedate(usedMarket);
		if (result == 1)
			System.out.println("-----Update NoUsedate UsedMarket Success-----");	
	}
	
	//UsedMarket U_COMPLETETF 수정
	@Override
	public void updateUsedMarketTF(int uNum) {
		Integer result = usedMarketMapper.updateUsedMarketTF(uNum);
		if (result == 1)
			System.out.println("-----Update UsedMarket u_completeTF Success-----");	
	}
	
	//UsedMarket 조회수++
	@Override
	public void updateUsedMarketHits(int nNum) {
		Integer result = usedMarketMapper.updateUsedMarketHits(nNum);
		if (result == 1)
			System.out.println("-----Update UsedMarket Hits Success-----");	
	}
	
	//UsedMarket 삭제
	@Override
	public void deleteUsedMarket(int uNum) {
		Integer result = usedMarketMapper.deleteUsedMarket(uNum);
		if (result == 1)
			System.out.println("-----Delete UsedMarket Success-----");	
	}
}
