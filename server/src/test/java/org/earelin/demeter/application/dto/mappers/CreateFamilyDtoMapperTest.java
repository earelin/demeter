package org.earelin.demeter.application.dto.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.earelin.demeter.application.dto.CreateFamilyDto;
import org.earelin.demeter.domain.catalog.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {CreateFamilyDtoMapperImpl.class})
class CreateFamilyDtoMapperTest {

  private static final String FAMILY_NAME = "Solanaceae";

  @Autowired
  private CreateFamilyDtoMapper mapper;

  @Test
  void should_update_name() {
    Family family = new Family();
    CreateFamilyDto createFamilyDto = new CreateFamilyDto();
    createFamilyDto.setName(FAMILY_NAME);

    mapper.updateDomainFromDto(createFamilyDto, family);

    assertThat(family.getName())
        .isEqualTo(FAMILY_NAME);
  }

}
