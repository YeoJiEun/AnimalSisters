package com.example.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.pet.domain.Schedule;

public interface ScheduleMapper {
	List<Schedule> selectSchedule(int m_num);
	int insertSchedule(Schedule schedule);
	int updateSchedule(Schedule schedule);	
	int deleteSchedule(int s_num);
	
	List<Integer> selectScheduleNum();
	int insertSchedule2(Schedule schedule);
	Integer deleteSchedule2(@Param("m_num") int sitterNum,@Param("s_date") String r_date);
}