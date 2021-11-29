package com.yarkin.careerguidance.services;

public class UserService {
    public static boolean isValid(String email, String password) {
        // TODO Write isValid() method
        if(email.equals("alex@yarkin.com.ua") && password.equals("121212")) {
            return true;
        }

        return false;
    }
}
