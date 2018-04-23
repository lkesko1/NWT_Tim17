\c nwt-cinema-auth nwt;

CREATE TABLE cinema_user (
    id INT PRIMARY KEY,
    email CHARACTER VARYING(255),
    password CHARACTER VARYING(255) NOT NULL,
    user_name CHARACTER VARYING(255) NOT NULL,
    first_name CHARACTER VARYING(255) NOT NULL,
    last_name CHARACTER VARYING(255) NOT NULL,
    birthday TIMESTAMP without time zone
);

INSERT INTO cinema_user (id, email, password, user_name, first_name, last_name, birthday)
VALUES (1, 'admin.user@gmail.com', md5('admin'::text), 'admin', 'admin', 'user', ('2018-03-20')::timestamp),
(2, 'test.user@gmail.com', md5('test'::text), 'test', 'test', 'user', ('2018-03-20')::timestamp),
(3, 'user.user@gmail.com', md5('user'::text), 'user', 'user', 'user', ('2018-03-20')::timestamp);

/*
    USE nwt-cinema-projections
*/

\c nwt-cinema-projections nwt;

CREATE TABLE user_role (
    id INT PRIMARY KEY,
    role_title CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255)
);

CREATE TABLE role_user (
    user_id INT NOT NULL,
    role_id INT NOT NULL REFERENCES user_role (id)
);

CREATE TABLE movie_timetable (
    movie_id INT PRIMARY KEY,
    createdBy INT NOT NULL,
    date TIMESTAMP without time zone,
    max_tickets INT NOT NULL
);

INSERT INTO user_role (id, role_title, description)
VALUES (4, 'admin', 'Administrator'),
(5, 'customer', 'Customer');

INSERT INTO role_user (user_id, role_id)
VALUES (1, 4), (2, 5), (3, 5);

INSERT INTO movie_timetable (movie_id, createdBy, date, max_tickets)
VALUES (6, 1, ('2018-03-20')::timestamp, 100),
(7, 1, ('2018-03-20')::timestamp, 100),
(8, 1, ('2018-03-20')::timestamp, 100);

/*
    USE nwt-cinema-reservations
*/

\c nwt-cinema-reservations nwt;

CREATE TABLE user_role (
    id INT PRIMARY KEY,
    role_title CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255)
);

CREATE TABLE role_user (
    user_id INT NOT NULL,
    role_id  INT NOT NULL REFERENCES user_role (id)
);

CREATE TABLE reservation (
    id INT PRIMARY KEY,
    user_id INT NOT NULL,
    movie_projection_id INT NOT NULL,
    number_of_tickets INT NOT NULL,
    date_created TIMESTAMP without time zone
);

INSERT INTO user_role (id, role_title, description)
VALUES (4, 'admin', 'Administrator'),
(5, 'customer', 'Customer');

INSERT INTO role_user (user_id, role_id)
VALUES (1, 4), (2, 5), (3, 5);

INSERT INTO reservation (id, user_id, movie_projection_id, number_of_tickets, date_created)
VALUES (9, 2, 6, 100, ('2018-03-20')::timestamp),
(10, 2, 7, 100, ('2018-03-20')::timestamp),
(11, 3, 8, 100, ('2018-03-20')::timestamp);

/*
    USE nwt-cinema-movies
*/

\c nwt-cinema-movies nwt;

CREATE TABLE user_role (
    id INT PRIMARY KEY,
    role_title CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255)
);

CREATE TABLE role_user (
    user_id INT NOT NULL,
    role_id INT NOT NULL REFERENCES user_role (id)
);

CREATE TABLE movie (
    id INT PRIMARY KEY,
    imdb_URL CHARACTER VARYING(255)
);

CREATE TABLE movie_review (
    id INT PRIMARY KEY,
    user_id INT NOT NULL,
    movie_id INT NOT NULL REFERENCES movie (id),
    rate INT NOT NULL,
    comment CHARACTER VARYING(255)
);

INSERT INTO user_role (id, role_title, description)
VALUES (4, 'admin', 'Administrator'),
(5, 'customer', 'Customer');

INSERT INTO role_user (user_id, role_id)
VALUES (1, 4), (2, 5), (3, 5);

INSERT INTO movie 
VALUES (12, 'http://www.imdb.com/title/tt0102926/'),
(13, 'http://www.imdb.com/title/tt0086250/'),
(14, 'http://www.imdb.com/title/tt0081398/');

INSERT INTO movie_review
VALUES (15, 2, 12, 10, 'Comment'),
(16, 2, 13, 10, 'Comment'),
(17, 2, 14, 10, 'Comment');