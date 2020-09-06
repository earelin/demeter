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

package org.earelin.demeter.application.catalog.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreatePlantDtoTest {

  public static final String PLANT_FAMILY = "520f6983-2d28-4664-9341-6391cd8d205a";
  public static final String PLANT_NAME = "Garlic";

  private CreatePlantDto createPlantDto;

  @BeforeEach
  void setUp() {
    createPlantDto = new CreatePlantDto();
    createPlantDto.setFamily(PLANT_FAMILY);
    createPlantDto.setName(PLANT_NAME);
  }

  @Test
  void should_set_and_return_family() {
    assertThat(createPlantDto.getFamily())
        .isEqualTo(PLANT_FAMILY);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(createPlantDto.getName())
        .isEqualTo(PLANT_NAME);
  }

  @Test
  void should_return_string_representation() {
    assertThat(createPlantDto.toString())
        .contains(CreatePlantDto.class.getSimpleName(), PLANT_FAMILY, PLANT_NAME);
  }
}

