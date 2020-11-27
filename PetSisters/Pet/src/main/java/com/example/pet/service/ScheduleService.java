package com.example.pet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dao.ScheduleDao;
import com.example.pet.domain.Schedule;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleDao ScheduleMapperRepository;

	public List<Schedule> selectSchedule(int m_num) {
		return ScheduleMapperRepository.selectSchedule(m_num);
	}
	
	public Integer insertSchedule(Schedule schedule) {
		return ScheduleMapperRepository.insertSchedule(schedule);
	}
			
	public Integer updateSchedule(Schedule schedule) {
		return ScheduleMapperRepository.updateSchedule(schedule);
	}
			
	public Integer deleteSchedule(int s_num) {
		return ScheduleMapperRepository.deleteSchedule(s_num);
	}
	
	public List<Integer> selectScheduleNum() {
		return ScheduleMapperRepository.selectScheduleNum();
	}
	public Integer insertSchedule2(Schedule schedule) {
		return ScheduleMapperRepository.insertSchedule2(schedule);
	}

	public Integer deleteSchedule2(@Param("m_num") int sitterNum,@Param("s_date") String r_date) {
		return ScheduleMapperRepository.deleteSchedule2(sitterNum,r_date);	
	}	
}
