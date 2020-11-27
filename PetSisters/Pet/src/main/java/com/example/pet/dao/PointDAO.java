package com.example.pet.dao;

import java.util.List;

import com.example.pet.domain.Point;

public interface PointDAO {
	List<Point> selectPoint(int m_num);
	int insertPoint(Point point);
	int updatePoint(Point point);
	int deletePoint(int po_num);
}
