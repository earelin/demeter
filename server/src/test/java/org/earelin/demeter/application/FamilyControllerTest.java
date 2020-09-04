package org.earelin.demeter.application;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.FAMILY_ID;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.FAMILY_NAME;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.generateFamiliesList;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.generateFamily;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Optional;
import org.earelin.demeter.application.catalog.FamilyController;
import org.earelin.demeter.application.catalog.dto.CreateFamilyDto;
import org.earelin.demeter.application.catalog.dto.mappers.CreateFamilyDtoMapper;
import org.earelin.demeter.domain.catalog.Family;
import org.earelin.demeter.factories.catalog.FamilyFactory;
import org.earelin.demeter.repositories.FamilyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class FamilyControllerTest {

  @Mock
  private FamilyRepository familyRepository;

  @Mock
  private CreateFamilyDtoMapper mapper;

  private Gson gson = new Gson();

  private FamilyController familyController;

  @BeforeEach
  void setUp() {
    familyController = new FamilyController(familyRepository, new FamilyFactory());
    RestAssuredMockMvc.standaloneSetup(familyController);
  }

  @Test
  void should_find_a_family_by_id() {
    Family family = generateFamily();
    when(familyRepository.findById(FAMILY_ID))
        .thenReturn(Optional.of(family));

    given()
      .when()
        .get("/api/v1/families/{id}", FAMILY_ID)
      .then()
        .status(HttpStatus.OK)
        .body("id", equalTo(FAMILY_ID))
        .body("name", equalTo(FAMILY_NAME));
  }

  @Test
  void should_return_not_found_if_a_family_does_not_exists() {
    when(familyRepository.findById(FAMILY_ID))
        .thenReturn(Optional.empty());

    given()
      .when()
        .get("/api/v1/families/{id}", FAMILY_ID)
      .then()
        .status(HttpStatus.NOT_FOUND);
  }

  @Test
  void should_return_all_families() {
    when(familyRepository.findAllByOrderByName())
        .thenReturn(generateFamiliesList());

    given()
      .when()
        .get("/api/v1/families")
      .then()
        .status(HttpStatus.OK)
        .body("size()", is(3));
  }

  @Test
  void should_delete_one_family() {
    when(familyRepository.existsById(FAMILY_ID))
        .thenReturn(true);

    given()
      .when()
        .delete("/api/v1/families/{id}", FAMILY_ID)
      .then()
        .status(HttpStatus.OK);
  }

  @Test
  void should_return_not_found_when_try_to_delete_not_existing_family() {
    when(familyRepository.existsById(FAMILY_ID))
        .thenReturn(false);

    given()
      .when()
        .delete("/api/v1/families/{id}", FAMILY_ID)
      .then()
        .status(HttpStatus.NOT_FOUND);
  }

  @Test
  void should_create_one_family() {
    Family family = generateFamily();
    when(familyRepository.save(any()))
        .thenReturn(family);
    CreateFamilyDto createFamilyDto = new CreateFamilyDto(FAMILY_NAME);

    given()
        .contentType(ContentType.JSON)
        .body(gson.toJson(createFamilyDto))
      .when()
        .post("/api/v1/families")
      .then()
        .status(HttpStatus.CREATED)
        .body("id", is(FAMILY_ID))
        .body("name", is(FAMILY_NAME));
  }

  @Test
  void should_update_one_family() {
    Family family = generateFamily();
    family.setName("Changed name");
    when(familyRepository.save(any()))
        .thenReturn(family);

    given()
        .contentType(ContentType.JSON)
        .body(gson.toJson(family))
      .when()
        .put("/api/v1/families/{id}", FAMILY_ID)
      .then()
        .status(HttpStatus.OK)
        .body("id", is(FAMILY_ID))
        .body("name", is("Changed name"));
  }

  @Test
  void should_not_update_family_if_id_does_not_match() {
    Family family = generateFamily();

    given()
        .contentType(ContentType.JSON)
        .body(gson.toJson(family))
      .when()
        .put("/api/v1/families/{id}", 10)
      .then()
        .status(HttpStatus.BAD_REQUEST);
  }

  @Test
  void should_not_update_family_if_id_is_null() {
    Family family = new Family();

    given()
        .contentType(ContentType.JSON)
        .body(gson.toJson(family))
      .when()
        .put("/api/v1/families/{id}", 10)
      .then()
        .status(HttpStatus.BAD_REQUEST);
  }
}
