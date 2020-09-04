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

class DatePeriodTest {

  private static final int YEARS = 2;
  private static final int MONTHS = 8;
  private static final int DAYS = 23;

  private DatePeriod datePeriod;

  @BeforeEach
  void setUp() {
    datePeriod = new DatePeriod();
    datePeriod.setYears(YEARS);
    datePeriod.setMonths(MONTHS);
    datePeriod.setDays(DAYS);
  }

  @Test
  void should_set_and_return_years() {
    assertThat(datePeriod.getYears())
        .isEqualTo(YEARS);
  }

  @Test
  void should_set_and_return_months() {
    assertThat(datePeriod.getMonths())
        .isEqualTo(MONTHS);
  }

  @Test
  void should_set_and_return_days() {
    assertThat(datePeriod.getDays())
        .isEqualTo(DAYS);
  }

  @Test
  void should_return_string_representation() {
    assertThat(datePeriod.toString())
        .contains(DatePeriod.class.getSimpleName(),
            Integer.toString(YEARS),
            Integer.toString(MONTHS),
            Integer.toString(DAYS));
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(datePeriod.equals(datePeriod))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(datePeriod.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_data() {
    DatePeriod compare = DatePeriod.of(YEARS, MONTHS, DAYS);

    assertThat(datePeriod.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_data() {
    DatePeriod compare = DatePeriod.of(MONTHS, DAYS);

    assertThat(datePeriod.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_object_with_same_data() {
    DatePeriod compare = DatePeriod.of(YEARS, MONTHS, DAYS);

    assertThat(datePeriod.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_different_hashCode_than_object_with_different_data() {
    DatePeriod compare = DatePeriod.of(MONTHS, DAYS);

    assertThat(datePeriod.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
