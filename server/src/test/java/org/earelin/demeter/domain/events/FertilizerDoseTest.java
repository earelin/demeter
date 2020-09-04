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

import org.earelin.demeter.domain.catalog.Fertilizer;
import org.earelin.demeter.domain.utils.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FertilizerDoseTest {

  public static final double FERTILIZER_DOSE_QUANTITY = 5;
  public static final Unit FERTILIZER_DOSE_UNIT = new Unit("4de6cbb7-f1b9-4876-9245-22eb164395b1");
  public static final Fertilizer FERTILIZER_DOSE_FERTILIZER = new Fertilizer("f328c147-2777-4460-b4ad-062140454996");

  private FertilizerDose fertilizerDose;

  @BeforeEach
  void setUp() {
    fertilizerDose = new FertilizerDose();
    fertilizerDose.setQuantity(FERTILIZER_DOSE_QUANTITY);
    fertilizerDose.setUnit(FERTILIZER_DOSE_UNIT);
    fertilizerDose.setFertilizer(FERTILIZER_DOSE_FERTILIZER);
  }

  @Test
  void should_set_and_return_fertilizer() {
    assertThat(fertilizerDose.getFertilizer())
        .isEqualTo(FERTILIZER_DOSE_FERTILIZER);
  }

  @Test
  void should_set_and_return_quantity() {
    assertThat(fertilizerDose.getQuantity())
        .isEqualTo(FERTILIZER_DOSE_QUANTITY);
  }

  @Test
  void should_set_and_return_unit() {
    assertThat(fertilizerDose.getUnit())
        .isEqualTo(FERTILIZER_DOSE_UNIT);
  }

  @Test
  void should_return_string_representation() {
    assertThat(fertilizerDose.toString())
        .contains(Double.toString(FERTILIZER_DOSE_QUANTITY),
            FERTILIZER_DOSE_UNIT.getId());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(fertilizerDose.equals(fertilizerDose))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(fertilizerDose.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_fertilizer() {
    FertilizerDose compare = new FertilizerDose();
    compare.setFertilizer(FERTILIZER_DOSE_FERTILIZER);

    assertThat(fertilizerDose.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_fertilizer() {
    FertilizerDose compare = new FertilizerDose();

    assertThat(fertilizerDose.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_fertilizer() {
    FertilizerDose compare = new FertilizerDose();
    compare.setFertilizer(FERTILIZER_DOSE_FERTILIZER);

    assertThat(fertilizerDose.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_fertilizer() {
    FertilizerDose compare = new FertilizerDose();

    assertThat(fertilizerDose.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
