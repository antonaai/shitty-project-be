package com.example.cleaning.context;

import com.example.cleaning.bean.UserSessionData;

public class UserSession {

    private static final ThreadLocal<UserSessionData> CURRENT = new ThreadLocal<>();

    public static void set(UserSessionData data) {
        CURRENT.set(data);
    }

    public static UserSessionData get() {
        return CURRENT.get();
    }

    public static void clear() {
        CURRENT.remove();
    }
}

