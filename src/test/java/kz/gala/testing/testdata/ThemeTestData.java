package kz.gala.testing.testdata;

import kz.gala.testing.model.Theme;

import static kz.gala.testing.model.BaseEntity.START_SEQ;

/**
 * Created by Mussulmanbekova_GE on 03.07.2017.
 */
public class ThemeTestData {
    public static final int THEME1_ID = START_SEQ ;

    public static final Theme THEME1 = new Theme(THEME1_ID, "тема0");
    public static final Theme THEME2 = new Theme(THEME1_ID + 1, "тема1");
    public static final Theme THEME3 = new Theme(THEME1_ID + 2,"тема2");

    private ThemeTestData() {
    }
}
