package com.example.pharmanic.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(	name = "users",
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "username"),
//                @UniqueConstraint(columnNames = "email")
//        })
public class User_Detail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;


    private String username;

    private String email;

    private String branch;

    private String role_name;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(	name = "user_roles",
//            joinColumns ={ @JoinColumn(name = "user_id")  },
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//
//
//    )


    public User_Detail() {
    }

    public User_Detail(String username, String email, String branch, String role_name) {
//        this.id = id;
        this.username = username;
        this.email = email;
        this.branch = branch;
        this.role_name = role_name;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "User_Detail{" +
//                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}