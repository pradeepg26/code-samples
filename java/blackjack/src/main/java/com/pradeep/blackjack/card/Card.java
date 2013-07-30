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

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 *
 * @author pradeepg26
 */
public class Card {

  public static final char CLUBS = '\u2663';
  public static final char DIAMONDS = '\u2666';
  public static final char HEARTS = '\u2665';
  public static final char SPADES = '\u2660';
  public static final Set<Character> SUITS;
  public static final int ACE = 1;
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  private final char suit;
  private final int rank;

  static {
    SUITS = Sets.newHashSet();
    SUITS.add(CLUBS);
    SUITS.add(DIAMONDS);
    SUITS.add(HEARTS);
    SUITS.add(SPADES);
  }

  Card(char suit, int rank) {
    Preconditions.checkArgument(SUITS.contains(suit), "Suit must be one of {}. Given {}", SUITS, suit);
    Preconditions.checkArgument(rank < 14 && rank > 0, "Rank must be between 1 and 13. Given {}", rank);
    this.suit = suit;
    this.rank = rank;
  }

  public int getRank() {
    return rank;
  }

  public char getSuit() {
    return suit;
  }

  public int hardValue() {
    return rank;
  }

  public int softValue() {
    return rank;
  }
}
