package ca.toronto.commoncomponents.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.toronto.commoncomponents.model.ExitCriteria;
import ca.toronto.commoncomponents.model.Payload;
import ca.toronto.commoncomponents.model.Schedule;
import ca.toronto.commoncomponents.repo.ScheduleRepository;

@Service
@Transactional
public class SchedulerService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	public Long create(Payload payload) {
		final Schedule schedule = payload.getSchedule();
		schedule.setRunParameters(payload.getParams());
		schedule.getRecurrence().getRunTimes().forEach(runtime -> runtime.setRecurrence(schedule.getRecurrence()));
		//TODO: fix me. DOn't hardcode exitCriteria -hj
		schedule.getRecurrence().setExitCriteria(ExitCriteria.OCCURANCES);
		scheduleRepository.save(schedule);

		return schedule.getId();

	}
}
