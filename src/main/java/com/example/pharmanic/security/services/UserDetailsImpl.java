package com.example.pharmanic.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.pharmanic.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private String branch;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String email, String password,String branch,
=======
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String email, String password,
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String email, String password,
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String email, String password,
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        this.branch=branch;
=======
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                user.getBranch(),
                authorities
                );
=======
                authorities);
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
                authorities);
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
                authorities);
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public String getBranch() {
        return branch;
    }



=======
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
=======
>>>>>>> parent of 6941f6b... Merge branch 'master' into Anupama
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
