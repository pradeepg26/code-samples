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
public class FaceCardTest {

  public FaceCardTest() {
  }

  /**
   * Test of hardValue method, of class FaceCard.
   */
  @Test
  public void testHardValue() {
    for (int i = 11; i < 14; i++) {
      FaceCard card = new FaceCard(Suit.CLUBS, i);
      assertEquals(10, card.hardValue());
    }
  }

  /**
   * Test of softValue method, of class FaceCard.
   */
  @Test
  public void testSoftValue() {
    for (int i = 11; i < 14; i++) {
      FaceCard card = new FaceCard(Suit.CLUBS, i);
      assertEquals(10, card.softValue());
    }
  }

  @Test
  public void testToString() {
    FaceCard card = new FaceCard(Suit.CLUBS, 11);
    assertEquals("\u2663J", card.toString());
    card = new FaceCard(Suit.CLUBS, 12);
    assertEquals("\u2663Q", card.toString());
    card = new FaceCard(Suit.CLUBS, 13);
    assertEquals("\u2663K", card.toString());

    card = new FaceCard(Suit.DIAMONDS, 11);
    assertEquals("\u2666J", card.toString());
    card = new FaceCard(Suit.DIAMONDS, 12);
    assertEquals("\u2666Q", card.toString());
    card = new FaceCard(Suit.DIAMONDS, 13);
    assertEquals("\u2666K", card.toString());

    card = new FaceCard(Suit.HEARTS, 11);
    assertEquals("\u2665J", card.toString());
    card = new FaceCard(Suit.HEARTS, 12);
    assertEquals("\u2665Q", card.toString());
    card = new FaceCard(Suit.HEARTS, 13);
    assertEquals("\u2665K", card.toString());

    card = new FaceCard(Suit.SPADES, 11);
    assertEquals("\u2660J", card.toString());
    card = new FaceCard(Suit.SPADES, 12);
    assertEquals("\u2660Q", card.toString());
    card = new FaceCard(Suit.SPADES, 13);
    assertEquals("\u2660K", card.toString());
  }
}