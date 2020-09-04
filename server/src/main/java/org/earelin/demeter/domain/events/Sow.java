package org.earelin.demeter.domain.events;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
public class Sow extends Event {

  private Integer number;

  @Embedded
  private Position position;

  public Sow() {}

  public Sow(String id) {
    super(id);
  }
}
