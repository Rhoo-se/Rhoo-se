package Capstone.newface.domain;

import jakarta.persistence.Entity;


public class User {
    private Long id;
    private String mail;
    private String pwd;

    public User() {}

    public User(String mail, String pwd){
        this.mail = mail;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
