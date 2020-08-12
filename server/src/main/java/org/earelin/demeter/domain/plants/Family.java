package org.earelin.demeter.domain.plants;

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
public class Family {

  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  public Family() {}

  public Family(Long id) {
    this.id = id;
  }
}
