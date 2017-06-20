package kz.gala.testing.service;

import kz.gala.testing.util.exception.NotFoundException;
import kz.gala.testing.model.Question;

public interface QuestionService {
    Question get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Question save(Question question);

    Question update(Question question) throws NotFoundException;

}
