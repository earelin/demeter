package org.earelin.demeter.domain.areas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CultivatedArea {

  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  private Long id;

  private String name;

  private String description;

  private Dimensions dimensions;
}
