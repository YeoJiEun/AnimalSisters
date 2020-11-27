package com.example.pet.dao;

import java.util.List;
import com.example.pet.domain.UsedMarket;

public interface UsedMarketDAO {
	
	//모든 UsedMarket 찾기
	public List<UsedMarket> selectAllUsedMarket();
	
	//조회순 내림차순 5개 UsedMarket 찾기
	public List<UsedMarket> selectDescHitsUsedMarket();
	
	//findValue로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketByFindValue(String findValue);
	
	//u_num으로 UsedMarket 찾기
	public UsedMarket selectUsedMarketByNum(int uNum);
	
	//goods_type으로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketByGoodsType(int goodsType);
	
	//추가된 u_num 찾기
	public List<Integer> selectUsedMarketNum();
	
	//m_num으로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketBymNum(int mNum);
	
	
	
	//UsedMarket 추가
	public void insertUsedMarket(UsedMarket usedMarket);
	
	//UsedMarket NoExpiredate 추가
	public void insertUsedMarketNoExpiredate(UsedMarket usedMarket);
	
	//UsedMarket 수정
	public void updateUsedMarket(UsedMarket usedMarket);
	
	//UsedMarket NoExpiredate 수정
	public void updateUsedMarketNoExpiredate(UsedMarket usedMarket);
	
	//UsedMarket NoExpireUsedate 수정
	public void updateUsedMarketNoExpireUsedate(UsedMarket usedMarket);
		
	//UsedMarket NoUsedate 수정
	public void updateUsedMarketNoUsedate(UsedMarket usedMarket);
	
	//UsedMarket U_COMPLETETF 수정
	public void updateUsedMarketTF(int uNum);
	
	//UsedMarket 조회수++
	public void updateUsedMarketHits(int nNum);
	
	//UsedMarket 삭제
	public void deleteUsedMarket(int uNum);
}
