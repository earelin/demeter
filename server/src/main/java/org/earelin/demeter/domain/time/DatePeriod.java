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

import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DatePeriod {

  public static DatePeriod of(int years, int months, int days) {
    DatePeriod datePeriod = new DatePeriod();
    datePeriod.setYears(years);
    datePeriod.setMonths(months);
    datePeriod.setDays(days);
    return datePeriod;
  }

  public static DatePeriod of(int months, int days) {
    return of(0, months, days);
  }

  public static DatePeriod of(int days) {
    return of(0, 0, days);
  }

  private int years;
  private int months;
  private int days;
}
