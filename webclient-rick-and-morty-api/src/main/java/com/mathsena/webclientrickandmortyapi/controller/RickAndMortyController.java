package com.mathsena.webclientrickandmortyapi.controller;

import com.mathsena.webclientrickandmortyapi.client.RickAndMortyClient;
import com.mathsena.webclientrickandmortyapi.response.CharactererResponse;
import com.mathsena.webclientrickandmortyapi.response.EpisodeResponse;
import com.mathsena.webclientrickandmortyapi.response.ListOfEpisodesResponse;
import com.mathsena.webclientrickandmortyapi.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {


    RickAndMortyClient rickAndMortyClient;


    @GetMapping("/character/{id}")
    public Mono<CharactererResponse> getCharacterById(@PathVariable String id){
        return rickAndMortyClient.findAnCharacterById(id);

    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id){
        return rickAndMortyClient.findAnLocationById(id);

    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
        return rickAndMortyClient.findAnLEpisodeById(id);

    }

    @GetMapping("/episodes")
    public Flux<ListOfEpisodesResponse> getAllEpisodes(){
        return rickAndMortyClient.getAllEpisodes();

    }
}
