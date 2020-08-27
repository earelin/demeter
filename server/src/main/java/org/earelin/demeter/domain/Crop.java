package org.earelin.demeter.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.earelin.demeter.domain.catalog.Cultivar;
import org.earelin.demeter.domain.events.Event;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Crop {

  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  @ManyToOne
  private Cultivar cultivar;

  @OneToMany(mappedBy = "crop")
  @OrderBy("date ASC")
  private List<Event> events;
}
