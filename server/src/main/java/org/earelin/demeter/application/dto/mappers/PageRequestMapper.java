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

import java.util.List;
import java.util.stream.Collectors;
import org.earelin.demeter.application.dto.SortDirection;
import org.earelin.demeter.application.dto.SortedProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

@Component
public class PageRequestMapper {
  public Pageable pageableFrom(int page, int size) {
    return pageableFrom(page, size, List.of());
  }

  public Pageable pageableFrom(int page, int size, List<SortedProperty> sort) {
    return PageRequest.of(page, size, sortFrom(sort));
  }

  public Sort sortFrom(List<SortedProperty> sort) {
    List<Sort.Order> orders = sort.stream()
        .map(this::orderFrom)
        .collect(Collectors.toList());
    return orders.isEmpty() ? Sort.unsorted() : Sort.by(orders);
  }

  public Order orderFrom(SortedProperty sortedProperty) {
    Sort.Direction direction = sortedProperty.getDirection() == SortDirection.DESC ?
        Direction.DESC : Direction.ASC;
    return new Order(direction, sortedProperty.getName());
  }
}
