package kz.gala.testing.repository;

import kz.gala.testing.model.Exam;
import java.util.List;

public interface ExamRepository {
    // сохранить ответ пользователя


    // добавить в репозиторий список вопросов для экзамена
    //void appendQuestions(Collection<Question> questions);

    List<Exam> getNextFrom(int questionId, int userId) ;

    List<Exam> getPreviousFrom(int questionId, int userId);

    List<Exam> getFirst(int userId) ;

    List<Exam> getLast(int userId) ;


    Exam update(Exam exam, int userId);

    Exam get(int questionId, int userId);

    List<Exam> getAll(int userId);

    int insert(int userId, int themeId);

    int delete(int userId);

}
