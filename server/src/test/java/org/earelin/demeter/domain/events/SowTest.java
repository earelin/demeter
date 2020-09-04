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

class SowTest {

  public static final String EVENT_ID = "d0008f66-d928-42aa-958c-31d63400ddd5";
  public static final int EVENT_NUMBER = 4;

  private Sow sow;

  @BeforeEach
  void setUp() {
    sow = new Sow(EVENT_ID);
    sow.setNumber(EVENT_NUMBER);
  }

  @Test
  void should_set_id_on_constructor() {
    assertThat(sow.getId())
        .isEqualTo(EVENT_ID);
  }

  @Test
  void should_set_and_return_number() {
    assertThat(sow.getNumber())
        .isEqualTo(EVENT_NUMBER);
  }

  @Test
  void should_return_string_representation() {
    assertThat(sow.toString())
        .contains(Sow.class.getSimpleName(),
            EVENT_ID, Integer.toString(EVENT_NUMBER));
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(sow.equals(sow))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(sow.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    Sow compare = new Sow(EVENT_ID);

    assertThat(sow.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    Sow compare = new Sow("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setNumber(EVENT_NUMBER);

    assertThat(sow.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_id() {
    Sow compare = new Sow(EVENT_ID);

    assertThat(sow.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    Sow compare = new Sow("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setNumber(EVENT_NUMBER);

    assertThat(sow.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
