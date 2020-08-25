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

import java.time.Period;
import java.util.List;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.earelin.demeter.domain.time.GenericDateInterval;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plant {

  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  private String binomialName;

  @ManyToOne
  private Family family;

  private String description;

  private Integer separationInCm;

  @ManyToMany
  @JoinTable(
      name = "plant_friends",
      joinColumns = @JoinColumn(name = "plant_a_id"),
      inverseJoinColumns = @JoinColumn(name = "plant_b_id")
  )
  @Setter(AccessLevel.NONE)
  private Set<Plant> friends;

  @ManyToMany
  @JoinTable(
      name = "plant_foes",
      joinColumns = @JoinColumn(name = "plant_a_id"),
      inverseJoinColumns = @JoinColumn(name = "plant_b_id")
  )
  @Setter(AccessLevel.NONE)
  private Set<Plant> foes;

  @ElementCollection
  @Setter(AccessLevel.NONE)
  private List<GenericDateInterval> sow;

  @ElementCollection
  @Setter(AccessLevel.NONE)
  private List<GenericDateInterval> harvest;

  private Period lifespan;

  private Period germination;

  private Period maturity;

  public Plant() {}

  public Plant(Long id) {
    this.id = id;
  }
}
