INSERT into COMPETITION_TYPES (type) values ('Mistrzostwa europy');

INSERT into COMPETITIONS (competition_id, id_from_server, name, city, start_date, end_date, type) values (1, 1, 'Mistrzostwa europy Warszawa', 'Warszawa', '2022-07-18', '2022-07-20', 'Mistrzostwa europy');

INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (1, 'Senior', '2000-01-01', '2002-12-31');
INSERT into AGE_CATEGORIES (age_category_id, name, oldest_competitor_birth_year, youngest_competitor_birth_year) values (2, 'Młodzik', '2003-01-01', '2005-12-31');

INSERT into SEXES (sex) values ('male');
INSERT into SEXES (sex) values ('female');

INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (1, 1, 'open', 'male');
INSERT into CATEGORIES (category_id, age_category_id, weight_category, sex) values (2, 2, '90', 'female');

INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (1, 1, 1, '2022-07-19');
INSERT into CATEGORIES_AT_COMPETITIONS (category_at_competition_id, competition_id, category_id, date) values (2, 1, 2, '2022-07-19');

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


