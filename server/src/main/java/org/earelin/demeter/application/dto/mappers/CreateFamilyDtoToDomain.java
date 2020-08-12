package org.earelin.demeter.application.dto.mappers;

import org.earelin.demeter.application.dto.CreateFamilyDto;
import org.earelin.demeter.domain.plants.Family;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CreateFamilyDtoToDomain {
  void updateDomainFromDto(CreateFamilyDto createFamilyDto, @MappingTarget Family family);
}
