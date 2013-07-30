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

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author pradeepg26
 */
public class Deck implements Iterable<ICard> {

  private final LinkedList<ICard> cards;

  public Deck() {
    this.cards = Lists.newLinkedList();
    for (Suit suit : Suit.values()) {
      for (int i = 1; i < 14; i++) {
        this.cards.add(CardFactory.newCard(suit, i));
      }
    }
  }

  public Collection<ICard> getCards() {
    return cards;
  }

  public Iterator<ICard> iterator() {
    return cards.iterator();
  }
}
