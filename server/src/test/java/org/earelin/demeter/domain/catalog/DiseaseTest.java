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

package org.earelin.demeter.domain.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiseaseTest {

  public static final Long DISEASE_ID = 12L;
  public static final String DISEASE_NAME = "Scab";
  public static final String DISEASE_DESCRIPTION = "Causes brown patches.";

  private Disease disease;

  @BeforeEach
  void setUp() {
    disease = new Disease(DISEASE_ID);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(disease.getId())
        .isEqualTo(DISEASE_ID);
  }

  @Test
  void should_set_and_return_name() {
    disease.setName(DISEASE_NAME);

    assertThat(disease.getName())
        .isEqualTo(DISEASE_NAME);
  }

  @Test
  void should_set_and_return_description() {
    disease.setDescription(DISEASE_DESCRIPTION);

    assertThat(disease.getDescription())
        .isEqualTo(DISEASE_DESCRIPTION);
  }

  @Test
  void should_return_string_representation() {
    disease.setName(DISEASE_NAME);

    assertThat(disease.toString())
        .startsWith(Disease.class.getSimpleName())
        .contains(DISEASE_ID.toString(), DISEASE_NAME);
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(disease.equals(disease))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(disease.equals(null))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_a_different_class() {
    assertThat(disease.equals(new String("Testing")))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    disease.setName(DISEASE_NAME);
    Disease compare = new Disease(DISEASE_ID);

    assertThat(disease.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    disease.setName(DISEASE_NAME);
    Disease compare = new Disease(1L);
    compare.setName(DISEASE_NAME);

    assertThat(disease.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_object_with_same_id() {
    disease.setName(DISEASE_NAME);
    Disease compare = new Disease(DISEASE_ID);

    assertThat(disease.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    disease.setName(DISEASE_NAME);
    Disease compare = new Disease(1L);
    compare.setName(DISEASE_NAME);

    assertThat(disease.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
