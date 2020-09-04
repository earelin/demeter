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

class DimensionsTest {

  public static final double HEIGHT = 123.45;
  public static final double WIDTH = 33.3;

  private Dimensions dimensions;

  @BeforeEach
  void setUp() {
    this.dimensions = new Dimensions();
  }

  @Test
  void should_set_and_return_height() {
    dimensions.setHeight(HEIGHT);

    assertThat(dimensions.getHeight())
        .isEqualTo(HEIGHT);
  }

  @Test
  void should_set_and_return_width() {
    dimensions.setWidth(WIDTH);

    assertThat(dimensions.getWidth())
        .isEqualTo(WIDTH);
  }

  @Test
  void should_set_height_and_width_on_constructor() {
    dimensions = new Dimensions(WIDTH, HEIGHT);

    assertThat(dimensions)
        .hasFieldOrPropertyWithValue("height", HEIGHT)
        .hasFieldOrPropertyWithValue("width", WIDTH);
  }

  @Test
  void should_return_string_representation() {
    dimensions.setHeight(HEIGHT);
    dimensions.setWidth(WIDTH);

    assertThat(dimensions.toString())
        .contains(Dimensions.class.getSimpleName(), Double.toString(HEIGHT),
            Double.toString(WIDTH));
  }
}
