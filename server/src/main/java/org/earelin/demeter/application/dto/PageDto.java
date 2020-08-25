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

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Getter
@Setter
@ToString
public class PageDto<K> {
  private List<K> content = new ArrayList<>();
  private long totalElements;
  private int pageSize;
  private int number;

  public PageDto() {}

  public PageDto(Page<K> page) {
    this.content = page.getContent();
    this.totalElements = page.getTotalElements();
    this.pageSize = page.getSize();
    this.number = page.getNumber();
  }

  public int getTotalPages() {
    return (int) Math.ceil((double) totalElements / pageSize);
  }
}
