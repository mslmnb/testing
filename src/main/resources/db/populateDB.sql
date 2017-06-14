DELETE FROM exam;
DELETE FROM answers;
DELETE FROM questions;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- вопросы 100000, 100001, 100002
INSERT INTO questions (body, right_answer_id  ) VALUES
  ('Земля по форме похожа на', 100004),
  ('Колобок был съеден', 100008),
  ('Дети любят', 100009);

INSERT INTO answers (body,question_id) VALUES
  ('конус',100000),
  ('шар',100000),
  ('куб',100000),
  ('Дюймовочкой',100001),
  ('Чебурашкой',100001),
  ('лисой',100001),
  ('играть',100002),
  ('стоять в углу',100002),
  ('рыбий жир',100002);

INSERT INTO exam (question_id) VALUES
  (100000),
  (100001),
  (100002);