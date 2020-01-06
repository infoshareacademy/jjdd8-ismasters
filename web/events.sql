create database if not exists 3city_events;

use '3city_events';

DROP TABLE IF EXISTS 'EVENTS';

create TABLE EVENTS
(
    event_id     INT UNSIGNED                        NOT NULL,
    start_date   DATE,
    end_date     DATE,
    name         VARCHAR(200),
    desc_short   VARCHAR(2000),
    desc_long    VARCHAR(10000),
    category_id  INT UNSIGNED,
    active       BIT,
    organizer_id INT UNSIGNED,
    ticket_id    INT UNSIGNED,
    address_id   INT UNSIGNED,
    place_id     INT UNSIGNED,
    ticket       ENUM ('tickets', 'free', 'unknown') NOT NULL,
    url_id       INT UNSIGNED,
    primary key (event_id),
    unique (event_id)
);

DROP TABLE IF EXISTS 'ORGANIZERS';

CREATE TABLE ORGANIZERS
(
    organizer_id INT UNSIGNED NOT NULL,
    designation VARCHAR(200),
    PRIMARY KEY (organizer_id),
    UNIQUE (organizer_id),
    FOREIGN KEY (organizer_id) REFERENCES EVENTS (event_id)
);

DROP TABLE IF EXISTS 'CATEGORIES';

CREATE TABLE CATEGORIES
(
    category_id      INT UNSIGNED NOT NULL,
    name             VARCHAR(100),
    category_type_id INT UNSIGNED,
    PRIMARY KEY (category_id),
    UNIQUE (category_id),
    FOREIGN KEY (category_id) REFERENCES EVENTS (event_id)
);

DROP TABLE IF EXISTS 'CATEGORY_TYPE';

CREATE TABLE CATEGORY_TYPE
(
    category_type_id INT UNSIGNED NOT NULL,
    name             VARCHAR(100),
    PRIMARY KEY (category_type_id),
    UNIQUE (category_type_id),
    FOREIGN KEY (category_type_id) REFERENCES CATEGORIES (category_id)
);

DROP TABLE IF EXISTS 'ADDRESS';

CREATE TABLE ADDRESS
(
    address_id INT UNSIGNED,
    street     VARCHAR(100),
    zipcode    VARCHAR(6),
    city       VARCHAR(50),
    latitude   VARCHAR(10),
    longitude  VARCHAR(10),
    PRIMARY KEY (address_id),
    UNIQUE (address_id),
    FOREIGN KEY (address_id) REFERENCES EVENTS (event_id)
);

DROP TABLE IF EXISTS 'URL';

CREATE TABLE URL
(
    url_id INT UNSIGNED,
    www_url VARCHAR(200),
    fb_url VARCHAR(200),
    other_url VARCHAR(200),
    PRIMARY KEY (url_id),
    UNIQUE (url_id),
    FOREIGN KEY (url_id) REFERENCES EVENTS(event_id)
);



