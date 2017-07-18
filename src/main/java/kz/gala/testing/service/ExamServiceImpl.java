package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.repository.ExamRepository;
import kz.gala.testing.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithIds;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository repository;
    private final QuestionRepository questionRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository repository, QuestionRepository questionRepository) {
        this.repository = repository;
        this.questionRepository = questionRepository;
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
    public List<Exam> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public Exam get(int questionId, int userId) {
        return checkNotFoundWithIds(repository.get(questionId, userId), userId, questionId);
    }

    @Override
    public Integer getRightAnswer(Exam exam) {
        return questionRepository.get(exam.getQuestionId()).getRightAnswerId();
    }

    @Override
    public Exam update(Exam exam, int userAnswerId, int userId) {
        return checkNotFoundWithIds(repository.update(exam, userAnswerId, userId), exam.getUserId(), exam.getQuestionId());
    }


}
