package com.example.pet.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.PointDAO;
import com.example.pet.domain.Point;
import com.example.repository.mapper.PointMapper;

@Repository
public class PointDAOImpl implements PointDAO{
	@Autowired
	private PointMapper pointMapper;

	public List<Point> selectPoint(int m_num) {
		return pointMapper.selectPoint(m_num);
	}
	
	public int insertPoint(Point point) {
		Integer result = pointMapper.insertPoint(point);
		return result;
	}
		
	public int updatePoint(Point point) {
		Integer result = pointMapper.updatePoint(point);
		return result;
	}
		
	public int deletePoint(int po_num) {
		Integer result = pointMapper.deletePoint(po_num);
		return result;
	}
}
