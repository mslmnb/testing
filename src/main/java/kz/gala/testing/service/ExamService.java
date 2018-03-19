package kz.gala.testing.service;

import kz.gala.testing.model.Exam;
import kz.gala.testing.to.ExamReport;
import kz.gala.testing.util.exception.NotFoundException;

import java.util.List;


public interface ExamService {
    List<Exam> getNextFrom(int questionId, int userId);
    List<Exam> getPreviousFrom(int questionId, int userId);
    List<Exam> getFirst(int userId);
    List<Exam> getLast(int userId);
    List<Exam> getAll(int userId);

    Exam get(int questionId, int userId) throws NotFoundException;
    Exam update(Exam exam,  int userId) throws NotFoundException;

    ExamReport getExamReport(int userId, int themeId) throws NotFoundException;
    boolean isComplete(int userId) throws NotFoundException;

    void insertFor(int userId);

    void deleteAllFor(int userId) throws NotFoundException;
}
