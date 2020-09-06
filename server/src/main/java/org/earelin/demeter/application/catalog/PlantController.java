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
import org.earelin.demeter.application.dto.PageDto;
import org.earelin.demeter.application.dto.SortedProperty;
import org.earelin.demeter.application.dto.mappers.PageRequestMapper;
import org.earelin.demeter.domain.catalog.Plant;
import org.earelin.demeter.repositories.PlantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/plants")
public class PlantController {

  private final PlantRepository repository;
  private final PageRequestMapper pageRequestMapper;

  public PlantController(PlantRepository repository,
      PageRequestMapper pageRequestMapper) {
    this.repository = repository;
    this.pageRequestMapper = pageRequestMapper;
  }

  @GetMapping
  public PageDto<Plant> findAll(
      @RequestParam(required = false, defaultValue = "1") int page,
      @RequestParam(required = false, defaultValue = "25") int size,
      @RequestParam(required = false) List<SortedProperty> sort) {
    Pageable pageable = pageRequestMapper.pageableFrom(page, size, sort);
    Page<Plant> plantsPage = repository.findAllByOrderByName(pageable);
    return new PageDto<>(plantsPage);
  }

  @GetMapping("/{id}")
  public Plant findById(@PathVariable String id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Plant not found: " + id
        ));
  }
}
