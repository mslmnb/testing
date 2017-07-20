package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kz.gala.testing.model.User;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

//смотрим на все поля, не смотрим на геттеры, на is- геттеры, на сеттеры
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class ExamReport {
    private final String themeName;
    private final String userName;
    private final String userPosition;
    private final String userDepartment;
    private final Integer countOfQuestions;
    private final Integer countOfAnswers;
    private final Integer countOfRightAnswers;

    public ExamReport(User user, Integer countOfQuestions, Integer countOfAnswers, Integer countOfRightAnswers) {
        this.themeName = user.getTheme().getName();
        this.userName = user.getName();
        this.userPosition = user.getPosition();
        this.userDepartment = user.getDepartment();
        this.countOfQuestions = countOfQuestions;
        this.countOfAnswers = countOfAnswers;
        this.countOfRightAnswers = countOfRightAnswers;
    }

    public String getThemeName() {
        return themeName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public Integer getCountOfQuestions() {
        return countOfQuestions;
    }

    public Integer getCountOfAnswers() {
        return countOfAnswers;
    }

    public Integer getCountOfRightAnswers() {
        return countOfRightAnswers;
    }

    public double getProcentOfRightAnswer() {
        return 100.00d*countOfRightAnswers/countOfQuestions;
    }

    public String getMark () {
        if (getProcentOfRightAnswer()<75d) {
            return "неудовлетворительно";
        } else {
            return "удовлетворительно";
        }
    }


    @Override
    public String toString() {
        return "UserReport{" +
                "themeName=" + themeName +
                ", userName='" + userName + '\'' +
                ", position='" + userPosition + '\'' +
                ", department='" + userDepartment + '\'' +
                ", countOfQuestions='" + countOfQuestions + '\'' +
                ", countOfAnswers='" + countOfAnswers + '\'' +
                ", countOfRightAnswers='" + countOfRightAnswers + '\'' +
                '}';
    }
}
