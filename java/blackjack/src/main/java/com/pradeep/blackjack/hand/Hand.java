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
package com.pradeep.blackjack.hand;

import com.pradeep.blackjack.card.Cards;
import com.pradeep.blackjack.card.ICard;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author pradeepg26
 */
public class Hand implements Iterable<ICard> {

  private final LinkedList<ICard> cards;
  private boolean aceSeen = false;
  private int hardTotal;
  private int softTotal;

  public Hand() {
    cards = Lists.newLinkedList();
  }

  public void addCard(ICard card) {
    cards.add(card);
    hardTotal += card.hardValue();
    if (Cards.isAce(card) && !aceSeen) {
      // First ace seen this hand
      aceSeen = true;
      softTotal += card.softValue();
    } else {
      // Either not an Ace or Ace already seen
      // Add hard value to hand soft total
      softTotal += card.hardValue();
    }
  }

  public int value() {
    if (aceSeen && softTotal <= 21) {
      return softTotal;
    } else {
      return hardTotal;
    }
  }

  public int size() {
    return cards.size();
  }

  public Iterator<ICard> iterator() {
    return cards.iterator();
  }
}
