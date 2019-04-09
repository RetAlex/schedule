package schedule.services;

import org.springframework.stereotype.Service;
import schedule.models.dto.payloads.CreateProjectPayload;
import schedule.models.dto.payloads.UpdateProjectPayload;
import schedule.models.entities.Project;
import schedule.models.exceptions.NotFoundException;
import schedule.repositories.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(CreateProjectPayload createTaskPayload){
        Project project = new Project(createTaskPayload);
        projectRepository.save(project);
        return project;
    }

    public void updateProject(UpdateProjectPayload payload, long id){
        Project project = projectRepository.findById(id).orElseThrow(NotFoundException::new);
        project.applyUpdates(payload);
        projectRepository.save(project);
    }

    public Project getProject(long id){
        return projectRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }
}
