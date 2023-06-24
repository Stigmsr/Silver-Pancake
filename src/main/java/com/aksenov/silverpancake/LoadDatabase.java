package com.aksenov.silverpancake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CatRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Cat("Jodie", "Sphinx")));
            log.info("Preloading " + repository.save(new Cat("Muffin", "Turkish Angora")));
            log.info("Preloading " + repository.save(new Cat("Trip", "Siamese")));
        };
    }
}
