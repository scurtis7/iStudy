CREATE TABLE istudy.study (
    study_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category_id INTEGER NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE istudy.study_note (
    note_id SERIAL PRIMARY KEY,
    study_id INTEGER,
    verse VARCHAR(100),
    note VARCHAR(5000),
    created_date DATE DEFAULT CURRENT_DATE,
    CONSTRAINT fk_study
        FOREIGN KEY(study_id)
            REFERENCES istudy.study(study_id)
);


