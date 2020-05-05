package pe.com.visanet.process.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class HealthCheckController {

	RestTemplate restTemplate;

	public HealthCheckController() {
		restTemplate = new RestTemplate();
	}

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=UTF-8")
	public String obtenerHealthCheck() {
		String healh = "{\"status\":\"UP\"}";
		return healh;
	}

	@GetMapping("/getForObjectOperation")
	public String getForObjectOperation() {
		final String responseBody = restTemplate.getForObject("http://localhost:8866/config-client/default", String.class);
		return responseBody;
	}
}