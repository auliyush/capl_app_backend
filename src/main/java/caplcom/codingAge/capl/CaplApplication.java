package caplcom.codingAge.capl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CaplApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaplApplication.class, args);
	}
}
