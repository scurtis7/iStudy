CREATE SCHEMA IF NOT EXISTS istudy;

CREATE TABLE istudy.study_category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(16) UNIQUE NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE istudy.book (
    id SERIAL PRIMARY KEY,
    name VARCHAR(16) UNIQUE NOT NULL,
    testament VARCHAR(3) NOT NULL,
    category VARCHAR(16) NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);

