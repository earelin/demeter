CREATE TABLE disease (
  id BIGINT NOT NULL,
  name VARCHAR(64),
  description ${text-datatype},
  PRIMARY KEY (id)
);

CREATE TABLE family (
  id VARCHAR(36) NOT NULL,
  name VARCHAR(64),
  PRIMARY KEY (id)
);

CREATE TABLE plant (
  id BIGINT NOT NULL,
  name VARCHAR(64),
  binomial_name VARCHAR(64),
  description ${text-datatype},
  separation INT,
  germination_days INT,
  germination_months INT,
  germination_years INT,
  maturity_days INT,
  maturity_months INT,
  maturity_years INT,
  lifespan_days INT,
  lifespan_months INT,
  lifespan_years INT,
  family_id VARCHAR(36) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (family_id)
    REFERENCES family(id)
    ON DELETE CASCADE
);

CREATE TABLE plant_friends (
  plant_a_id BIGINT NOT NULL,
  plant_b_id BIGINT NOT NULL,
  PRIMARY KEY (plant_a_id, plant_b_id),
  FOREIGN KEY (plant_a_id)
    REFERENCES plant(id)
    ON DELETE CASCADE,
  FOREIGN KEY (plant_b_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE plant_foes (
  plant_a_id BIGINT NOT NULL,
  plant_b_id BIGINT NOT NULL,
  PRIMARY KEY (plant_a_id, plant_b_id),
  FOREIGN KEY (plant_a_id)
    REFERENCES plant(id)
    ON DELETE CASCADE,
  FOREIGN KEY (plant_b_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE plant_sow (
  plant_id BIGINT NOT NULL,
  start_day INT,
  start_month INT,
  end_day INT,
  end_month INT,
  FOREIGN KEY (plant_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE plant_harvest (
  plant_id BIGINT NOT NULL,
  start_day INT,
  start_month INT,
  end_day INT,
  end_month INT,
  FOREIGN KEY (plant_id)
    REFERENCES plant(id)
    ON DELETE CASCADE
);

CREATE TABLE cultivar (
  id BIGINT NOT NULL,
  name VARCHAR(64),
  description ${text-datatype},
  separation INT,
  plant_id BIGINT NOT NULL,
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
  cultivar_id BIGINT NOT NULL,
  start_day INT,
  start_month INT,
  end_day INT,
  end_month INT,
  FOREIGN KEY (cultivar_id)
    REFERENCES cultivar(id)
    ON DELETE CASCADE
);

CREATE TABLE cultivar_harvest (
  cultivar_id BIGINT NOT NULL,
  start_day INT,
  start_month INT,
  end_day INT,
  end_month INT,
  FOREIGN KEY (cultivar_id)
    REFERENCES cultivar(id)
    ON DELETE CASCADE
);

CREATE TABLE crop (
  id BIGINT NOT NULL,
  label VARCHAR(128),
  notes ${text-datatype},
  cultivar_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cultivar_id)
    REFERENCES cultivar(id)
    ON DELETE CASCADE
);

CREATE TABLE cultivated_area (
  id BIGINT NOT NULL,
  name VARCHAR(64) NOT NULL,
  description ${text-datatype},
  height DOUBLE,
  width DOUBLE,
  PRIMARY KEY (id)
);

CREATE TABLE event (
  id BIGINT NOT NULL,
  crop_id BIGINT NOT NULL,
  date DATE,
  label VARCHAR(64),
  notes ${text-datatype},
  PRIMARY KEY (id),
  FOREIGN KEY (crop_id)
    REFERENCES crop(id)
    ON DELETE CASCADE
);
