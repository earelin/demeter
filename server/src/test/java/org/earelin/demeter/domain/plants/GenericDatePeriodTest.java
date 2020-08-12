package org.earelin.demeter.domain.plants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericDatePeriodTest {

  private GenericDatePeriod genericDatePeriod;

  private GenericDate start;
  private GenericDate end;

  @BeforeEach
  void setUp() {
    start = new GenericDate(1, 23);
    end = new GenericDate(3, 12);
    genericDatePeriod = new GenericDatePeriod();
    genericDatePeriod.setStart(start);
    genericDatePeriod.setEnd(end);
  }

  @Test
  void should_set_and_return_start_date() {
    assertThat(genericDatePeriod.getStart())
        .isEqualTo(start);
  }

  @Test
  void should_set_and_return_end_date() {
    assertThat(genericDatePeriod.getEnd())
        .isEqualTo(end);
  }

  @Test
  void should_return_a_string_representation() {
    assertThat(genericDatePeriod.toString())
        .contains(GenericDatePeriod.class.getSimpleName());
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(genericDatePeriod.equals(genericDatePeriod))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(genericDatePeriod.equals(null))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_a_different_class() {
    assertThat(genericDatePeriod.equals(new String("test")))
        .isFalse();
  }

  @Test
  void should_be_equal_to_an_object_with_same_dates() {
    GenericDatePeriod compare = new GenericDatePeriod();
    compare.setStart(start);
    compare.setEnd(end);

    assertThat(genericDatePeriod.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_an_object_with_different_start_date() {
    GenericDatePeriod compare = new GenericDatePeriod();
    compare.setStart(new GenericDate(10, 5));
    compare.setEnd(end);

    assertThat(genericDatePeriod.equals(compare))
        .isFalse();
  }

  @Test
  void should_not_be_equal_to_an_object_with_different_end_date() {
    GenericDatePeriod compare = new GenericDatePeriod();
    compare.setStart(start);
    compare.setEnd(new GenericDate(10, 5));

    assertThat(genericDatePeriod.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_an_object_with_same_properties() {
    GenericDatePeriod compare = new GenericDatePeriod();
    compare.setStart(start);
    compare.setEnd(end);

    assertThat(genericDatePeriod.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_have_a_different_hashCode_than_an_object_with_no_equal_properties() {
    GenericDatePeriod compare = new GenericDatePeriod();
    compare.setStart(new GenericDate(10, 1));
    compare.setEnd(new GenericDate(10, 5));

    assertThat(genericDatePeriod.hashCode())
        .isNotEqualTo(compare.hashCode());
  }
}
