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
    cultivatedArea = new CultivatedArea();
  }

  @Test
  void should_set_id_on_constructor() {
    cultivatedArea = new CultivatedArea(CULTIVATED_AREA_DI);

    assertThat(cultivatedArea.getId())
        .isEqualTo(CULTIVATED_AREA_DI);
  }

  @Test
  void should_set_and_return_name() {
    cultivatedArea.setName(CULTIVATED_AREA_NAME);

    assertThat(cultivatedArea.getName())
        .isEqualTo(CULTIVATED_AREA_NAME);
  }

  @Test
  void should_set_and_return_description() {
    cultivatedArea.setDescription(CULTIVATED_AREA_DESCRIPTION);

    assertThat(cultivatedArea.getDescription())
        .isEqualTo(CULTIVATED_AREA_DESCRIPTION);
  }

  @Test
  void should_set_and_return_dimensions() {
    cultivatedArea.setDimensions(CULTIVATED_AREA_DIMENSIONS);

    assertThat(cultivatedArea.getDimensions())
        .isEqualTo(CULTIVATED_AREA_DIMENSIONS);
  }

}
