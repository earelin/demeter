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


import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

/**
 * Units are centimeters.
 */
@Setter
@Getter
@ToString
@Embeddable
public class Subarea {
  private double x;
  private double y;
  private double width;
  private double height;

  public Subarea() {}

  public Subarea(double x, double y, double width, double height) {
    this.x = x;
    this.y = y;
    this.height = height;
    this.width = width;
  }
}
