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

package org.earelin.demeter.domain.events;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.earelin.demeter.domain.areas.CultivatedArea;
import org.earelin.demeter.domain.areas.Subarea;

@Getter
@Setter
@ToString
@Embeddable
public class Position {

  @ManyToOne
  private CultivatedArea cultivatedArea;

  @Embedded
  private Subarea subarea;

  public static Position from(CultivatedArea cultivatedArea, Subarea subarea) {
    Position position = new Position();
    position.setCultivatedArea(cultivatedArea);
    position.setSubarea(subarea);

    return position;
  }
}
