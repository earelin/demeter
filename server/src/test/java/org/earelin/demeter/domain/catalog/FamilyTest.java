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
import static org.earelin.demeter.domain.catalog.FamilyGenerator.FAMILY_ALT_ID;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.FAMILY_ID;
import static org.earelin.demeter.domain.catalog.FamilyGenerator.FAMILY_NAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamilyTest {

  private Family family;

  @BeforeEach
  void setUp() {
    family = new Family(FAMILY_ID);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(family.getId())
        .isEqualTo(FAMILY_ID);
  }

  @Test
  void should_set_and_return_name() {
    family.setName(FAMILY_NAME);

    assertThat(family.getName())
        .isEqualTo(FAMILY_NAME);
  }

  @Test
  void should_return_string_representation() {
    family.setName(FAMILY_NAME);

    assertThat(family.toString())
        .startsWith(Family.class.getSimpleName())
        .contains(FAMILY_ID.toString(), FAMILY_NAME);
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(family.equals(family))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(family.equals(null))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_a_different_class() {
    assertThat(family.equals(new String("Testing")))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    family.setName(FAMILY_NAME);
    Family compare = new Family(FAMILY_ID);

    assertThat(family.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    family.setName(FAMILY_NAME);
    Family compare = new Family("c7f8582a-4762-448d-9a93-a70e87155aab");
    compare.setName(FAMILY_NAME);

    assertThat(family.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_object_with_same_id() {
    family.setName(FAMILY_NAME);
    Family compare = new Family(FAMILY_ID);

    assertThat(family.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_other_object_with_different_id() {
    family.setName(FAMILY_NAME);
    Family compare = new Family(FAMILY_ALT_ID);
    compare.setName(FAMILY_NAME);

    assertThat(family.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
