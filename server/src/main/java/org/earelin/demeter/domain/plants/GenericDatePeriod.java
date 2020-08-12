package org.earelin.demeter.domain.plants;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class GenericDatePeriod {

  @Embedded
  @AttributeOverrides(value = {
      @AttributeOverride(name = "day", column = @Column(name = "start_day")),
      @AttributeOverride(name = "month", column = @Column(name = "start_month"))
  })
  private GenericDate start;

  @Embedded
  @AttributeOverrides(value = {
      @AttributeOverride(name = "day", column = @Column(name = "end_day")),
      @AttributeOverride(name = "month", column = @Column(name = "end_month"))
  })
  private GenericDate end;
}
