package es.deusto.sd.strava.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GoogleServiceGateway {

    private final String googleServiceBaseUrl = "http://localhost:8080/api/auth/google";

    public boolean isEmailRegistered(String email) {
        RestTemplate restTemplate = new RestTemplate();
        String url = googleServiceBaseUrl + "/isRegistered?email=" + email;
        return restTemplate.getForObject(url, Boolean.class);
    }

    public boolean validateCredentials(String email, String password) {
        RestTemplate restTemplate = new RestTemplate();
        String url = googleServiceBaseUrl + "/validate?email=" + email + "&password=" + password;
        return restTemplate.postForObject(url, null, Boolean.class);
    }
}
