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
import {Link, useHistory, useParams} from 'react-router-dom'
import axios from 'axios'

export default function FamilyFormDelete() {
  const { id } = useParams()
  const [family, setFamily] = useState([])
  const history = useHistory()

  useEffect(() => {
    if (id) {
      axios.get(`/api/v1/families/${id}`)
      .then(res => {
        setFamily(res.data)
      })
    }
  }, [])

  function deleteFamily() {
    axios.delete(`/api/v1/families/${family.id}`)
    history.push('/catalog/families')
  }

  return (
    <>
      <p>Do you want to delete <strong>{family.name}</strong> family?</p>
      <div>
        <Link to="/catalog/families">Cancel</Link>
        <button onClick={deleteFamily}>Yes</button>
      </div>
    </>
  )
}

