package ca.toronto.commoncomponents.web;

import java.io.IOException;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.toronto.commoncomponents.model.Payload;
import ca.toronto.commoncomponents.utils.JsonValidationUtils;
import ca.toronto.commoncomponents.utils.exception.MissingNecessaryPropertiesInJsonException;

@RestController
@RequestMapping("/")
public class SchedulerController {

	@Autowired
	ProducerTemplate producerTemplate;

	@Autowired
	ObjectMapper jacksonObjectMapper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/api/post/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> createSchedule(@RequestBody Payload payload, UriComponentsBuilder componentsBuilder)
			throws JsonParseException, JsonMappingException, IOException {
		try {
			JsonValidationUtils.validate(payload);
			producerTemplate.sendBody("direct:createSchedule", payload);
		} catch (MissingNecessaryPropertiesInJsonException e) {
			return new ResponseEntity(jacksonObjectMapper.writeValueAsString(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return null;
	}

}
