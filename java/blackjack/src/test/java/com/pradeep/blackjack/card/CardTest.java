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
public class CardTest {

  public CardTest() {
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadSuit() {
    Card _ = new Card('c', 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadRank1() {
    Card _ = new Card(Card.CLUBS, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadRank2() {
    Card _ = new Card(Card.CLUBS, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadRank3() {
    Card _ = new Card(Card.CLUBS, 14);
  }

  /**
   * Test of getRank method, of class Card.
   */
  @Test
  public void testGetRank() {
    for (int i = 1; i < 14; i++) {
      Card card = new Card(Card.CLUBS, i);
      assertEquals(i, card.getRank());
    }
  }

  /**
   * Test of getSuit method, of class Card.
   */
  @Test
  public void testGetSuit() {
    for (char c : Card.SUITS) {
      Card card = new Card(c, 10);
      assertEquals(c, card.getSuit());
    }
  }

  /**
   * Test of hardValue method, of class Card.
   */
  @Test
  public void testHardValue() {
    for (int i = 1; i < 14; i++) {
      Card card = new Card(Card.CLUBS, i);
      assertEquals(i, card.hardValue());
    }
  }

  /**
   * Test of softValue method, of class Card.
   */
  @Test
  public void testSoftValue() {
    for (int i = 1; i < 14; i++) {
      Card card = new Card(Card.CLUBS, i);
      assertEquals(i, card.softValue());
    }
  }
}