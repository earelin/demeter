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

import java.util.List;

public class FamilyGenerator {

  public static final String FAMILY_ID = "9e1176e1-1c48-428b-a9cd-f6348422f0f0";
  public static final String FAMILY_NAME = "Brassicaceae";
  public static final String FAMILY_ALT_ID = "f51960b5-2317-4b2f-83ee-96e2582eed74";
  public static final String FAMILY_ALT_NAME = "Solanaeae";

  public static Family generateFamily() {
    return fromIdAndName(FAMILY_ID, FAMILY_NAME);
  }

  public static List<Family> generateFamiliesList() {
    return List.of(
        fromIdAndName(FAMILY_ID, FAMILY_NAME),
        fromIdAndName("bdee65b6-687b-4186-86aa-f64781cf5ccb", "Amaryllidaceae"),
        fromIdAndName("a1dcceb1-c3de-49d5-9b42-0ba5e6e64ba7", "Solanaeae")
    );
  }

  private static Family fromIdAndName(String id, String name) {
    Family family = new Family(id);
    family.setName(name);
    return family;
  }

  private FamilyGenerator() {}
}
