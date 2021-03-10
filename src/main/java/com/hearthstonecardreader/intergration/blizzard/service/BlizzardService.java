package com.hearthstonecardreader.intergration.blizzard.service;

import com.hearthstonecardreader.features.hearthstonecards.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BlizzardService {
    @Autowired
    private WebClient webClient;
//api call to get cards from blizzard api (used api params to filter for warlock rarity and collectible
    public Mono<Deck> getCards() {
        return this.webClient.get().uri("https://us.api.blizzard.com/hearthstone/cards?locale=en_US&class=warlock&collectible=1&rarity=legendary")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Deck.class);
    }
    //Api calls to query for card metadata
    public Flux<Rarity> getRarity() {
        return this.webClient.get().uri("https://us.api.blizzard.com/hearthstone/metadata/rarities?locale=en_US")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Rarity.class);
    }
    public Flux<CardClasses> getClasses() {
        return this.webClient.get().uri("https://us.api.blizzard.com/hearthstone/metadata/classes?locale=en_US")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CardClasses.class);
    }
    public Flux<Type> getTypes() {
        return this.webClient.get().uri("https://us.api.blizzard.com/hearthstone/metadata/types?locale=en_US")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Type.class);
    }
    public Flux<Set> getSet() {
        return this.webClient.get().uri("https://us.api.blizzard.com/hearthstone/metadata/sets?locale=en_US")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Set.class);
    }

}
