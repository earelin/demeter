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

import org.earelin.demeter.domain.areas.CultivatedArea;
import org.earelin.demeter.domain.areas.Subarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {

  public static final CultivatedArea POSITION_CULTIVATED_AREA =
      new CultivatedArea("eb7d03a9-0de6-4541-a6f3-2b448ae31bb0");
  public static final Subarea POSITION_SUBAREA = new Subarea(0, 666.66, 333.33, 1000);

  private Position position;

  @BeforeEach
  void setUp() {
    position = new Position();
    position.setCultivatedArea(POSITION_CULTIVATED_AREA);
    position.setSubarea(POSITION_SUBAREA);
  }

  @Test
  void should_create_from_cultivated_area_and_subarea() {
    position = Position.from(POSITION_CULTIVATED_AREA, POSITION_SUBAREA);

    assertThat(position)
        .hasFieldOrPropertyWithValue("cultivatedArea", POSITION_CULTIVATED_AREA)
        .hasFieldOrPropertyWithValue("subarea", POSITION_SUBAREA);
  }

  @Test
  void should_set_and_return_cultivated_area() {
    assertThat(position.getCultivatedArea())
        .isEqualTo(POSITION_CULTIVATED_AREA);
  }

  @Test
  void should_set_and_return_subarea() {
    assertThat(position.getSubarea())
        .isEqualTo(POSITION_SUBAREA);
  }

  @Test
  void should_return_string_representation() {
    assertThat(position.toString())
        .contains(Position.class.getSimpleName(),
            POSITION_CULTIVATED_AREA.toString(),
            POSITION_SUBAREA.toString());
  }

}
