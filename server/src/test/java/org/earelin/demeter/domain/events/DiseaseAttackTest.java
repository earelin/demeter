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

import org.earelin.demeter.domain.catalog.Disease;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiseaseAttackTest {

  public static final String EVENT_ID = "d0008f66-d928-42aa-958c-31d63400ddd5";
  public static final int EVENT_NUMBER = 4;
  public static final Disease EVENT_DISEASE = new Disease("9f6ef081-2bfd-41f3-91a8-e40be7ad1505");

  private DiseaseAttack diseaseAttack;

  @BeforeEach
  void setUp() {
    diseaseAttack = new DiseaseAttack(EVENT_ID);
    diseaseAttack.setNumber(EVENT_NUMBER);
    diseaseAttack.setDisease(EVENT_DISEASE);
  }

  @Test
  void should_set_id_on_constructor() {
    assertThat(diseaseAttack.getId())
        .isEqualTo(EVENT_ID);
  }

  @Test
  void should_set_and_return_number() {
    assertThat(diseaseAttack.getNumber())
        .isEqualTo(EVENT_NUMBER);
  }

  @Test
  void should_set_and_return_disease() {
    assertThat(diseaseAttack.getDisease())
        .isEqualTo(EVENT_DISEASE);
  }

  @Test
  void should_return_string_representation() {
    diseaseAttack.setNumber(EVENT_NUMBER);

    assertThat(diseaseAttack.toString())
        .contains(DiseaseAttack.class.getSimpleName(),
            EVENT_ID, Integer.toString(EVENT_NUMBER),
            EVENT_DISEASE.getId());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(diseaseAttack.equals(diseaseAttack))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(diseaseAttack.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    DiseaseAttack compare = new DiseaseAttack(EVENT_ID);

    assertThat(diseaseAttack.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    DiseaseAttack compare = new DiseaseAttack("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    diseaseAttack.setNumber(EVENT_NUMBER);

    assertThat(diseaseAttack.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_id() {
    diseaseAttack.setNumber(EVENT_NUMBER);
    DiseaseAttack compare = new DiseaseAttack(EVENT_ID);

    assertThat(diseaseAttack.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    DiseaseAttack compare = new DiseaseAttack("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    diseaseAttack.setNumber(EVENT_NUMBER);

    assertThat(diseaseAttack.hashCode())
        .isNotEqualTo(compare.hashCode());
  }

}
