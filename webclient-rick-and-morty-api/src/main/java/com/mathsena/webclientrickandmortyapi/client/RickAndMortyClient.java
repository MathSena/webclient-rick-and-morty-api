package com.mathsena.webclientrickandmortyapi.client;

import com.mathsena.webclientrickandmortyapi.response.CharactererResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class RickAndMortyClient {

    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharactererResponse> findAndCharacterById(String id){
        log.info("buscando o personagem com o id [{}]");
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os campos informados")
                                )).bodyToMono(CharactererResponse.class);

    }
}
