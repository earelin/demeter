package org.earelin.demeter.domain.events;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.earelin.demeter.domain.utils.Unit;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
public class Harvest extends Event {

  private Double quantity;

  @ManyToOne
  private Unit unit;

  public Harvest() {}

  public Harvest(String id) {
    super(id);
  }
}
