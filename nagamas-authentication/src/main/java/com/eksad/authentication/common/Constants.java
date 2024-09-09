package com.eksad.authentication.common;

public class Constants {

    public static final int MAX_LIMIT = 100;
    public static final int ERROR_CODE_DATA_EXIST = 202;
    public static final int ERROR_CODE_REQUIRED = 500;
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    public static class Login {
        public static final String WRONG_PASSWORD = "User and Password does not match";
        public static final String USER_NOT_FOUND = "User not found";
        public static final String USER_INACTIVE = "Inactive user";
        public static final String USER_BLOCK = "This user is blocked. Please wait for 1 minutes.";
        public static final String STATUS_LOGOUT = "LOGOUT";

    }
}
