package org.earelin.demeter.domain.areas;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CultivatedArea {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  private String name;

  @Type(type="text")
  private String description;

  @Embedded
  private Dimensions dimensions;
}
