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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlantTest {

  private static final Long PLANT_ID = 45L;
  private static final String PLANT_NAME = "Garlic";
  private static final String PLANT_BINOMIAL_NAME = "Allium sativum";
  private static final Integer PLANT_SEPARATION = 165;

  private Plant plant;

  @BeforeEach
  void setUp() {
    plant = new Plant(PLANT_ID);
    plant.setName(PLANT_NAME);
    plant.setBinomialName(PLANT_BINOMIAL_NAME);
    plant.setSeparationInCm(PLANT_SEPARATION);
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
  void should_set_and_return_separation() {
    assertThat(plant.getSeparationInCm())
        .isEqualTo(PLANT_SEPARATION);
  }
}
