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
public class AceCardTest {

  public AceCardTest() {
  }

  /**
   * Test of hardValue method, of class AceCard.
   */
  @Test
  public void testHardValue() {
    AceCard instance = new AceCard(Suit.CLUBS);
    assertEquals(1, instance.hardValue());
  }

  /**
   * Test of softValue method, of class AceCard.
   */
  @Test
  public void testSoftValue() {
    AceCard instance = new AceCard(Suit.CLUBS);
    assertEquals(11, instance.softValue());
  }

  @Test
  public void testToString() {
    AceCard card;
    card = new AceCard(Suit.CLUBS);
    assertEquals("\u2663A", card.toString());
    card = new AceCard(Suit.DIAMONDS);
    assertEquals("\u2666A", card.toString());
    card = new AceCard(Suit.HEARTS);
    assertEquals("\u2665A", card.toString());
    card = new AceCard(Suit.SPADES);
    assertEquals("\u2660A", card.toString());
  }
}