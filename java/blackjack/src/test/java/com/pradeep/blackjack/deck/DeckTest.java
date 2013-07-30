/*
 * Copyright 2013 pradeepg26.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pradeep.blackjack.deck;

import com.pradeep.blackjack.card.ICard;
import com.pradeep.blackjack.card.Suit;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author pradeepg26
 */
public class DeckTest {

  @Test
  public void testNumCards() {
    Deck deck = new Deck();
    assertEquals(52, deck.getCards().size());
  }

  @Test
  public void testRanks() {
    Deck deck = new Deck();
    Multiset<Integer> ranks = HashMultiset.create();
    for (ICard card : deck) {
      ranks.add(card.getRank());
    }

    assertEquals(13, ranks.elementSet().size()); // Ensure 13 ranks
    for (int i = 1; i < 14; i++) {
      assertEquals(4, ranks.count(i)); // Ensure 4 cards for each rank
    }
  }

  @Test
  public void testSuits() {
    Deck deck = new Deck();
    Multiset<Suit> suits = EnumMultiset.create(Suit.class);
    for (ICard card : deck) {
      suits.add(card.getSuit());
    }

    assertEquals(4, suits.elementSet().size()); // Ensure 4 suits
    for (Suit suit : Suit.values()) {
      assertEquals(13, suits.count(suit)); // Ensure 13 cards for each suit
    }
  }
}