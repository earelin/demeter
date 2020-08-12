package org.earelin.demeter.domain.plants;

import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class GenericDate {
  private int month;
  private int day;

  public GenericDate() {}

  public GenericDate(int month, int day) {
    this.month = month;
    this.day = day;
  }
}
