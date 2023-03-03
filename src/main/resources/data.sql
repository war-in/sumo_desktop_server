INSERT into COMPETITION_TYPES (type) values ('European Championships');
INSERT into COMPETITION_TYPES (type) values ('European Cup');

INSERT into COMPETITIONS (competition_id, id_from_server, name, city, start_date, end_date, type) values (10, 10, 'Roland Cup', 'Brandenburg an der Havel', '2023-03-03', '2023-03-04', 'European Cup');

INSERT into SEXES (sex) values ('male');
INSERT into SEXES (sex) values ('female');

--Age categories
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (10, 'U21', '2001-01-01', '2004-12-31');
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (11, 'U23', '1999-01-01', '2004-12-31');
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (12, 'Senior', '1000-01-01', '2004-12-31');

--Categories

--W-Senior
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (50, 12, '50 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (51, 12, '55 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (52, 12, '60 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (53, 12, '65 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (54, 12, '73 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (55, 12, '80 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (56, 12, '+80 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (57, 12, 'OPEN', 'female');

--M-Senior
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (58, 12, '70 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (59, 12, '77 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (60, 12, '85 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (61, 12, '92 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (62, 12, '100 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (63, 12, '115 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (64, 12, '+115 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (65, 12, 'OPEN', 'male');


--Senior
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (50, 10, 50, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (51, 10, 51, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (52, 10, 52, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (53, 10, 53, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (54, 10, 54, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (55, 10, 55, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (56, 10, 56, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (57, 10, 57, '2022-08-31');

INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (58, 10, 58, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (59, 10, 59, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (60, 10, 60, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (61, 10, 61, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (62, 10, 62, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (63, 10, 63, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (64, 10, 64, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (65, 10, 65, '2022-08-31');


INSERT into REGIONS (region) values ( 'EUROPE' );

INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (1, 5, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (8, 8, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (9, 16, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (2, 5, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (3, 10, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (4, 32, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (5, 64, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (6, 0, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (7, 8, 'EUROPE');

INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (1,10,12,1,20);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (2,10,12,2,15);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (3,10,12,3,10);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (4,10,12,4,5);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (5,10,12,5,5);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (100, 'Ivancsics', 'Babita', null, null, '2003-04-17', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (100, 100, 0, 'HUNGARY');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (100, 51, 100);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (101, 'Krystek ', 'Zuzanna', null, null, '2003-11-2', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (101, 101, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (101, 56, 101);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (102, 'ZajÄ…c', 'Wioleta', null, null, '1988-10-10', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (102, 102, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (102, 56, 102);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (103, 'Grygiel', 'Aleksandra', null, null, '1993-4-22', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (103, 103, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (103, 55, 103);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (104, 'Glegolska ', 'Oliwia', null, null, '2004-11-10', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (104, 104, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (104, 55, 104);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (105, 'Skiba', 'Monika', null, null, '1988-8-4', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (105, 105, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (105, 55, 105);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (106, 'Rozum', 'Aleksandra', null, null, '1998-4-7', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (106, 106, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (106, 53, 106);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (107, 'Marczak', 'Karolina', null, null, '2001-7-8', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (107, 107, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (107, 51, 107);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (108, 'Pieprzak ', 'Klaudia', null, null, '1998-3-17', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (108, 108, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (108, 51, 108);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (109, 'Baljer', 'RoxÃ¡na', null, null, '2004-12-22', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (109, 109, 0, 'HUNGARY');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (109, 53, 109);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (110, 'Hristova', 'Izabel', null, null, '1998-2-27', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (110, 110, 0, 'BULGARIA');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (110, 53, 110);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (111, 'Kose', 'Luca-Leoni', null, null, '2004-9-7', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (111, 111, 0, 'GERMANY');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (111, 53, 111);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (112, 'Zuckschwerdt', 'Marie-Luis', null, null, '2005-4-27', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (112, 112, 0, 'GERMANY');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (112, 56, 112);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (113, 'Raack', 'Emely', null, null, '2005-4-27', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (113, 113, 0, 'GERMANY');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (113, 56, 113);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (114, 'Sabardak', 'Viktoriia', null, null, '1995-11-18', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (114, 114, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (114, 51, 114);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (115, 'Grebenchiuk', 'Iryna', null, null, '2004-5-18', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (115, 115, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (115, 53, 115);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (116, 'Nikitinska', 'Olena', null, null, '2002-10-5', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (116, 116, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (116, 53, 116);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (117, 'Bordinskykh', 'Sofiia ', null, null, '2003-7-9', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (117, 117, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (117, 53, 117);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (118, 'Ruzhanska', 'Viktoriia', null, null, '2006-7-18', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (118, 118, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (118, 54, 118);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (119, 'Tereshonok', 'Veronika', null, null, '2005-7-19', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (119, 119, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (119, 54, 119);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (120, 'Karachenko', 'Tetiana', null, null, '1994-4-23', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (120, 120, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (120, 54, 120);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (121, 'Sokha', 'Tetiana', null, null, '2003-3-3', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (121, 121, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (121, 55, 121);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (122, 'Dubova', 'Anastasiia', null, null, '1991-6-23', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (122, 122, 0, 'UKRAINE');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (122, 56, 122);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (123, 'CzyÅ¼ewska', 'Gabriela', null, null, '2005-4-14', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (123, 123, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (123, 53, 123);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (124, 'SmaczyÅ„ska', 'Weronika', null, null, '2005-4-6', 'female');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (124, 124, 0, 'POLAND');
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (124, 54, 124);