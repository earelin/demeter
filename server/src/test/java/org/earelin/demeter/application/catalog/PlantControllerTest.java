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

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.earelin.demeter.domain.catalog.PlantGenerator.PLANT_ID;
import static org.earelin.demeter.domain.catalog.PlantGenerator.PLANT_NAME;
import static org.earelin.demeter.domain.catalog.PlantGenerator.generatePlant;
import static org.earelin.demeter.domain.catalog.PlantGenerator.generatePlantList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import com.google.gson.Gson;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Optional;
import org.assertj.core.util.Lists;
import org.earelin.demeter.application.dto.mappers.PageRequestMapper;
import org.earelin.demeter.domain.catalog.Plant;
import org.earelin.demeter.repositories.PlantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class PlantControllerTest {

  @Mock
  private PlantRepository plantRepository;

  @Mock
  private PageRequestMapper pageRequestMapper;

  private Gson gson = new Gson();

  private PlantController plantController;

  @BeforeEach
  void setUp() {
    plantController = new PlantController(plantRepository, pageRequestMapper);
    RestAssuredMockMvc.standaloneSetup(plantController);
  }

  @Test
  void should_find_by_id() {
    Plant plant = generatePlant();
    when(plantRepository.findById(PLANT_ID))
        .thenReturn(Optional.of(plant));

    given()
      .when()
        .get("/api/v1/plants/{id}", PLANT_ID)
      .then()
        .status(HttpStatus.OK)
        .body("id", equalTo(PLANT_ID))
        .body("name", equalTo(PLANT_NAME));
  }

  @Test
  void should_return_not_found_if_a_entity_does_not_exists() {
    when(plantRepository.findById(PLANT_ID))
        .thenReturn(Optional.empty());

    given()
      .when()
        .get("/api/v1/plants/{id}", PLANT_ID)
      .then()
        .status(HttpStatus.NOT_FOUND);
  }

  @Test
  void should_return_all() {
    Pageable pageable = PageRequest.of(1, 25);
    when(pageRequestMapper.pageableFrom(1, 25, null))
        .thenReturn(pageable);
    Page<Plant> page = new PageImpl<>(generatePlantList(), pageable, 137);
    when(plantRepository.findAllByOrderByName(pageable))
        .thenReturn(page);

    given()
      .when()
        .get("/api/v1/plants")
      .then()
        .status(HttpStatus.OK)
        .body("content.size()", is(3));
  }
}
