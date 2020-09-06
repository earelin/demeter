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

package org.earelin.demeter.domain.catalog;

import static org.earelin.demeter.domain.catalog.FamilyGenerator.generateFamily;

import java.util.List;

public final class PlantGenerator {

  public static final String PLANT_ID = "0206b569-481e-4bbc-93c2-80411facdcb5";
  public static final String PLANT_NAME = "Garlic";
  public static final String PLANT_BINOMIAL_NAME = "Allium sativum";
  public static final String PLANT_DESCRIPTION = "Lorem ipsum";

  public static Plant generatePlant() {
    return from(PLANT_ID, PLANT_NAME, PLANT_BINOMIAL_NAME, PLANT_DESCRIPTION, generateFamily());
  }

  public static List<Plant> generatePlantList() {
    Family family = generateFamily();
    return List.of(
        from(PLANT_ID, PLANT_NAME, PLANT_BINOMIAL_NAME, PLANT_DESCRIPTION, family),
        from("83558ea2-57b7-4a51-86b2-b21dbffc0653", "", "", "", family),
        from("a482de4d-13b5-4621-ade1-0b894cc7680f", "", "", "", family)
    );
  }

  public static Plant from(String id, String name, String binomialName,
      String description, Family family) {
    Plant plant = new Plant(id);
    plant.setName(name);
    plant.setBinomialName(binomialName);
    plant.setDescription(description);
    plant.setFamily(family);
    return plant;
  }

  private PlantGenerator() {}
}
