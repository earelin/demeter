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

package org.earelin.demeter.factories.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.demeter.domain.catalog.Family;
import org.earelin.demeter.domain.catalog.Plant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlantFactoryTest {

  public static final String PLANT_NAME = "Garlic";
  public static final Family PLANT_FAMILY = new Family("5df6fc4d-1b3e-4519-925f-0e2ff2150ce0");

  private PlantFactory plantFactory;

  @BeforeEach
  void setUp() {
    plantFactory = new PlantFactory();
  }

  @Test
  void should_build_a_plant_from_name_and_family() {
    Plant plant = plantFactory.build(PLANT_NAME, PLANT_FAMILY);

    assertThat(plant)
        .hasFieldOrPropertyWithValue("name", PLANT_NAME)
        .hasFieldOrPropertyWithValue("family", PLANT_FAMILY);
    assertThat(plant.getId())
        .isNotBlank();
  }

}
