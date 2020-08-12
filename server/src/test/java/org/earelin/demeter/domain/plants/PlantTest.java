package org.earelin.demeter.domain.plants;

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
    plant.setSeparation(PLANT_SEPARATION);
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
    assertThat(plant.getSeparation())
        .isEqualTo(PLANT_SEPARATION);
  }
}
