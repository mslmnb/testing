package kz.gala.testing.service;

import kz.gala.testing.model.Answer;
import kz.gala.testing.util.exception.NotFoundException;

import java.util.List;

public interface AnswerService {

    Answer get(int questionId, int enumerator) throws NotFoundException;

    void delete(int questionId, int enumerator) throws NotFoundException;

    Answer save(Answer a, Integer questionId);

    Answer update(Answer a) throws NotFoundException;

    List<Answer> getAll(int questionId);

}
