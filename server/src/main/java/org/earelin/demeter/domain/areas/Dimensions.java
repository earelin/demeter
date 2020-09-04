package org.earelin.demeter.domain.areas;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Units are millimeters.
 */
@Setter
@Getter
@ToString
@Embeddable
public class Dimensions {
  private double width;
  private double height;

  public Dimensions() {}

  public Dimensions(double width, double height) {
    this.height = height;
    this.width = width;
  }
}
