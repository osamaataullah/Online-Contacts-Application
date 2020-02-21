package com.example.contacts;
import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;

public class ContactsApplication extends Application {


    public static final String APPLICATION_ID = "C7D23099-EE69-6298-FFAF-2F5B10771400";
    public static final String API_KEY = "F7510C27-7342-714F-FF20-4ADE73F0A100";
    public static final String SERVER_URL = "https://api.backendless.com";

    public static BackendlessUser user;
    public static List<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );


    }
}
