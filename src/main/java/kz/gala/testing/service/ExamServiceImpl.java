package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithIds;

import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */
@Service
public class ExamServiceImpl implements ExamService {

    private ExamRepository repository;

    @Autowired
    public ExamServiceImpl(ExamRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Exam> getNextFrom(int questionId, int userId) {
        return repository.getNextFrom(questionId, userId);
    }

    @Override
    public List<Exam> getPreviousFrom(int questionId, int userId) {
        return repository.getPreviousFrom(questionId, userId);
    }

    @Override
    public List<Exam> getFirst(int userId) {
        return repository.getFirst(userId);
    }

    @Override
    public List<Exam> getLast(int userId) {
        return repository.getLast(userId);
    }

    @Override
    public Exam get(int questionId, int userId) {
        return checkNotFoundWithIds(repository.get(questionId, userId), userId, questionId);
    }

    @Override
    public Exam update(Exam exam, int userAnswerId, int userId) {
        return checkNotFoundWithIds(repository.update(exam, userAnswerId, userId), exam.getUserId(), exam.getQuestionId());
    }
}
