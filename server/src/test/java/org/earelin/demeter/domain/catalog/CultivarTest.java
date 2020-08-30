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
import static org.earelin.demeter.domain.catalog.PlantGenerator.generatePlant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CultivarTest {

  public static final String CULTIVAR_ID = "afd88e59-cbf4-425c-bb1a-64a171163809";
  public static final String CULTIVAR_NAME = "Spanish Roja";
  public static final String CULTIVAR_DESCRIPTION = "Lorem ipsum ...";
  public static final Double CULTIVAR_SEPARATION = 20.;

  private Cultivar cultivar;
  private Plant plant;

  @BeforeEach
  void setUp() {
    cultivar = new Cultivar(CULTIVAR_ID);
    plant = generatePlant();
    cultivar.setPlant(plant);
    cultivar.setName(CULTIVAR_NAME);
    cultivar.setDescription(CULTIVAR_DESCRIPTION);
    cultivar.setSeparation(CULTIVAR_SEPARATION);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(cultivar.getId())
        .isEqualTo(CULTIVAR_ID);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(cultivar.getName())
        .isEqualTo(CULTIVAR_NAME);
  }

  @Test
  void should_set_and_return_description() {
    assertThat(cultivar.getDescription())
        .isEqualTo(CULTIVAR_DESCRIPTION);
  }

  @Test
  void should_set_and_return_plant() {
    assertThat(cultivar.getPlant())
        .isEqualTo(plant);
  }

  @Test
  void should_set_and_return_separation() {
    assertThat(cultivar.getSeparation())
        .isEqualTo(CULTIVAR_SEPARATION);
  }
}
