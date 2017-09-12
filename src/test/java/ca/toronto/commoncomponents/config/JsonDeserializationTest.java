package ca.toronto.commoncomponents.config;

import static org.junit.Assert.assertNotNull;

import org.apache.camel.ProducerTemplate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.core.IsNull.notNullValue;
import ca.toronto.commoncomponents.model.Payload;
import ca.toronto.commoncomponents.model.Schedule;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@JsonTest
public class JsonDeserializationTest {
		
	@Autowired
	private ProducerTemplate template;
	
	@Autowired
    private JacksonTester<Payload> json;

	private MockMvc mockMvc;



	@Before
	public void setUp() throws Exception {
		//this.mockMvc = MockMvcBuilders.standaloneSetup(controllerToTest).build();
	}

	
	@Test
    public void testSimpleJsonPayloadNoCustomParamsDeserialize() throws Exception {
        String content = jsonWithNoCustomParams();
//        assertThat(this.json.parse(content))
//                .isEqualTo(new VehicleDetails("Ford", "Focus"));
        final Payload payload = this.json.parseObject(content);
        assertThat(payload, notNullValue());
        final Schedule schedule = payload.getSchedule();
		assertThat(schedule,notNullValue());
		String endPointUrl = payload.getSchedule().getEndPointUrl();
		assertThat(endPointUrl, is(equalToIgnoringWhiteSpace("http://fodaboda.com/endpoint")));
		assertThat(schedule.getType(), notNullValue());
		assertThat(schedule.isEnabled(), notNullValue());
		
    }

	@After
	public void tearDown() throws Exception {
	}


	private static String jsonWithNoCustomParams() {
		return "{\n\t\"schedule\": {\n\t\t\"type\": \"recurring\",\n\t\t\"enabled\": true,\n\t\t\"endPointUrl\": \"http://fodaboda.com/endpoint\",\n\t\t\"recurrence\": {\n\t\t\t\"frequency\": \"days\",\n\t\t\t\"interval\": 1,\n\t\t\t\"startTime\": \"2017-08-31T05:00:00\",\n\t\t\t\"endTime\": 2,\n\t\t\t\"runTimes\": [\n\t\t\t\t{\n\t\t\t\t\t\"time\": \"22:00\"\n\t\t\t\t}\n\t\t\t]\n\t\t}\n\t}\n}";
	}

}
