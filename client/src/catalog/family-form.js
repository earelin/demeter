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
import {
  Link,
  useHistory,
  useParams
} from 'react-router-dom'
import axios from 'axios'
import { useForm } from 'react-hook-form'

export default function FamilyForm(props) {
  const { id } = useParams()
  const [family, setFamily] = useState([])
  const { register, handleSubmit } = useForm()
  const history = useHistory()

  useEffect(() => {
    if (id) {
      axios.get(`/api/v1/families/${id}`)
        .then(res => {
          setFamily(res.data)
        })
    }
  }, [])

  function onSubmit(family) {
    if (family.id === "") {
      axios.post('/api/v1/families', {name: family.name})
    } else {
      axios.put(`/api/v1/families/${family.id}`, family)
    }

    history.push('/catalog/families')
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="form-group">
        <label>Name</label>
        <input type="hidden" name="id" defaultValue={family.id} ref={register} />
        <input type="text" name="name" defaultValue={family.name} ref={register({ required: true })} />
      </div>
      <Link to="/catalog/families">Cancel</Link>
      <input type="submit" value={family.id ? 'Update' : 'Create'} />
    </form>
  )
}
