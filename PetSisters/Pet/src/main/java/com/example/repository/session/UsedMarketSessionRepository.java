package com.example.repository.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.pet.domain.UsedMarket;
import com.example.repository.mapper.UsedMarketMapper;

public class UsedMarketSessionRepository {
	private SqlSessionFactory sqlSessionFactory = createSqlSessionFactory();
	
	private SqlSessionFactory createSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//모든 UsedMarket 찾기
	public List<UsedMarket> selectAllUsedMarket() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UsedMarketMapper.class).selectAllUsedMarket();
		} finally {
			sqlSession.close();
		}
	}
	
	//조회순 내림차순 5개 UsedMarket 찾기
	public List<UsedMarket> selectDescHitsUsedMarket() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UsedMarketMapper.class).selectDescHitsUsedMarket();
		} finally {
			sqlSession.close();
		}
	}
	
	//findValue로 Question 찾기
	public List<UsedMarket> selectUsedMarketByFindValue(String findValue) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UsedMarketMapper.class).selectUsedMarketByFindValue(findValue);
		} finally {
			sqlSession.close();
		}
	}
	
	//u_num으로 UsedMarket 찾기
	public UsedMarket selectUsedMarketByNum(int uNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UsedMarketMapper.class).selectUsedMarketByNum(uNum);
		} finally {
			sqlSession.close();
		}
	}
	
	//goods_type으로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketByGoodsType(int goodsType) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UsedMarketMapper.class).selectUsedMarketByGoodsType(goodsType);
		} finally {
			sqlSession.close();
		}
	}
	
	//추가된 u_num 찾기
	public List<Integer> selectUsedMarketNum() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UsedMarketMapper.class).selectUsedMarketNum();
		} finally {
			sqlSession.close();
		}
	}
	
	//m_num으로 UsedMarket 찾기
	public List<UsedMarket> selectUsedMarketBymNum(int mNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.getMapper(UsedMarketMapper.class).selectUsedMarketBymNum(mNum);
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	//UsedMarket 추가
	public int insertUsedMarket(UsedMarket usedMarket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).insertUsedMarket(usedMarket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	//UsedMarket NoExpiredate 추가
	public int insertUsedMarketNoExpiredate(UsedMarket usedMarket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).insertUsedMarketNoExpiredate(usedMarket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	//UsedMarket NoExpireUsedate 수정
	public int updateUsedMarketNoExpireUsedate(UsedMarket usedMarket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).updateUsedMarketNoExpireUsedate(usedMarket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
		
	//UsedMarket NoUsedate 수정
	public int updateUsedMarketNoUsedate(UsedMarket usedMarket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).updateUsedMarketNoUsedate(usedMarket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	//UsedMarket U_COMPLETETF 수정
	public int updateUsedMarketTF(int uNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).updateUsedMarketTF(uNum);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	//UsedMarket 수정
	public int updateUsedMarket(UsedMarket usedMarket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).insertUsedMarket(usedMarket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	//UsedMarket NoExpiredate 수정
	public int updateUsedMarketNoExpiredate(UsedMarket usedMarket) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).updateUsedMarketNoExpiredate(usedMarket);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	//UsedMarket 조회수++
	public int updateUsedMarketHits(int nNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).updateUsedMarketHits(nNum);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	//UsedMarket 삭제
	public int deleteUsedMarket(int uNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int result = sqlSession.getMapper(UsedMarketMapper.class).deleteUsedMarket(uNum);
			
			if (result > 0)
				sqlSession.commit();
			
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
