package org.earelin.demeter.domain.plants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericDateTest {

  public static final int GENERIC_DATE_MONTH = 6;
  public static final int GENERIC_DATE_DAY = 21;

  private GenericDate genericDate;

  @BeforeEach
  void setUp() {
    genericDate = new GenericDate();
    genericDate.setMonth(GENERIC_DATE_MONTH);
    genericDate.setDay(GENERIC_DATE_DAY);
  }

  @Test
  void should_set_and_return_month() {
    assertThat(genericDate.getMonth())
        .isEqualTo(GENERIC_DATE_MONTH);
  }

  @Test
  void should_set_and_return_day() {
    assertThat(genericDate.getDay())
        .isEqualTo(GENERIC_DATE_DAY);
  }

  @Test
  void should_return_a_string_representation() {
    assertThat(genericDate.toString())
        .startsWith(GenericDate.class.getSimpleName())
        .contains(
            Integer.toString(GENERIC_DATE_MONTH),
            Integer.toString(GENERIC_DATE_DAY)
        );
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(genericDate.equals(genericDate))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(genericDate.equals(null))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_different_class() {
    assertThat(genericDate.equals(new String("test")))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_an_object_with_different_month() {
    GenericDate compare = new GenericDate();
    compare.setMonth(7);
    compare.setDay(GENERIC_DATE_DAY);

    assertThat(genericDate.equals(compare))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_an_object_with_different_day() {
    GenericDate compare = new GenericDate();
    compare.setMonth(GENERIC_DATE_MONTH);
    compare.setDay(12);

    assertThat(genericDate.equals(compare))
        .isFalse();
  }

  @Test
  void should_be_equal_to_an_object_with_same_values() {
    GenericDate compare = new GenericDate();
    compare.setMonth(GENERIC_DATE_MONTH);
    compare.setDay(GENERIC_DATE_DAY);

    assertThat(genericDate.equals(compare))
        .isTrue();
  }

  @Test
  void should_have_a_hashCode_different_to_an_object_with_different_month() {
    GenericDate compare = new GenericDate();
    compare.setMonth(7);
    compare.setDay(GENERIC_DATE_DAY);

    assertThat(genericDate.hashCode())
        .isNotEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_hashCode_different_to_an_object_with_different_day() {
    GenericDate compare = new GenericDate();
    compare.setMonth(GENERIC_DATE_MONTH);
    compare.setDay(12);

    assertThat(genericDate.hashCode())
        .isNotEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_hashCode_equal_to_an_object_with_same_values() {
    GenericDate compare = new GenericDate();
    compare.setMonth(GENERIC_DATE_MONTH);
    compare.setDay(GENERIC_DATE_DAY);

    assertThat(genericDate.hashCode())
        .isEqualTo(compare.hashCode());
  }
}
