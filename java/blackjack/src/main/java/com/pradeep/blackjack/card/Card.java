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

import com.google.common.base.Objects;

/**
 *
 * @author pradeepg26
 */
class Card implements ICard {

  private final Suit suit;
  private final int rank;

  Card(Suit suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  @Override
  public int getRank() {
    return rank;
  }

  @Override
  public Suit getSuit() {
    return suit;
  }

  @Override
  public int hardValue() {
    return rank;
  }

  @Override
  public int softValue() {
    return rank;
  }

  @Override
  public String toString() {
    return String.valueOf(suit) + rank;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(suit, rank);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Card other = (Card) obj;
    if (this.suit != other.suit) {
      return false;
    }
    if (this.rank != other.rank) {
      return false;
    }
    return true;
  }
}
