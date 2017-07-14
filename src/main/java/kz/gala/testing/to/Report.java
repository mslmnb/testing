package kz.gala.testing.to;

import kz.gala.testing.model.User;

/**
 * Created by Mussulmanbekova_GE on 12.07.2017.
 */
public class Report {
    private final UserTo userTo;
    private final Integer countOfQuestions;
    private final Integer countOfAnswers;
    private final Integer countOfRightAnswers;

    public Report(User user, Integer countOfQuestions, Integer countOfAnswers, Integer countOfRightAnswers) {
        this.userTo = new UserTo(user);
        this.countOfQuestions = countOfQuestions;
        this.countOfAnswers = countOfAnswers;
        this.countOfRightAnswers = countOfRightAnswers;
    }
}
