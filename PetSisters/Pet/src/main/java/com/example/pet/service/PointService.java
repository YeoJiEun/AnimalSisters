package com.example.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dao.PointDAO;
import com.example.pet.domain.Point;

@Service
public class PointService {
	@Autowired
	private PointDAO pointDAO;

	public List<Point> selectPoint(int m_num) {
		return pointDAO.selectPoint(m_num);
	}
	
	public int insertPoint(Point point) {
		return pointDAO.insertPoint(point);
	}
			
	public int updatePoint(Point point) {
		return pointDAO.updatePoint(point);
	}
			
	public int deleteBasket(int po_num) {
		return pointDAO.deletePoint(po_num);
	}
}
