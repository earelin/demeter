package org.earelin.demeter.application.catalog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateFamilyDto {
  private String name;

  public CreateFamilyDto() {}

  public CreateFamilyDto(String name) {
    this.name = name;
  }
}
