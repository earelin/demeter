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

class SubareaTest {

  public static final double SUBAREA_X = 333.33;
  public static final double SUBAREA_Y = 3000;
  public static final double SUBAREA_HEIGHT = 1000;
  public static final double SUBAREA_WIDTH = 666.66;

  private Subarea subarea;

  @BeforeEach
  void setUp() {
    subarea = new Subarea();
  }

  @Test
  void constructor_should_set_values() {
    subarea = new Subarea(SUBAREA_X, SUBAREA_Y, SUBAREA_WIDTH, SUBAREA_HEIGHT);

    assertThat(subarea)
        .hasFieldOrPropertyWithValue("x", SUBAREA_X)
        .hasFieldOrPropertyWithValue("y", SUBAREA_Y)
        .hasFieldOrPropertyWithValue("width", SUBAREA_WIDTH)
        .hasFieldOrPropertyWithValue("height", SUBAREA_HEIGHT);
  }

  @Test
  void should_set_and_return_x() {
    subarea.setX(SUBAREA_X);

    assertThat(subarea.getX())
        .isEqualTo(SUBAREA_X);
  }

  @Test
  void should_set_and_return_y() {
    subarea.setY(SUBAREA_Y);

    assertThat(subarea.getY())
        .isEqualTo(SUBAREA_Y);
  }

  @Test
  void should_set_and_return_width() {
    subarea.setWidth(SUBAREA_WIDTH);

    assertThat(subarea.getWidth())
        .isEqualTo(SUBAREA_WIDTH);
  }

  @Test
  void should_set_and_return_height() {
    subarea.setHeight(SUBAREA_HEIGHT);

    assertThat(subarea.getHeight())
        .isEqualTo(SUBAREA_HEIGHT);
  }

  @Test
  void should_return_string_representation() {
    subarea = new Subarea(SUBAREA_X, SUBAREA_Y, SUBAREA_WIDTH, SUBAREA_HEIGHT);

    assertThat(subarea.toString())
        .contains(Subarea.class.getSimpleName(), Double.toString(SUBAREA_X),
            Double.toString(SUBAREA_Y), Double.toString(SUBAREA_HEIGHT),
            Double.toString(SUBAREA_WIDTH));
  }
}
