package kz.gala.testing.service;

import kz.gala.testing.model.Exam;

import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */
public interface ExamService {
    List<Exam> getNext(Integer id, int userId);
    List<Exam> getPrevious(Integer id, int userId);
    List<Exam> getFirst(int userId);
    List<Exam> getLast(int userId);
}
