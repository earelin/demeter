package org.earelin.demeter.domain.events;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
public class Dead extends Event {

  private Integer number;

  public Dead() {}

  public Dead(String id) {
    super(id);
  }
}
