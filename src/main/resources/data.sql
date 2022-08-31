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
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (20, 'Adam', 'Lloyd', null, 'mr. adam lloyd.jpg', '1985-07-26', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (21, 'Sonny', 'Bell', null, 'mr. sonny bell.jpg', '2002-12-22', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (22, 'Mandeep Singh', 'Kundi', null, 'mr. mandeep singh kundi.jpg', '1981-06-16', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (23, 'Courtney', 'Pflasterer', null, 'mr. courtney pflasterer.jpg', '1992-08-07', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (24, 'Ryan', 'Wood', null, 'mr. ryan john  wood.jpg', '1996-08-01', 'male');

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


--Italy
--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (30, 'Arianna', 'Vettori', null, 'VETTORI Arianna Photo.jpg', '1999-06-14', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (31, 'Giovanni', 'Sanzone', null, 'SANZONE Giovanni Photo.jpg', '2000-06-09', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (32, 'Giovanni', 'Galimberti', null, 'GALIMBERTI Giovanni Photo.jpg', '2000-08-30', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (33, 'Giulia', 'Meinardi', null, 'MEINARDI Giulia Photo.png', '1990-07-19', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (34, 'Maria', 'Bertola', null, 'BERTOLA Maria Photo.jpg', '1985-12-24', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (35, 'Fausto', 'Gobbi', null, 'GOBBI Fausto Emilio Photo.jpg', '1972-07-08', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (30, 30, 0, 'Italy');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (31, 31, 0, 'Italy');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (32, 32, 0, 'Italy');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (33, 33, 0, 'Italy');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (34, 34, 0, 'Italy');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (35, 35, 0, 'Italy');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 30);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 38, 31);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 32);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 33);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 34);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 31);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 32);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 35);


--Hungary
--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (40, 'Roxána', 'Baljer', null, 'Baljer_Roxana_Picture.jpg', '2004-12-22', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (41, 'Enikő', 'Elekes', null, 'Elekes Enikő_Photo.jpg', '2004-11-27', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (42, 'Zoltán', 'Mráz', null, 'Mráz Zoltán_Photo.png', '2004-10-14', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (43, 'Ádám Attila', 'Buzsi', null, 'Adam_Buzsi_Photo.jpeg', '2002-11-16', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (44, 'Kende', 'Márai', null, 'Márai Kende_Photo.jpg', '2003-09-14', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (45, 'Dominik Bendegúz', 'Bereczki', null, 'Bereczki Dominik_Photo.jpg', '2004-12-19', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (46, 'Erik Márk', 'Szilágyi', null, 'Szilagyi_Erik_Mark_Photo.jpg', '2001-02-02', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (47, 'Balázs', 'Berregi', null, 'Berregi Balázs Photo.jpg', '2003-03-17', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (48, 'Péter', 'Zsivnovszky ', null, 'Zsivnovszky Péter_Photo.jpg', '2005-02-06', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (49, 'Marcell', 'Gyuricza', null, 'Gyuricza Marcell_Photo.jpg', '2005-10-11', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (50, 'Dávid', 'Kotricz', null, 'blank.jpg', '2002-09-16', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (51, 'Artúr', 'Végh', null, 'Végh_Artúr_Photo.jpg', '2001-08-15', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (52, 'Bertold Boldizsár', 'Barnóczki ', null, 'blank.jpg', '2004-01-16', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (53, 'Mike', 'Berta', null, 'Berta Mike_Photo.jpg', '2000-10-15', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (54, 'Patrik', 'Buzás ', null, 'Buzas_Patrik_Photo.jpg', '1999-07-14', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (55, 'Benedek Vajk', 'Laczkó ', null, 'Lackó Benedek_Photo.jpg', '2000-04-27', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (57, 'Piroska', 'Rónáné Kalmár ', null, 'blank.jpg', '1987-06-02', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (58, 'Tamás', 'Molnár', null, 'Molnár_Tamás_Photo.jpg', '1998-03-04', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (59, 'Arnold', 'Pap', null, 'Pap_Arnold_Photo.jpg', '1993-03-28', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (40, 40, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (41, 41, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (42, 42, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (43, 43, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (44, 44, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (45, 45, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (46, 46, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (47, 47, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (48, 48, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (49, 49, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (50, 50, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (51, 51, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (52, 52, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (53, 53, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (54, 54, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (55, 55, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (57, 57, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (58, 58, 0, 'Hungary');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (59, 59, 0, 'Hungary');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 40);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 41);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 18, 42);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 18, 43);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 19, 45);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 44);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 46);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 47);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 48);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 22, 49);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 23, 50);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 24, 51);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 24, 52);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 25, 46);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 25, 52);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 40);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 41);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 38, 53);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 38, 42);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 39, 45);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 54);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 46);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 47);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 44);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 42, 55);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 43, 50);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 43, 49);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 52);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 52, 57);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 40);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 53);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 54);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 46);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 47);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 55);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 50);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 58);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 59);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 51);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 65, 59);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 65, 58);


