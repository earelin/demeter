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

package org.earelin.demeter.domain.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTest {

  public static final String UNIT_ID = "d75bf995-b5fb-4342-aef2-5cd4f7df3128";
  public static final String UNIT_NAME = "ml";
  public static final UnitType UNIT_TYPE = UnitType.VOLUME;

  private Unit unit;

  @BeforeEach
  void setUp() {
    unit = new Unit(UNIT_ID);
    unit.setName(UNIT_NAME);
    unit.setType(UNIT_TYPE);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(unit.getId())
        .isEqualTo(UNIT_ID);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(unit.getName())
        .isEqualTo(UNIT_NAME);
  }

  @Test
  void should_set_and_return_type() {
    assertThat(unit.getType())
        .isEqualTo(UNIT_TYPE);
  }
}
