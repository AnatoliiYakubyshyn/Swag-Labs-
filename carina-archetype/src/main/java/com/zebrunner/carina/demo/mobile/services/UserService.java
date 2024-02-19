package com.zebrunner.carina.demo.mobile.services;

import com.zebrunner.carina.demo.mobile.pojo.User;

public class UserService {

    private static User getStandardUser() {
        return new User("standard_user", "secret_sauce");
    }

    private static User getLockedInUser() {
        return new User("locked_out_user","secret_sauce");
    }

    private static User getProblemUser() {
        return new User("problem_user","secret_sauce");
    }
}
