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

package org.earelin.demeter.domain.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.demeter.domain.events.Fertilize;
import org.earelin.demeter.domain.utils.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FertilizerTest {

  public static final String FERTILIZER_ID = "83f9646d-fc68-468f-ae99-209905ca4d81";
  public static final String FERTILIZER_NAME = "BioBizz BioHeaven";
  public static final String FERTILIZER_DESCRIPION = "Lorem ipsum ...";
  public static final Unit FERTILIZER_DOSAGE_UNIT =
      new Unit("080e3f1a-6cd1-4e5f-a421-5e590cacc405");

  private Fertilizer fertilizer;

  @BeforeEach
  void setUp() {
    fertilizer = new Fertilizer(FERTILIZER_ID);
    fertilizer.setName(FERTILIZER_NAME);
    fertilizer.setDescription(FERTILIZER_DESCRIPION);
    fertilizer.setDosageUnit(FERTILIZER_DOSAGE_UNIT);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(fertilizer.getId())
        .isEqualTo(FERTILIZER_ID);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(fertilizer.getName())
        .isEqualTo(FERTILIZER_NAME);
  }

  @Test
  void should_set_and_return_description() {
    assertThat(fertilizer.getDescription())
        .isEqualTo(FERTILIZER_DESCRIPION);
  }

  @Test
  void should_set_and_return_dosage_unit() {
    assertThat(fertilizer.getDosageUnit())
        .isEqualTo(FERTILIZER_DOSAGE_UNIT);
  }

  @Test
  void should_return_string_representation() {
    assertThat(fertilizer.toString())
        .contains(Fertilizer.class.getSimpleName(), FERTILIZER_ID,
            FERTILIZER_NAME, FERTILIZER_DESCRIPION,
            FERTILIZER_DOSAGE_UNIT.getId());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(fertilizer.equals(fertilizer))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(fertilizer.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    Fertilizer compare = new Fertilizer(FERTILIZER_ID);

    assertThat(fertilizer.equals(compare))
      .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    Fertilizer compare = new Fertilizer("319f41af-0f83-4f35-a815-c95f5b37e69a");

    assertThat(fertilizer.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_object_with_same_id() {
    Fertilizer compare = new Fertilizer(FERTILIZER_ID);

    assertThat(fertilizer.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_different_hashCode_than_object_with_different_id() {
    Fertilizer compare = new Fertilizer("319f41af-0f83-4f35-a815-c95f5b37e69a");

    assertThat(fertilizer.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
