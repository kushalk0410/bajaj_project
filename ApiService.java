package com.example.sqlsolver.service;

import com.example.sqlsolver.model.GenerateRequest;
import com.example.sqlsolver.model.GenerateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {

    private final WebClient webClient;

    // Call the generateWebhook API
    public Mono<GenerateResponse> getWebhook(String url, GenerateRequest req) {
        return webClient.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(req)
                .retrieve()
                .bodyToMono(GenerateResponse.class);
    }

    // Send the final query back
    public Mono<Result> sendQuery(String webhookUrl, String token, String query) {
        record Body(String finalQuery) {}

        return webClient.post()
                .uri(webhookUrl)
                .header(HttpHeaders.AUTHORIZATION, token) // JWT as is
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new Body(query))
                .exchangeToMono(resp ->
                        resp.bodyToMono(String.class)
                                .defaultIfEmpty("")
                                .map(body -> new Result(resp.statusCode().value(), body))
                );
    }

    public record Result(int status, String body) {}
}
