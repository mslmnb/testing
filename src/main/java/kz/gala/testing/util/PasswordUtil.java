package kz.gala.testing.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * Created by Mussulmanbekova_GE on 28.07.2017.
 */
public class PasswordUtil {
    private static final Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static PasswordEncoder getPasswordEncoder() {
        return PASSWORD_ENCODER;
    }

    /**
     * Кодирует пароль
     * @param newPassword пароль для кодировки
     * @return закодированный пароль
     */
    public static String encode(String newPassword) {
        if(!StringUtils.hasText(newPassword)) {
            return null;
        }
        if (isEncoded(newPassword)) {
            return  newPassword;
        }
        return PASSWORD_ENCODER.encode(newPassword);
    }

    /**
     *
     * @param rawPassword сырой пароль, введенный пользователем
     * @param password хэшированный пароль из БД
     * @return
     */
    public static boolean isMatch(String rawPassword, String password) {
        return PASSWORD_ENCODER.matches(rawPassword, password);
    }

    public static boolean isEncoded(String newPassword) {
        return BCRYPT_PATTERN.matcher(newPassword).matches();
    }
}
