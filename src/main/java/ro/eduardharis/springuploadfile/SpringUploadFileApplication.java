package ro.eduardharis.springuploadfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)

public class SpringUploadFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUploadFileApplication.class, args);
    }

    CommandLineRunner init(StorageService storageService) {
        return args -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
