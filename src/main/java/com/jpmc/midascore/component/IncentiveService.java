package com.jpmc.midascore.component;

import com.jpmc.midascore.foundation.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IncentiveService {
    private final RestTemplate restTemplate;

    public IncentiveService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Incentive fetchIncentive(Transaction transaction) {
        try {
            Incentive response = restTemplate.postForObject("http://localhost:8080/incentive", transaction, Incentive.class);
            return response != null ? response : new Incentive(0f);
        } catch (Exception e) {
            return new Incentive(0f);
        }
    }
}
