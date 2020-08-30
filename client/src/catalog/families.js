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
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useRouteMatch
} from 'react-router-dom';
import Plants from "./plants";
import FamilyForm from "./family-form";
import FamilyFormDelete from "./family-form-delete";

export default function FamiliesComponent() {
  const { path, url } = useRouteMatch()
  const [families, setFamilies] = useState([])

  useEffect(() => {
    axios.get('/api/v1/families')
      .then(res => {
        setFamilies(res.data)
      })
  }, [])

  return (
    <section>
      <h2>Families</h2>
      <Switch>
        <Route path={`${path}/add`}>
          <FamilyForm />
        </Route>
        <Route path={`${path}/:id/edit`}>
          <FamilyForm />
        </Route>
        <Route path={`${path}/:id/delete`}>
          <FamilyFormDelete />
        </Route>
        <Route exact path={path}>
          <Link to={`${url}/add`}>Add</Link>
          <Families families={families} />
        </Route>
      </Switch>
    </section>
  )
}

function Families(props) {
  return (
    <div>
      { props.families.map(f => Family(f)) }
    </div>
  )
}

function Family(family) {
  const { url } = useRouteMatch()
  return (
    <article key={family.id}>
      {family.name}
      <Link to={`${url}/${family.id}/edit`}>Edit</Link>
      <Link to={`${url}/${family.id}/delete`}>Delete</Link>
    </article>
  )
}
