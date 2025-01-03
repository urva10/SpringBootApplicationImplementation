package ThirdPartyApiService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {

    private  final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    public String callThirdPartyApi(String apiUrl ){
        ResponseEntity<String> response=restTemplate.getForEntity(apiUrl, String.class);
                return response.getBody();
    }
}
