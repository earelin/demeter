package org.earelin.demeter.domain.events;

import java.time.LocalDate;
import org.earelin.demeter.domain.Crop;

public abstract class Event {
  private Long id;
  private Crop cultivatedPlants;
  private LocalDate date;
  private String label;
  private String notes;
}
