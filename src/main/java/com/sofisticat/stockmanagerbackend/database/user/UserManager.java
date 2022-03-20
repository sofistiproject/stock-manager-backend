package com.sofisticat.stockmanagerbackend.database.user;

import com.sofisticat.stockmanagerbackend.model.user.User;
import com.sofisticat.stockmanagerbackend.model.user.UserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager implements UserDatabase {

    public User getUserByUsername(String username) {
        // TODO: Implement database connection
        // TODO: If user is valid then return
        // TODO: Else throw UsernameNotFoundException
        List<GrantedAuthority> simpleGrantedAuthorities = List.of(new SimpleGrantedAuthority("admin"));
        UserDetail userDetail = new UserDetail(simpleGrantedAuthorities, false, false, false, true);
        User user = new User("test", "test", "test", userDetail);
        return user;
    }
}
