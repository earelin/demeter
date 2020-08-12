INSERT INTO family (id, name)
VALUES
  (1, 'Amaryllidaceae'),
  (2, 'Solanaeae'),
  (3, 'Brassicaceae');

INSERT INTO plant (id, name, binomial_name, separation, family_id)
VALUES
  (1, 'Garlic', 'Allium sativum', NULL, 1),
  (2, 'Onion', 'Allium cepa', NULL, 1),
  (3, 'Tomato', 'Solanum lycopersicum', 30, 2);

INSERT INTO cultivar (id, name, description, plant_id)
VALUES
  (1, 'Crimson Crush', NULL, 3),
  (2, 'Sweet Aperitif', NULL, 3);
