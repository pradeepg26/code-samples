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
class FaceCard extends Card {

  FaceCard(Suit suit, int rank) {
    super(suit, rank);
  }

  @Override
  public int hardValue() {
    return 10;
  }

  @Override
  public int softValue() {
    return 10;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.getSuit());
    switch (this.getRank()) {
      case ICard.JACK:
        sb.append('J');
        break;
      case ICard.QUEEN:
        sb.append('Q');
        break;
      case ICard.KING:
        sb.append('K');
        break;
      default:
        throw new AssertionError("Cannot happen");
    }
    return sb.toString();
  }
}
