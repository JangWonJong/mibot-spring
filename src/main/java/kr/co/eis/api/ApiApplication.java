package kr.co.eis.api;

import kr.co.eis.api.image.properties.ImageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ImageProperties.class)
public class ApiApplication {

	public static void main(String... args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
