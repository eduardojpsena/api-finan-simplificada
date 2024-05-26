package com.api_financeira_simplificada.service;

import com.api_financeira_simplificada.dto.AuthorizeClientDTO;
import com.api_financeira_simplificada.service.client.AuthorizeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AuthorizationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${authorize.client.url}")
    private String authorizeUrl;

    public AuthorizeClientDTO authorize() {
        try {
            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(authorizeUrl, Map.class);
            Map<String, Object> responseMap = responseEntity.getBody();
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                Map<String, Object> data = (Map<String, Object>) responseMap.get("data");
                Boolean authorization = (Boolean) data.get("authorization");
                return new AuthorizeClientDTO(authorization);
            }
            return null;
        } catch (Exception e) {
            return new AuthorizeClientDTO(false);
        }

    }
}
