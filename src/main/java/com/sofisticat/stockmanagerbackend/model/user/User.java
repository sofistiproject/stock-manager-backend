package com.sofisticat.stockmanagerbackend.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @JsonProperty
    String id;

    @JsonProperty
    String username;

    @JsonProperty
    String password;

    @JsonProperty
    UserDetail details;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return details.getGrantedAuthority();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !details.isExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !details.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !details.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return details.isEnabled();
    }
}
