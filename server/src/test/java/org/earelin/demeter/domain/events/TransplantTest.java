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

import org.earelin.demeter.domain.areas.CultivatedArea;
import org.earelin.demeter.domain.areas.Subarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransplantTest {

  public static final String EVENT_ID = "d0008f66-d928-42aa-958c-31d63400ddd5";
  public static final Position EVENT_TO = Position.from(
      new CultivatedArea("7e4da511-1a7e-4af4-b4b9-6ff28430bec4"),
      new Subarea(333.33, 3000, 1000, 666.66)
  );

  private Transplant transplant;

  @BeforeEach
  void setUp() {
    transplant = new Transplant(EVENT_ID);
    transplant.setTo(EVENT_TO);
  }

  @Test
  void should_set_id_on_constructor() {
    assertThat(transplant.getId())
        .isEqualTo(EVENT_ID);
  }

  @Test
  void should_set_and_return_to() {
    assertThat(transplant.getTo())
        .isEqualTo(EVENT_TO);
  }

  @Test
  void should_return_string_representation() {
    assertThat(transplant.toString())
        .contains(Transplant.class.getSimpleName(),
            EVENT_ID, EVENT_TO.toString());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(transplant.equals(transplant))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(transplant.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    Transplant compare = new Transplant(EVENT_ID);

    assertThat(transplant.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    Transplant compare = new Transplant("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setTo(EVENT_TO);

    assertThat(transplant.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_id() {
    Transplant compare = new Transplant(EVENT_ID);

    assertThat(transplant.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    Transplant compare = new Transplant("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setTo(EVENT_TO);

    assertThat(transplant.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
