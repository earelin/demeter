package org.earelin.demeter.domain.events;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.earelin.demeter.domain.Crop;
import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Event {

  @Id
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private String id;

  @ManyToOne
  private Crop crop;

  private LocalDate date;

  private String label;

  @Type(type="text")
  private String notes;

  public Event() {}

  public Event(String id) {
    this.id = id;
  }
}
