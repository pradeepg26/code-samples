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

import com.pradeep.blackjack.card.CardFactory;
import com.pradeep.blackjack.card.ICard;
import com.pradeep.blackjack.card.Suit;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 *
 * @author pradeepg26
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Collections.class)
public class ShoeTest {

  @Test
  public void testNumCards() {
    Shoe shoe = new Shoe(4); // Create a shoe with 4 decks
    assertEquals(52 * 4, Iterables.size(shoe));
  }

  @Test
  public void testRankAndSuit() {
    Shoe shoe = new Shoe(4);
    Multiset<String> ranks = HashMultiset.create();
    for (ICard card : shoe) {
      ranks.add(card.toString());
    }

    assertEquals(52, ranks.elementSet().size()); // Ensure 52 suit,rank pairs in shoe
    for (Suit suit : Suit.values()) {
      for (int i = 1; i < 14; i++) {
        String rankAndSuit = CardFactory.newCard(suit, i).toString();
        assertEquals(4, ranks.count(rankAndSuit)); // Ensure 4 duplicates of each card
      }
    }
  }

  @Test
  public void testShuffle() {
    PowerMockito.mockStatic(Collections.class);
    Collections.shuffle(Mockito.anyListOf(ICard.class));

    Shoe shoe = new Shoe(4);
    shoe.shuffle();

    PowerMockito.verifyStatic(); // Verify shuffle was called exactly once
    Collections.shuffle(Mockito.anyListOf(ICard.class));
    assertEquals(52 * 4, Iterables.size(shoe)); // Verify size of shoe
  }

  @Test
  public void testShuffleWithStopDeal() throws Exception {
    PowerMockito.mockStatic(Collections.class);
    Collections.shuffle(Mockito.anyListOf(ICard.class));

    Shoe shoe = new Shoe(4, 52); // Stop dealing when 1 deck left
    shoe.shuffle();

    PowerMockito.verifyStatic(); // Verify shuffle was called once
    Collections.shuffle(Mockito.anyListOf(ICard.class));
    assertEquals(52 * 3, Iterables.size(shoe)); // Verify size of shoe
  }
}