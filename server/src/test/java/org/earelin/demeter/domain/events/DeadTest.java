/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.earelin.demeter.domain.events;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeadTest {

  public static final String EVENT_ID = "d0008f66-d928-42aa-958c-31d63400ddd5";
  public static final int EVENT_NUMBER = 4;

  private Dead dead;

  @BeforeEach
  void setUp() {
    dead = new Dead(EVENT_ID);
    dead.setNumber(EVENT_NUMBER);
  }

  @Test
  void should_set_id_on_constructor() {
    assertThat(dead.getId())
        .isEqualTo(EVENT_ID);
  }

  @Test
  void should_set_and_return_number() {
    assertThat(dead.getNumber())
        .isEqualTo(EVENT_NUMBER);
  }

  @Test
  void should_return_string_representation() {
    assertThat(dead.toString())
        .contains(Dead.class.getSimpleName(),
            EVENT_ID, Integer.toString(EVENT_NUMBER));
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(dead.equals(dead))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(dead.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    Dead compare = new Dead(EVENT_ID);

    assertThat(dead.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    Dead compare = new Dead("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setNumber(EVENT_NUMBER);

    assertThat(dead.equals(compare))
    .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_id() {
    Dead compare = new Dead(EVENT_ID);

    assertThat(dead.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    Dead compare = new Dead("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setNumber(EVENT_NUMBER);

    assertThat(dead.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
