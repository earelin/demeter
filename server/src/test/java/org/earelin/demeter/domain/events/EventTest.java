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

package org.earelin.demeter.domain.events;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlType.DEFAULT;
import org.earelin.demeter.domain.Crop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {

  public static final String EVENT_ID = "4f5293cb-c236-4f80-a434-995781dd4dad";
  public static final Crop EVENT_CROP = new Crop("9ac2a7a0-0b23-498a-8e2a-c6382d251bcf");
  public static final LocalDate EVENT_DATE = LocalDate.of(2020, 5, 14);
  public static final String EVENT_LABEL = "Something happens";
  public static final String EVENT_NOTES = "Lorem Ipsum ...";

  private DefaultEvent defaultEvent;

  @BeforeEach
  void setUp() {
    defaultEvent = new DefaultEvent();
  }

  @Test
  void constructor_should_set_id() {
    defaultEvent = new DefaultEvent(EVENT_ID);

    assertThat(defaultEvent.getId())
        .isEqualTo(EVENT_ID);
  }

  @Test
  void should_set_and_return_crop() {
    defaultEvent.setCrop(EVENT_CROP);

    assertThat(defaultEvent.getCrop())
        .isEqualTo(EVENT_CROP);
  }

  @Test
  void should_set_and_return_date() {
    defaultEvent.setDate(EVENT_DATE);

    assertThat(defaultEvent.getDate())
        .isEqualTo(EVENT_DATE);
  }

  @Test
  void should_set_and_return_label() {
    defaultEvent.setLabel(EVENT_LABEL);

    assertThat(defaultEvent.getLabel())
        .isEqualTo(EVENT_LABEL);
  }

  @Test
  void should_set_and_return_notes() {
    defaultEvent.setNotes(EVENT_NOTES);

    assertThat(defaultEvent.getNotes())
        .isEqualTo(EVENT_NOTES);
  }

  @Test
  void should_return_string_representation() {
    defaultEvent = new DefaultEvent(EVENT_ID);
    defaultEvent.setLabel(EVENT_LABEL);
    defaultEvent.setNotes(EVENT_NOTES);

    assertThat(defaultEvent.toString())
        .contains(EVENT_ID, EVENT_LABEL, EVENT_NOTES);
  }

  @Test
  void should_be_equal_to_itself() {
    assertThat(defaultEvent.equals(defaultEvent))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_null() {
    assertThat(defaultEvent.equals(null))
        .isFalse();
  }

  @Test
  void should_be_equal_to_other_object_with_same_id() {
    defaultEvent = new DefaultEvent(EVENT_ID);
    defaultEvent.setLabel(EVENT_LABEL);
    DefaultEvent compare = new DefaultEvent(EVENT_ID);

    assertThat(defaultEvent.equals(compare))
        .isTrue();
  }

  @Test
  void should_not_be_equal_to_other_object_with_different_id() {
    defaultEvent = new DefaultEvent(EVENT_ID);
    DefaultEvent compare = new DefaultEvent("2a1ebe8a-26e9-4906-9c3c-ca9a73bfe417");

    assertThat(defaultEvent.equals(compare))
        .isFalse();
  }

  @Test
  void should_have_the_same_hashCode_than_other_object_with_same_id() {
    defaultEvent = new DefaultEvent(EVENT_ID);
    defaultEvent.setLabel(EVENT_LABEL);
    DefaultEvent compare = new DefaultEvent(EVENT_ID);

    assertThat(defaultEvent.hashCode())
        .isEqualTo(compare.hashCode());
  }

  @Test
  void should_not_have_the_same_hashCode_than_to_other_object_with_different_id() {
    defaultEvent = new DefaultEvent(EVENT_ID);
    DefaultEvent compare = new DefaultEvent("2a1ebe8a-26e9-4906-9c3c-ca9a73bfe417");

    assertThat(defaultEvent.hashCode())
        .isNotEqualTo(compare.hashCode());
  }

  static class DefaultEvent extends Event {
    public DefaultEvent() {}

    public DefaultEvent(String id) {
      super(id);
    }
  }
}
