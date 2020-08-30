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
import static org.earelin.demeter.domain.catalog.FamilyGenerator.generateFamily;
import static org.earelin.demeter.domain.catalog.PlantGenerator.PLANT_BINOMIAL_NAME;
import static org.earelin.demeter.domain.catalog.PlantGenerator.PLANT_DESCRIPTION;
import static org.earelin.demeter.domain.catalog.PlantGenerator.PLANT_ID;
import static org.earelin.demeter.domain.catalog.PlantGenerator.PLANT_NAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlantTest {

  private Plant plant;
  private Family family;

  @BeforeEach
  void setUp() {
    plant = new Plant(PLANT_ID);
    plant.setName(PLANT_NAME);
    plant.setBinomialName(PLANT_BINOMIAL_NAME);
    plant.setDescription(PLANT_DESCRIPTION);
    family = generateFamily();
    plant.setFamily(family);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(plant.getId())
        .isEqualTo(PLANT_ID);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(plant.getName())
        .isEqualTo(PLANT_NAME);
  }

  @Test
  void should_set_and_return_binomial_name() {
    assertThat(plant.getBinomialName())
        .isEqualTo(PLANT_BINOMIAL_NAME);
  }

  @Test
  void should_set_and_return_description() {
    assertThat(plant.getDescription())
        .isEqualTo(PLANT_DESCRIPTION);
  }

  @Test
  void should_set_and_return_family() {
    assertThat(plant.getFamily())
        .isEqualTo(family);
  }

  @Test
  void should_return_empty_foes() {
    assertThat(plant.getFriends())
        .isNotNull()
        .isEmpty();
  }

  @Test
  void should_return_empty_friends() {
    assertThat(plant.getFoes())
        .isNotNull()
        .isEmpty();
  }

  @Test
  void should_return_string_representation() {
    assertThat(plant.toString())
        .contains(Plant.class.getSimpleName(), PLANT_ID,
            PLANT_BINOMIAL_NAME, PLANT_NAME, PLANT_DESCRIPTION);
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(plant.equals(plant))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(plant.equals(null))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_a_different_class() {
    assertThat(plant.equals(new String("Testing")))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    Plant compare = new Plant(PLANT_ID);

    assertThat(plant.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    Plant compare = new Plant("c7f8582a-4762-448d-9a93-a70e87155aab");
    compare.setName(PLANT_NAME);

    assertThat(plant.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_object_with_same_id() {
    Plant compare = new Plant(PLANT_ID);

    assertThat(plant.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    Plant compare = new Plant("c7f8582a-4762-448d-9a93-a70e87155aab");

    assertThat(plant.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
