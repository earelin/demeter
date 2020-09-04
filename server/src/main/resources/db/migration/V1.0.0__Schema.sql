CREATE TABLE family (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64),
  PRIMARY KEY (id)
);

CREATE TABLE plant (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64),
  binomial_name VARCHAR(64),
  description ${text-datatype},
  family_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (family_id)
    REFERENCES family(id)
    ON DELETE CASCADE
);

CREATE TABLE plant_friends (
  plant_a_id VARCHAR(36) NOT NULL,
  plant_b_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (plant_a_id, plant_b_id),
  FOREIGN KEY (plant_a_id)
    REFERENCES plant(id)
    ON DELETE CASCADE,
  FOREIGN KEY (plant_b_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE plant_foes (
  plant_a_id VARCHAR(36) NOT NULL,
  plant_b_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (plant_a_id, plant_b_id),
  FOREIGN KEY (plant_a_id)
    REFERENCES plant(id)
    ON DELETE CASCADE,
  FOREIGN KEY (plant_b_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE cultivar (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64),
  description ${text-datatype},
  separation DOUBLE,
  plant_id VARCHAR(36) NOT NULL,
  germination_days INT,
  germination_months INT,
  germination_years INT,
  maturity_days INT,
  maturity_months INT,
  maturity_years INT,
  lifespan_days INT,
  lifespan_months INT,
  lifespan_years INT,
  PRIMARY KEY (id),
  FOREIGN KEY (plant_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE cultivar_sow (
  cultivar_id VARCHAR(36) NOT NULL,
  start_day INT,
  start_month INT,
  end_day INT,
  end_month INT,
  FOREIGN KEY (cultivar_id)
    REFERENCES cultivar(id)
    ON DELETE CASCADE
);

CREATE TABLE cultivar_harvest (
  cultivar_id VARCHAR(36) NOT NULL,
  start_day INT,
  start_month INT,
  end_day INT,
  end_month INT,
  FOREIGN KEY (cultivar_id)
    REFERENCES cultivar(id)
    ON DELETE CASCADE
);

CREATE TABLE crop (
  id VARCHAR(36) NOT NULL,
  label VARCHAR(128),
  notes ${text-datatype},
  cultivar_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cultivar_id)
    REFERENCES cultivar(id)
    ON DELETE CASCADE
);

CREATE TABLE cultivated_area (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64) NOT NULL,
  description ${text-datatype},
  height DOUBLE,
  width DOUBLE,
  PRIMARY KEY (id)
);

CREATE TABLE unit (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64) NOT NULL,
  type VARCHAR(32) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE fertilizer (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64) NOT NULL,
  dosage_unit_id VARCHAR(36) NOT NULL,
  description ${text-datatype},
  PRIMARY KEY (id),
  FOREIGN KEY (dosage_unit_id)
    REFERENCES unit(id)
    ON DELETE CASCADE
);

CREATE TABLE disease (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64),
  description ${text-datatype},
  PRIMARY KEY (id)
);

CREATE TABLE disease_targets (
  disease_id VARCHAR(36) NOT NULL,
  targets_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (disease_id, targets_id),
  FOREIGN KEY (disease_id)
    REFERENCES disease(id)
    ON DELETE CASCADE,
  FOREIGN KEY (targets_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE pest (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64) NOT NULL,
  description ${text-datatype},
  PRIMARY KEY (id)
);

CREATE TABLE pest_targets (
  pest_id VARCHAR(36) NOT NULL,
  targets_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (pest_id, targets_id),
  FOREIGN KEY (pest_id)
    REFERENCES pest(id)
    ON DELETE CASCADE,
  FOREIGN KEY (targets_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE pest_foes (
  pest_id VARCHAR(36) NOT NULL,
  foes_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (pest_id, foes_id),
  FOREIGN KEY (pest_id)
    REFERENCES pest(id)
    ON DELETE CASCADE,
  FOREIGN KEY (foes_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE event (
  id VARCHAR(36) NOT NULL,
  crop_id VARCHAR(36) NOT NULL,
  date DATE,
  label VARCHAR(64),
  notes ${text-datatype},
  PRIMARY KEY (id),
  FOREIGN KEY (crop_id)
    REFERENCES crop(id)
    ON DELETE CASCADE
);

CREATE TABLE dead (
  id VARCHAR(36) NOT NULL,
  number INT,
  PRIMARY KEY (id),
  FOREIGN KEY (id)
    REFERENCES event(id)
    ON DELETE CASCADE
);

CREATE TABLE disease_attack (
  id VARCHAR(36) NOT NULL,
  number INTEGER,
  disease_id VARCHAR(36),
  PRIMARY KEY (id),
  FOREIGN KEY (id)
    REFERENCES event(id)
    ON DELETE CASCADE,
  FOREIGN KEY (disease_id)
    REFERENCES disease(id)
    ON DELETE SET NULL
);

CREATE TABLE harvest (
  id VARCHAR(36) NOT NULL,
  quantity DOUBLE,
  unit_id VARCHAR(36),
  PRIMARY KEY (id),
  FOREIGN KEY (id)
    REFERENCES event(id)
    ON DELETE CASCADE,
  FOREIGN KEY (unit_id)
    REFERENCES unit(id)
    ON DELETE SET NULL
);

CREATE TABLE pest_attack (
  id VARCHAR(36) NOT NULL,
  pest_id VARCHAR(36),
  PRIMARY KEY (id),
  FOREIGN KEY (id)
    REFERENCES event(id)
    ON DELETE CASCADE,
  FOREIGN KEY (pest_id)
    REFERENCES pest(id)
    ON DELETE SET NULL
);

CREATE TABLE sow (
  id VARCHAR(36) NOT NULL,
  x DOUBLE,
  y DOUBLE,
  width DOUBLE,
  height DOUBLE,
  seeds INTEGER,
  cultivated_area_id VARCHAR(36),
  PRIMARY KEY (id),
  FOREIGN KEY (id)
    REFERENCES event(id)
    ON DELETE CASCADE,
  FOREIGN KEY (cultivated_area_id)
    REFERENCES cultivated_area(id)
    ON DELETE SET NULL
);

CREATE TABLE transplant (
  id VARCHAR(36) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id)
    REFERENCES event(id)
    ON DELETE CASCADE
);
