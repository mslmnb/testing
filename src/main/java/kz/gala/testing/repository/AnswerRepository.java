package kz.gala.testing.repository;

import kz.gala.testing.model.Answer;

import java.util.Collection;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
public interface AnswerRepository {
    // добавить новый вариант ответа для данного вопроса
    // удалить вариант ответа по id для данного вопроса
    // получить список вариантов ответов для данного вопроса
    Collection<Answer> getAll(Integer idQuestion);
}
