package com.hearthstonecardreader.features.hearthstonecards.service;

import com.hearthstonecardreader.features.hearthstonecards.dto.*;
import com.hearthstonecardreader.features.hearthstonecards.dto.Set;
import com.hearthstonecardreader.intergration.blizzard.service.BlizzardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
//Service class thaat does the logic needed to set up the data for display
public class HearthStoneCardsService {

    private final BlizzardService blizzardService;

    //Method to grab the Card data from the Api service and start filtering
    //This is also the method that returns the final object for the front-end
    public Deck getSortedWarlockCards() {
        Deck jsonCards = blizzardService.getCards().block();
        return populateCardIDs(jsonCards);

    }

    //--------------------------------------------------------------------------------
    //  Methods used to set up Pojo's for ID to Name conversions
    public List<Rarity> getRarity() {
        List<Rarity> rarities = blizzardService.getRarity().collect(Collectors.toList()).block();
        return rarities;
    }
    public List<CardClasses> getClasses() {
        List<CardClasses> cardClasses = blizzardService.getClasses().collect(Collectors.toList()).block();
        return cardClasses;
    }
    public List<Set> getSet() {
        List<Set> sets = blizzardService.getSet().collect(Collectors.toList()).block();
        return sets;
    }
    public List<Type> getTypes() {
        List<Type> types = blizzardService.getTypes().collect(Collectors.toList()).block();
        return types;
    }

    //  logic to find and set the the ID's to their corresponding names
    public Deck populateCardIDs(Deck jsonCards) {
        List<Rarity> rarities = getRarity();
        List<CardClasses> cardClasses = getClasses();
        List<Set> sets = getSet();
        List<Type> types = getTypes();

        for(Card card : jsonCards.cards){

                Optional<Rarity> rarity = rarities.stream().filter(rare -> rare.getId() == card.getRarityId()).findFirst();
                card.setRarityName(rarity.isEmpty() ? "Rarity not found" : rarity.get().getName());

                System.out.println(card.getRarityName());

                Optional<CardClasses> cardClassifer = cardClasses.stream().filter(cardClass -> cardClass.getId() == card.getClassId()).findFirst();
                card.setClassName(cardClassifer.isEmpty() ? "Class not found" : cardClassifer.get().getName());

                System.out.println(card.getClassName());

                Optional<Set> cardSets = sets.stream().filter(cardSet -> cardSet.getId() == card.getCardSetId()).findFirst();
                card.setCardSetName(cardSets.isEmpty() ? "Set not found" : cardSets.get().getName());
                System.out.println(card.getCardSetName());


                Optional<Type> cardTypes = types.stream().filter(type -> type.getId() == card.getCardTypeId()).findFirst();
                card.setTypeName(cardTypes.isEmpty() ? "Type not found" : cardTypes.get().getName());

                System.out.println(card.getTypeName());
        }
        return jsonCards;
    }
}
