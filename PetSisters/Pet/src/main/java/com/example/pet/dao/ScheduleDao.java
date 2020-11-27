package com.example.pet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.pet.domain.Schedule;

public interface ScheduleDao {
	List<Schedule> selectSchedule(int m_num);
	Integer insertSchedule(Schedule schedule);
	Integer updateSchedule(Schedule schedule);	
	Integer deleteSchedule(int s_num);
	
	List<Integer> selectScheduleNum();
	Integer insertSchedule2(Schedule schedule);
	Integer deleteSchedule2(@Param("m_num") int sitterNum,@Param("s_date") String r_date);
}