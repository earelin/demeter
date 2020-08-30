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
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">Demeter</Link>
        </div>
      </nav>

      <nav className="navbar navbar-expand-lg navbar-light bg-primary">
        <div className="container-fluid">
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link className="nav-link" to="/">Home</Link>
              </li>
              <li className="nav-item">
                <a className="nav-link">Catalog</a>
                <ul className="dropdown-menu">
                  <li className="dropdown-item">
                    <Link className="nav-link" to="/catalog/families">Families</Link>
                  </li>
                  <li className="dropdown-item">
                    <Link className="nav-link" to="/catalog/plants">Plants</Link>
                  </li>
                  <li className="dropdown-item">
                    <Link className="nav-link" to="/catalog/diseases">Diseases</Link>
                  </li>
                  <li className="dropdown-item">
                    <Link className="nav-link" to="/catalog/pests">Pests</Link>
                  </li>
                  <li className="dropdown-item">
                    <Link className="nav-link" to="/catalog/fertilizers">Fertilizers</Link>
                  </li>
                </ul>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/areas">Cultivation Areas</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/inventory">Inventory</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div className="container-fluid">
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
      </div>
    </Router>
  )
}

const mountNode = document.getElementById('app')
ReactDOM.render(<DemeterApplication />, mountNode)
