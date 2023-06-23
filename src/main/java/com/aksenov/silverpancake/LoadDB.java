package com.aksenov.silverpancake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
class LoadDB {
    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase(CatRepository repository) {
        return args -> {
          log.info("preload " + repository.save(new Cat("Jodie", "Sphinx")));
            log.info("preload " + repository.save(new Cat("Johnny", "Bengal")));
            log.info("preload " + repository.save(new Cat("Penny", "Persian")));
        };
    }
}
