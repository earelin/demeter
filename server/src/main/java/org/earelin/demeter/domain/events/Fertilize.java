package org.earelin.demeter.domain.events;

import java.util.Set;

public class Fertilize extends Event {
  private Set<FertilizerDose> doses;
}
