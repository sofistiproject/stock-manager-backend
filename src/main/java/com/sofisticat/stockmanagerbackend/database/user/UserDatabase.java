package com.sofisticat.stockmanagerbackend.database.user;

import com.sofisticat.stockmanagerbackend.model.user.User;

public interface UserDatabase {
    public User getUserByUsername(String username);
}
