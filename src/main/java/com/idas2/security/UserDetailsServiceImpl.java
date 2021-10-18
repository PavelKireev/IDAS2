package com.idas2.security;

import com.idas2.component.AuthUser;
import com.idas2.db.entity.User;
import com.idas2.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(
        UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }
//    private final AuthorityService authorityService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        final User user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException(email));

        return AuthUser.of(user, getAuthorities(user));
    }

    private Collection<GrantedAuthority> getAuthorities(User user) {
        return null;
//        return authorityService.getAuthorities(user.getId());
    }

}
