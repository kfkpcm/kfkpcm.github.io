package org.webapp.savvy.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.webapp.savvy.Model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Role-based authority handling (you can add more roles if needed)
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();  // Get the password from the User entity
    }

    @Override
    public String getUsername() {
        return user.getUsername();  // Get the username from the User entity
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // You can add your own logic for expired accounts
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // You can add your own logic for locked accounts
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // You can add your own logic for credential expiration
    }

    @Override
    public boolean isEnabled() {
        return true;  // You can add your own logic for disabled accounts
    }

    public User getUser() {
        return user;
    }
}