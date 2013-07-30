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

import com.pradeep.blackjack.card.CardFactory;
import com.pradeep.blackjack.card.ICard;
import com.pradeep.blackjack.card.Suit;

import java.util.Iterator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author pradeepg26
 */
public class HandTest {

  /**
   * Test of addCard method, of class Hand.
   */
  @Test
  public void testAddCard() {
    Hand hand = new Hand();
    ICard aceClubs = CardFactory.newCard(Suit.CLUBS, 1);
    hand.addCard(aceClubs);
    assertEquals(1, hand.size());
    ICard tenDiamonds = CardFactory.newCard(Suit.DIAMONDS, 10);
    hand.addCard(tenDiamonds);
    assertEquals(2, hand.size());
    hand.addCard(tenDiamonds);
    assertEquals(3, hand.size());
    Iterator<ICard> iter = hand.iterator();
    assertEquals(aceClubs, iter.next());
    assertEquals(tenDiamonds, iter.next());
    assertEquals(tenDiamonds, iter.next());
  }

  /**
   * Test of value method, of class Hand.
   */
  @Test
  public void testBlackjack() {
    Hand hand = new Hand();
    hand.addCard(CardFactory.newCard(Suit.CLUBS, 1));
    hand.addCard(CardFactory.newCard(Suit.CLUBS, 10));
    assertEquals(21, hand.value());
  }

  @Test
  public void testTwoAces() {
    Hand hand = new Hand();
    hand.addCard(CardFactory.newCard(Suit.CLUBS, 1));
    hand.addCard(CardFactory.newCard(Suit.DIAMONDS, 1));
    assertEquals(12, hand.value());
  }

  @Test
  public void testTwoAcesOver21() {
    Hand hand = new Hand();
    hand.addCard(CardFactory.newCard(Suit.CLUBS, 1));
    hand.addCard(CardFactory.newCard(Suit.HEARTS, 1));
    hand.addCard(CardFactory.newCard(Suit.HEARTS, 10));
    assertEquals(12, hand.value());
  }

  @Test
  public void test21() {
    Hand hand = new Hand();
    hand.addCard(CardFactory.newCard(Suit.CLUBS, ICard.JACK));
    hand.addCard(CardFactory.newCard(Suit.CLUBS, 7));
    hand.addCard(CardFactory.newCard(Suit.CLUBS, 4));
    assertEquals(21, hand.value());
  }
}