package pe.com.visanet.process.init;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.activemq.transport.stomp.StompConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class SecretsBean {
	private static final Logger LOG = Logger.getLogger(SecretsBean.class);

	private String destination = "/queue/queue1";

	@Autowired
	private Environment environment;

	@PostConstruct
	public void init() {
		System.out.println("SecretsBean.init() DATA!! DATA!! DATA!! DATA!! DATA!! DATA!!");
		LOG.info("P1: " + environment.getProperty("spring.batch.initializer.enabled"));
		LOG.info("P2: " + environment.getProperty("spring.batch.job.enabled"));
		LOG.info("P3: " + environment.getProperty("spring.datasource.url"));
		LOG.info("P3: " + environment.getProperty("spring.datasource.username"));
		LOG.info("P3: " + environment.getProperty("spring.datasource.password"));
//		LOG.info("JOBER: " + Arrays.asList(environment.getDefaultProfiles()));

		String host = "localhost";
		int port = 61613;
		String user = "user";
		String password = "pass";

		StompConnection connection = new StompConnection();
		try {
//			URL u = new URL(url);
			connection.open(host, port);
			connection.connect(user, password);

//			StompFrame connect = connection.receive();
//			if (!connect.getAction().equals(Stomp.Responses.CONNECTED)) {
//			    throw new IOException ("Not connected");
//			}

			connection.begin("tx1");
			for (int i = 0; i < 5; i++)
				connection.send(destination, "tx-msg:" + i);
			connection.commit("tx1");

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (IOException e) {
			}
		}

		System.out.println("SecretsBean.init() BIT!!! BIT!!! BIT!!! BIT!!! BIT!!! BIT!!!");
	}

	public void consumeCloudConfigServer(String endpointAut, String endpointToken) {

//		ResponseApiAutorization response = new ResponseApiAutorization();
		try {

			RestTemplate restTemplate = new RestTemplate();
//			String token = this.generarToken(endpointToken, usuario, clave);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
//			headers.add("Authorization", token);

			HttpEntity requestBody = new HttpEntity(headers);

			ResponseEntity<String> responseEntity = restTemplate.exchange(endpointAut, HttpMethod.POST, requestBody,
					String.class);

			HttpStatus statusCode = responseEntity.getStatusCode();
//			Gson gson = new Gson();

//			response.setExecutionDate(Utils.tiempoEnMiliSegundos());

			String strJson = responseEntity.getBody();
//			if (strJson != null) {
//				dataAuthorization = gson.fromJson(strJson, ResponseDataAuthorization.class);
//			}
//
//			response.setCode(statusCode.value());
//			response.setDescription(Constantes.HTTP_EXITO_DESCRIPCION);
//			response.setJson(strJson);
//			response.setData(dataAuthorization);

		} catch (HttpStatusCodeException e) {
			e.printStackTrace();
			System.out.println("ClientStomp.authorizationApi() e:" + e.getMessage());
		} catch (RestClientException e) {
			e.printStackTrace();
			System.out.println("ClientStomp.authorizationApi() e:" + e.getMessage());
		}
//		return response;
	}

}
