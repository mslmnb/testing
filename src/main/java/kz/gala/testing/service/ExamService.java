package kz.gala.testing.service;

import kz.gala.testing.model.Exam;

import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */
public interface ExamService {
    List<Exam> getNextFrom(Integer id, int userId);
    List<Exam> getPreviousFrom(Integer id, int userId);
    List<Exam> getFirst(int userId);
    List<Exam> getLast(int userId);
}
