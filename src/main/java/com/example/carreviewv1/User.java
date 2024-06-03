package com.example.carreviewv1;

public class User {
    String Uname;
    String Password;
    String Gender;
    String localisation;

    public User(String uname, String password, String gender, String localisation) {
        Uname = uname;
        Password = password;
        Gender = gender;
        this.localisation = localisation;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
