package org.earelin.demeter.application.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateFamilyDtoTest {

  private static final String FAMILY_NAME = "Solanaceae";

  private CreateFamilyDto createFamilyDto;

  @BeforeEach
  void setUp() {
    createFamilyDto = new CreateFamilyDto();
    createFamilyDto.setName(FAMILY_NAME);
  }

  @Test
  void should_set_and_return_name() {
    assertThat(createFamilyDto.getName())
        .isEqualTo(FAMILY_NAME);
  }

  @Test
  void should_return_string_representation() {
    assertThat(createFamilyDto.toString())
        .contains(CreateFamilyDto.class.getSimpleName(), FAMILY_NAME);
  }
}

