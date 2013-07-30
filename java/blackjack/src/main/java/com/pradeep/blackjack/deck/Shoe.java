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

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author pradeepg26
 */
public class Shoe implements Iterable<ICard> {

  private final LinkedList<ICard> cards;
  private final int stopDeal;

  public Shoe(int numDecks) {
    this(numDecks, 0);
  }

  public Shoe(int numDecks, int stopDeal) {
    Preconditions.checkArgument(numDecks > 0, "Number of decks must be greater than 0. Given {}", numDecks);
    Preconditions.checkArgument(stopDeal >= 0 && stopDeal < numDecks * 52,
                                "Can't remove stop deal before the first card");
    this.cards = Lists.newLinkedList();
    // Construct n decks and add the cards to the shoe
    for (int i = 0; i < numDecks; i++) {
      Deck d = new Deck();
      for (ICard card : d) {
        this.cards.add(card);
      }
    }
    this.stopDeal = stopDeal;
  }

  /**
   *
   */
  public void shuffle() {
    Collections.shuffle(cards); // Shuffle the cards
    // Remove stopDeal number of cards from the shoe to simiulate
    // stopping a deal when that many cards are left in the shoe
    for (int i = 0; i < stopDeal; i++) {
      // It doesn't matter functionally if cards are removed from the head of the list
      // or the tail of the list... but pretend end of list is bottom of shoe...
      // we want to remove n cards from the bottom of the shoe
      cards.removeLast();
    }
  }

  public Iterator<ICard> iterator() {
    return cards.iterator();
  }
}
