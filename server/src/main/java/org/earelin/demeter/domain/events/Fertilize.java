package org.earelin.demeter.domain.events;

import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Fertilize extends Event {
  private Set<FertilizerDose> doses;
}
