package at.jku.ce.fridge.openfoodfacts;

import io.micronaut.context.annotation.Bean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductOpenFoodService {

    public List<String> getProductsEans(String search) {
        List <String> eans = new ArrayList<>();
        String url = "https://world.openfoodfacts.org/cgi/search.pl?action=process&tagtype_0=categories&tag_contains_0=contains&tag_0=" + search + "&fields=code&json=1";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity request = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            Matcher m = Pattern.compile("\\{\"code\":\"(\\d*)\"\\}").matcher(response.getBody());
            while (m.find())
            {
                eans.add(m.group(1));
            }

        }
        return eans;
    }
}