package retrain.maven.neko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class NekoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NekoApplication.class, args);
	}

}
