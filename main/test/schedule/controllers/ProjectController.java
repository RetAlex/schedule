package schedule.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import schedule._main.BaseTest;
import schedule.models.entities.Project;
import schedule.repositories.ProjectRepository;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ProjectController extends BaseTest {

    @Autowired
    public ProjectRepository projectRepository;

    private final Project firstProject = new Project(1, "Name1", null, "color", new ArrayList<>());

    @Before
    public void setUp() throws Exception {
        projectRepository.save(firstProject);
    }

    @Test
    public void testGetProject() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/project").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(200)).andReturn();
        Project returnedProject = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Project.class);
        assert returnedProject.equals(firstProject);
    }
}
