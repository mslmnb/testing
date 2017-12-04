package kz.gala.testing.repository;

import kz.gala.testing.model.Question;

public interface QuestionRepository {
    // добавить новый вопрос
    // удалить вопрос по id
    // получить вопрос по id

    Question save(Question question);

    boolean delete(int id);

    Question get (int id);

    Integer getCorrectAnswerEnums(int questionId);

}
