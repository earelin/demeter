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

package org.earelin.demeter.application.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedPropertyTest {

  public static final String SORTED_PROPERTY_NAME = "age";
  public static final SortDirection SORTED_PROPERTY_DIRECTION = SortDirection.DESC;

  private SortedProperty sortedProperty;

  @BeforeEach
  void setUp() {
    sortedProperty = new SortedProperty();
  }

  @Test
  void should_set_asc_by_default() {
    assertThat(sortedProperty.getDirection())
        .isEqualTo(SortDirection.ASC);
  }

  @Test
  void should_set_name_in_constructor() {
    sortedProperty = new SortedProperty(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty.getName())
        .isEqualTo(SORTED_PROPERTY_NAME);
  }

  @Test
  void should_set_and_return_name() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty.getName())
        .isEqualTo(SORTED_PROPERTY_NAME);
  }

  @Test
  void should_set_and_return_direction() {
    sortedProperty.setDirection(SORTED_PROPERTY_DIRECTION);

    assertThat(sortedProperty.getDirection())
        .isEqualTo(SORTED_PROPERTY_DIRECTION);
  }

  @Test
  void should_build_asc_sorting() {
    sortedProperty = SortedProperty.asc(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty)
        .hasFieldOrPropertyWithValue("name", SORTED_PROPERTY_NAME)
        .hasFieldOrPropertyWithValue("direction", SortDirection.ASC);
  }

  @Test
  void should_build_desc_sorting() {
    sortedProperty = SortedProperty.desc(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty)
        .hasFieldOrPropertyWithValue("name", SORTED_PROPERTY_NAME)
        .hasFieldOrPropertyWithValue("direction", SortDirection.DESC);
  }

  @Test
  void should_return_string_representation() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);
    assertThat(sortedProperty.toString())
        .contains(SortedProperty.class.getSimpleName(), SORTED_PROPERTY_NAME,
            SortDirection.ASC.name());
  }

  @Test
  void should_be_equal_to_itself() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty.equals(sortedProperty))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_instance_with_same_name() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);
    SortedProperty compare = SortedProperty.desc(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_instance_with_different_name() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);
    SortedProperty compare = SortedProperty.asc("surname");

    assertThat(sortedProperty.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_instance_with_same_name() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);
    SortedProperty compare = SortedProperty.desc(SORTED_PROPERTY_NAME);

    assertThat(sortedProperty.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_instance_with_different_name() {
    sortedProperty.setName(SORTED_PROPERTY_NAME);
    SortedProperty compare = SortedProperty.asc("surname");

    assertThat(sortedProperty.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
