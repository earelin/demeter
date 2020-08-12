package org.earelin.demeter.domain.events;

import java.time.ZonedDateTime;
import org.earelin.demeter.domain.CultivatedPlants;

public abstract class Event {
  private Long id;
  private CultivatedPlants cultivatedPlants;
  private ZonedDateTime date;
}
