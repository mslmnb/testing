package kz.gala.testing.service;

import kz.gala.testing.util.exception.NotFoundException;
import kz.gala.testing.model.Question;

import java.util.List;

public interface QuestionService {
    Question get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Question save(Question question);

    Question update(Question question) throws NotFoundException;

    List<Question> getAll(int themeId);

    void correct(Integer questionId, Integer enumerator, Boolean correct);
}
