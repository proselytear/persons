package net.proselyte.addressservice.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.proselyte.addressservice.dto.PersonDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonClient {

    private final RestTemplate restTemplate;
    @Value("${person.service.url}")
    private String personServiceUrl;

    public List<PersonDto> getPersons() {
        ResponseEntity<List<PersonDto>> response = restTemplate.exchange(
                personServiceUrl + "/api/v1/persons", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        List<PersonDto> result = response.getBody();
        log.info("IN getPersons - {} persons", result.size());
        return result;
    }
}
