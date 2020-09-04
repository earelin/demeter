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

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.earelin.demeter.domain.catalog.Pest;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
public class PestAttack extends Event {
  @ManyToOne
  private Pest pest;

  private Integer number;

  public PestAttack() {}

  public PestAttack(String id) {
    super(id);
  }
}
