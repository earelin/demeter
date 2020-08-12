package org.earelin.demeter.domain.plants;

import java.util.List;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plant {

  @Id
  @GeneratedValue
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private Long id;

  private String name;

  private String binomialName;

  private Integer separation;

  @ManyToMany
  @JoinTable(
      name = "plant_friends",
      joinColumns = @JoinColumn(name = "plant_a_id"),
      inverseJoinColumns = @JoinColumn(name = "plant_b_id")
  )
  @Setter(AccessLevel.NONE)
  private Set<Plant> friends;

  @ManyToMany
  @JoinTable(
      name = "plant_foes",
      joinColumns = @JoinColumn(name = "plant_a_id"),
      inverseJoinColumns = @JoinColumn(name = "plant_b_id")
  )
  @Setter(AccessLevel.NONE)
  private Set<Plant> foes;

  @ElementCollection
  @Setter(AccessLevel.NONE)
  private List<GenericDatePeriod> sow;

  @ElementCollection
  @Setter(AccessLevel.NONE)
  private List<GenericDatePeriod> harvest;

  private Boolean perennial;

  public Plant() {}

  public Plant(Long id) {
    this.id = id;
  }
}
