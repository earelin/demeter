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
import Popup from 'reactjs-popup';

export default function FamiliesComponent() {
  const [families, setFamilies] = useState([])

  useEffect(() => {
    axios.get('/api/families')
      .then(res => {
        setFamilies(res.data)
      })
  }, [])

  return (
    <section>
      <h2>Families</h2>
      <Popup trigger={<button>Add</button>} modal>
        <p>Testing popup</p>
      </Popup>
      <div>
        { families.map(f => Family(f)) }
      </div>
    </section>
  )
}

function Family(family) {
  return (
    <article key={family.id}>
      {family.name}
      <button>Edit</button>
      <button>Delete</button>
    </article>
  )
}
