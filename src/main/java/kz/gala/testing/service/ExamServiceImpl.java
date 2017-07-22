package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.model.User;
import kz.gala.testing.repository.ExamRepository;
import kz.gala.testing.repository.QuestionRepository;
import kz.gala.testing.repository.UserRepository;
import kz.gala.testing.to.ExamReport;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithId;
import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithIds;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository repository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository repository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.repository = repository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
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
    public Exam update(Exam exam, int userAnswerId, int userId) {
        return checkNotFoundWithIds(repository.update(exam, userAnswerId, userId), exam.getUserId(), exam.getQuestionId());
    }

    @Override
    public boolean isComplete(int userId) throws NotFoundException{
        User user = checkNotFoundWithId(userRepository.get(userId), userId);
        return user.isComplete();
    }

    @Override
    public ExamReport getExamReport(int userId) throws NotFoundException {
        User user = checkNotFoundWithId(userRepository.get(userId), userId);
        user.setComplete(true);
        userRepository.save(user);
        List<Exam> exams = repository.getAll(userId);
        int countOfQuestions = exams.size();
        int countOfAnswers = (int) exams.stream()
                .filter(e->e.getUserAnswerId()!=null)
                .count();
        int countOfCorrectAnswers = (int) exams.stream()
                .filter(e->questionRepository.getCorrectAnswerId(e.getQuestionId()).equals(e.getUserAnswerId()))
                .count();
        return new ExamReport(user,countOfQuestions, countOfAnswers, countOfCorrectAnswers);

    }


}
