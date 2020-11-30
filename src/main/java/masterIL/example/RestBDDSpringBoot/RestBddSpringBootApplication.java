package masterIL.example.RestBDDSpringBoot;

import masterIL.example.RestBDDSpringBoot.model.Serie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SpringBootApplication
public class RestBddSpringBootApplication {

	private static final Logger log = LoggerFactory.getLogger(RestBddSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestBddSpringBootApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner demo(SerieRepository repository){
		return args -> {
			repository.save(new Serie("name", "author", "resume"));
			repository.save(new Serie("name1", "author1", "resume1"));
			repository.save(new Serie("name2", "author2", "resume2"));

			log.info("Affichage de toutes les séries avec findAll");
			for(Serie serie : repository.findAll()){
				log.info(serie.toString());
				System.out.println(serie.toString());
			}
		};
	}*/

}
