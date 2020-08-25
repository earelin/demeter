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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class GenericDateInterval {

  @Embedded
  @AttributeOverrides(value = {
      @AttributeOverride(name = "day", column = @Column(name = "start_day")),
      @AttributeOverride(name = "month", column = @Column(name = "start_month"))
  })
  private GenericDate start;

  @Embedded
  @AttributeOverrides(value = {
      @AttributeOverride(name = "day", column = @Column(name = "end_day")),
      @AttributeOverride(name = "month", column = @Column(name = "end_month"))
  })
  private GenericDate end;
}
