/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.earelin.demeter.application.catalog;

import java.util.List;
import org.earelin.demeter.application.catalog.dto.CreateFamilyDto;
import org.earelin.demeter.application.catalog.dto.mappers.CreateFamilyDtoMapper;
import org.earelin.demeter.domain.catalog.Family;
import org.earelin.demeter.factories.catalog.FamilyFactory;
import org.earelin.demeter.repositories.FamilyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/families")
public class FamilyController {

  private final FamilyRepository repository;
  private final FamilyFactory familyFactory;

  public FamilyController(FamilyRepository repository,
      FamilyFactory familyFactory) {
    this.repository = repository;
    this.familyFactory = familyFactory;
  }

  @GetMapping
  public List<Family> findAll() {
    return repository.findAllByOrderByName();
  }

  @GetMapping("/{id}")
  public Family findById(@PathVariable String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Family not found: " + id
        ));
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable String id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          "Family not found: " + id
      );
    }
    repository.deleteById(id);
  }

  @PostMapping
  public ResponseEntity<Family> create(@RequestBody CreateFamilyDto createFamilyDto) {
    Family family = familyFactory.build(createFamilyDto.getName());

    return new ResponseEntity<>(repository.save(family), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public Family updateById(
      @PathVariable String id,
      @RequestBody Family family) {
    if (family.getId() == null || !family.getId().equals(id)) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Category id property does not match: " + id
      );
    }
    return repository.save(family);
  }
}
