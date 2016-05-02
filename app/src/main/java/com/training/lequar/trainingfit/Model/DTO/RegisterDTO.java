package com.training.lequar.trainingfit.Model.DTO;

/**
 * Created by Camilo Arias on 29/04/16.
 */
public class RegisterDTO {
    private String name;
    private String lastName;
    private String email;
    private long phone;
    private String pass;

    public RegisterDTO() {

    }

    public RegisterDTO(String name, String lastName, String email, long phone, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
