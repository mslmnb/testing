package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Exam> getNextFrom(Integer id, int userId) {
        return repository.getNextFrom(id, userId);
    }

    @Override
    public List<Exam> getPreviousFrom(Integer id, int userId) {
        return repository.getPreviousFrom(id, userId);
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
    public void save(Integer id, Integer userAnswerId, int userId) {
        repository.save(id, userAnswerId, userId);
    }
}
