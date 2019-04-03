package schedule._main;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import schedule.controllers.ProjectController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Runner.class)
public class BaseTest {
    protected MockMvc mockMvc;

    @Before()
    public void start(){
        mockMvc = MockMvcBuilders.standaloneSetup(ProjectController.class).build();
    }
}
