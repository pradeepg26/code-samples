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


/**
 *
 * @author pradeepg26
 */
class Card implements ICard {

  public static final int ACE = 1;
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  private final Suit suit;
  private final int rank;

  Card(Suit suit, int rank) {
    Preconditions.checkArgument(rank < 14 && rank > 0, "Rank must be between 1 and 13. Given {}", rank);
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
}
