package org.earelin.demeter.domain.areas;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CultivatedArea {

  @Id
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private String id;

  private String name;

  @Type(type="text")
  private String description;

  @Embedded
  private Dimensions dimensions;

  public CultivatedArea() {}

  public CultivatedArea(String id) {
    this.id = id;
  }
}
