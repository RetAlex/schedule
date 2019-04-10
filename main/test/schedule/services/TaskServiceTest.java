package schedule.services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import schedule._main.BaseTest;
import schedule.models.dto.payloads.CreateProjectPayload;
import schedule.models.dto.payloads.UpdateProjectPayload;
import schedule.models.entities.Project;
import schedule.models.exceptions.NotFoundException;
import schedule.repositories.ProjectRepository;


public class TaskServiceTest extends BaseTest {

    @Autowired
    public ProjectService projectService;
    @Autowired
    public ProjectRepository projectRepository;

    private final CreateProjectPayload firstProject = new CreateProjectPayload("Name1", null, "color");
    private Project project1, project2;


    @Before
    public void setUp(){
        project1 = new Project(new CreateProjectPayload("Name1", null, "color"));
        project2 = new Project(new CreateProjectPayload("Name2", null, "color2"));
        projectRepository.save(project1); projectRepository.save(project2);
    }


    @Test
    public void createProject() throws Exception {
        Project project = projectService.createProject(firstProject);
        assert project.getId()>=0 && project.getTasks().size()==0;
    }

    @Test
    public void testGetProject() throws Exception {
        Project project = projectService.getProject(project1.getId());
        assert project !=null && project.equals(project1);
    }

    @Test(expected = NotFoundException.class)
    public void testGetProjectNotFound() throws Exception {
        projectService.getProject(-1);
    }

    @Test
    public void testUpdateProject(){
        String newName = "Completely other name"; Long newDeadline = 1000L;
        UpdateProjectPayload updateProjectPayload = new UpdateProjectPayload();
        updateProjectPayload.setName(newName);
        updateProjectPayload.setDeadline(newDeadline);
        projectService.updateProject(updateProjectPayload, project2.getId());
        Project project = projectService.getProject(project2.getId());
        assert !project.equals(project2) && project.getName().equals(newName) && project.getDeadline().equals(newDeadline);
    }

    @Test(expected = NotFoundException.class)
    public void testUpdateProjectNotExists(){
        projectService.updateProject(new UpdateProjectPayload(), -1);
    }
}
