package com.springboot.app.moviebooking.services.imp;

import com.springboot.app.moviebooking.model.UserDB;
import com.springboot.app.moviebooking.repositories.UserDBRepository;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Collection;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserDBRepository userRepository;

    public UserDetailsServiceImp(UserDBRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        UserDB user = userRepository.findByEmail(userEmail);
        if( user == null) {
            throw new UsernameNotFoundException("Email " + userEmail +" not found.");
        }
        return new User(user.getEmail(),user.getPassword(), getGrantedAuthority(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthority(UserDB user) {

            Collection<GrantedAuthority> authorities = new ArrayDeque<>();
            if (user.getRole().getName().equalsIgnoreCase("admin")) { //FIXME: not sure if it's okey to do this
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            return authorities;
    }
}
