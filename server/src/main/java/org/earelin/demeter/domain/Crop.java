package org.earelin.demeter.domain;

import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
import org.earelin.demeter.domain.events.Position;
import org.hibernate.annotations.Type;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Crop {

  @Id
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private String id;

  private String label;

  @Type(type="text")
  private String notes;

  @ManyToOne
  private Cultivar cultivar;

  @OneToMany(mappedBy = "crop")
  @OrderBy("date ASC")
  @Setter(AccessLevel.NONE)
  private List<Event> events;

  private Integer number;

  @Embedded
  private Position position;

  public Crop() {}

  public Crop(String id) {
    this.id = id;
  }
}
