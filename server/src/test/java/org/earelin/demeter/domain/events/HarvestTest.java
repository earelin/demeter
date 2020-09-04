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

import org.earelin.demeter.domain.utils.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HarvestTest {

  public static final String EVENT_ID = "d0008f66-d928-42aa-958c-31d63400ddd5";
  public static final Double EVENT_QUANTITY = 5.36;
  public static final Unit unit = new Unit("2e8d735c-7308-4849-9b69-8b441352867e");

  private Harvest harvest;

  @BeforeEach
  void setUp() {
    harvest = new Harvest(EVENT_ID);
    harvest.setQuantity(EVENT_QUANTITY);
    harvest.setUnit(unit);
  }

  @Test
  void constructor_should_set_id() {
    assertThat(harvest.getId())
        .isEqualTo(EVENT_ID);
  }

  @Test
  void should_set_and_return_quantity() {
    assertThat(harvest.getQuantity())
        .isEqualTo(EVENT_QUANTITY);
  }

  @Test
  void should_set_and_return_unit() {
    assertThat(harvest.getUnit())
        .isEqualTo(unit);
  }

  @Test
  void should_return_string_representation() {
    assertThat(harvest.toString())
        .contains(Harvest.class.getSimpleName(), EVENT_ID,
            Double.toString(EVENT_QUANTITY), unit.getId());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(harvest.equals(harvest))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(harvest.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    Harvest compare = new Harvest(EVENT_ID);

    assertThat(harvest.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    Harvest compare = new Harvest("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setQuantity(EVENT_QUANTITY);
    compare.setUnit(unit);

    assertThat(harvest.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_id() {
    Harvest compare = new Harvest(EVENT_ID);

    assertThat(harvest.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    Harvest compare = new Harvest("d7ea646a-a0f8-4937-8bac-3eaa5c376");
    compare.setQuantity(EVENT_QUANTITY);
    compare.setUnit(unit);

    assertThat(harvest.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
