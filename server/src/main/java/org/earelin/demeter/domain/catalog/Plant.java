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
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.earelin.demeter.domain.time.DatePeriod;
import org.earelin.demeter.domain.time.GenericDateInterval;
import org.hibernate.annotations.Type;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  private String binomialName;

  @ManyToOne
  private Family family;

  @Type(type="text")
  private String description;

  private Integer separation;

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

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "days", column = @Column(name = "germinationDays")),
      @AttributeOverride(name = "months", column = @Column(name = "germinationMonths")),
      @AttributeOverride(name = "years", column = @Column(name = "germinationYears"))
  })
  private DatePeriod germination;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "days", column = @Column(name = "maturityDays")),
      @AttributeOverride(name = "months", column = @Column(name = "maturityMonths")),
      @AttributeOverride(name = "years", column = @Column(name = "maturityYears"))
  })
  private DatePeriod maturity;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "days", column = @Column(name = "lifespanDays")),
      @AttributeOverride(name = "months", column = @Column(name = "lifespanMonths")),
      @AttributeOverride(name = "years", column = @Column(name = "lifespanYears"))
  })
  private DatePeriod lifespan;

  public Plant() {}

  public Plant(Long id) {
    this.id = id;
  }
}
