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

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Cultivar {

  @Id
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private String id = null;

  @ManyToOne
  private Plant plant;

  private String name;

  @Type(type="text")
  private String description;

  /**
   * Separation in CM.
   */
  private Double separation;

  @ElementCollection
  @Setter(AccessLevel.NONE)
  private List<GenericDateInterval> sow = new ArrayList<>();

  @ElementCollection
  @Setter(AccessLevel.NONE)
  private List<GenericDateInterval> harvest = new ArrayList<>();

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

  public Cultivar() {}

  public Cultivar(String id) {
    this.id = id;
  }
}
