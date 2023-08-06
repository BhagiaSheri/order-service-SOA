package esb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ESBApplication implements CommandLineRunner {

	RestTemplate restTemplate;

	@Autowired
	public ESBApplication() {
		this.restTemplate = new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ESBApplication.class, args);
	}

	@Override
	public void run(String... args) {
		restTemplate.postForLocation("http://localhost:8080/orders", new Order("334", 120.0));
		restTemplate.postForLocation("http://localhost:8080/orders", new Order("355", 185.0));
	}
}
