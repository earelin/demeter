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
  }

  @Test
  void should_set_and_return_years() {
    datePeriod.setYears(YEARS);

    assertThat(datePeriod.getYears())
        .isEqualTo(YEARS);
  }

  @Test
  void should_set_and_return_months() {
    datePeriod.setMonths(MONTHS);

    assertThat(datePeriod.getMonths())
        .isEqualTo(MONTHS);
  }

  @Test
  void should_set_and_return_days() {
    datePeriod.setDays(DAYS);

    assertThat(datePeriod.getDays())
        .isEqualTo(DAYS);
  }

  @Test
  void should_return_string_representaion() {
    datePeriod.setYears(YEARS);
    datePeriod.setMonths(MONTHS);
    datePeriod.setDays(DAYS);

    assertThat(datePeriod.toString())
        .contains(DatePeriod.class.getSimpleName(),
            Integer.toString(YEARS),
            Integer.toString(MONTHS),
            Integer.toString(DAYS));
  }
}
