package caplcom.codingAge.capl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "caplcom.codingAge.capl")
public class CaplApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaplApplication.class, args);
	}
}
