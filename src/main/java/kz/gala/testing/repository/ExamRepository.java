package kz.gala.testing.repository;

import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
public interface ExamRepository {
    // сохранить ответ пользователя


    // добавить в репозиторий список вопросов для экзамена
    //void appendQuestions(Collection<Question> questions);

    List<Exam> getNextFrom(int id, int userId) ;

    List<Exam> getPreviousFrom(int id, int userId);

    List<Exam> getFirst(int userId) ;

    List<Exam> getLast(int userId) ;

    void save(Integer id, Integer userAnswerId, int userId);
}
