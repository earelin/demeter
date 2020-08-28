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

package org.earelin.demeter.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.FAMILY_ID;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.FAMILY_NAME;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.generateFamily;

import java.util.Optional;
import org.earelin.demeter.RepositoryIntegration;
import org.earelin.demeter.domain.catalog.Family;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RepositoryIntegration
class FamilyRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private FamilyRepository familyRepository;

  @Test
  void should_find_a_family_by_id() {
    Family family = generateFamily();
    entityManager.persist(family);

    Optional<Family> foundFamily = familyRepository.findById(FAMILY_ID);

    assertThat(foundFamily)
        .isPresent()
        .get()
        .hasFieldOrPropertyWithValue("id", FAMILY_ID)
        .hasFieldOrPropertyWithValue("name", FAMILY_NAME);
  }

  @Test
  void should_not_find_a_family_if_it_does_not_exists() {
    Optional<Family> foundFamily = familyRepository.findById(FAMILY_ID);

    assertThat(foundFamily).isNotPresent();
  }

  @Test
  void should_save_a_family() {
    familyRepository.save(generateFamily());

    Family foundFamily = entityManager.find(Family.class, FAMILY_ID);
    assertThat(foundFamily)
        .hasFieldOrPropertyWithValue("id", FAMILY_ID)
        .hasFieldOrPropertyWithValue("name", FAMILY_NAME);
  }

  @Test
  void should_delete_a_family() {
    this.entityManager.persist(generateFamily());

    familyRepository.deleteById(FAMILY_ID);

    assertThat(entityManager.find(Family.class, FAMILY_ID))
        .isNull();
  }

  @Test
  void should_return_true_if_a_family_exists() {
    this.entityManager.persist(generateFamily());

    assertThat(familyRepository.existsById(FAMILY_ID))
        .isTrue();
  }

  @Test
  void should_return_true_if_a_family_does_not_exist() {
    assertThat(familyRepository.existsById(FAMILY_ID))
        .isFalse();
  }

}
