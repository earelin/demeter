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
import Popup from '../components/popup'
import axios from 'axios'
import FamilyForm from './family-form'

export default function DiseasesComponent() {
  const [diseases, setDiseases] = useState([])

  useEffect(() => {
    axios.get('/api/diseases')
      .then(res => {
        setDiseases(res.data)
      })
  }, [])

  return (
    <>
      <h2>Diseases</h2>
      <Popup trigger={<button className="btn btn-primary">Add</button>}>
        <FamilyForm />
      </Popup>
      <ul>
        {diseases.map(d => Disease(d))}
      </ul>
    </>
  )
}

function Disease(props) {
  return (
    <li>
      {props.name}
    </li>
  )
}
