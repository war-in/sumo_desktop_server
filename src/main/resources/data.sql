INSERT into COMPETITION_TYPES (type) values ('European Championships');

INSERT into COMPETITIONS (competition_id, id_from_server, name, city, start_date, end_date, type) values (1, 1, 'European Championships Warszawa', 'Warszawa', '2022-07-18', '2022-07-20', 'European Championships');

INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (1, 'Senior', '2000-01-01', '2002-12-31');
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (2, 'Młodzik', '2003-01-01', '2005-12-31');

INSERT into SEXES (sex) values ('male');
INSERT into SEXES (sex) values ('female');

INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (1, 1, 'open', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (2, 2, '90', 'female');

INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (1, 1, 1, '2022-07-19');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (2, 1, 2, '2022-07-19');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (0, 'Free', 'Fight', null, null, null, null);
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (1, 'Marcin', 'Warchoł', '727731521', '1.jpg', '2000-09-02', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (2, 'Gabriela', 'Erazmus', '727731521', '2.jpg', '2004-05-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (3, 'Anna', 'Kowalska', '727731521', '2.jpg', '2004-07-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (4, 'Barbara', 'Nowak', '727731521', '2.jpg', '2004-08-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (5, 'Zofia', 'War', '727731521', '2.jpg', '2004-09-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (6, 'Karolina', 'Opal', '727731521', '2.jpg', '2004-01-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (7, 'Zuzanna', 'Loker', '727731521', '2.jpg', '2004-02-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (8, 'Katarzyna', 'Parun', '727731521', '2.jpg', '2004-03-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (9, 'Jolanta', 'Wena', '727731521', '2.jpg', '2004-04-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (10, 'Joanna', 'Waga', '727731521', '2.jpg', '2004-06-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (11, 'Aleksandra', 'Lora', '727731521', '2.jpg', '2004-04-08', 'female');

INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (0, 0, 0, 'Free Fight');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (1, 1, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (2, 2, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (3, 3, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (4, 4, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (5, 5, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (6, 6, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (7, 7, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (8, 8, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (9, 9, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (10, 10, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (11, 11, 0, 'Poland');

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (1, 1, 1);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (2, 2, 2);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (3, 2, 3);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (4, 2, 4);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (5, 2, 5);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (6, 2, 6);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (7, 2, 7);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (8, 2, 8);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (9, 2, 9);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (10, 2, 10);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (11, 2, 11);

INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (1, 1, 67.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (2, 2, 55.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (3, 3, 55.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (4, 4, 59.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (5, 5, 54.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (6, 6, 52.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (7, 7, 55.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (8, 8, 58.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (9, 9, 55.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (10, 10, 55.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (11, 11, 55.0, '2022-07-19');

INSERT into REGIONS (region) values ( 'EUROPE' );

INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (1, 16, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (2, 5, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (3, 10, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (4, 32, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (5, 64, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (6, 0, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (7, 8, 'EUROPE');


--Competition
INSERT into COMPETITIONS (competition_id, id_from_server, name, city, start_date, end_date, type) values (10, 10, 'EUROPEAN SUMO CHAMPIONSHIPS 2022', 'Krotoszyn', '2022-08-31', '2022-09-4', 'European Championships');

--Age categories
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (10, 'U21', '2001-01-01', '2004-12-31');
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (11, 'U23', '1999-01-01', '2004-12-31');
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (12, 'Senior', '1000-01-01', '2004-12-31');

--Categories

--W-U21
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (10, 10, '50 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (11, 10, '55 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (12, 10, '60 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (13, 10, '65 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (14, 10, '73 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (15, 10, '80 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (16, 10, '+80 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (17, 10, 'OPEN', 'female');

--M-U21
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (18, 10, '70 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (19, 10, '77 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (20, 10, '85 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (21, 10, '92 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (22, 10, '100 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (23, 10, '115 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (24, 10, '+115 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (25, 10, 'OPEN', 'male');

--W-U23
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (30, 11, '50 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (31, 11, '55 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (32, 11, '60 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (33, 11, '65 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (34, 11, '73 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (35, 11, '80 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (36, 11, '+80 kg', 'female');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (37, 11, 'OPEN', 'female');

--M-U23
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (38, 11, '70 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (39, 11, '77 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (40, 11, '85 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (41, 11, '92 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (42, 11, '100 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (43, 11, '115 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (44, 11, '+115 kg', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (45, 11, 'OPEN', 'male');

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

--CategoriesAtCompetition

--U21
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (10, 10, 10, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (11, 10, 11, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (12, 10, 12, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (13, 10, 13, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (14, 10, 14, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (15, 10, 15, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (16, 10, 16, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (17, 10, 17, '2022-08-31');

INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (18, 10, 18, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (19, 10, 19, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (20, 10, 20, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (21, 10, 21, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (22, 10, 22, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (23, 10, 23, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (24, 10, 24, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (25, 10, 25, '2022-08-31');

--U23
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (30, 10, 30, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (31, 10, 31, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (32, 10, 32, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (33, 10, 33, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (34, 10, 34, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (35, 10, 35, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (36, 10, 36, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (37, 10, 37, '2022-08-31');

INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (38, 10, 38, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (39, 10, 39, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (40, 10, 40, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (41, 10, 41, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (42, 10, 42, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (43, 10, 43, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (44, 10, 44, '2022-08-31');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (45, 10, 45, '2022-08-31');

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


--Great Britain
--PersonalDetails
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (20, 'Adam', 'Lloyd', null, '2.jpg', '1985-07-26', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (21, 'Sonny', 'Bell', null, '2.jpg', '2002-12-22', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (22, 'Mandeep Singh', 'Kundi', null, '2.jpg', '1981-06-16', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (23, 'Courtney', 'Pflasterer', null, '2.jpg', '1992-08-07', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (24, 'Ryan', 'Wood', null, '2.jpg', '1996-08-01', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (20, 20, 0, 'Great Britain');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (21, 21, 0, 'Great Britain');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (22, 22, 0, 'Great Britain');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (23, 23, 0, 'Great Britain');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (24, 24, 0, 'Great Britain');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 20);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (21, 62, 21);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (22, 64, 22);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (23, 65, 22);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (24, 64, 23);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (25, 65, 24);






