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

package org.earelin.demeter.domain.time;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericDateIntervalTest {

  private GenericDateInterval genericDateInterval;

  private GenericDate start;
  private GenericDate end;

  @BeforeEach
  void setUp() {
    start = new GenericDate(1, 23);
    end = new GenericDate(3, 12);
    genericDateInterval = new GenericDateInterval();
    genericDateInterval.setStart(start);
    genericDateInterval.setEnd(end);
  }

  @Test
  void should_set_and_return_start_date() {
    assertThat(genericDateInterval.getStart())
        .isEqualTo(start);
  }

  @Test
  void should_set_and_return_end_date() {
    assertThat(genericDateInterval.getEnd())
        .isEqualTo(end);
  }

  @Test
  void should_return_a_string_representation() {
    assertThat(genericDateInterval.toString())
        .contains(GenericDateInterval.class.getSimpleName());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(genericDateInterval.equals(genericDateInterval))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(genericDateInterval.equals(null))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_a_different_class() {
    assertThat(genericDateInterval.equals(new String("test")))
        .isFalse();
  }

  @Test
  void should_be_equal_to_an_object_with_same_dates() {
    GenericDateInterval compare = new GenericDateInterval();
    compare.setStart(start);
    compare.setEnd(end);

    assertThat(genericDateInterval.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_an_object_with_different_start_date() {
    GenericDateInterval compare = new GenericDateInterval();
    compare.setStart(new GenericDate(10, 5));
    compare.setEnd(end);

    assertThat(genericDateInterval.equals(compare))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_an_object_with_different_end_date() {
    GenericDateInterval compare = new GenericDateInterval();
    compare.setStart(start);
    compare.setEnd(new GenericDate(10, 5));

    assertThat(genericDateInterval.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_an_object_with_same_properties() {
    GenericDateInterval compare = new GenericDateInterval();
    compare.setStart(start);
    compare.setEnd(end);

    assertThat(genericDateInterval.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_different_hashCode_than_an_object_with_no_equal_properties() {
    GenericDateInterval compare = new GenericDateInterval();
    compare.setStart(new GenericDate(10, 1));
    compare.setEnd(new GenericDate(10, 5));

    assertThat(genericDateInterval.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
