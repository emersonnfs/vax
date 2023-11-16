package br.com.vax;

import br.com.vax.services.DataInitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaxApplication implements CommandLineRunner {

	@Autowired
	private DataInitializationService dataInitializationService;

	public static void main(String[] args) {
		SpringApplication.run(VaxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataInitializationService.initializeData();
	}
}
