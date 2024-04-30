package co.edu.uco.infrastructure.adapter.jwt.model;

import co.edu.uco.entity.CustomerEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserInformationDetails implements UserDetails {
    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInformationDetails(CustomerEntity userInfo) {
        name = userInfo.getCompanyEmail();
        password = userInfo.getPassword();
        authorities = new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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
