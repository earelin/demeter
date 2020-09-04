package org.earelin.demeter.domain.events;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
public class Transplant extends Event {
  @Embedded
  private Position to;

  public Transplant() {}

  public Transplant(String id) {
    super(id);
  }
}
