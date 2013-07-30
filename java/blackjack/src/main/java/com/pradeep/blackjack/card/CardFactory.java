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
public class CardFactory {

  /**
   *
   * @param suit
   * @param rank
   * @return
   * @throws IllegalArgumentException
   */
  public static ICard newCard(Suit suit, int rank) {
    Preconditions.checkArgument(rank < 14 && rank > 0, "Rank must be between 1 and 13. Given {}", rank);
    return null;
  }
}
