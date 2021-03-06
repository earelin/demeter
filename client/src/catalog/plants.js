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

import React, {useEffect, useState} from 'react'
import axios from 'axios'

export default function PlantsComponent() {
  const [plants, setPlants] = useState([])

  useEffect(() => {
    axios.get('/api/plants')
      .then(res => {
        setPlants(res.data)
      })
  }, [])

  return (
    <section>
      <h2>Plants</h2>
      <button>Add</button>
      <div>
        { plants.map(p => Plant(p)) }
      </div>
    </section>
  )
}

function Plant(plant) {
  return (
    <article key={plant.id}>
      {plant.name}
      <button>Edit</button>
      <button>Delete</button>
    </article>
  )
}
