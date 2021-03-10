package com.hearthstonecardreader.features.hearthstonecards.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

//Pojo used to transfer card info
public class Card {

   public int id;

   public int collectible;

   public String slug;

   public int classId;

   public String className;

   public int multiClassId;

   public int cardTypeId;

   public String typeName;

   public int cardSetId;

   public String cardSetName;

   public int rarityId;

   public String rarityName;

   public String artistName;

   public int health;

   public int attack;

   public int manaCost;

   public String name;

   public String text;

   public String image;
}
