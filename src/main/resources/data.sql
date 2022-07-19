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

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (1, 'Marcin', 'Warchoł', '727731521', 'link', '2000-09-02', 'male');
INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (2, 'Gabi', 'Erazmus', 'numer', 'link', '2000-05-03', 'female');

INSERT into COMPETITORS (competitor_id, personal_details_id, status) values (1, 1, 0);
INSERT into COMPETITORS (competitor_id, personal_details_id, status) values (2, 2, 0);

INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (1, 1, 1);
INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values (2, 2, 2);

INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (1, 1, 67.0, '2022-07-19');
INSERT into WEIGHED_COMPETITORS (weighed_competitor_id, registration_id, weight, date) values (2, 2, 55.0, '2022-07-19');

