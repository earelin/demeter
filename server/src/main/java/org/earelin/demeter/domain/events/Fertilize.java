package org.earelin.demeter.domain.events;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Entity
public class Fertilize extends Event {
  @ElementCollection
  @Setter(AccessLevel.NONE)
  private Set<FertilizerDose> doses = new HashSet<>();

  public Fertilize() {}

  public Fertilize(String id) {
    super(id);
  }
}
