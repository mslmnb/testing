DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS exam;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS themes;
DROP SEQUENCE  IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE themes
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  NAME      VARCHAR NOT NULL
);

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  theme_id   INTEGER NOT NULL,
  name       VARCHAR NOT NULL,
  position   VARCHAR NOT NULL,
  department VARCHAR NOT NULL,
  login      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  complete   BOOLEAN DEFAULT FALSE NOT NULL,
  role       VARCHAR NOT NULL,
  FOREIGN KEY (theme_id) REFERENCES themes (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX users_unique_login_idx ON users (login);


CREATE TABLE questions
(
  id                     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  theme_id               INTEGER NOT NULL,
  body                   VARCHAR NOT NULL,
  correct_answer_enums   INTEGER NOT NULL,
  FOREIGN KEY (theme_id) REFERENCES themes (id) ON DELETE CASCADE
);

CREATE TABLE answers
(
  enum                INTEGER,
  body              VARCHAR NOT NULL,
  question_id       INTEGER NOT NULL,
  FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);
 CREATE UNIQUE INDEX answers_unique_question_enum_idx ON answers (question_id, enum);

CREATE TABLE exam
(
  user_id                INTEGER NOT NULL,
  question_id            INTEGER NOT NULL,
  user_answer_enums      INTEGER NOT NULL DEFAULT 0,
  FOREIGN KEY (question_id) REFERENCES  questions (id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX exam_unique_user_question_idx ON exam (user_id, question_id);