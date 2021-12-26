package com.idas2.zdravotnisystem.security;

import com.idas2.zdravotnisystem.component.AuthUser;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.repository.UzivatelRepository;
import com.idas2.zdravotnisystem.db.view.UzivatelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UzivatelRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(
        UzivatelRepository userRepository
    ) {
        this.userRepository = userRepository;
    }
//    private final AuthorityService authorityService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        final User user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException(email));

        UzivatelView uzivatelView =
            userRepository.findViewByUuid(user.getUuid());

        return AuthUser.of(user, getAuthorities(uzivatelView.getRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
        String role
    ) {
        List<GrantedAuthority> authorities
            = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }

}
