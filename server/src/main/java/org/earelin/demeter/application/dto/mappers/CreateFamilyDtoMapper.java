package org.earelin.demeter.application.dto.mappers;

import org.earelin.demeter.application.dto.CreateFamilyDto;
import org.earelin.demeter.domain.catalog.Family;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CreateFamilyDtoMapper {
  void updateDomainFromDto(CreateFamilyDto createFamilyDto, @MappingTarget Family family);
}
