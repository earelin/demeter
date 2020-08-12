package org.earelin.demeter.domain.plants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamilyTest {

  public static final Long FAMILY_ID = 12L;
  public static final String FAMILY_NAME = "Brassicaceae";

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
    Family compare = new Family(1L);
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
    Family compare = new Family(1L);
    compare.setName(FAMILY_NAME);

    assertThat(family.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
