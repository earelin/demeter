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

package org.earelin.demeter.domain.catalog;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pest {

  @Id
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private String id;

  private String name;

  @Type(type="text")
  private String description;

  @ManyToMany
  @Setter(AccessLevel.NONE)
  private Set<Plant> foes = new HashSet<>();

  @ManyToMany
  @Setter(AccessLevel.NONE)
  private Set<Plant> targets = new HashSet<>();

  public Pest() {}

  public Pest(String id) {
    this.id = id;
  }
}
