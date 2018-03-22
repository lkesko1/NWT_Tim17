\c nwt-cinema-auth nwt;

CREATE TABLE USER (
    id INT NOT NULL,
    email CHARACTER VARYING(255) NOT NULL,
    password CHARACTER VARYING(255) NOT NULL,
    user_name CHARACTER VARYING(255) NOT NULL,
    first_name CHARACTER VARYING(255) NOT NULL,
    last_name CHARACTER VARYING(255) NOT NULL,
    birthday TIMESTAMP without time zone

    CONSTRAINT user_id_pk PRIMARY KEY (id)
);

INSERT INTO USER (id, email, password, user_name, first_name, last_name, birthday)
VALUES (1, 'admin.user@gmail.com', md5('admin'::text), 'admin', 'admin', 'user', 2018-03-20 09:40:42.002);

INSERT INTO USER (id, email, password, user_name, first_name, last_name, birthday)
VALUES (2, 'test.user@gmail.com', md5('test'::text), 'test', 'test', 'user', 2018-03-20 09:40:42.002);

INSERT INTO USER (id, email, password, user_name, first_name, last_name, birthday)
VALUES (3, 'user.user@gmail.com', md5('user'::text), 'user', 'user', 'user', 2018-03-20 09:40:42.002);

/*
    USE nwt-cinema-projections
*/

\c nwt-cinema-projections nwt;

CREATE TABLE ROLE (
    id INT NOT NULL,
    role_title CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255)

    CONSTRAINT role_id_pk PRIMARY KEY (id)
);

CREATE TABLE ROLE_USER (
    user_id INT NOT NULL,
    role_id INT NOT NULL

    CONSTRAINT role_id_fk FOREIGN KEY (role_id)
);

CREATE TABLE MOVIE_TIMETABLE (
    movie_id INT NOT NULL,
    createdBy INT NOT NULL,
    date TIMESTAMP without time zone,
    max_tickets INT NOT NULL

    CONSTRAINT movie_id_pk PRIMARY KEY (movie_id)
);

INSERT INTO ROLE (id, role_title, description)
VALUES (4, 'admin', 'Administrator');

INSERT INTO ROLE (id, role_title, description)
VALUES (5, 'customer', 'Customer');

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (1, 4);

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (2, 5);

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (3, 5);

INSERT INTO MOVIE_TIMETABLE (movie_id, createdBy, date, max_tickets)
VALUES (6, 1, 2018-03-20 09:40:42.002, 100);

INSERT INTO MOVIE_TIMETABLE (movie_id, createdBy, date, max_tickets)
VALUES (7, 1, 2018-03-20 09:40:42.002, 100);

INSERT INTO MOVIE_TIMETABLE (movie_id, createdBy, date, max_tickets)
VALUES (8, 1, 2018-03-20 09:40:42.002, 100);

/*
    USE nwt-cinema-reservations
*/

\c nwt-cinema-reservations nwt;

CREATE TABLE ROLE (
    id INT NOT NULL,
    role_title CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255)

    CONSTRAINT role_id_pk PRIMARY KEY (id)
);

CREATE TABLE ROLE_USER (
    user_id INT NOT NULL,
    role_id  INT NOT NULL

    CONSTRAINT role_id_fk FOREIGN KEY (role_id)
);

CREATE TABLE RESERVATION (
    id INT NOT NULL,
    user_id INT NOT NULL,
    movie_projection_id INT NOT NULL,
    number_of_tickets INT NOT NULL,
    date_created TIMESTAMP without time zone

    CONSTRAINT reservation_id_pk PRIMARY KEY (id)
);

INSERT INTO ROLE (id, role_title, description)
VALUES (4, 'admin', 'Administrator');

INSERT INTO ROLE (id, role_title, description)
VALUES (5, 'customer', 'Customer');

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (1, 4);

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (2, 5);

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (3, 5);

INSERT INTO RESERVATION (id, user_id, movie_projection_id, number_of_tickets, date_created)
VALUES (9, 2, 6, 100, 2018-03-20 09:40:42.002);

INSERT INTO RESERVATION (id, user_id, movie_projection_id, number_of_tickets, date_created)
VALUES (10, 2, 7, 100, 2018-03-20 09:40:42.002);

INSERT INTO RESERVATION (id, user_id, movie_projection_id, number_of_tickets, date_created)
VALUES (11, 3, 8, 100, 2018-03-20 09:40:42.002);

/*
    USE nwt-cinema-movies
*/

\c nwt-cinema-movies nwt;

CREATE TABLE ROLE (
    id INT NOT NULL,
    role_title CHARACTER VARYING(255) NOT NULL,
    description CHARACTER VARYING(255)

    CONSTRAINT role_id_pk PRIMARY KEY (id)
);

CREATE TABLE ROLE_USER (
    user_id INT NOT NULL,
    role_id INT NOT NULL

    CONSTRAINT role_id_fk FOREIGN KEY (role_id)
);

CREATE TABLE MOVIE (
    id INT NOT NULL,
    imdb_URL CHARACTER VARYING(255)

    CONSTRAINT movie_id_pk FOREIGN KEY (id)
);

CREATE TABLE MOVIE_REVIEW (
    id INT NOT NULL,
    user_id INT NOT NULL,
    movie_id INT NOT NULL,
    rate INT NOT NULL,
    comment CHARACTER VARYING(255)

    CONSTRAINT movie_review_id_pk PRIMARY KEY (id)
    CONSTRAINT movie_id_fk PRIMARY KEY (movie_id)
);

INSERT INTO ROLE (id, role_title, description)
VALUES (4, 'admin', 'Administrator');

INSERT INTO ROLE (id, role_title, description)
VALUES (5, 'customer', 'Customer');

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (1, 4);

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (2, 5);

INSERT INTO ROLE_USER (user_id, role_id)
VALUES (3, 5);

INSERT INTO MOVIE (12, 'http://www.imdb.com/title/tt0102926/');

INSERT INTO MOVIE (13, 'http://www.imdb.com/title/tt0086250/');

INSERT INTO MOVIE (14, 'http://www.imdb.com/title/tt0081398/');

INSERT INTO MOVIE_REVIEW (15, 2, 12, 10, 'Comment');

INSERT INTO MOVIE_REVIEW (16, 2, 13, 10, 'Comment');

INSERT INTO MOVIE_REVIEW (17, 2, 14, 10, 'Comment');