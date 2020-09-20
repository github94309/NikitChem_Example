package com.java.nikitchem_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class NikitChemExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NikitChemExampleApplication.class, args);
	}

}
