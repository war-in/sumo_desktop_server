import sys
import csv

if __name__ == '__main__':
    competitionName = sys.argv[1] if sys.argv[1] else "empty"
    CsvFile = sys.argv[2] if sys.argv[2] else "empty"
    resultFile = sys.argv[3] if sys.argv[3] else "empty"

    CsvFile = open(CsvFile,encoding="utf-8")
    resultFile = open(resultFile, mode='a',encoding="utf-8")
    print(sys.argv[1])

#     adding competitons types
resultFile.write("INSERT into COMPETITION_TYPES (type) values ('European Championships');\n")
resultFile.write("INSERT into COMPETITION_TYPES (type) values ('European Cup');\n")

# creatin curent competition
resultFile.write('''
INSERT into COMPETITIONS (competition_id, id_from_server, name, city, start_date, end_date, type) values (10, 10, '{}', '{}', '{}', '{}', '{}');\n
'''.format("Roland Cup", "Brandenburg an der Havel", "2023-03-03", "2023-03-04", "European Cup"))

# creating genders
resultFile.write("INSERT into SEXES (sex) values ('male');\n")
resultFile.write("INSERT into SEXES (sex) values ('female');\n")

FemaleDict = {
    '50kg':50,
    '55kg':51,
    '60kg':52,
    '65kg':53,
    '73kg':54,
    '80kg':55,
    '+80kg':56,
    'OPEN':57,
}

MaleDict = {
    '70kg':58,
    '77kg':59,
    '85kg':60,
    '92kg':61,
    '100kg':62,
    '115kg':63,
    '+115kg':64,
    'OPEN':65
}

resultFile.write('''

INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values (0, 'Free', 'Fight', null, null, null, null);
INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values (0, 0, 0, 'Free Fight');


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


INSERT into REGIONS (region) values ( 'EUROPE' );

INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (1, 0, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (8, 8, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (9, 16, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (4, 32, 'EUROPE');
INSERT into DRAW_TYPES (draw_type_id, number_of_competitors, region) values (5, 64, 'EUROPE');


INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (1,10,12,1,20);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (2,10,12,2,15);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (3,10,12,3,10);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (4,10,12,4,5);
INSERT INTO POINTS_CLASSIFICATIONS(point_classification_id,competition_id,age_category_id,placement_on_competition,number_of_points) values (5,10,12,5,5);
''')

for id, row in enumerate(CsvFile):
    id = id + 100
    row = row.strip()
    row = row.split(',')
    for i in row:
        i.strip()
    date = row[2].split('/')
    date = date[2] + '-' + date[0] + '-' + date[1]
    gender = "male" if row[3] == "Man" else "female"
    print(row)
    # Personal Details
    resultFile.write(
        "INSERT into PERSONAL_DETAILS (personal_details_id, name, surname, phone_number, link_to_profile_picture, birth_date, sex) values ({}, '{}', '{}', null, null, '{}', '{}');\n"
        .format(id, row[0], row[1], date, gender))
    # Competitors
    resultFile.write(
        "INSERT into COMPETITORS (competitor_id, personal_details_id, status, country) values ({}, {}, 0, '{}');\n"
        .format(id, id, row[5]))

    categoryid = MaleDict[row[4]] if gender=='male' else FemaleDict[row[4]]

    # Registration
    resultFile.write(
        "INSERT into REGISTRATIONS (registration_id, category_at_competition_id, competitior_id) values ({}, {}, {});\n".format(
            id, categoryid, id))

