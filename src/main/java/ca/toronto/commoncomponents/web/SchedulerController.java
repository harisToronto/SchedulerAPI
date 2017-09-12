package ca.toronto.commoncomponents.web;

import java.io.IOException;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.toronto.commoncomponents.model.Payload;

@RestController
@RequestMapping("/")
public class SchedulerController {
	
	@Autowired
    ProducerTemplate producerTemplate;
 
	
	 @RequestMapping(value = "/api/post/", method = RequestMethod.POST, consumes = "application/json")
	   public void startCamel(@RequestBody Payload body) throws JsonParseException, JsonMappingException, IOException {
		  //ObjectMapper mapper = new ObjectMapper();
		  //Payload p =  mapper.readValue(body, Payload.class);
		 //TODO: validate json for missing certain parts, invalid value/format etc -hj
		   producerTemplate.sendBody("direct:createSchedule",body);
	   }

}
