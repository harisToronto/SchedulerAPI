package ca.toronto.commoncomponents.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.toronto.commoncomponents.model.Schedule;
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	
	Schedule findById(String id);
	
	List<Schedule> findByEnabled(boolean status);

}
