package ca.toronto.commoncomponents.routing;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ca.toronto.commoncomponents.model.Payload;
import ca.toronto.commoncomponents.services.SchedulerService;

@Component
public class SchedulerRoutes extends RouteBuilder {

	@Value("${server.port}")
	String serverPort;

	@Value("${context.api.path}")
	String contextPath;

	@Autowired
	private SchedulerService schedulerService;

	@Override
	public void configure() {
		restConfiguration().contextPath(contextPath).port(serverPort).enableCORS(true).apiContextPath("/api-doc")
				.apiProperty("api.title", "Scheduler REST API").apiProperty("api.version", "v1").apiProperty("cors", "true") // cross-site
				.apiContextRouteId("doc-api").component("servlet").bindingMode(RestBindingMode.json)
				.dataFormatProperty("prettyPrint", "true");

		from("direct:createSchedule").process((exchange) -> {
			Payload bodyIn = (Payload) exchange.getIn().getBody();

			Long schedulerId = schedulerService.create(bodyIn);
			exchange.getIn().setBody(schedulerId);
		}).setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
	}
}
