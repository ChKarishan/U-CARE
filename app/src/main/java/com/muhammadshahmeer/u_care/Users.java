package com.muhammadshahmeer.u_care;

public class Users {
    String email, password, pic, name;

    public Users(String email, String password, String pic, String name) {
        this.email = email;
        this.password = password;
        this.pic = pic;
        this.name = name;


    }
    //signup constructor
    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //gender constructor
//    public Users(String gender) {
//       this.gender = gender;
//    }

    public Users() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }




}