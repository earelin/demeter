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

package org.earelin.demeter.factories.catalog;

import java.util.UUID;
import org.earelin.demeter.domain.catalog.Family;
import org.earelin.demeter.domain.catalog.Plant;
import org.springframework.stereotype.Component;

@Component
public class PlantFactory {

  public Plant build(String name, Family family) {
    String id = UUID.randomUUID().toString();
    Plant plant = new Plant(id);
    plant.setName(name);
    plant.setFamily(family);
    return plant;
  }

}
