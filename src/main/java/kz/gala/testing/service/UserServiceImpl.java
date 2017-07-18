package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.model.User;
import kz.gala.testing.repository.ExamRepository;
import kz.gala.testing.repository.QuestionRepository;
import kz.gala.testing.repository.UserRepository;
import kz.gala.testing.to.UserReport;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, ExamRepository examRepository, QuestionRepository questionRepository) {
        this.repository = repository;
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public User get(int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(userId), userId);
    }

    public UserReport getUserReport(int userId) {
    User user = get(userId);
    List<Exam> exams = examRepository.getAll(userId);
    int countOfQuestions = exams.size();
    int countOfAnswers = (int) exams.stream()
            .filter(e->e.getUserAnswerId()==null)
            .count();
    int countOfRightAnswers = (int) exams.stream()
            .filter(e->questionRepository.getRightAnswerId(e.getQuestionId()).equals(e.getUserAnswerId()))
            .count();
    return new UserReport(user,countOfQuestions, countOfAnswers, countOfRightAnswers);

    }
}
