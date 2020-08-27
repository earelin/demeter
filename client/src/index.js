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
import Home from './home'
import ReactDOM from 'react-dom'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from 'react-router-dom'
import Catalog from './catalog/index'
import Areas from './areas'
import Inventory from './inventory'
import './index.scss'

function DemeterApplication() {
  return (
    <Router>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/catalog">Catalog</Link>
          </li>
          <li>
            <Link to="/areas">Cultivation Areas</Link>
          </li>
          <li>
            <Link to="/inventory">Inventory</Link>
          </li>
        </ul>
      </nav>

      <Switch>
        <Route path="/areas">
          <Areas />
        </Route>
        <Route path="/catalog">
          <Catalog />
        </Route>
        <Route path="/inventory">
          <Inventory />
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>

    </Router>
  )
}

const mountNode = document.getElementById('app')
ReactDOM.render(<DemeterApplication />, mountNode)
