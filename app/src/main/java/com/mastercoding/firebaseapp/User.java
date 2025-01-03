package com.mastercoding.firebaseapp;

public class User {

    String name;
    String email;

    public User() {
        // this is to prevent the below error
            // com.google.firebase.database.DatabaseException:
            // Class com.mastercoding.firebaseapp.User does not
            // define a no-argument constructor. If you are using
            // ProGuard, make sure these constructors are not stripped.
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
