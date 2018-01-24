package kz.gala.testing.util;

import kz.gala.testing.model.Theme;
import kz.gala.testing.to.ThemeTo;

import java.util.List;
import java.util.stream.Collectors;

public class ThemeUtil {
    public static ThemeTo asTo(Theme theme) {
        return new ThemeTo(theme.getId(), theme.getName());
    }

    public static List<ThemeTo>  convertToListThemeTo(List<Theme> themes) {
        return themes.stream().map(t->asTo(t)).collect(Collectors.toList());
    }
}
