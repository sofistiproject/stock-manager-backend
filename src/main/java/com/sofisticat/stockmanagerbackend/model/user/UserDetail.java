package com.sofisticat.stockmanagerbackend.model.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    @JsonProperty
    private List<GrantedAuthority> grantedAuthority;

    @JsonProperty
    private boolean isExpired;

    @JsonProperty
    private boolean isLocked;

    @JsonProperty
    private boolean isCredentialsExpired;

    @JsonProperty
    private boolean isEnabled;
}
