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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SortedProperty {

  public static SortedProperty asc(String name) {
    return new SortedProperty(name);
  }

  public static SortedProperty desc(String name) {
    SortedProperty sortedProperty = new SortedProperty(name);
    sortedProperty.setDirection(SortDirection.DESC);
    return sortedProperty;
  }

  @EqualsAndHashCode.Include
  private String name;

  private SortDirection direction = SortDirection.ASC;

  public SortedProperty() {}

  public SortedProperty(String name) {
    this.name = name;
  }
}
