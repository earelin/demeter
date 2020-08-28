package org.earelin.demeter.domain.events;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.earelin.demeter.domain.Crop;
import org.hibernate.annotations.Type;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  @ManyToOne
  private Crop crop;

  private LocalDate date;

  private String label;

  @Type(type="text")
  private String notes;
}
