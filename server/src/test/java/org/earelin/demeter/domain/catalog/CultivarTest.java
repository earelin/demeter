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

import org.earelin.demeter.domain.time.DatePeriod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CultivarTest {

  public static final String CULTIVAR_ID = "afd88e59-cbf4-425c-bb1a-64a171163809";
  public static final String CULTIVAR_NAME = "Spanish Roja";
  public static final String CULTIVAR_DESCRIPTION = "Lorem ipsum ...";
  public static final Double CULTIVAR_SEPARATION = 20.;
  public static final DatePeriod CULTIVAR_GERMINATION = DatePeriod.of(4);
  public static final DatePeriod CULTIVAR_MATURITY = DatePeriod.of(2, 15);
  public static final DatePeriod CULTIVAR_LIFESPAN = DatePeriod.of(2, 0, 0);

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
    cultivar.setGermination(CULTIVAR_GERMINATION);
    cultivar.setMaturity(CULTIVAR_MATURITY);
    cultivar.setLifespan(CULTIVAR_LIFESPAN);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(cultivar.getId())
        .isEqualTo(CULTIVAR_ID);
  }

  @Test
  void should_set_and_return_plant() {
    assertThat(cultivar.getPlant())
        .isEqualTo(plant);
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
  void should_set_and_return_separation() {
    assertThat(cultivar.getSeparation())
        .isEqualTo(CULTIVAR_SEPARATION);
  }

  @Test
  void should_set_and_return_germination() {
    assertThat(cultivar.getGermination())
        .isEqualTo(CULTIVAR_GERMINATION);
  }

  @Test
  void should_set_and_return_maturity() {
    assertThat(cultivar.getMaturity())
        .isEqualTo(CULTIVAR_MATURITY);
  }

  @Test
  void should_set_and_return_lifespan() {
    assertThat(cultivar.getLifespan())
        .isEqualTo(CULTIVAR_LIFESPAN);
  }

  @Test
  void should_return_string_representation() {
    assertThat(cultivar.toString())
        .contains(Cultivar.class.getSimpleName(), CULTIVAR_ID,
            CULTIVAR_NAME, CULTIVAR_DESCRIPTION);
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(cultivar.equals(cultivar))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(cultivar.equals(null))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_different_class() {
    assertThat(cultivar.equals(new String("Testing")))
        .isFalse();
  }

  @Test
  void should_be_equal_to_object_with_same_id() {
    Cultivar compare = new Cultivar(CULTIVAR_ID);

    assertThat(cultivar.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_object_with_different_id() {
    Cultivar compare = new Cultivar("a4f82d61-5ef3-42df-bd14-9fbb59c55f68");

    assertThat(cultivar.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_an_object_with_same_id() {
    Cultivar compare = new Cultivar(CULTIVAR_ID);

    assertThat(cultivar.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_an_object_with_different_id() {
    Cultivar compare = new Cultivar("a4f82d61-5ef3-42df-bd14-9fbb59c55f68");

    assertThat(cultivar.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
