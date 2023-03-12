package io.github.com.creditappraisalms;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableRabbit
public class CreditAppraisalMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditAppraisalMsApplication.class, args);
	}

}
