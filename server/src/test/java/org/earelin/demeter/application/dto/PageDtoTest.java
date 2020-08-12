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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PageDtoTest {

  private static final int PAGE_SIZE = 10;
  private static final int TOTAL_ELEMENTS = 99;

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
  void should_set_and_return_pageSize() {
    page.setPageSize(PAGE_SIZE);

    assertThat(page.getPageSize())
        .isEqualTo(PAGE_SIZE);
  }

  @Test
  void should_set_and_return_totalElements() {
    page.setTotalElements(TOTAL_ELEMENTS);

    assertThat(page.getTotalElements())
        .isEqualTo(TOTAL_ELEMENTS);
  }

  @Test
  void should_return_a_string_representation() {
    page.setPageSize(PAGE_SIZE);
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

  List<String> generateContentList() {
    return Lists.list("one", "two", "three");
  }
}
