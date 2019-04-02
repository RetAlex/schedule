package schedule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import schedule.models.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
