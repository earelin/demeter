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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PestTest {

  public static final String PEST_ID = "684305da-a728-4551-9051-c401b42435e8";
  public static final String PEST_NAME = "Onion fly";
  public static final String PEST_DESCRIPTION = "Lorem ipsum ...";

  private Pest pest;

  @BeforeEach
  void setUp() {
    pest = new Pest(PEST_ID);
    pest.setName(PEST_NAME);
    pest.setDescription(PEST_DESCRIPTION);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(pest.getId())
        .isEqualTo(PEST_ID);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(pest.getName())
        .isEqualTo(PEST_NAME);
  }

  @Test
  void should_set_and_return_description() {
    assertThat(pest.getDescription())
        .isEqualTo(PEST_DESCRIPTION);
  }

  @Test
  void should_return_string_representation() {
    assertThat(pest.toString())
        .contains(Pest.class.getSimpleName(), PEST_ID,
            PEST_NAME, PEST_DESCRIPTION);
  }

}
