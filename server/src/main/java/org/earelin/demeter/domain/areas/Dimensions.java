package org.earelin.demeter.domain.areas;

import javax.persistence.Embeddable;
import lombok.Value;

/**
 * Units are centimeters.
 */
@Value
@Embeddable
public class Dimensions {
  double length = 0;
  double width = 0;
}
