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

package org.earelin.demeter.application.dto.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.earelin.demeter.application.dto.SortedProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

class PageRequestMapperTest {

  public static final int PAGE = 12;
  public static final int SIZE = 15;
  public static final String SORTED_PROPERTY_NAME = "age";
  public static final List<SortedProperty> SORT =
    List.of(SortedProperty.desc(SORTED_PROPERTY_NAME));

  private PageRequestMapper pageRequestMapper;

  @BeforeEach
  void setUp() {
    pageRequestMapper = new PageRequestMapper();
  }

  @Test
  void should_create_an_unsorted_pageable() {
    Pageable pageable = pageRequestMapper.pageableFrom(PAGE, SIZE);

    assertThat(pageable.getPageNumber())
        .isEqualTo(PAGE);
    assertThat(pageable.getPageSize())
        .isEqualTo(SIZE);
    assertThat(pageable.getSort().isUnsorted())
        .isTrue();
  }

  @Test
  void should_create_a_sorted_pageable() {
    Pageable pageable = pageRequestMapper.pageableFrom(PAGE, SIZE, SORT);

    assertThat(pageable.getPageNumber())
        .isEqualTo(PAGE);
    assertThat(pageable.getPageSize())
        .isEqualTo(SIZE);
    assertThat(pageable.getSort().isSorted())
        .isTrue();
    assertThat(pageable.getSort().toList().size())
        .isEqualTo(1);
    assertThat(pageable.getSort().getOrderFor("age").getDirection())
        .isEqualTo(Direction.DESC);
  }

  @Test
  void should_convert_asc_order() {
    SortedProperty sortedProperty = SortedProperty.asc(SORTED_PROPERTY_NAME);

    Order order = pageRequestMapper.orderFrom(sortedProperty);

    assertThat(order.getProperty())
        .isEqualTo(SORTED_PROPERTY_NAME);
    assertThat(order.getDirection())
        .isEqualTo(Direction.ASC);
  }

  @Test
  void should_convert_desc_order() {
    SortedProperty sortedProperty = SortedProperty.desc(SORTED_PROPERTY_NAME);

    Order order = pageRequestMapper.orderFrom(sortedProperty);

    assertThat(order.getProperty())
        .isEqualTo(SORTED_PROPERTY_NAME);
    assertThat(order.getDirection())
        .isEqualTo(Direction.DESC);
  }
}
