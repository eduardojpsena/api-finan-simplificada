package com.api_financeira_simplificada.service;

import com.api_financeira_simplificada.dto.AuthorizeClientDTO;
import com.api_financeira_simplificada.dto.NotifyClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NotifyService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${notify.client.url}")
    private String notifyUrl;

    public NotifyClientDTO authorize() {
        try {
            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(notifyUrl, Map.class);
            Map<String, Object> responseMap = responseEntity.getBody();
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                Map<String, Object> data = (Map<String, Object>) responseMap.get("data");
                Boolean authorization = (Boolean) data.get("message");
                return new NotifyClientDTO(HttpStatus.OK, "Notificação enviada com sucesso");
            }
            return null;
        } catch (Exception e) {
            return new NotifyClientDTO(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
