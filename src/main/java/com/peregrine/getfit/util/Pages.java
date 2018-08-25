package com.peregrine.getfit.util;

import java.util.ResourceBundle;

public class Pages {
    private static Pages instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "pages";
    public static final String INDEX = "INDEX";
    public static final String ERROR = "ERROR";
    public static final String REGISTER = "REGISTER";
    public static final String LOGIN = "LOGIN";
    public static final String ACCOUNT = "ACCOUNT";
    public static final String AJAX = "AJAX";
    public static final String CUSTOM = "CUSTOM";

    public static Pages getInstance() {
        if (instance == null) {
            instance = new Pages();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
