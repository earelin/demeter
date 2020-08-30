INSERT INTO family (id, name)
VALUES
  ('5dc40f68-7dcf-4512-89ac-84bfd47c3faa', 'Amaryllidaceae'),
  ('f3f1a2d4-7cfe-4bde-a0a8-5d103f5fcdf3', 'Solanaeae'),
  ('900d6092-d44d-40ac-a33c-31f2b9b3263d', 'Brassicaceae');

INSERT INTO plant (id, name, binomial_name, family_id)
VALUES
  ('e2052738-646a-4777-bb8f-918a5f20adfa', 'Garlic', 'Allium sativum', '5dc40f68-7dcf-4512-89ac-84bfd47c3faa'),
  ('68ce75d2-ec9d-4a47-9d5e-98ea99c7f1e8', 'Onion', 'Allium cepa', '5dc40f68-7dcf-4512-89ac-84bfd47c3faa'),
  ('07021d3c-e284-44fd-8967-d22bf33a1085', 'Tomato', 'Solanum lycopersicum', 'f3f1a2d4-7cfe-4bde-a0a8-5d103f5fcdf3'),
  ('40c5c40c-0798-4e1b-a375-07c5b574790d', 'Cabagge', 'Brassica Oleracea', '900d6092-d44d-40ac-a33c-31f2b9b3263d');

INSERT INTO cultivar (id, name, description, plant_id)
VALUES
  ('8b12796e-4e80-40b0-875f-88625337ab9c', 'Crimson Crush', NULL, '07021d3c-e284-44fd-8967-d22bf33a1085'),
  ('3ee38e34-77e6-473d-a4b1-1642cfcf89b3', 'Sweet Aperitif', NULL, '07021d3c-e284-44fd-8967-d22bf33a1085'),
  ('fce6dade-9330-47c8-86c9-bf9d599d6f04', 'Dutchman', NULL, '40c5c40c-0798-4e1b-a375-07c5b574790d');
