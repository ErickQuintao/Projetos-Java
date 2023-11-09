package com.erickcode.webclientrickandmortyapi.client;

import com.erickcode.webclientrickandmortyapi.response.CharacterResponse;
import com.erickcode.webclientrickandmortyapi.response.EpisodeResponse;
import com.erickcode.webclientrickandmortyapi.response.ListOfEpisodesResponse;
import com.erickcode.webclientrickandmortyapi.response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {

	private final WebClient webClient;
	
	public RickAndMortyClient(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}
	public Mono<CharacterResponse> findAndCharacterById(String id){
		   log.info("Buscando personagem com o id [{}]", id);
	        return webClient
	                .get()
	                .uri("/character/" + id)
	                .accept(MediaType.APPLICATION_JSON)
	                .retrieve()
	                .onStatus(HttpStatus::is4xxClientError,
	                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
	                .bodyToMono(CharacterResponse.class);
	
	}
}
