package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kz.gala.testing.model.User;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

//смотрим на все поля, не смотрим на геттеры, на is- геттеры, на сеттеры
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class UserReport {
    private final String themeName;
    private final String userName;
    private final String userPosition;
    private final String userDepartment;
    private final Integer countOfQuestions;
    private final Integer countOfAnswers;
    private final Integer countOfRightAnswers;

    public UserReport(User user, Integer countOfQuestions, Integer countOfAnswers, Integer countOfRightAnswers) {
        this.themeName = user.getTheme().getName();
        this.userName = user.getName();
        this.userPosition = user.getPosition();
        this.userDepartment = user.getDepartment();
        this.countOfQuestions = countOfQuestions;
        this.countOfAnswers = countOfAnswers;
        this.countOfRightAnswers = countOfRightAnswers;
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
