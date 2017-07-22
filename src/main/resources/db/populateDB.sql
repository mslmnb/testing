DELETE FROM exam;
DELETE FROM answers;
DELETE FROM questions;
DELETE FROM users;
DELETE FROM themes;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO themes (name) VALUES
  ('тема0'),     --100 000
  ('тема1'),     --100 001
  ('тема2'),     --100 002
  ('тема3'),     --100 003
  ('тема4'),     --100 004
  ('тема5'),     --100 005
  ('тема6'),     --100 006
  ('тема7'),     --100 007
  ('тема8'),     --100 008
  ('тема9');     --100 009

INSERT INTO users (name, theme_id, position, department, login,  password, complete, role) VALUES
  ('Сергеев И.И.',100000, 'инженер 1 кат', 'секретный отдел', 'User', 'UserPassword', FALSE, 'USER'),      -- 100 010
  ('Антонов И.И.',100000, 'инженер 2 кат', 'админ отдел', 'Admin', 'AdminPassword', FALSE, 'ADMIN'),    -- 100 011
  ('Петров И.И.',100001, 'инженер 3 кат', 'отдел П', 'User12', 'UserPassword', FALSE, 'USER'),      -- 100 012
  ('Васильев И.И.',100001, 'инженер 4 кат', 'отдел В', 'User13', 'UserPassword', FALSE, 'USER'),      -- 100 013
  ('Петров И.И.',100001, 'техник 1 раз', 'отдел П', 'User14', 'UserPassword', FALSE, 'USER'),      -- 100 014
  ('Павлов И.И.', 100002, 'техник 2 раз', 'отдел П', 'User15', 'UserPassword', FALSE, 'USER'),      -- 100 015
  ('Матвеев И.И.', 100002, 'техник 3 раз', 'отдел М', 'User16', 'UserPassword', FALSE, 'USER'),      -- 100 016
  ('Александров И.И.', 100002, 'технолог 1 кат', 'отдел А', 'User17', 'UserPassword', FALSE, 'USER'),      -- 100 017
  ('Васечкин И.И.', 100002, 'технолог 2 кат', 'отдел В', 'User18', 'UserPassword', FALSE, 'USER'),      -- 100 018
  ('Григорьев И.И.', 100002, 'технолог 3 кат', 'отдел Г', 'User19', 'UserPassword', FALSE, 'USER');      -- 100 019


-- вопросы 100002 - 100010
INSERT INTO questions (theme_id, body, correct_answer_id  ) VALUES
  (100000,'Земля по форме похожа на', 100041),  --100 020
  (100000,'Колобок был съеден', 100045),        --100 021
  (100000,'Дети любят', 100046),                --100 022
  (100000,'Светофор имеет цвет', 100051),       --100 023
  (100000,'Караганда это', 100052),              --100 024
  (100000,'Два умножить на два равно', 100056),  --100 025
  (100000,'Луна вращается вокруг', 100058),      --100 026
  (100000,'Дюймовочка была ростом', 100061),     --100 027
  (100000,'Яблоко это', 100066),                 --100 028
  (100001,'тема1 вопрос1', 100067),              --100 029
  (100001,'тема1 вопрос2', 100070),              --100 030
  (100001,'тема1 вопрос3', 100073),              --100 031
  (100001,'тема1 вопрос4', 100076),              --100 032
  (100001,'тема1 вопрос5', 100079),              --100 033
  (100002,'тема2 вопрос1', 100082),              --100 034
  (100002,'тема2 вопрос2', 100085),              --100 035
  (100002,'тема2 вопрос3', 100088),              --100 036
  (100002,'тема2 вопрос4', 100091),              --100 037
  (100002,'тема2 вопрос5', 100094),              --100 038
  (100002,'тема2 вопрос6', 100097);              --100 039


INSERT INTO answers (body,question_id) VALUES
  ('конус',100020),                     --100 040
  ('шар',100020),                     --100 041
  ('куб',100020),                     --100 042
  ('Дюймовочкой',100021),                     --100 043
  ('Чебурашкой',100021),                     --100 044
  ('лисой',100021),                     --100 045
  ('играть',100022),                     --100 046
  ('стоять в углу',100022),                     --100 047
  ('рыбий жир',100022),                     --100 048
  ('черный',100023),                     --100 049
  ('розовый',100023),                     --100 050
  ('желтый',100023),                     --100 051
  ('город',100024),                     --100 052
  ('поселок',100024),                     --100 053
  ('район',100024),                     --100 054
  ('ноль',100025),                     --100 055
  ('четыре',100025),                     --100 056
  ('десять',100025),                     --100 057
  ('Земли',100026),                     --100 058
  ('Марса',100026),                     --100 059
  ('Сатурна',100026),                     --100 060
  ('дюйм',100027),                     --100 061
  ('метр',100027),                     --100 062
  ('полтора метра',100027),                     --100 063
  ('овощ',100028),                     --100 064
  ('ягода',100028),                     --100 065
  ('фрукт',100028),                     --100 066
  ('тема1 вопрос1 ответ1',100029),                     --100 067
  ('тема1 вопрос1 ответ2',100029),                     --100 068
  ('тема1 вопрос1 ответ3',100029),                     --100 069
  ('тема1 вопрос2 ответ1',100030),                     --100 070
  ('тема1 вопрос2 ответ2',100030),                     --100 071
  ('тема1 вопрос2 ответ3',100030),                     --100 072
  ('тема1 вопрос3 ответ1',100031),                     --100 073
  ('тема1 вопрос3 ответ2',100031),                     --100 074
  ('тема1 вопрос3 ответ3',100031),                     --100 075
  ('тема1 вопрос4 ответ1',100032),                     --100 076
  ('тема1 вопрос4 ответ2',100032),                     --100 077
  ('тема1 вопрос4 ответ3',100032),                     --100 078
  ('тема1 вопрос5 ответ1',100033),                     --100 079
  ('тема1 вопрос5 ответ2',100033),                     --100 080
  ('тема1 вопрос5 ответ3',100033),                     --100 081
  ('тема2 вопрос1 ответ1',100034),                     --100 082
  ('тема2 вопрос1 ответ2',100034),                     --100 083
  ('тема2 вопрос1 ответ3',100034),                     --100 084
  ('тема2 вопрос2 ответ1',100035),                     --100 085
  ('тема2 вопрос2 ответ2',100035),                     --100 086
  ('тема2 вопрос2 ответ3',100035),                     --100 087
  ('тема2 вопрос3 ответ1',100036),                     --100 088
  ('тема2 вопрос3 ответ2',100036),                     --100 089
  ('тема2 вопрос3 ответ3',100036),                     --100 090
  ('тема2 вопрос4 ответ1',100037),                     --100 091
  ('тема2 вопрос4 ответ2',100037),                     --100 092
  ('тема2 вопрос4 ответ3',100037),                     --100 093
  ('тема2 вопрос5 ответ1',100038),                     --100 094
  ('тема2 вопрос5 ответ2',100038),                     --100 095
  ('тема2 вопрос5 ответ3',100038),                     --100 096
  ('тема2 вопрос6 ответ1',100039),                     --100 097
  ('тема2 вопрос6 ответ2',100039),                     --100 098
  ('тема2 вопрос6 ответ3',100039);                     --100 099


INSERT INTO exam (user_id, question_id) VALUES
  (100010, 100020),
  (100010, 100021),
  (100010, 100022),
  (100010, 100023),
  (100010, 100024),
  (100010, 100025),
  (100010, 100026),
  (100010, 100027),
  (100010, 100028);

;
