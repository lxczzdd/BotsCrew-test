USE botscrew;
INSERT INTO degrees (id, name) VALUES (1, 'assistant');
INSERT INTO degrees (id, name) VALUES (2, 'associate professor');
INSERT INTO degrees (id, name) VALUES (3, 'professor');
INSERT INTO lectors (name, salary, degree_id) VALUES ('Lector1', 2000, 1);
INSERT INTO lectors (name, salary, degree_id) VALUES ('Lector2', 5000, 2);
INSERT INTO departments (name) VALUES ('Department1');
INSERT INTO departments (name) VALUES ('Department2');
INSERT INTO departments (name) VALUES ('Department31');
INSERT INTO departments (name) VALUES ('Bibartment');
INSERT INTO departments_lectors (lectors_id, department_id) VALUES (1, 1);
INSERT INTO departments_lectors (lectors_id, department_id) VALUES (2, 1);


