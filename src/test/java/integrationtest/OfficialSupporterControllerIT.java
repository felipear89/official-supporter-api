package integrationtest;

import com.company.officialsupporterapi.OfficialSupporterApiApplication;
import com.company.officialsupporterapi.model.OfficialSupporter;
import com.company.officialsupporterapi.repository.OfficialSupporterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = OfficialSupporterApiApplication.class)
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
@AutoConfigureMockMvc
public class OfficialSupporterControllerIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private OfficialSupporterRepository supporterRepository;

    @Test
    public void createSupporter() throws Exception {

        supporterRepository.deleteAll();

        mvc.perform(post("/officialSupporters")
                .content(mapper.writeValueAsString(officialSupporter()))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void avoidDuplicateSupporter() throws Exception {

        supporterRepository.deleteAll();
        supporterRepository.save(officialSupporter());

        mvc.perform(post("/officialSupporters")
                .content(mapper.writeValueAsString(officialSupporter()))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isConflict());

    }

    private OfficialSupporter officialSupporter() {
        OfficialSupporter officialSupporter = new OfficialSupporter();
        officialSupporter.setEmail("test@fake.com");
        officialSupporter.setName("James");
        officialSupporter.setTeamId("spfc");
        return officialSupporter;
    }

}