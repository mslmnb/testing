package kz.gala.testing.repository;

import kz.gala.testing.model.Question;

import java.util.List;

public interface QuestionRepository {
    // добавить новый вопрос
    // удалить вопрос по id
    // получить вопрос по id

    Question save(Question question, int themeId);

    boolean delete(int id, int themeId);

    Question get (int id, int themeId);

    Integer getCorrectAnswerEnums(int questionId, int themeId);

    List<Question> getAll(int themeId);
}
