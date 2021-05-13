package com.course.utils;

import com.course.model.InterFaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterFaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl = "";
        if (name == InterFaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }

        if (name == InterFaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if (name == InterFaceName.ADDUSER){
            uri = bundle.getString("addUser.uri");
        }

        if (name == InterFaceName.UPDATEUSERINFOURL){
            uri = bundle.getString("updateUserInfo.uri");
        }

        if (name == InterFaceName.GETALL){
            uri = bundle.getString("getAll.uri");
        }

        testUrl = address + uri;
        return testUrl;

    }
}
