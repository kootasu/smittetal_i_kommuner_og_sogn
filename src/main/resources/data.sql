INSERT INTO commune (commune_Code, name, incidence) VALUES (630, 'Vejle', 73.65);
INSERT INTO commune (commune_Code, name, incidence) VALUES (851, 'Aalborg', 165.54);
INSERT INTO commune (commune_Code, name, incidence) VALUES (230, 'Rudersdal', 139.50);
INSERT INTO commune (commune_Code, name, incidence) VALUES (820, 'Vesthimmerlands', 89.15);
INSERT INTO commune (commune_Code, name, incidence) VALUES (760, 'Ringkøbing-Skjern', 42.91);

INSERT INTO parish (parish_Code, name, incidence, is_Shut_Down, shutdown_Date, commune_Code) VALUES (7975, 'Givskud', 1150.37, true, '2021-06-03', 630);
INSERT INTO parish (parish_Code, name, incidence, is_Shut_Down, commune_Code) VALUES (7985, 'Lindeballe', 1414.14, false, 630);