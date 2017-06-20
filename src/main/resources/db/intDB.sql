DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS exam;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS users;
DROP SEQUENCE  IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  position   VARCHAR NOT NULL,
  department VARCHAR NOT NULL,
  login      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_login_idx ON users (login);


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
  user_id           INTEGER NOT NULL,
  question_id       INTEGER NOT NULL,
  user_answer_id    INTEGER,
  FOREIGN KEY (question_id) REFERENCES  questions (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX exam_unique_user_question_idx ON exam (user_id, question_id)