--Norway

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (60, 'Othelie Annette', 'Høie', null, 'Othelie Høie.jpg', '2002-12-09', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (61, 'Kornelius', 'Haraldsen', null, 'Kornelius Haraldsen.jpg', '2003-12-17', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (62, 'Ramona', 'Eriksen', null, 'Ramona Eriksen.jpg', '1996-10-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (63, 'Liz Hjelle  ', 'Jenssen', null, 'Liz Jenssen.jpg', '1978-12-12', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (64, 'Sofie Elisabeth Lizzie', 'Jörgensen', null, 'Jorgensen, Sofie.jpg', '1988-01-30', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (65, 'Pernille Rojahn', 'Oddlien', null, 'IFS_Picture_Pernille_Oddlien.jpg', '1988-02-02', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (66, 'Erik Enger', 'Bjørgen', null, 'Erik Bjørgen.jpg', '1994-10-15', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (67, 'Steffen', 'Larsen', null, 'Steffen Larsen – Kopi.jpeg', '1995-03-23', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (68, 'Truls Alfheim', 'Thue', null, 'Truls Thue.jpg', '1997-01-17', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (69, 'Kim Erik Valentin ', 'Svensson', null, 'IFS_Picture_KimErik_Svensson.jpg', '1992-07-21', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (70, 'Joakim Sandberg ', 'Rusvik', null, 'Rusvik, Joakim.jpg', '1993-11-27', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (71, 'Sigmund Røtnes', 'Widerberg', null, 'Sigmund Widerberg.jpeg', '1991-05-28', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (72, 'Simen Nordlie', 'Kristensen', null, 'Simen Kristensen.jpg', '1978-05-29', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (60, 60, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (61, 61, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (62, 62, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (63, 63, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (64, 64, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (65, 65, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (66, 66, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (67, 67, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (68, 68, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (69, 69, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (70, 70, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (71, 71, 0, 'Norway');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (72, 72, 0, 'Norway');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 12, 60);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 61);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 60);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 61);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 50, 62);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 51, 63);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 52, 60);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 64);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 65);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 66);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 67);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 68);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 69);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 70);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 71);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 72);


--Germany

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (80, 'Luca Leoni', 'Kose', null, 'Picture_GER_Luca_Leoni_Kose.jpg', '2004-09-07', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (81, 'Emely', 'Raack', null, 'blank.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (82, 'Marie-Luis', 'Zuckschwerdt', null, 'Picture_GER_Marie-LuisZuckschwerdt_jpg.jpg', '2005-04-27', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (83, 'Fynn', 'Bathe', null, 'blank.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (84, 'Stephanie', 'Steinmetz', null, 'blank.jpg', '1988-10-19', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (85, 'Daniela', 'Schmidtsdorf', null, 'blank.jpg', '1976-10-15', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (86, 'Kerstin', 'Schmidtsdorf', null, 'blank.jpg', '1977-10-16', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (87, 'Johanna', 'Schumann', null, 'blank.jpg', '1977-10-16', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (88, 'Mohammad', 'Alhasbani', null, 'blank.jpg', '1977-10-16', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (89, 'Darius', 'Mayek', null, 'blank.jpg', '1977-10-16', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (90, 'Jörg', 'Frischmann', null, 'GER_Picture,Frischmann,J”rg.jpg', '1981-08-28', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (91, 'Andreas', 'Hoffmann', null, 'blank.jpg', '1981-08-28', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (80, 80, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (81, 81, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (82, 82, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (83, 83, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (84, 84, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (85, 85, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (86, 86, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (87, 87, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (88, 88, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (89, 89, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (90, 90, 0, 'Germany');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (91, 91, 0, 'Germany');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 80);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 16, 81);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 16, 82);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 17, 81);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 17, 82);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 83);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 80);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 81);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 82);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 37, 81);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 37, 82);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 83);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 80);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 84);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 54, 85);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 86);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 87);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 81);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 82);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 57, 81);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 57, 81);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 88);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 89);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 89);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 90);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 91);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 65, 90);


