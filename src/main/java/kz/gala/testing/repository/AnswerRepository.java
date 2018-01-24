package kz.gala.testing.repository;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.Question;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
public interface AnswerRepository {
    // добавить новый вариант ответа для данного вопроса
    // удалить вариант ответа по id для данного вопроса
    // получить список вариантов ответов для данного вопроса
    Answer save(Answer a);

    boolean delete(int questionId, int enumerator);

    Answer get (int questionId, int enumerator);

    List<Answer> getAll(int questionId);
}
