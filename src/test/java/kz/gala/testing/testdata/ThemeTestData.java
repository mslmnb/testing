package kz.gala.testing.testdata;

import kz.gala.testing.matcher.ModelMatcher;
import kz.gala.testing.model.Theme;

import static kz.gala.testing.model.BaseEntity.START_SEQ;

public class ThemeTestData {

    public static final ModelMatcher<Theme> MATCHER = ModelMatcher.of(Theme.class);

    public static final int THEME1_ID = START_SEQ ;

    public static final Theme THEME1 = new Theme(THEME1_ID, "Общий кругозор");
    public static final Theme THEME2 = new Theme(THEME1_ID + 1, "тема1");
    public static final Theme THEME3 = new Theme(THEME1_ID + 2,"тема2");
    public static final Theme THEME4 = new Theme(THEME1_ID + 3,"тема3");
    public static final Theme THEME5 = new Theme(THEME1_ID + 4,"тема4");
    public static final Theme THEME6 = new Theme(THEME1_ID + 5, "тема5");
    public static final Theme THEME7 = new Theme(THEME1_ID + 6,"тема6");
    public static final Theme THEME8 = new Theme(THEME1_ID + 7,"тема7");
    public static final Theme THEME9 = new Theme(THEME1_ID + 8,"тема8");
    public static final Theme THEME10 = new Theme(THEME1_ID + 9,"тема9");

    private ThemeTestData() {
    }
}
