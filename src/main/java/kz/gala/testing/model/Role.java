package kz.gala.testing.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Mussulmanbekova_GE on 26.07.2017.
 */
public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
