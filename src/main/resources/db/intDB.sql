DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS exam;
DROP TABLE IF EXISTS questions;
DROP SEQUENCE  IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE questions
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  body              TEXT NOT NULL,
  right_answer_id   INTEGER
);

CREATE TABLE answers
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  body              TEXT NOT NULL,
  question_id       INTEGER NOT NULL,
  FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);

CREATE TABLE exam
(
  question_id       INTEGER NOT NULL,
  user_answer_id    INTEGER,
  FOREIGN KEY (question_id) REFERENCES  questions (id) ON DELETE CASCADE
);