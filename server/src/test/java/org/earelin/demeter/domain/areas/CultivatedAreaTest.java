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

package org.earelin.demeter.domain.areas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CultivatedAreaTest {

  public static final String CULTIVATED_AREA_DI = "ff40de4d-5a0c-43bc-8b9a-1f9ff2481d78";
  public static final String CULTIVATED_AREA_NAME = "East Raised Bed";
  public static final String CULTIVATED_AREA_DESCRIPTION = "Lorem ipsum ...";
  public static final Dimensions CULTIVATED_AREA_DIMENSIONS = new Dimensions(666.66, 4000);

  private CultivatedArea cultivatedArea;

  @BeforeEach
  void setUp() {
    cultivatedArea = new CultivatedArea(CULTIVATED_AREA_DI);
    cultivatedArea.setName(CULTIVATED_AREA_NAME);
    cultivatedArea.setDescription(CULTIVATED_AREA_DESCRIPTION);
    cultivatedArea.setDimensions(CULTIVATED_AREA_DIMENSIONS);
  }

  @Test
  void should_set_id_on_constructor() {
    assertThat(cultivatedArea.getId())
        .isEqualTo(CULTIVATED_AREA_DI);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(cultivatedArea.getName())
        .isEqualTo(CULTIVATED_AREA_NAME);
  }

  @Test
  void should_set_and_return_description() {
    assertThat(cultivatedArea.getDescription())
        .isEqualTo(CULTIVATED_AREA_DESCRIPTION);
  }

  @Test
  void should_set_and_return_dimensions() {
    assertThat(cultivatedArea.getDimensions())
        .isEqualTo(CULTIVATED_AREA_DIMENSIONS);
  }

  @Test
  void should_return_string_representation() {
    assertThat(cultivatedArea.toString())
        .contains(CultivatedArea.class.getSimpleName(),
            CULTIVATED_AREA_DI, CULTIVATED_AREA_NAME,
            CULTIVATED_AREA_DESCRIPTION, CULTIVATED_AREA_DIMENSIONS.toString());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(cultivatedArea.equals(cultivatedArea))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(cultivatedArea.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    CultivatedArea compare = new CultivatedArea(CULTIVATED_AREA_DI);

    assertThat(cultivatedArea.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    CultivatedArea compare = new CultivatedArea("319f41af-0f83-4f35-a815-c95f5b37e69a");

    assertThat(cultivatedArea.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_object_with_same_id() {
    CultivatedArea compare = new CultivatedArea(CULTIVATED_AREA_DI);

    assertThat(cultivatedArea.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_different_hashCode_than_object_with_different_id() {
    CultivatedArea compare = new CultivatedArea("319f41af-0f83-4f35-a815-c95f5b37e69a");

    assertThat(cultivatedArea.hashCode())
        .isNotEqualTo(compare.hashCode());
  }

}
