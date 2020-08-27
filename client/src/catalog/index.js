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

import React from 'react'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useRouteMatch
} from 'react-router-dom'
import Families from './families'
import Plants from './plants'
import Fertilizers from './fertilizers'
import Diseases from './diseases'
import Pests from './pests'

export default function Catalog() {
  const { path, url } = useRouteMatch()

  return (
    <main>
      <header>
        <h1> Catalog</h1>
      </header>
      <nav>
        <ul>
          <Link to={url}>Plants</Link>
        </ul>
        <ul>
          <Link to={`${url}/families`}>Families</Link>
        </ul>
        <ul>
          <Link to={`${url}/fertilizers`}>Fertilizers</Link>
        </ul>
        <ul>
          <Link to={`${url}/pests`}>Pests</Link>
        </ul>
        <ul>
          <Link to={`${url}/diseases`}>Diseases</Link>
        </ul>
      </nav>
      <Switch>
        <Route path={`${path}/families`}>
          <Families />
        </Route>
        <Route path={`${path}/fertilizers`}>
          <Fertilizers />
        </Route>
        <Route path={`${path}/pests`}>
          <Pests />
        </Route>
        <Route path={`${path}/diseases`}>
          <Diseases />
        </Route>
        <Route exact path={path}>
          <Plants />
        </Route>
      </Switch>
    </main>
  )
}
