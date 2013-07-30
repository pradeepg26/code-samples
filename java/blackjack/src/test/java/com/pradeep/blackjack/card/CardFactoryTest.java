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
package com.pradeep.blackjack.card;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author pradeepg26
 */
public class CardFactoryTest {

  public CardFactoryTest() {
  }

  @Test
  public void testAceCard() {
    for (Suit suit : Suit.values()) {
      ICard card = CardFactory.newCard(suit, 1);
      assertEquals(AceCard.class, card.getClass());
    }
  }

  @Test
  public void testFaceCard() {
    for (Suit suit : Suit.values()) {
      for (int i = 11; i < 14; i++) {
        ICard card = CardFactory.newCard(suit, i);
        assertEquals(FaceCard.class, card.getClass());
      }
    }
  }

  @Test
  public void testNumberCard() {
    for (Suit suit : Suit.values()) {
      for (int i = 2; i < 11; i++) {
        ICard card = CardFactory.newCard(suit, i);
        assertEquals(Card.class, card.getClass());
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadArgument() {
    CardFactory.newCard(Suit.CLUBS, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadArgument2() {
    CardFactory.newCard(Suit.CLUBS, 14);
  }
}