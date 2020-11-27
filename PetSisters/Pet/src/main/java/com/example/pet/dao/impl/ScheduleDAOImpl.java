package com.example.pet.dao.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pet.dao.ScheduleDao;
import com.example.pet.domain.Schedule;
import com.example.repository.mapper.ScheduleMapper;


@Repository
public class ScheduleDAOImpl implements ScheduleDao{
	@Autowired
	private ScheduleMapper ScheduleMapper;
	
	public List<Schedule> selectSchedule(int m_num) {
		return ScheduleMapper.selectSchedule(m_num);
	}
	
	public Integer insertSchedule(Schedule schedule) {
		Integer result = ScheduleMapper.insertSchedule(schedule);
		return result;
	}
		
	public Integer updateSchedule(Schedule schedule) {
		Integer result = ScheduleMapper.updateSchedule(schedule);
		return result;
	}
		
	public Integer deleteSchedule(int s_num) {
		Integer result = ScheduleMapper.deleteSchedule(s_num);
		return result;
	}

	public List<Integer> selectScheduleNum() {
		return ScheduleMapper.selectScheduleNum();
	}
	public Integer insertSchedule2(Schedule schedule) {
		Integer result = ScheduleMapper.insertSchedule2(schedule);
		return result;
	}

	public Integer deleteSchedule2(@Param("m_num") int sitterNum,@Param("s_date") String r_date) {
		Integer result = ScheduleMapper.deleteSchedule2(sitterNum,r_date);
		return result;
	}
}
