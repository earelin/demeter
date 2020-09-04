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

import org.earelin.demeter.domain.catalog.Pest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PestAttackTest {

  public static final String EVENT_ID = "d0008f66-d928-42aa-958c-31d63400ddd5";
  public static final int EVENT_NUMBER = 4;
  public static final Pest EVENT_PEST =
      new Pest("a0863b44-3eb9-4c7f-9c22-cb30db0ad191");

  private PestAttack pestAttack;

  @BeforeEach
  void setUp() {
    pestAttack = new PestAttack(EVENT_ID);
    pestAttack.setNumber(EVENT_NUMBER);
    pestAttack.setPest(EVENT_PEST);
  }

  @Test
  void should_set_id_on_constructor() {
    assertThat(pestAttack.getId())
        .isEqualTo(EVENT_ID);
  }

  @Test
  void should_set_and_return_number() {
    assertThat(pestAttack.getNumber())
        .isEqualTo(EVENT_NUMBER);
  }

  @Test
  void should_set_and_return_pest() {
    assertThat(pestAttack.getPest())
        .isEqualTo(EVENT_PEST);
  }

  @Test
  void should_return_string_representation() {
    assertThat(pestAttack.toString())
        .contains(PestAttack.class.getSimpleName(),
            EVENT_ID, Integer.toString(EVENT_NUMBER));
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(pestAttack.equals(pestAttack))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(pestAttack.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    PestAttack compare = new PestAttack(EVENT_ID);

    assertThat(pestAttack.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    PestAttack compare = new PestAttack("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setNumber(EVENT_NUMBER);
    compare.setPest(EVENT_PEST);

    assertThat(pestAttack.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_id() {
    PestAttack compare = new PestAttack(EVENT_ID);

    assertThat(pestAttack.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    PestAttack compare = new PestAttack("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setNumber(EVENT_NUMBER);
    compare.setPest(EVENT_PEST);

    assertThat(pestAttack.hashCode())
        .isNotEqualTo(compare.hashCode());
  }

}
