package org.earelin.demeter.domain.plants;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cultivar {

  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  private Integer separation;

  @ElementCollection
  private List<GenericDatePeriod> sow;

  @ElementCollection
  private List<GenericDatePeriod> harvest;

  private Integer daysToGermination;

  private Integer daysToMaturity;

  public Cultivar() {}

  public Cultivar(Long id) {
    this.id = id;
  }
}
