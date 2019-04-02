package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.models.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
