package com.xavier.springsecurity2.Utils;

import com.xavier.springsecurity2.models.User;

import java.util.Arrays;
import java.util.List;

public class Utils {

    private static  final List<User> users = Arrays.asList(
            new User(1,"xavier"),
            new User(2,"tom"),
            new User(3,"asher"),
            new User(4,"john"),
            new User(5,"frank"),
            new User(6,"paul"),
            new User(7,"james"),
            new User(8,"tracy"),
            new User(9,"oscar")

    );

    public static List<User> getUsers() {
        return users;
    }
}
