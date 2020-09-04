package org.earelin.demeter.domain.events;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.earelin.demeter.domain.areas.CultivatedArea;
import org.earelin.demeter.domain.areas.Subarea;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Sow extends Event {

  private int seeds;

  @ManyToOne
  private CultivatedArea cultivatedArea;

  private Subarea position;
}
