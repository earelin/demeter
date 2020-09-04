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

import org.earelin.demeter.domain.catalog.Disease;
import org.junit.jupiter.api.BeforeEach;

class DiseaseAttackTest {

  public static final String EVENT_ID = "d0008f66-d928-42aa-958c-31d63400ddd5";
  public static final int EVENT_NUMBER = 4;
  public static final Disease EVENT_DISEASE = new Disease("9f6ef081-2bfd-41f3-91a8-e40be7ad1505");

  private DiseaseAttack diseaseAttack;

  @BeforeEach
  void setUp() {
    diseaseAttack = new DiseaseAttack(EVENT_ID);
    diseaseAttack.setNumber(EVENT_NUMBER);
  }

}
