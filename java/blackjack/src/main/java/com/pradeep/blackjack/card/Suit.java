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

/**
 *
 * @author pradeepg26
 */
public enum Suit {

  CLUBS('\u2663'),
  DIAMONDS('\u2666'),
  HEARTS('\u2665'),
  SPADES('\u2660');
  private final char suit;

  Suit(char suit) {
    this.suit = suit;
  }

  public char getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return String.valueOf(suit);
  }
}
