package com.hearthstonecardreader.features.hearthstonecards.rest;

import com.hearthstonecardreader.features.hearthstonecards.dto.Card;
import com.hearthstonecardreader.features.hearthstonecards.service.HearthStoneCardsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Getter
@RequiredArgsConstructor
@RequestMapping("/api")
//Rest controller used to pass transformed data to the front end
public class HearthStoneCardsController {
    final HearthStoneCardsService hearthStoneCardsService;
    @CrossOrigin
    @GetMapping("/warlocks")
    public List<Card> getWarlockCards(){
        return hearthStoneCardsService.getSortedWarlockCards();
    }
}
