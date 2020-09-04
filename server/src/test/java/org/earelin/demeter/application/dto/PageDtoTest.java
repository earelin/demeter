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

package org.earelin.demeter.application.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.earelin.demeter.application.dto.PageDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

class PageDtoTest {

  private static final int PAGE_NUMBER = 3;
  private static final int PAGE_SIZE = 10;
  private static final long TOTAL_ELEMENTS = 99L;

  private PageDto<String> page;

  @BeforeEach
  void setUp() {
    page = new PageDto<>();
  }

  @Test
  void should_set_and_return_content() {
    List<String> content = generateContentList();
    page.setContent(content);

    assertThat(page.getContent())
        .isEqualTo(content);
  }

  @Test
  void should_set_and_return_number() {
    page.setNumber(PAGE_NUMBER);

    assertThat(page.getNumber())
        .isEqualTo(PAGE_NUMBER);
  }

  @Test
  void should_set_and_return_totalElements() {
    page.setTotalElements(TOTAL_ELEMENTS);

    assertThat(page.getTotalElements())
        .isEqualTo(TOTAL_ELEMENTS);
  }

  @Test
  void should_set_and_return_pageSize() {
    page.setSize(PAGE_SIZE);

    assertThat(page.getSize())
        .isEqualTo(PAGE_SIZE);
  }

  @Test
  void should_return_total_number_of_pages() {
    page.setTotalElements(TOTAL_ELEMENTS);
    page.setSize(PAGE_SIZE);

    assertThat(page.getTotalPages())
        .isEqualTo(10);
  }

  @Test
  void should_return_a_string_representation() {
    page.setSize(PAGE_SIZE);
    page.setTotalElements(TOTAL_ELEMENTS);
    page.setContent(generateContentList());

    assertThat(page.toString())
        .contains(
            PageDto.class.getSimpleName(),
            "one", "two", "three",
            String.valueOf(PAGE_SIZE),
            String.valueOf(TOTAL_ELEMENTS)
        );
  }

  @Test
  void should_create_from_a_page() {
    List<String> content = generateContentList();
    Page<String> page = new PageImpl<>(
        content,
        PageRequest.of(PAGE_NUMBER, PAGE_SIZE),
        TOTAL_ELEMENTS
    );

    PageDto<String> pageDto = new PageDto<>(page);

    assertThat(pageDto)
        .hasFieldOrPropertyWithValue("content", content)
        .hasFieldOrPropertyWithValue("totalElements", TOTAL_ELEMENTS)
        .hasFieldOrPropertyWithValue("size", PAGE_SIZE)
        .hasFieldOrPropertyWithValue("number", PAGE_NUMBER);
  }

  List<String> generateContentList() {
    return Lists.list("one", "two", "three");
  }
}
