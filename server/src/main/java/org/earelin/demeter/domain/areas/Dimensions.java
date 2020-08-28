package org.earelin.demeter.domain.areas;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Units are centimeters.
 */
@Setter
@Getter
@ToString
@Embeddable
public class Dimensions {
  private double height;
  private double width;

  public Dimensions() {}

  public Dimensions(double height, double width) {
    this.height = height;
    this.width = width;
  }
}