--GEORGIA

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (100, 'ANI ', 'MOTSIKULASHVILI', null, 'ANA MOTSIKULASHVILI.jpg', '2002-12-03', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (101, 'NINO ', 'SIMONISHVILI', null, 'NINO SIMONISHVILI.jpg', '2001-08-16', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (102, 'GURAMI ', 'KIBORDZALIDZE', null, 'GURAMI KIBORDZALIDZE.jpeg', '2003-05-28', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (103, 'AKUBARDIA ', 'SABA', null, 'SABA AKUBARDIA.jpeg', '2003-09-30', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (104, 'SABA ', 'GAMTENADZE', null, 'SABA GAMTENADZE.jpg', '2002-09-15', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (105, 'ZURA', 'TSIKORADZE', null, 'ZURA TSIKORADZE.jpg', '2001-06-22', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (106, 'ANRI', 'MTCHEDLIDZE', null, 'ANRI MTCHEDLIDZE.jpg', '1999-01-17', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (107, 'BADRI ', 'KHATISKATSI', null, 'BADRI KHATISKATSI.jpg', '1999-01-09', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (108, 'KOBA ', 'MALAKMADZE', null, 'KOBA MALAKMADZE.jpg', '1998-10-27', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (109, 'LASHA  ', 'JELADZE', null, 'LASHA JELADZE.jpg', '1996-12-07', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (100, 100, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (101, 101, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (102, 102, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (103, 103, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (104, 104, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (105, 105, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (106, 106, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (107, 107, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (108, 108, 0, 'Georgia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (109, 109, 0, 'Georgia');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 12, 100);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 15, 101);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 17, 100);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 17, 101);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 102);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 103);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 22, 104);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 24, 105);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 25, 105);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 25, 104);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 100);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 101);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 37, 100);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 37, 100);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 102);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 106);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 42, 104);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 105);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 107);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 45, 105);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 45, 107);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 108);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 106);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 107);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 109);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 65, 107);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 65, 109);


--Greece

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (110, 'Georgios', 'Stavropoulos', null, 'Georgios Stavropoulos.jpg', '1980-07-04', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (111, 'Panagiotis', 'Varelas', null, 'Panagiotis Varelas.jpg', '1999-04-15', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (112, 'Marina', 'Papadopoulou', null, 'Marina Papadopoulou.jpg', '2005-05-09', 'female');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (110, 110, 0, 'Greece');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (111, 111, 0, 'Greece');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (112, 112, 0, 'Greece');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 112);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 112);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 112);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 111);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 111);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 110);


--Estonia

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (120, 'NELE', 'NISUMAA', null, 'Nele Nisumaa.jpg', '2001-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (121, 'KÄROLIN', 'TAMMRE', null, 'K„rolin Tammre.jpeg', '2005-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (122, 'KAI', 'PÄHKEL', null, 'Kai P„hkel.jpeg', '2001-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (123, 'MARIETTE', 'LIIGEND', null, 'Mariette Liigend.jpg', '2005-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (124, 'KARLIS', 'BOLLVERK', null, 'blank.jpg', '2005-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (125, 'ROBYN', 'PAULBERG', null, 'blank.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (126, 'ROMEL', 'SEEMANN', null, 'Romel Seemann.jpg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (127, 'KENNET', 'KÜNNARPUU', null, 'Kennet Konnarpuu.jpeg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (128, 'ALONSO', 'GONZALEZ MARGALEF', null, 'Alonso Gonzalez Margalef.jpg', '2005-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (129, 'OLAVI', 'REILENT', null, 'Olavi Reilet.jpg', '2005-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (130, 'XSANDER', 'SOLBAJA', null, 'Xsander Solbaja.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (131, 'GREETE', 'KÕNNUSAAR', null, 'Grete Kõnnusaar.jpg', '1999-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (132, 'IVAN', 'NOVITSKI', null, 'Ivan Novitski (2).jpg', '1987-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (133, 'INDREK', 'LÜISTE', null, 'blank.jpg', '1991-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (134, 'RAIDO', 'LIITMÄE', null, 'blank.jpg', '1994-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (135, 'GERRITH', 'PUNGAS', null, 'Gerrith Pungas.png', '1995-01-01', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (120, 120, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (121, 121, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (122, 122, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (123, 123, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (124, 124, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (125, 125, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (126, 126, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (127, 127, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (128, 128, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (129, 129, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (130, 130, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (131, 131, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (132, 132, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (133, 133, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (134, 134, 0, 'Estonia');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (135, 135, 0, 'Estonia');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 11, 120);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 15, 121);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 16, 122);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 16, 123);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 17, 122);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 17, 121);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 124);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 125);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 126);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 22, 127);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 23, 128);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 24, 129);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 24, 130);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 25, 129);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 25, 130);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 31, 120);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 34, 131);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 121);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 122);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 123);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 37, 122);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 37, 123);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 124);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 125);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 126);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 42, 127);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 43, 128);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 129);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 130);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 45, 129);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 45, 130);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 51, 120);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 54, 131);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 121);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 123);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 132);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 133);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 125);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 134);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 126);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 127);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 135);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 128);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 130);


--Azerbaijan

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (140, 'Konul', 'Abdullayeva', null, '1 (1).jpg', '2003-11-22', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (141, 'Nigar', 'Haciramazanova', null, 'blank.jpg', '2000-08-22', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (142, 'Hasan', 'Aghazada', null, '11 (1).jpg', '2000-11-17', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (143, 'Jamal', 'Feyziyev', null, '9 (1).jpg', '2000-06-17', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (144, 'Khayyam', 'Abdullayev', null, '5.jpg', '1994-05-03', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (145, 'Royal', 'Aghamaliyev', null, '3 (1).jpg', '1998-11-26', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (146, 'Javid', 'Mustafayev', null, '10 (1).jpg', '1997-10-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (147, 'Tunjay', 'Vazirzade', null, 'blank.jpg', '1997-10-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (148, 'Chingiz', 'Samadov', null, 'blank.jpg', '1996-05-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (149, 'Sadig', 'Aghamaliyev', null, '4 (1).jpg', '1996-08-28', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (140, 140, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (141, 141, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (142, 142, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (143, 143, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (144, 144, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (145, 145, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (146, 146, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (147, 147, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (148, 148, 0, 'Azerbaijan');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (149, 149, 0, 'Azerbaijan');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 140);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 30, 141);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 140);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 38, 142);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 143);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 45, 143);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 144);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 142);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 145);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 146);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 147);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 148);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 149);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 143);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 65, 143);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 50, 141);


--Ukraine

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (150, 'Iryna', 'DOROSHENKO', null, 'DOROSHENKO Iryna - athlete.jpg', '2002-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (151, 'Sofiia', 'KUSHNIR', null, 'KUSHNIR Sofiia - athlete.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (152, 'Andriana', 'ANTONIUV', null, 'ANTONIUV Andriana - athlete.jpeg', '2001-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (153, 'Kateryna', 'PALII', null, 'PALII Kateryna - athlete.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (154, 'Olena', 'NIKITINSKA', null, 'NIKITINSKA Olena - athlete.jpg', '2002-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (155, 'Yuliia', 'TOLMACHOVA', null, 'TOLMACHOVA Yuliia - athlete.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (156, 'Iryna', 'HREBENCHUK', null, 'HREBENCHUK Iryna - athlete.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (157, 'Anna', 'POSHTAR', null, 'POSHTAR Anna - athlete.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (158, 'Tetiana', 'SOKHA', null, 'SOKHA Tetiana - athlete.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (159, 'Anna', 'FOMITSKA', null, 'FOMITSKA Anna - athlete.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (160, 'Marharyta', 'BIELKOVA', null, 'BIELKOVA Marharyta - athlete.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (161, 'Yelyzaveta', 'MORENKO', null, 'MORENKO Yelyzaveta - athlete.jpg', '2002-01-01', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (162, 'Kyrylo', 'KRUPSKYI', null, 'KRUPSKYI Kiril - athlete.jpg', '2004-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (163, 'Askold', 'BYSTROV', null, 'BYSTROV Askold - athlete.jpg', '2004-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (164, 'Yehor', 'KRUPSKYI', null, 'KRUPSKYI Yehor - athlete.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (165, 'Tymur', 'SAMEDOV', null, 'blank.jpg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (166, 'Vladyslav', 'MILKOVSKYI', null, 'MILKOVSKYI Vladyslav - athlete.jpg', '2002-01-01', 'male');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (167, 'Sofiia', 'BORDINSKYKH', null, 'BORDINSKYKH Sofiia - athlete.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (168, 'Karyna', 'KOLESNIK', null, 'KOLESNIK Karyna - athlete.jpg', '2000-01-01', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (169, 'Volodymyr', 'BILOVTSOV', null, 'BILOVTSOV Volodymyr - athlete.jpg', '1999-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (170, 'Vazha', 'DAIAURI', null, 'DAIAURI Vazha - athlete.jpg', '1999-01-01', 'male');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (171, 'Viktoriia', 'SABARDAK', null, 'SABARDAK Viktoriia - athlete.jpg', '1995-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (172, 'Anna', 'GAVRYSHCHIUK', null, 'blank.jpg', '2001-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (173, 'Yelyzaveta', 'PAVLICHENKO', null, 'PAVLICHENKO Yelyzaveta - athlete.png', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (174, 'Alina', 'BONDARIEVA', null, 'BONDARIEVA Alina - athlete.jpg', '1985-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (175, 'Maryna', 'MAKSYMENKO', null, 'MAKSYMENKO Maryna - athlete.jpg', '1988-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (176, 'Ivanna', 'BEREZOVSKA', null, 'BEREZOVSKA Ivanna - athlete.jpg', '1991-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (177, 'Svitlana', 'YAROMKA', null, 'YAROMKA Svitlana - athlete.JPG', '1989-01-01', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (178, 'Oleksandr', 'KOZYRIEV', null, 'KOZYRIEV Oleksandr - athlete.jpg', '1985-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (179, 'Sviatoslav', 'SEMYKRAS', null, 'SEMYKRAS Sviatoslav - athlete.jpg', '1997-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (180, 'Anatolii', 'KHLIUSTIN', null, 'KHLIUSTIN Anatolii - athlete.jpg', '1997-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (181, 'Anton', 'BURLACHENKO', null, 'BURLACHENKO Anton - athlete.jpg', '1993-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (182, 'Oleksandr', 'VERESIUK', null, 'VERESIUK Oleksandr -athlete.jpg', '1989-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (183, 'Ivan', 'SOROCHAN', null, 'SOROCHAN Ivan - athlete.jpg', '1992-01-01', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (150, 150, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (151, 151, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (152, 152, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (153, 153, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (154, 154, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (155, 155, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (156, 156, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (157, 157, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (158, 158, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (159, 159, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (160, 160, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (161, 161, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (162, 162, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (163, 163, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (164, 164, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (165, 165, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (166, 166, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (167, 167, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (168, 168, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (169, 169, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (170, 170, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (171, 171, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (172, 172, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (173, 173, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (174, 174, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (175, 175, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (176, 176, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (177, 177, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (178, 178, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (179, 179, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (180, 180, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (181, 181, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (182, 182, 0, 'Ukraine');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (183, 183, 0, 'Ukraine');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 10, 150);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 11, 151);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 12, 152);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 12, 153);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 154);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 155);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 14, 156);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 14, 157);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 15, 158);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 15, 159);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 16, 160);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 16, 161);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 19, 162);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 163);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 164);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 165);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 23, 166);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 30, 150);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 31, 151);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 152);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 153);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 154);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 167);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 34, 156);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 34, 157);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 168);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 159);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 160);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 161);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 39, 162);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 163);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 164);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 169);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 42, 165);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 43, 166);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 43, 170);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 50, 150);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 50, 171);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 51, 151);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 52, 172);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 52, 173);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 154);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 167);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 54, 164);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 54, 156);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 168);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 175);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 176);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 177);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 178);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 162);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 179);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 180);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 169);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 181);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 165);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 170);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 182);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 183);


--Bulgaria

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (190, 'Stefani', 'Veselinova', null, 'VESELINOVA,  STEFANI.jpg', '2003-05-22', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (191, 'Andrea', 'Georgieva', null, 'GEORGIEVA, ANDREA.jpg', '2003-06-15', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (192, 'Lyudmila', 'Yordanova', null, 'YORDANOVA,  LYUDMILA.jpg', '2001-04-25', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (193, 'Mihaela', 'Hristova', null, 'HRISTOVA, MIHAELA.jpg', '2002-08-01', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (194, 'Simeon', 'Penev', null, 'PENEV,  SIMEON.jpg', '2005-07-12', 'male');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (195, 'Teodora', 'Vasileva', null, 'VASILEVA,  TEODORA.jpg', '2000-08-17', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (196, 'Gabriela', 'Gigova', null, 'GIGOVA,  GABRIELA.jpg', '1995-04-29', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (197, 'Ivan', 'Panovski', null, 'PANOVSKI,  IVAN.jpg', '1994-09-18', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (198, 'Dimitar', 'Rangelov', null, 'RANGELOV,  DIMITAR.jpg', '1983-07-30', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (199, 'Atanas', 'Kolev', null, 'KOLEV, ATANAS.jpg', '1989-07-31', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (200, 'Presiyan', 'Mihov', null, 'MIHOV,  PRESIYAN.jpg', '1996-09-02', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (201, 'Pencho', 'Dochev', null, 'DOCHEV,  PENCHO.jpg', '1990-06-02', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (202, 'Dobromir', 'Dermendzhiev', null, 'DERMENDZHIEV,  DOBROMIR.jpg', '1987-06-20', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (203, 'Stilian', 'Ivanov', null, 'IVANOV,  STILIAN.jpg', '1997-08-30', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (204, 'Ivan', 'Blagoev', null, 'BLAGOEV,  IVAN.jpg', '1988-12-02', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (205, 'Mihail', 'Iliev', null, 'ILIEV,  MIHAIL.jpg', '1989-06-03', 'male');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (190, 190, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (191, 191, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (192, 192, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (193, 193, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (194, 194, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (195, 195, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (196, 196, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (197, 197, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (198, 198, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (199, 199, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (200, 200, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (201, 201, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (202, 202, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (203, 203, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (204, 204, 0, 'Bulgaria');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (205, 205, 0, 'Bulgaria');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 10, 190);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 11, 191);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 12, 192);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 13, 193);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 18, 194);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 31, 195);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 38, 194);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 50, 190);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 51, 191);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 51, 195);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 52, 192);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 193);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 196);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 197);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 198);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 199);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 200);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 201);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 202);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 203);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 204);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 205);


--Poland

--Personal Details
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (210, 'Daniel', 'Ziobroń', null, 'DANIEL ZIOBROŃ.jpg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (211, 'Paweł', 'Sikora', null, 'blank.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (212, 'Piotr', 'Sikora', null, 'PIOTR SIKORA.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (213, 'Jakub', 'Tworek', null, 'blank.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (214, 'Mikołaj', 'Mrowiński', null, 'IFS_Picture_Mrowinski_Mikolaj.jpg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (215, 'Dawid', 'Kuraś', null, 'DAWID KURAŚ.jpg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (216, 'Paweł', 'Puacz', null, 'PAWEŁ PUACZ.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (217, 'Adam', 'Fietz', null, 'blank.jpg', '2004-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (218, 'Sławomir', 'Ochał', null, 'SŁAWOMIR OCHAŁ .jpg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (219, 'Maciej', 'Nowakowski', null, 'MACIEJ NOWAKOWSKI.jpg', '2005-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (220, 'Jakub', 'Siuchta', null, 'JAKUB SIUCHTA.jpg', '2003-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (221, 'Sebastian', 'Warchoł', null, 'blank.jpg', '2005-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (222, 'Jakub', 'Micek', null, 'JAKUB MICEK.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (223, 'Aleksander', 'Gorący', null, 'blank.jpg', '2004-01-01', 'male');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (224, 'Marta', 'Gruszkiewicz', null, 'MARTA GRUSZKIEWICZ.jpg', '2002-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (225, 'Gabriela', 'Warchoł', null, 'GABRIELA WARCHOŁ.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (226, 'Eliza', 'Sobolewska', null, 'blank.jpg', '2006-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (227, 'Natalia', 'Koszewska', null, 'NATALIA KOSZEWSKA.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (228, 'Agata', 'Kucner', null, 'AGATA KUCNER.jpg', '2005-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (229, 'Wiktoria', 'Żebrowska', null, 'blank.jpg', '2005-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (230, 'Julia', 'Piwowarska', null, 'JULIA PIWOWARSKA - PO LEWEJ CZARNE DŁUGIE WŁOSY.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (231, 'Karolina', 'Domaszuk', null, 'KAROLINA DOMASZUK.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (232, 'Agata', 'Choroszuka', null, 'blank.jpg', '2001-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (233, 'Oliwia', 'Woźniczka', null, 'blank.jpg', '2002-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (234, 'Oliwia', 'Glegolska', null, 'OLIWIA GLEGOLSKA.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (235, 'Joanna', 'Baranowska', null, 'blank.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (236, 'Zuzanna', 'Krystek', null, 'IFS_Picture_Krystek_Zuzanna.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (237, 'Weronika', 'Gabryel', null, 'blank.jpg', '2003-01-01', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (238, 'Hubert', 'Dęborowski', null, 'HUBERT DĘBOROWSKI.jpg', '2000-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (239, 'Kacper', 'Wiatrak', null, 'Kacper Wiatrak.jpg', '2002-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (240, 'Łukasz', 'Nawrol', null, 'blank.jpg', '1999-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (241, 'Rafał', 'Choroszuka', null, 'blank.jpg', '1999-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (242, 'Damian', 'Wróbel', null, 'blank.jpg', '2000-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (243, 'Jakub', 'Nowakowski', null, 'JAKUB NOWAKOWSKI.jpg', '2000-01-01', 'male');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (245, 'Justyna', 'Komza', null, 'JUSTYNA KOMZA.jpg', '2004-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (246, 'Julia', 'Całka', null, 'JULIA CAŁKA.jpg', '2000-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (247, 'Paulina', 'Wesół', null, 'PAULINA WESÓŁ.JPG', '2000-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (248, 'Paulina', 'Żemła', null, 'PAULINA ŻEMŁA.jpg', '2001-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (249, 'Magdalena', 'Kaźmierczak', null, 'blank.jpg', '2000-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (250, 'Paulina', 'Zarychta', null, 'PAULINA ZARYCHTA .jpg', '2002-01-01', 'female');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (252, 'Paweł', 'Pieprzak', null, 'PAWEŁ PIEPRZAK.jpg', '1988-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (253, 'Mateusz', 'Konieczny', null, 'MATEUSZ KONIECZNY.jpg', '1991-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (254, 'Patryk', 'Swora', null, 'SWORA PATRYK.jpg', '1993-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (255, 'Michał', 'Luto', null, 'IFS_Picture_Luto-Michał.jpg', '1991-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (256, 'Rafał', 'Głodek', null, 'RAFAŁ GŁODEK.jpg', '1996-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (257, 'Aron', 'Rozum', null, 'IFS_Picture_Rozum_Aron.jpg', '1990-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (258, 'Jacek', 'Piersiak', null, 'IFS_Picture_Piersiak_Jacek.jpg', '1988-01-01', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (259, 'Mateusz', 'Linka', null, 'IFS_PHOTO_LINKA_MATEUSZ.jpg', '2004-01-01', 'male');

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (260, 'Klaudia', 'Pieprzak', null, 'KLAUDIA PIEPRZAK.jpg', '1998-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (261, 'Karolina', 'Marczak', null, 'KAROLINA MARCZAK.jpg', '2001-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (263, 'Aleksandra', 'Rozum', null, 'IFS_Picture_Rozum_Aleksandra.jpg', '1998-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (264, 'Monika', 'Skiba', null, 'IFS_Picture_Skiba_Monika.jpg', '1988-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (265, 'Lena', 'Andrzejak', null, 'blank.jpg', '2003-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (266, 'Aleksandra', 'Grygel', null, 'blank.jpg', '1992-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (267, 'Magda', 'Skrajnowska', null, 'blank.jpg', '1998-01-01', 'female');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (268, 'Wioleta', 'Kielar', null, 'WIOLETA KIELAR.jpg', '1988-01-01', 'female');

--Competitors
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (210, 210, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (211, 211, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (212, 212, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (213, 213, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (214, 214, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (215, 215, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (216, 216, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (217, 217, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (218, 218, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (219, 219, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (220, 220, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (221, 221, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (222, 222, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (223, 223, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (224, 224, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (225, 225, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (226, 226, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (227, 227, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (228, 228, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (229, 229, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (230, 230, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (231, 231, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (232, 232, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (233, 233, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (234, 234, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (235, 235, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (236, 236, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (237, 237, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (238, 238, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (239, 239, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (240, 240, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (241, 241, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (242, 242, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (243, 243, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (245, 245, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (246, 246, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (247, 247, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (248, 248, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (249, 249, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (250, 250, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (252, 252, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (253, 253, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (254, 254, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (255, 255, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (256, 256, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (257, 257, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (258, 258, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (259, 259, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (260, 260, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (261, 261, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (263, 263, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (264, 264, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (265, 265, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (266, 266, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (267, 267, 0, 'Poland');
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (268, 268, 0, 'Poland');

--Registrations
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 18, 210);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 18, 211);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 19, 212);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 19, 213);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 214);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 20, 215);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 216);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 21, 217);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 22, 218);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 22, 219);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 23, 220);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 23, 221);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 24, 222);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 24, 223);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 30, 224);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 30, 225);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 31, 226);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 31, 227);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 228);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 229);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 230);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 231);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 34, 232);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 34, 233);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 234);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 235);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 236);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 237);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 38, 238);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 38, 239);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 39, 212);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 39, 240);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 214);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 40, 215);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 216);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 41, 241);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 42, 242);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 42, 218);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 43, 220);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 43, 243);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 222);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 44, 223);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 30, 224);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 30, 245);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 31, 226);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 31, 246);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 247);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 32, 248);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 231);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 33, 249);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 34, 250);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 34, 233);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 234);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 35, 235);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 236);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 36, 237);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 252);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 58, 238);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 253);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 59, 240);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 214);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 60, 215);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 61, 254);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 255);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 62, 256);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 257);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 63, 243);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 258);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 64, 259);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 50, 225);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 50, 224);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 51, 260);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 51, 261);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 52, 247);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 52, 228);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 263);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 53, 231);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 54, 264);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 54, 265);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 266);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 55, 267);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 236);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (20, 56, 268);
