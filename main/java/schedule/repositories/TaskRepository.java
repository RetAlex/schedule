package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import schedule.models.entities.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select * from tasks where start_date>=?1 and start_date<=?2 and list is null", nativeQuery = true)
    List<Task> getTasksInRange(long from, long to);

    List<Task> findAllByListIsNotNull();
}
