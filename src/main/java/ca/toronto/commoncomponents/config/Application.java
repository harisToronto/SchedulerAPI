package ca.toronto.commoncomponents.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("ca.toronto.commoncomponents")
@EnableJpaRepositories(basePackages = "ca.toronto.commoncomponents.repo")
@EntityScan(basePackages = "ca.toronto.commoncomponents.model")
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer {

	//
	// public static void main(String[] args) {
	// SpringApplication.run(Application.class, args);
	// }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
