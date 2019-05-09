package com.dairy.project.dairysystem.security;

import com.dairy.project.dairysystem.component.DairyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private DairyUser dairyUser;

    @Autowired
    public UserDetailsServiceImpl(DairyUser dairyUser) {
        this.dairyUser = dairyUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dairyUser.user(username);
    }
}
