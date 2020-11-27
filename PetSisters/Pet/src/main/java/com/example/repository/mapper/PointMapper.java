package com.example.repository.mapper;

import java.util.List;

import com.example.pet.domain.Point;

public interface PointMapper {
	List<Point> selectPoint(int m_num);
	int insertPoint(Point point);
	int updatePoint(Point Point);	
	int deletePoint(int po_num);
}