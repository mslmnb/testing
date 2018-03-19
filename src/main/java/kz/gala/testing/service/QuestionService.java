package kz.gala.testing.service;

import kz.gala.testing.util.exception.NotFoundException;
import kz.gala.testing.model.Question;

import java.util.List;

public interface QuestionService {
    Question get(int id, int themeId) throws NotFoundException;

    void delete(int id, int themeId) throws NotFoundException;

    Question save(Question question, int themeId);

    Question update(Question question, int themeId) throws NotFoundException;

    List<Question> getAll(int themeId);

    void correct(int questionId, int themeId, int enumerator, boolean correct);
}
