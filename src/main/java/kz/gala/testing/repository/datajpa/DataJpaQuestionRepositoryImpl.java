package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Question;
import kz.gala.testing.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaQuestionRepositoryImpl implements QuestionRepository {

    private final CrudQuestionRepository crudQuestionRepository;
    private final CrudThemeRepository crudThemeRepository;


    @Autowired
    public DataJpaQuestionRepositoryImpl(CrudQuestionRepository crudQuestionRepository, CrudThemeRepository crudThemeRepository) {
        this.crudQuestionRepository = crudQuestionRepository;
        this.crudThemeRepository = crudThemeRepository;
    }

    @Override
    public Question save(Question question, int themeId) {
        if (!question.isNew() && get(question.getId(), themeId) == null) {
            return null;
        }
        question.setTheme(crudThemeRepository.getOne(themeId));
        return crudQuestionRepository.save(question);
    }

    @Override
    public boolean delete(int id, int themeId) {
        return crudQuestionRepository.delete(id, themeId) != 0;
    }

    @Override
    public Question get(int id, int themeId) {
        Question question = crudQuestionRepository.findOne(id);
        return question != null && question.getTheme().getId() == themeId ? question : null;
    }

    @Override
    public Integer getCorrectAnswerEnums(int id, int themeId) {
        return get(id, themeId).getCorrectAnswerEnums();
    }

    @Override
    public List<Question> getAll(int themeId) {
        return crudQuestionRepository.getAll(themeId);
    }
}
