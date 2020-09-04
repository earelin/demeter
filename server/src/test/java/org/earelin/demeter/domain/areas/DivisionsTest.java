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

class DivisionsTest {

  public static final int ROWS = 6;
  public static final int COLUMNS = 2;

  private Divisions divisions;

  @BeforeEach
  void setUp() {
    divisions = new Divisions();
  }

  @Test
  void should_set_and_return_rows() {
    divisions.setRows(ROWS);

    assertThat(divisions.getRows())
        .isEqualTo(ROWS);
  }

  @Test
  void should_set_and_return_columns() {
    divisions.setColumns(COLUMNS);

    assertThat(divisions.getColumns())
        .isEqualTo(COLUMNS);
  }

  @Test
  void should_set_rows_and_columns_on_constructor() {
    divisions = new Divisions(ROWS, COLUMNS);

    assertThat(divisions)
        .hasFieldOrPropertyWithValue("rows", ROWS)
        .hasFieldOrPropertyWithValue("columns", COLUMNS);
  }

  @Test
  void should_return_a_string_representation() {
    divisions = new Divisions(ROWS, COLUMNS);

    assertThat(divisions.toString())
        .contains(Divisions.class.getSimpleName(),
            Integer.toString(ROWS),
            Integer.toString(COLUMNS));
  }
}
