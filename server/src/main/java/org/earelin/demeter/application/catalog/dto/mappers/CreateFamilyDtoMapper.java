package org.earelin.demeter.application.catalog.dto.mappers;

import org.earelin.demeter.application.catalog.dto.CreateFamilyDto;
import org.earelin.demeter.domain.catalog.Family;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CreateFamilyDtoMapper {
  void updateDomainFromDto(CreateFamilyDto createFamilyDto, @MappingTarget Family family);
}
