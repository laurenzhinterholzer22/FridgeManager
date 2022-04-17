package at.jku.ce.fridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FridgeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FridgeManagerApplication.class, args);
	}

}
