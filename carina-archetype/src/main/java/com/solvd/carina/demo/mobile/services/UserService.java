package com.solvd.carina.demo.mobile.services;

import com.solvd.carina.demo.mobile.enums.UserType;
import com.solvd.carina.demo.mobile.pojo.User;
import com.zebrunner.carina.utils.R;

public class UserService {

    public static User getUser(UserType userType) {
        return new User(R.TESTDATA.get(userType.getValue() + ".username"),
                R.TESTDATA.get(userType.getValue() + ".password"));
    }

    public static User getUser(String userKey) {
        return new User(R.TESTDATA.get(userKey + ".username"),
                R.TESTDATA.get(userKey + ".password"));
    }

}
