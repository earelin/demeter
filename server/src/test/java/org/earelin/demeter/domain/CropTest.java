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

package org.earelin.demeter.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CropTest {
  public static final String CROP_ID = "83f9646d-fc68-468f-ae99-209905ca4d81";
  public static final String CROP_LABEL = "BioBizz BioHeaven";
  public static final String CROP_NOTES = "Lorem ipsum ...";

  private Crop crop;

  @BeforeEach
  void setUp() {
    crop = new Crop(CROP_ID);
    crop.setLabel(CROP_LABEL);
    crop.setNotes(CROP_NOTES);
  }

  @Test
  void should_set_and_return_id() {
    assertThat(crop.getId())
        .isEqualTo(CROP_ID);
  }


  @Test
  void should_return_string_representation() {
    assertThat(crop.toString())
        .contains(Crop.class.getSimpleName(), CROP_ID,
            CROP_LABEL, CROP_NOTES);
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(crop.equals(crop))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(crop.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    Crop compare = new Crop(CROP_ID);

    assertThat(crop.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    Crop compare = new Crop("319f41af-0f83-4f35-a815-c95f5b37e69a");

    assertThat(crop.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_object_with_same_id() {
    Crop compare = new Crop(CROP_ID);

    assertThat(crop.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_different_hashCode_than_object_with_different_id() {
    Crop compare = new Crop("319f41af-0f83-4f35-a815-c95f5b37e69a");

    assertThat(crop.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
