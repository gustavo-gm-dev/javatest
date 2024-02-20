package com.javatest.user.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.javatest.user.model.profile.Profile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "tb_user")
@Entity(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String email;
    // private UserRole role;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Profile> profiles;

    public User(String login, String password, String email, List<Profile> profiles){
        this.login = login;
        this.password = password;
        this.email = email;
        this.profiles = profiles;
        // this.role = role;
    }

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     for (Profile profile : this.profiles){
    //         if(profile.getRole().equals(UserRole.ADMIN.name())) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
    //     } 
    //     return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    // }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Profile profile : this.profiles) {
            if (profile.getRole().equals(UserRole.ROLE_ADMIN.name())) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }
        if (authorities.isEmpty()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return login;
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
}
