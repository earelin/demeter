CREATE TABLE family (
  id BIGINT NOT NULL,
  name VARCHAR(64),
  PRIMARY KEY (id)
);

CREATE TABLE plant (
  id BIGINT NOT NULL,
  name VARCHAR(64),
  binomial_name VARCHAR(64),
  separation INT,
  family_id INT NOT NULL,
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

CREATE TABLE cultivar (
  id BIGINT NOT NULL,
  name VARCHAR(64),
  description TEXT,
  plant_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (plant_id)
    REFERENCES Plant(id)
    ON DELETE CASCADE
);
