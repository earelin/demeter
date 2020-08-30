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

public final class PlantGenerator {

  public static final String PLANT_ID = "0206b569-481e-4bbc-93c2-80411facdcb5";
  public static final String PLANT_NAME = "Garlic";
  public static final String PLANT_BINOMIAL_NAME = "Allium sativum";
  public static final String PLANT_DESCRIPTION = "Lorem ipsum";
  public static final Integer PLANT_SEPARATION = 15;

  public static Plant generatePlant() {
    Plant plant = new Plant(PLANT_ID);
    plant.setName(PLANT_NAME);
    plant.setBinomialName(PLANT_BINOMIAL_NAME);
    plant.setDescription(PLANT_DESCRIPTION);
    plant.setFamily(generateFamily());
    return plant;
  }

  private PlantGenerator() {}
}
